package com.jobportal.server.controller;

import com.jobportal.server.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public String init() {
        return "home";
    }

}
