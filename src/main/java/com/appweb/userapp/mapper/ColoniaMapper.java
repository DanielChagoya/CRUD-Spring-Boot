package com.appweb.userapp.mapper;

import com.appweb.userapp.dto.request.ColoniaRequestDTO;
import com.appweb.userapp.dto.response.ColoniaResponseDTO;
import com.appweb.userapp.model.Colonia;
import org.springframework.stereotype.Component;

@Component
public class ColoniaMapper {

    public ColoniaResponseDTO toResponse(Colonia entity){
        ColoniaResponseDTO dto = new ColoniaResponseDTO();
        dto.setId(entity.getId_colonia());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public Colonia toEntity(ColoniaRequestDTO dto){
        Colonia colonia = new Colonia();
        colonia.setNombre(dto.getNombre());
        return colonia;
    }

    public void UpdateEntityFromRequest(ColoniaRequestDTO dto, Colonia entity){
        entity.setNombre(dto.getNombre());
    }
}
