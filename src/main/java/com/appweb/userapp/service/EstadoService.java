package com.appweb.userapp.service;

import com.appweb.userapp.dto.request.EstadoRequestDTO;
import com.appweb.userapp.dto.response.EstadoResponseDTO;
import com.appweb.userapp.mapper.EstadoMapper;
import com.appweb.userapp.model.Estado;
import com.appweb.userapp.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private EstadoRepository estadoRepository;
    private final EstadoMapper estadoMapper;

    public EstadoService(EstadoRepository estadoRepository, EstadoMapper estadoMapper){
        this.estadoRepository = estadoRepository;
        this.estadoMapper = estadoMapper;
    }

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    // *** Metodos CRUD ***

    //Guardar
    public EstadoResponseDTO crear(EstadoRequestDTO dto) {

        Estado estado = estadoMapper.toEntity(dto);   // Request → Entidad
        Estado guardado = estadoRepository.save(estado);

        return estadoMapper.toResponse(guardado);     // Entidad → Response
    }

    //Obtener todos los estados
    public List<EstadoResponseDTO> listar(){
        return estadoRepository.findAll()
                .stream()
                .map(estadoMapper::toResponse)
                .toList();
    }

    //Buscar por id
    public EstadoResponseDTO buscarPorId(Long id) {

        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + id));

        return estadoMapper.toResponse(estado);
    }

    //Actualizar
    public EstadoResponseDTO actualizar(Long id, EstadoRequestDTO dto) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        estadoMapper.updateEntityFromRequest(dto, estado);

        Estado actualizado = estadoRepository.save(estado);

        return estadoMapper.toResponse(actualizado);
    }
    //Elimimar por ID
    public void eliminar(Long id) {

        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado con id: " + id);
        }

        estadoRepository.deleteById(id);
    }


    public List<EstadoResponseDTO> listarPorPais(Long paisId) {

        List<Estado> estados = estadoRepository.findByPais_IdPais(paisId);
        List<EstadoResponseDTO> response = new ArrayList<>();

        for (Estado estado : estados) {
            response.add(toResponseDTO(estado));
        }

        return response;
    }


    private EstadoResponseDTO toResponseDTO(Estado estado) {
        EstadoResponseDTO dto = new EstadoResponseDTO();
        dto.setId(estado.getId_estado());
        dto.setNombre(estado.getNombre());
        return dto;
    }



}
