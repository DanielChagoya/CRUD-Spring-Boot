package com.appweb.userapp.mapper;

import com.appweb.userapp.dto.request.EstadoRequestDTO;
import com.appweb.userapp.dto.response.EstadoResponseDTO;
import com.appweb.userapp.model.Estado;
import org.springframework.stereotype.Component;

@Component
public class EstadoMapper {

    public EstadoResponseDTO toResponse(Estado entity){
        EstadoResponseDTO dto = new EstadoResponseDTO();
        dto.setId(entity.getId_estado());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public Estado toEntity (EstadoRequestDTO dto){
        Estado estado = new Estado();
        estado.setNombre(dto.getNombre());
        return estado;
    }

    public void updateEntityFromRequest(EstadoRequestDTO dto, Estado entity){
        entity.setNombre(dto.getNombre());
    }
}
