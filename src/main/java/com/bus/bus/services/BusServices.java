package com.bus.bus.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bus.bus.models.Bus;
import com.bus.bus.repositories.BusRepository;

@Service
public class BusServices {
    @Autowired
    BusRepository busRepository;

    public ArrayList<Bus> getAllBuses() {
        return (ArrayList<Bus>) busRepository.findAll();
    }
    
    public Page<Bus> Pagination(Pageable pageable) {
        return busRepository.findAll(pageable);
    }

    public Bus getBusById(int id) {
        return busRepository.findById(id).get();
    }

    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }
}
