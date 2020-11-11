package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String TrangChu() {
        return "Xin chào việt nam! tôi là Trần Chí Hiếu";
    }
}
