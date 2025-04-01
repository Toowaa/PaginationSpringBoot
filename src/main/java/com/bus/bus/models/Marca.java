package com.bus.bus.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombreMarca;

    @OneToMany(mappedBy = "marca")
    @JsonBackReference
    private Set<Bus> buses;

    public Marca() {
    }

    public Marca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public java.util.Set<Bus> getBuses() {
        return buses;
    }

    public void setBuses(java.util.Set<Bus> buses) {
        this.buses = buses;
    }
}