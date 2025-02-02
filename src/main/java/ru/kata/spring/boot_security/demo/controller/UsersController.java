package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (value = "/user")
    public String printUsers(ModelMap model, Principal principal) { //, @RequestParam(defaultValue = "5", name = "count") int count) {
        //List<User> usersResponse = new ArrayList<>(userService.listUsers());
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user" , user);
        return "user";
    }
}
