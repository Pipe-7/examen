package com.example.app_pago.maper;


import org.springframework.stereotype.Component;

import com.example.app_pago.dto.AutorRequest;
import com.example.app_pago.models.pago;


@Component
public class maper {

    
    public AutorRequest entityToDto(pago user){
        AutorRequest dto = new AutorRequest();
        dto.setIdfactura(user.getIdfactura());
        dto.setMonto(user.getMonto());
        dto.setFecha(user.getFecha());
 
        return dto;
    }

    public pago dtoTOEntity(AutorRequest dto){
        pago use = new pago();
        use.setIdfactura(dto.getIdfactura());
        use.setMonto(dto.getMonto());
        use.setFecha(dto.getFecha());
        return use;
}

}
