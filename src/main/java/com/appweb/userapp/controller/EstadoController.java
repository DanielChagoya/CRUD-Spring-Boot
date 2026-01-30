package com.appweb.userapp.controller;

import com.appweb.userapp.dto.request.EstadoRequestDTO;
import com.appweb.userapp.dto.response.EstadoResponseDTO;
import com.appweb.userapp.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoService estadoService;

    public EstadoController (EstadoService estadoService){
        this.estadoService = estadoService;
    }

    // CREAR
    // POST /estados
    @PostMapping
    public ResponseEntity<EstadoResponseDTO> crear(
       @Valid @RequestBody EstadoRequestDTO dto)
    {
        EstadoResponseDTO response = estadoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // LISTAR TODOS
    // GET /estados
    @GetMapping
    public ResponseEntity<List<EstadoResponseDTO>> listar(){
        return ResponseEntity.ok(estadoService.listar());
    }

    // BUSCAR POR ID
    // GET /estados/{id}
    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(estadoService.buscarPorId(id));
    }

    // ACTUALIZAR
    // PUT /estados/{id}
    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponseDTO> actualizar(@PathVariable Long id,
                                                        @RequestBody EstadoRequestDTO dto){
        return ResponseEntity.ok(estadoService.actualizar(id,dto));
    }

    // ELIMINAR
    // DELETE /estados/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        estadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // GET /estados/pais/{paisId}
    @GetMapping("/pais/{paisId}")
    public ResponseEntity<List<EstadoResponseDTO>> listarPorPais(
            @PathVariable ("paisId") Long idPais) {

        return ResponseEntity.ok(estadoService.listarPorPais(idPais));
    }


}
