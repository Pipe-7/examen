package com.example.app_seguridad.maper;


import org.springframework.stereotype.Component;

import com.example.app_seguridad.dto.AutorRequest;
import com.example.app_seguridad.models.usuario;




@Component
public class maper {

    
    public AutorRequest entityToDto(usuario user){
        AutorRequest dto = new AutorRequest();
        dto.setNombre(user.getNombre());
        dto.setClave(user.getClave());
 
        return dto;
    }

    public usuario dtoTOEntity(AutorRequest dto){
        usuario use = new usuario();
        use.setNombre(dto.getNombre());
        use.setClave(dto.getClave());
     
        return use;
}

}
