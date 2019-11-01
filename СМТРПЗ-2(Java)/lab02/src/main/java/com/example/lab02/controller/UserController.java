package com.example.lab02.controller;

import com.example.lab02.entity.User;
import com.example.lab02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String home() {
        return "redirect:/users";
    }

    @GetMapping("users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userList";
    }

    @GetMapping("/user/{id}")
    public String getByIdUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUserPage() {
        return "newUser";
    }


    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "updateUser";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/users";
    }
}
