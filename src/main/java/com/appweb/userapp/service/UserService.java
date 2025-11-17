package com.appweb.userapp.service;

import com.appweb.userapp.model.User;
import com.appweb.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
}
