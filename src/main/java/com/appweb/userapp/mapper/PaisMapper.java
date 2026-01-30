package com.appweb.userapp.mapper;

import com.appweb.userapp.dto.request.PaisRequestDTO;
import com.appweb.userapp.dto.response.PaisResponseDTO;
import com.appweb.userapp.model.Pais;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {

    public PaisResponseDTO toResponse(Pais entity){
        PaisResponseDTO dto = new PaisResponseDTO();
        dto.setId(entity.getIdPais());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public Pais toEntity(PaisRequestDTO dto) {
        Pais pais = new Pais();
        pais.setNombre(dto.getNombre());
        return pais;
    }

    public void UpdateEntityFromRequest(PaisRequestDTO dto, Pais entity) {
        entity.setNombre(dto.getNombre());
    }

}
