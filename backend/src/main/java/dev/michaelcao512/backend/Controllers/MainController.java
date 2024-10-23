package dev.michaelcao512.backend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }





}
