package com.appweb.userapp.service;

import com.appweb.userapp.dto.request.MunicipioRequestDTO;
import com.appweb.userapp.dto.response.MunicipioResponseDTO;
import com.appweb.userapp.mapper.MunicipioMapper;
import com.appweb.userapp.model.Municipio;
import com.appweb.userapp.repository.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    private MunicipioRepository municipioRepository;
    private MunicipioMapper municipioMapper;

    public MunicipioService(MunicipioRepository municipioRepository, MunicipioMapper municipioMapper){
        this.municipioRepository = municipioRepository;
        this.municipioMapper = municipioMapper;
    }

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    // *** Metodos CRUD ***

    //Guardar
    public MunicipioResponseDTO crear(MunicipioRequestDTO dto){
        Municipio municipio = municipioMapper.toEntity(dto);
        Municipio guardado = municipioRepository.save(municipio);

        return municipioMapper.toResponse(guardado);
    }

    //Listar municipios
    public List<MunicipioResponseDTO> listar(){
        return municipioRepository.findAll()
                .stream()
                .map(municipioMapper::toResponse)
                .toList();
    }

    //Buscar por id
    public MunicipioResponseDTO buscarPorId(Long id){
        Municipio municipio = municipioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Municipio no encontrado con id: " + id));
       return municipioMapper.toResponse(municipio);
    }

    //Actualizar
    public MunicipioResponseDTO actualizar(Long id, MunicipioRequestDTO dto) {
        Municipio municipio = municipioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Municipio no encontrado"));
        municipioMapper.UpdateEntityFromRequest(dto, municipio);
        Municipio actualizado = municipioRepository.save(municipio);

        return municipioMapper.toResponse(actualizado);
    }

    //Eliminar por id
    public void eliminar(Long id){
        if(!municipioRepository.existsById(id)){
            throw new RuntimeException("Municipio no encontrado con id: " + id);
        }
        municipioRepository.deleteById(id);
    }

    public List<MunicipioResponseDTO> listarPorEstado(Long idEstado) {

        List<Municipio> municipios = municipioRepository.findByEstado_IdEstado(idEstado);
        List<MunicipioResponseDTO> response = new ArrayList<>();

        for (Municipio municipio : municipios) {
            response.add(toResponseDTO(municipio));
        }

        return response;
    }

    private MunicipioResponseDTO toResponseDTO(Municipio municipio) {
        MunicipioResponseDTO dto = new MunicipioResponseDTO();
        dto.setId(municipio.getId_municipio());
        dto.setNombre(municipio.getNombre());
        return dto;
    }


}
