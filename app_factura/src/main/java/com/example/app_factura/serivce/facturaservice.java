package com.example.app_factura.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app_factura.model.factura;
import com.example.app_factura.repository.facturarepository;


@Service

public class facturaservice implements Ifacturaservice{
    
    @Autowired
    private facturarepository facturarepositorio;

    @Transactional(readOnly = true)
    public List<factura> buscar() {
        return (List<factura>)facturarepositorio.findAll();
    }

}
