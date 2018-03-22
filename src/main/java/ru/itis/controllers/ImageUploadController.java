package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.services.UploadImageService;

/**
 * created by Iskander Valiev
 * on 22.03.2018
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class ImageUploadController {

    @Autowired
    private UploadImageService imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file")MultipartFile file) {
        imageService.uploadImage(file);
        return "redirect:/";
    }
}
