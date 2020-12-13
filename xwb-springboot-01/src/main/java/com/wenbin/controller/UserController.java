package com.wenbin.controller;

import com.wenbin.config.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    Student student;

    @GetMapping("hello")
    public String hello(){
        System.out.println(student.getName());
        return "hello";
    }
}
