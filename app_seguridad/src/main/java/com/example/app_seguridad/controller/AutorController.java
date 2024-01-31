package com.example.app_seguridad.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app_seguridad.dto.AutorRequest;
import com.example.app_seguridad.dto.AutorResponse;
import com.example.app_seguridad.exception.PrestamosReponse;
import com.example.app_seguridad.jwt.JwtToken;
import com.example.app_seguridad.maper.maper;
import com.example.app_seguridad.models.usuario;
import com.example.app_seguridad.service.AutorServicioImp;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorServicioImp autorservice;

    @Autowired
    private maper mapers;

    private static final Logger logger = LoggerFactory.getLogger(AutorController.class);

    @Autowired
    private JwtToken jwtToken;

    @GetMapping("/listar")
    public ResponseEntity<PrestamosReponse<List<AutorRequest>>> mostrar() {
        try {
            logger.info("Listado de libro exitoso");
            List<usuario> presta= autorservice.mostrarAutor();
            List<AutorRequest> autore= presta.stream().map(mapers::entityToDto).collect(Collectors.toList());
            return ResponseEntity.ok(new PrestamosReponse<>(HttpStatus.OK.value(),
            "Consulta de listado de historia Exitosa", autore));
        } catch (Exception e) {
            logger.error("No se encontraron Libros", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PrestamosReponse<>(HttpStatus.OK.value(),
            "error al prestar",null));
        }

    }

    @PostMapping("/listar")
    public ResponseEntity<?> post(@RequestBody AutorRequest requestUsu) throws Exception {
        try {
            logger.info("Listado de libro exitoso");
            if (!autorservice.validarCredenciales(requestUsu.getNombre(), requestUsu.getClave())) {
                
                return new ResponseEntity<String>("INVALID_CREDENTIALS", HttpStatus.UNAUTHORIZED);
            }
            
            String token = jwtToken.generateToken(requestUsu);
            AutorResponse response = new AutorResponse(token, requestUsu.getNombre(), "1d");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("No se encontraron Libros", e);
            
            return new ResponseEntity<String>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
