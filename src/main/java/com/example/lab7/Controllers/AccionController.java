package com.example.lab7.Controllers;

import com.example.lab7.Entities.Accion;
import com.example.lab7.Entities.Credito;
import com.example.lab7.Repositories.AccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping(value = "/acciones")
public class AccionController {

    @Autowired
    AccionRepository accionRepository;

    @ResponseBody
    @PostMapping("/save")
    public ResponseEntity<HashMap<String,String>> saveAccion(@RequestBody Accion accion){
        HashMap<String,String> hashMap = new HashMap<>();

        accionRepository.save(accion);

        hashMap.put("idCreado", String.valueOf(accion.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }

}
