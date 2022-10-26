package com.example.lab7.Controllers;

import com.example.lab7.Entities.Pago;
import com.example.lab7.Repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/pagos")
public class PagoController {

    @Autowired
    PagoRepository pagoRepository;

    @ResponseBody
    @GetMapping(value = "/listarPagos")
    public List<Pago> listaPagos(){
        return pagoRepository.findAll();
    }
}
