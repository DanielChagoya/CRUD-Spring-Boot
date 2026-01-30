package com.appweb.userapp.service;

import com.appweb.userapp.dto.request.CodigoPostalRequestDTO;
import com.appweb.userapp.dto.response.CodigoPostalResponseDTO;
import com.appweb.userapp.mapper.CodigoPostalMapper;
import com.appweb.userapp.model.CodigoPostal;
import com.appweb.userapp.repository.CodigoPostalRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CodigoPostalService {

    private CodigoPostalRepository codigoPostalRepository;
    private CodigoPostalMapper codigoPostalMapper;

    public CodigoPostalService(CodigoPostalRepository codigoPostalRepository, CodigoPostalMapper codigoPostalMapper){
        this.codigoPostalRepository = codigoPostalRepository;
        this.codigoPostalMapper = codigoPostalMapper;
    }

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    // *** Metodos CRUD ***

    //Guardar
    public CodigoPostalResponseDTO crear(CodigoPostalRequestDTO dto){
        CodigoPostal codigoPostal = codigoPostalMapper.toEntity(dto);
        CodigoPostal guardado = codigoPostalRepository.save(codigoPostal);

        return codigoPostalMapper.toResponse(guardado);
    }

    //Listar Cp
    public List<CodigoPostalResponseDTO> listar(){
        return codigoPostalRepository.findAll()
                .stream()
                .map(codigoPostalMapper::toResponse)
                .toList();
    }

    //Buscar por id
    public CodigoPostalResponseDTO buscar(Long id){
        CodigoPostal codigoPostal = codigoPostalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Codigo Postal no encontrado con id: " + id));
        return codigoPostalMapper.toResponse(codigoPostal);
    }

    //Actualizar
    public CodigoPostalResponseDTO actualizar(Long id, CodigoPostalRequestDTO dto){
        CodigoPostal codigoPostal = codigoPostalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Codigo Postal no encontrado"));
        codigoPostalMapper.UpdateEntityFromRequest(dto,codigoPostal);
        CodigoPostal actualizado = codigoPostalRepository.save(codigoPostal);

        return codigoPostalMapper.toResponse(actualizado);
    }

    //Eliminar por ID
    public void eliminar(Long id){
        if (!codigoPostalRepository.existsById(id)){
            throw new RuntimeException("Codigo Postal no encontrado con id: " + id);
        }
        codigoPostalRepository.deleteById(id);
    }
}
