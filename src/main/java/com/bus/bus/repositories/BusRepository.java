package com.bus.bus.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.bus.models.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer> {

    
}

