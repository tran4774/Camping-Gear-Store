package com.example.campinggearstore.service;

import com.example.campinggearstore.dto.FileDTO;

public interface IStorageStrategy {
    FileDTO generateSignedUrl(FileDTO fileDTO);
}
