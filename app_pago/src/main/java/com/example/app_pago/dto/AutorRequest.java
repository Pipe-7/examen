package com.example.app_pago.dto;

import java.io.Serializable;
import java.util.Date;

public class AutorRequest implements Serializable {
    
    private int idpago;
    private int idfactura;
    private double monto;
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

    
    
    

    
}
