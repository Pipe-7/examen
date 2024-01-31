package com.example.app_seguridad.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app_seguridad.models.usuario;



public interface AutorRepositori extends CrudRepository<usuario, Integer> {
    
}
