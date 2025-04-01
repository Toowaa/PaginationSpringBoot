package com.bus.bus.controllers;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.bus.models.Bus;
import com.bus.bus.services.BusServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/bus")
@CrossOrigin
@RestController

public class BusController {
    @Autowired
    BusServices busServices;

    @GetMapping("/all")
    public ArrayList<Bus> getAllBuses() {
        return busServices.getAllBuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable int id) {
        try {
            Bus bus = busServices.getBusById(id);
            return ResponseEntity.ok(bus);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Page<Bus> getBusesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return busServices.Pagination(pageable);
    }

    @PostMapping
    public Bus postMethodName(@RequestBody Bus bus) {
        this.busServices.saveBus(bus);
        return bus;
    }

}
