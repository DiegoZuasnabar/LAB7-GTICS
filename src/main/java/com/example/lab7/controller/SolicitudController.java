package com.example.lab7.controller;

import com.example.lab7.Entities.Solicitud;
import com.example.lab7.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@CrossOrigin
public class SolicitudController {
    @Autowired
    SolicitudRepository solicitudRepository;

    /****** Pregunta 2a ******/
    @PostMapping("/solicitudes/registro")
    public ResponseEntity<HashMap<String,String>> guardarSolicitud(@RequestBody Solicitud solicitud){
        HashMap<String,String> hashMap = new HashMap<>();

        solicitud.setSolicitudEstado("pendiente");  //Pendiente de forma automática
        solicitudRepository.save(solicitud);

        hashMap.put("Monto solicitado", String.valueOf(solicitud.getSolicitudMonto()));
        hashMap.put("id", String.valueOf(solicitud.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestionarErrorCrearSolicitud(){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("error","true");
        hashMap.put("msg","Debes enviar la solicitud como json");
        return ResponseEntity.badRequest().body(hashMap);
    }

    /****** Pregunta 2b ******/
    @PutMapping(value = "/solicitudes/aprobarSolicitud")
    public ResponseEntity<HashMap<String,String>> aprobarSolicitudFormaParcial(@RequestParam("idSolicitud") Integer idSolicitud){
        HashMap<String,String> hashMap = new HashMap<>();

        Optional<Solicitud> optionalSolicitud = solicitudRepository.findById(idSolicitud);
        if(optionalSolicitud.isPresent()){
            Solicitud solicitudOriginal = optionalSolicitud.get();

            if(solicitudOriginal.getSolicitudEstado().equalsIgnoreCase("pendiente")){
                solicitudOriginal.setSolicitudEstado("aprobado");
                solicitudRepository.save(solicitudOriginal);
                hashMap.put("id solicitud", String.valueOf(solicitudOriginal.getId()));
                return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
            }else{
                hashMap.put("solicitud ya atendida", String.valueOf(solicitudOriginal.getId()));
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(hashMap);
            }
        }else{
            hashMap.put("status","error");
            hashMap.put("msg","la solicitud a aprobar no existe");
            return ResponseEntity.ok(hashMap);
        }
    }
}
