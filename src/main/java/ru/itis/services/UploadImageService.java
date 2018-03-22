package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
    void uploadImage(MultipartFile file);
}
