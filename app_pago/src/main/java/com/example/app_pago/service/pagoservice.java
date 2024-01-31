package com.example.app_pago.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.app_pago.models.pago;
import com.example.app_pago.repository.pagorepository;

@Service

public class pagoservice implements Ipagoservice {
    
   @Autowired
   private pagorepository pagorepositorio;

    @Override
    public pago crearpago(pago pago) {
 
     return pagorepositorio.save(pago);
    }    
    
}
