package com.appweb.userapp.controller;

import com.appweb.userapp.dto.request.MunicipioRequestDTO;
import com.appweb.userapp.dto.response.MunicipioResponseDTO;
import com.appweb.userapp.service.MunicipioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService){
        this.municipioService = municipioService;
    }

    // CREAR
    // POST /municipios
    @PostMapping
    public ResponseEntity<MunicipioResponseDTO> crear(
           @Valid @RequestBody MunicipioRequestDTO dto){
        MunicipioResponseDTO response = municipioService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // LISTAR TODOS
    // GET /municipios
    @GetMapping
    public ResponseEntity<List<MunicipioResponseDTO>> listar(){
        return ResponseEntity.ok(municipioService.listar());
    }

    // BUSCAR POR ID
    // GET /municipios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MunicipioResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(municipioService.buscarPorId(id));
    }

    // ACTUALIZAR
    // PUT /municipios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<MunicipioResponseDTO> actualizar(@PathVariable Long id,
                                                        @RequestBody MunicipioRequestDTO dto){
        return ResponseEntity.ok(municipioService.actualizar(id,dto));
    }

    // ELIMINAR
    // DELETE /municipios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        municipioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estado/{estadoId}")
    public ResponseEntity<List<MunicipioResponseDTO>> listarPorEstado(
            @PathVariable Long estadoId) {

        return ResponseEntity.ok(municipioService.listarPorEstado(estadoId));
    }



}
