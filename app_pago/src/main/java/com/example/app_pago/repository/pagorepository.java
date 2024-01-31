package com.example.app_pago.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app_pago.models.pago;



public interface pagorepository extends JpaRepository<pago,Integer> {
    
}
