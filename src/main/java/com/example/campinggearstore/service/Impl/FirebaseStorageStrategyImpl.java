package com.example.campinggearstore.service.Impl;

import com.example.campinggearstore.config.FireBaseConfig;
import com.example.campinggearstore.dto.FileDTO;
import com.example.campinggearstore.service.IStorageStrategy;
import com.google.cloud.storage.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirebaseStorageStrategyImpl implements IStorageStrategy {
    private static FirebaseStorageStrategyImpl instance;
    private final FireBaseConfig fireBaseConfig = FireBaseConfig.getInstance();
    private final Storage storage;
    private Bucket bucket;

    private FirebaseStorageStrategyImpl() {
        storage = fireBaseConfig.getStorage();
        bucket = fireBaseConfig.getBucket();
    }

    public static FirebaseStorageStrategyImpl getInstance() {
        if (instance == null)
            instance = new FirebaseStorageStrategyImpl();
        return instance;
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
