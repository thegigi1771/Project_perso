package com.example.SpringBootCrud_perso.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController { // faire attention de bien ouvrir avec localhost
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/create")
    public String create() {
        return "create.html";
    }

    @GetMapping("/read")
    public String read() {
        return "read.html";
    }

    @GetMapping("/update")
    public String update() {
        return "update.html";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete.html";
    }
}
