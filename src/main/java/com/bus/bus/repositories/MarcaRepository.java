package com.bus.bus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.bus.models.Marca;

@Repository
public interface MarcaRepository  extends JpaRepository <Marca, Integer> {

}
