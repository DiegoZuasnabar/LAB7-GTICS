package com.example.lab7.Controllers;

import com.example.lab7.Entities.Credito;
import com.example.lab7.Entities.Pago;
import com.example.lab7.Repositories.CreditoRepository;
import com.example.lab7.Repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/pagos")
public class PagoController {

    @Autowired
    PagoRepository pagoRepository;

    @Autowired
    CreditoRepository creditoRepository;

    @ResponseBody
    @GetMapping(value = "/listarPagos")
    public List<Pago> listaPagos(){
        return pagoRepository.findAll();
    }

    @PostMapping("/registrarPago")
    public ResponseEntity<HashMap<String,String>> crearProducto(@RequestBody Credito credito){
        HashMap<String,String> hashMap = new HashMap<>();

        creditoRepository.save(credito);

        hashMap.put("idCreado", String.valueOf(credito.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestionarErrorCrearProducto(){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("error","true");
        hashMap.put("msg","Debes enviar el producto como json");
        return ResponseEntity.badRequest().body(hashMap);
    }
}
