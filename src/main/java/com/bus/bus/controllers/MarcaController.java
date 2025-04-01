package com.bus.bus.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.bus.bus.models.Marca;
import com.bus.bus.services.MarcaServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/marca")
@RestController
@CrossOrigin
public class MarcaController {
    @Autowired
    MarcaServices marcaServices;

    @GetMapping
    public ArrayList<Marca> getAllMarcas() {
        return marcaServices.getAllMarcas();
    }
    
    @PostMapping
    public Marca postMethodName(@RequestBody Marca marca) {
        this.marcaServices.saveMarca(marca);
        return marca;
    }
    

}
