package com.example.app_factura.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app_factura.serivce.Ifacturaservice;

import org.slf4j.Logger;



import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/factura")

public class facturacontroller {
    
    @Autowired
    private Ifacturaservice facturaService;

    private static final Logger logger = LoggerFactory.getLogger(facturacontroller.class);

     //Metodo vER
     @GetMapping("/listar")
     public ResponseEntity<?> getLibro() {            
         try {
             logger.info("Listado de libro exitoso");
             return ResponseEntity.status(HttpStatus.OK).body(facturaService.buscar());
         } catch (Exception e) {
             logger.error("No se encontraron Libros", e);
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al ver los libros");
         }  
     }
}
