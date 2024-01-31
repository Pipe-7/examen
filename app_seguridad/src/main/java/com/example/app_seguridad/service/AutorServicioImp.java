package com.example.app_seguridad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app_seguridad.models.usuario;
import com.example.app_seguridad.repository.AutorRepositori;


@Service
public class AutorServicioImp implements IAutorService {

    @Autowired
    private AutorRepositori autorreporio;

    @Override
    public List<usuario> mostrarAutor() {
        return (List<usuario>)autorreporio.findAll();
    }


    @Override
    public boolean validarCredenciales(String usuario, String password) {
      List<usuario> result = (List<usuario>) autorreporio.findAll();
      List<usuario> resultFilter = result.stream()
      .filter(t -> t.getNombre().equals(usuario) && t.getClave().equals(password))
      .collect(Collectors.toList());
      if(null == resultFilter || resultFilter.isEmpty()){
          return false;
      }
      return true;

    }

  
}
