package com.appweb.userapp.mapper;

import com.appweb.userapp.dto.request.CodigoPostalRequestDTO;
import com.appweb.userapp.dto.response.CodigoPostalResponseDTO;
import com.appweb.userapp.model.CodigoPostal;
import org.springframework.stereotype.Component;

@Component
public class CodigoPostalMapper {

    public CodigoPostalResponseDTO toResponse(CodigoPostal entity){
        CodigoPostalResponseDTO dto = new CodigoPostalResponseDTO();
        dto.setId(entity.getId_cp());
        dto.setCp(entity.getCp());
        return dto;
    }

    public CodigoPostal toEntity(CodigoPostalRequestDTO dto){
        CodigoPostal codigoPostal = new CodigoPostal();
        codigoPostal.setCp((int) dto.getCp());
        return codigoPostal;
    }

    public void UpdateEntityFromRequest(CodigoPostalRequestDTO dto, CodigoPostal entity){
        entity.setCp((int)dto.getCp());
    }

}
