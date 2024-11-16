package com.example.crudproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TesteController {

    @GetMapping("/publico/tarefas")
    public String publicEndpoint() {
        return "endpoint público";
    }

    @GetMapping("/privado/tarefas")
    public String protectedEndpoint() {
        return "endpoint privado";
    }
}
