package com.appweb.userapp.service;

import com.appweb.userapp.dto.request.PaisRequestDTO;
import com.appweb.userapp.dto.response.PaisResponseDTO;
import com.appweb.userapp.mapper.PaisMapper;
import com.appweb.userapp.model.Pais;
import com.appweb.userapp.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaisService {

    private PaisRepository paisRepository;
    private PaisMapper paisMapper;

    //Constructor
    public PaisService(PaisRepository paisRepository, PaisMapper paisMapper){
        this.paisRepository = paisRepository;
        this.paisMapper = paisMapper;
    }

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    // *** Metodos CRUD ***

    //Guardar
    public PaisResponseDTO crear(PaisRequestDTO dto){
        Pais pais = paisMapper.toEntity(dto);
        Pais guardado = paisRepository.save(pais);

        return paisMapper.toResponse(guardado);
    }

    //Listar paises
    public List<PaisResponseDTO> listar(){
        return paisRepository.findAll()
                .stream()
                .map(paisMapper::toResponse)
                .toList();
    }

    //Buscar por id
    public PaisResponseDTO buscar(Long id){
        Pais pais = paisRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pais no encontrado con id: " + id));
        return paisMapper.toResponse(pais);
    }

    //Actualizar
    public PaisResponseDTO actualizar(Long id, PaisRequestDTO dto){
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pais no encontrado"));
        paisMapper.UpdateEntityFromRequest(dto, pais);
        Pais actualizado = paisRepository.save(pais);

        return paisMapper.toResponse(actualizado);
    }

    //Eliminar por ID
    public void eliminar(Long id){
        if(!paisRepository.existsById(id)){
            throw new RuntimeException("Pais no encontrado con id: " + id);
        }
        paisRepository.deleteById(id);
    }

}
