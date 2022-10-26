package com.example.lab7.Controllers;

import com.example.lab7.Entities.Usuario;
import com.example.lab7.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UsuarioController {
    @Autowired
    UserRepository userRepository;
    @ResponseBody
    @GetMapping(value = "/listar")
    public List<Usuario> listarUsuario(){
        return userRepository.findAll();
    }
}
