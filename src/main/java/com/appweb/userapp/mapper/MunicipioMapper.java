package com.appweb.userapp.mapper;

import com.appweb.userapp.dto.request.MunicipioRequestDTO;
import com.appweb.userapp.dto.response.MunicipioResponseDTO;
import com.appweb.userapp.model.Municipio;
import org.springframework.stereotype.Component;

@Component
public class MunicipioMapper {

    public MunicipioResponseDTO toResponse(Municipio entity){
        MunicipioResponseDTO dto = new MunicipioResponseDTO();
        dto.setId(entity.getId_municipio());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public Municipio toEntity(MunicipioRequestDTO dto){
        Municipio municipio = new Municipio();
        municipio.setNombre(dto.getNombre());
        return municipio;
    }

    public void UpdateEntityFromRequest(MunicipioRequestDTO dto, Municipio entity){
        entity.setNombre(dto.getNombre());
    }
}
