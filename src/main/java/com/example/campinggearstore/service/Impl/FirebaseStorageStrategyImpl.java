package com.example.campinggearstore.service.Impl;

//import com.example.campinggearstore.config.FireBaseConfig;
import com.example.campinggearstore.dto.FileDTO;
import com.example.campinggearstore.dto.FirebaseCredential;
import com.example.campinggearstore.service.IStorageStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class FirebaseStorageStrategyImpl implements IStorageStrategy {
    private final Environment environment;
    private static Storage storage;
    private static Bucket bucket;

    public FirebaseStorageStrategyImpl(Environment environment) {
        this.environment = environment;
    }
    @PostConstruct
    public void InitFireBaseConfig() {
        FirebaseCredential firebaseCredential = new FirebaseCredential();
        String privateKey = environment.getRequiredProperty("FIREBASE_PRIVATE_KEY")
                .replace("\\n", "\n");
        firebaseCredential.setType(environment.getRequiredProperty("FIREBASE_TYPE"));
        firebaseCredential.setProject_id(environment.getRequiredProperty("FIREBASE_PROJECT_ID"));
        firebaseCredential.setPrivate_key_id(environment.getRequiredProperty("FIREBASE_PRIVATE_KEY_ID"));
        firebaseCredential.setPrivate_key(privateKey);
        firebaseCredential.setClient_email(environment.getRequiredProperty("FIREBASE_CLIENT_EMAIL"));
        firebaseCredential.setClient_id(environment.getRequiredProperty("FIREBASE_CLIENT_ID"));
        firebaseCredential.setAuth_uri(environment.getRequiredProperty("FIREBASE_AUTH_URI"));
        firebaseCredential.setToken_uri(environment.getRequiredProperty("FIREBASE_TOKEN_URI"));
        firebaseCredential.setAuth_provider_x509_cert_url(environment.getRequiredProperty("FIREBASE_AUTH_PROVIDER_X509_CERT_URL"));
        firebaseCredential.setClient_x509_cert_url(environment.getRequiredProperty("FIREBASE_CLIENT_X509_CERT_URL"));
        //serialize with jackson
        ObjectMapper mapper = new ObjectMapper();
        FirebaseOptions options = null;

        try {
            //convert jsonString to InputStream using Apache Commons
            String jsonString = mapper.writeValueAsString(firebaseCredential);
            InputStream firebaseStream = IOUtils.toInputStream(jsonString);
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(firebaseStream))
                    .setStorageBucket(environment.getRequiredProperty("FIREBASE_BUCKET_NAME"))
                    .build();
            FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
            StorageClient storageClient = StorageClient.getInstance(firebaseApp);
            storage = storageClient.bucket().getStorage();
            bucket = storageClient.bucket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileDTO generateSignedUrl(FileDTO fileDTO) {
        BlobInfo blobInfo = BlobInfo.newBuilder(bucket.getName(), fileDTO.getFileName()).setContentType("image/png").build();
        storage.create(blobInfo);
        URL url = storage.signUrl(blobInfo, 1, TimeUnit.MINUTES,
                Storage.SignUrlOption.withV4Signature(),
                Storage.SignUrlOption.httpMethod(HttpMethod.PUT));
        storage.createAcl(blobInfo.getBlobId(), Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
        fileDTO.setUrl(url.toString());
        return fileDTO;
    }
}
