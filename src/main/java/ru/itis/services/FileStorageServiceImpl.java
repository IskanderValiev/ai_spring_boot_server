package ru.itis.services;

import lombok.SneakyThrows;
import org.apache.tomcat.jni.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.models.Image;
import ru.itis.repositories.ImageRepository;
import ru.itis.utils.ImageStorageUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * created by Iskander Valiev
 * on 22.03.2018
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageStorageUtil imageStorageUtil;

    @Override
    public String saveFile(MultipartFile file) {
        Image image = imageStorageUtil.convertFromMultipart(file);
        imageRepository.save(image);
        imageStorageUtil.copyToStorage(file, image.getStorageFileName());
        return image.getStorageFileName();
    }

    @SneakyThrows
    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        Image image = imageRepository.findOneByStorageFileName(fileName);
        response.setContentType(image.getType());
        InputStream inputStream = new FileInputStream(new File(image.getUrl()));
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }
}

