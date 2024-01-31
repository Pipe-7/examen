package com.example.app_factura.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="factura")
public class factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfactura;
    private double monto;
    private int estado;

    
   
    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "factura [idfactura=" + idfactura + ", monto=" + monto + ", estado=" + estado + "]";
    }   
    
}
