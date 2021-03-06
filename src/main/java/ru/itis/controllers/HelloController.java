package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * created by Iskander Valiev
 * on 22.03.2018
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "template";
    }
}
