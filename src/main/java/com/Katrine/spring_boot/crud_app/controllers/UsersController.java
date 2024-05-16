package com.Katrine.spring_boot.crud_app.controllers;

import com.Katrine.spring_boot.crud_app.models.User;
import com.Katrine.spring_boot.crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "users/allUsers";
    }

    @GetMapping("/newUser")
    public String newUsers(@ModelAttribute("user") User user) {
        return "users/newUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "users/editUser";
    }

    @PatchMapping("/editUser") // @PostMapping возвращает 405 METHOD_NOT_ALLOWED
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(name = "id") int id) {
        userService.update(id, user);

        return "redirect:/users";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam(name = "id") int id) {
        userService.delete(id);

        return "redirect:/users";
    }
}
