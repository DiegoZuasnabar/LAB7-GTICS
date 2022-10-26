package com.example.lab7.Controllers;

import com.example.lab7.Repositories.UserRepository;
import com.example.lab7.Entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @ResponseBody
    @PostMapping(value = "/crear",produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public ResponseEntity<HashMap<String,Object>> crearUser(@RequestBody Usuario usuario){
        HashMap<String,Object> rmap = new HashMap<>();
        userRepository.save(usuario);
        rmap.put("id creado",usuario.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(rmap);
    }

}
