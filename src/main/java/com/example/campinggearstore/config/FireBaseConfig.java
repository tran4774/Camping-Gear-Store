package com.example.campinggearstore.config;

import com.example.campinggearstore.dto.FirebaseCredential;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;

import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FireBaseConfig {
    private static Storage storage;
    private static Bucket bucket;
    private static FireBaseConfig instance;

    private FireBaseConfig() {
        FirebaseCredential firebaseCredential = new FirebaseCredential();
        String privateKey = System.getenv("FIREBASE_PRIVATE_KEY")
                .replace("\\n", "\n");
        firebaseCredential.setType(System.getenv("FIREBASE_TYPE"));
        firebaseCredential.setProject_id(System.getenv("FIREBASE_PROJECT_ID"));
        firebaseCredential.setPrivate_key_id(System.getenv("FIREBASE_PRIVATE_KEY_ID"));
        firebaseCredential.setPrivate_key(privateKey);
        firebaseCredential.setClient_email(System.getenv("FIREBASE_CLIENT_EMAIL"));
        firebaseCredential.setClient_id(System.getenv("FIREBASE_CLIENT_ID"));
        firebaseCredential.setAuth_uri(System.getenv("FIREBASE_AUTH_URI"));
        firebaseCredential.setToken_uri(System.getenv("FIREBASE_TOKEN_URI"));
        firebaseCredential.setAuth_provider_x509_cert_url(System.getenv("FIREBASE_AUTH_PROVIDER_X509_CERT_URL"));
        firebaseCredential.setClient_x509_cert_url(System.getenv("FIREBASE_CLIENT_X509_CERT_URL"));
        //serialize with jackson
        ObjectMapper mapper = new ObjectMapper();
        FirebaseOptions options = null;

        try {
            //convert jsonString to InputStream using Apache Commons
            String jsonString = mapper.writeValueAsString(firebaseCredential);
            InputStream firebaseStream = IOUtils.toInputStream(jsonString);
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(firebaseStream))
                    .setStorageBucket(System.getenv("FIREBASE_BUCKET_NAME"))
                    .build();
            FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
            StorageClient storageClient = StorageClient.getInstance(firebaseApp);
            storage = storageClient.bucket().getStorage();
            bucket = storageClient.bucket();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static FireBaseConfig getInstance() {
        if(instance == null)
            instance = new FireBaseConfig();
        return instance;
    }
    public Storage getStorage(){
        return storage;
    }

    public Bucket getBucket() {
        return bucket;
    }
}
