package com.appweb.userapp.controller;

import com.appweb.userapp.model.User;
import com.appweb.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form"; // <- apunta a user-form.html
    }

    @PostMapping
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    // Mostrar formulario para editar usuario
    @GetMapping("/edit/{idUsuario}")
    public String showEditForm(@PathVariable("idUsuario") Long idUsuario, Model model) {
        User user = userService.getUserById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + idUsuario));
        model.addAttribute("user", user);
        return "user-form";
    }

    // Eliminar usuario
    @GetMapping("/delete/{idUsuario}")
    public String deleteUser(@PathVariable("idUsuario") Long idUsuario) {
        userService.deleteUser(idUsuario);
        return "redirect:/users";
    }

}
