package com.example.app_pago.controller;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app_pago.dto.AutorRequest;

import com.example.app_pago.exception.PrestamosReponse;
import com.example.app_pago.maper.maper;
import com.example.app_pago.models.pago;
import com.example.app_pago.service.Ipagoservice;

import org.slf4j.Logger;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/pago")

public class pagocontrolador {
    
    @Autowired
    private Ipagoservice pagoservice;

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(pagocontrolador.class);

    @Autowired
    private maper mapiarpago;

     
    //Crear 
    @PostMapping("/crear")
    public ResponseEntity<?> guardar(@RequestBody pago obj){
        try {
            logger.info("creado exitoso");
            return ResponseEntity.status(HttpStatus.CREATED).body(pagoservice.crearpago(obj));
        } catch (Exception e) {
            logger.error("incorrecto", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear Libro");
        }
     
    }

    @PostMapping("/create")
    public ResponseEntity<PrestamosReponse<AutorRequest>> add(@RequestBody AutorRequest pagorequest) {
        try{
            pago pagos = mapiarpago.dtoTOEntity(pagorequest);
            pagos = pagoservice.crearpago(pagos);
            AutorRequest creaHCitaRequest = mapiarpago.entityToDto(pagos);
            return ResponseEntity.status(HttpStatus.CREATED)
            .body(new PrestamosReponse<>(HttpStatus.CREATED.value(), 
            "Citas creado", creaHCitaRequest));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new PrestamosReponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
            "Error al crear Historia", null));
        }
    }



    
}
