package com.appweb.userapp.service;

import com.appweb.userapp.model.Municipio;
import com.appweb.userapp.model.User;
import com.appweb.userapp.repository.MunicipioRepository;
import com.appweb.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final MunicipioRepository municipioRepository;

    //constructores
    public UserService(UserRepository userRepository,
                       MunicipioRepository municipioRepository){
        this.userRepository = userRepository;
        this.municipioRepository = municipioRepository;
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar usuario por ID
    public Optional<User> getUserById(Long idUsuario) {
        return userRepository.findById(idUsuario);
    }

    // Guardar o actualizar usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Eliminar usuario por ID
    public void deleteUser(Long idUsuario) {
        userRepository.deleteById(idUsuario);
    }

    public void saveUserWithMunicipio(User user, Long municipioId) {
        Municipio municipio = municipioRepository
                .findById(municipioId)
                .orElseThrow(() -> new RuntimeException("Municipio no encontrado"));

        user.setMunicipio(municipio);
        userRepository.save(user);
    }

}


