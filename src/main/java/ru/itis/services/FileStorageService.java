package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {
    String saveFile(MultipartFile multipartFile);
    void writeFileToResponse(String filename, HttpServletResponse response);
}
