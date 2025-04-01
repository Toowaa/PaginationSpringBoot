package com.bus.bus.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.bus.models.Marca;
import com.bus.bus.repositories.MarcaRepository;

@Service
public class MarcaServices {
    @Autowired
    MarcaRepository marcaRepository;

    public ArrayList<Marca> getAllMarcas() {
        return (ArrayList<Marca>) marcaRepository.findAll();
    }

    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

}
