package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.repositories.ImageRepository;

/**
 * created by Iskander Valiev
 * on 22.03.2018
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class UploadImageServiceImpl implements UploadImageService {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void uploadImage(MultipartFile file) {
        String imagePath = fileStorageService.saveFile(file);
        imageRepository.findOneByStorageFileName(imagePath);
    }
}
