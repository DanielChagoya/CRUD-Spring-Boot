package com.appweb.userapp.service;


import com.appweb.userapp.dto.request.ColoniaRequestDTO;
import com.appweb.userapp.dto.response.ColoniaResponseDTO;
import com.appweb.userapp.mapper.ColoniaMapper;
import com.appweb.userapp.model.Colonia;
import com.appweb.userapp.repository.ColoniaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColoniaService {

    private ColoniaRepository coloniaRepository;
    private ColoniaMapper coloniaMapper;

    // Constructor
    public ColoniaService(ColoniaRepository coloniaRepository, ColoniaMapper coloniaMapper){
        this.coloniaRepository = coloniaRepository;
        this.coloniaMapper = coloniaMapper;
    }

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    // *** Metodos CRUD ***

    //Guardar
    public ColoniaResponseDTO crear(ColoniaRequestDTO dto){
        Colonia colonia = coloniaMapper.toEntity(dto);
        Colonia guardado = coloniaRepository.save(colonia);

        return coloniaMapper.toResponse(guardado);
    }

    //Listar paises
    public List<ColoniaResponseDTO> listar(){
        return coloniaRepository.findAll()
                .stream()
                .map(coloniaMapper::toResponse)
                .toList();
    }

    //Buscar por id
    public ColoniaResponseDTO buscar(Long id){
        Colonia colonia = coloniaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colonia no encontrada con id: " + id));
        return coloniaMapper.toResponse(colonia);
    }

    //Actualizar
    public ColoniaResponseDTO actualizar(Long id, ColoniaRequestDTO dto){
        Colonia colonia = coloniaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Colonia no encontrada"));
        coloniaMapper.UpdateEntityFromRequest(dto, colonia);
        Colonia actalizado = coloniaRepository.save(colonia);

        return coloniaMapper.toResponse(actalizado);
    }

    //Eliminar por ID
    public void eliminar(Long id){
        if (!coloniaRepository.existsById(id)){
            throw new RuntimeException("Colonia no encontrada con id: " + id);
        }
        coloniaRepository.deleteById(id);
    }
}
