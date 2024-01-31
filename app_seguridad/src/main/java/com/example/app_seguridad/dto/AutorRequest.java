package com.example.app_seguridad.dto;

import java.io.Serializable;

public class AutorRequest implements Serializable {
    
    private int idusuario;
    private String nombre;
    private String clave;
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    

    
}
