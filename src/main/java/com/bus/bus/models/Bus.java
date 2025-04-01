package com.bus.bus.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NroBus")
    private String NroBus;

    @Column(name = "Placa")
    private String Placa;

    @Column(name = "FechaCreacion")
    private LocalDateTime FechaCreacion;

    @Column(name = "Caracteristicas")
    private String Caracteristicas;
    
    @Column(name = "Activo")
    private boolean Activo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
    
 
    public Bus() {
    }

    public Bus(String NroBus, String Placa, LocalDateTime FechaCreacion, String Caracteristicas, Marca marca, boolean Activo) {
        this.NroBus = NroBus;
        this.Placa = Placa;
        this.FechaCreacion = FechaCreacion;
        this.Caracteristicas = Caracteristicas;
        this.marca = marca;
        this.Activo = Activo;
    }
    @PrePersist
    public void prePersist() {
        FechaCreacion = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNroBus() {
        return NroBus;
    }

    public void setNroBus(String nroBus) {
        NroBus = nroBus;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public LocalDateTime getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        Caracteristicas = caracteristicas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    
}
