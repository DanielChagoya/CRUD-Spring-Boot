package com.appweb.userapp.controller;

import com.appweb.userapp.model.Municipio;
import com.appweb.userapp.model.User;
import com.appweb.userapp.repository.MunicipioRepository;
import com.appweb.userapp.repository.UserRepository;
import com.appweb.userapp.service.PaisService;
import com.appweb.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PaisService paisService;
    private final MunicipioRepository municipioRepository;
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          PaisService paisService,
                          MunicipioRepository municipioRepository,
                          UserRepository userRepository) {
        this.userService = userService;
        this.paisService = paisService;
        this.municipioRepository = municipioRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("paises", paisService.listar());
        return "user-form";
    }

    @PostMapping
    public String saveUser(
            @ModelAttribute("user") User user,
            @RequestParam("municipioId") Long municipioId
    ) {
        Municipio municipio = municipioRepository.findById(municipioId).orElse(null);
        if (municipio != null) {
            user.setMunicipio(municipio);
            user.setEstado(municipio.getEstado());
            user.setPais(municipio.getEstado().getPais());
        }

        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{idUsuario}")
    public String showEditForm(@PathVariable Long idUsuario, Model model) {
        User user = userService.getUserById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + idUsuario));
        model.addAttribute("user", user);
        model.addAttribute("paises", paisService.listar());
        return "user-form";
    }

    @GetMapping("/delete/{idUsuario}")
    public String deleteUser(@PathVariable Long idUsuario) {
        userService.deleteUser(idUsuario);
        return "redirect:/users";
    }
}