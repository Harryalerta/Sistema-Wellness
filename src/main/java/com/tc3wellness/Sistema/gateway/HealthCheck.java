package com.tc3wellness.Sistema.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/")
    public String getMethodName() {
        return "Sistema Online";
    }
}
