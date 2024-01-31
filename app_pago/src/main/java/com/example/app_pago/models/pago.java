package com.example.app_pago.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="pago")

public class pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpago;
    private int idfactura;
    private double monto;
    
    @Column(name="fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "pago [idpago=" + idpago + ", idfactura=" + idfactura + ", monto=" + monto + ", fecha=" + fecha + "]";
    }
    
}
