package com.example.app_seguridad.service;

import java.util.List;

import com.example.app_seguridad.models.usuario;



public interface IAutorService {
    
    public List<usuario> mostrarAutor();
   
    public boolean validarCredenciales(String usuario,String password);

}
