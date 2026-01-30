package com.appweb.userapp.controller;

import com.appweb.userapp.dto.request.PaisRequestDTO;
import com.appweb.userapp.dto.response.PaisResponseDTO;
import com.appweb.userapp.service.PaisService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    // -----------------------------
    // CREAR
    // POST /paises
    // -----------------------------
    @PostMapping
    public ResponseEntity<PaisResponseDTO> crear(
           @Valid @RequestBody PaisRequestDTO dto
    ) {
        PaisResponseDTO response = paisService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // -----------------------------
    // LISTAR TODOS
    // GET /paises
    // -----------------------------
    @GetMapping
    public ResponseEntity<List<PaisResponseDTO>> listar() {
        return ResponseEntity.ok(paisService.listar());
    }

    // -----------------------------
    // BUSCAR POR ID
    // GET /paises/{id}
    // -----------------------------
    @GetMapping("/{id}")
    public ResponseEntity<PaisResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(paisService.buscar(id));
    }

    // -----------------------------
    // ACTUALIZAR
    // PUT /paises/{id}
    // -----------------------------
    @PutMapping("/{id}")
    public ResponseEntity<PaisResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PaisRequestDTO dto
    ) {
        return ResponseEntity.ok(paisService.actualizar(id, dto));
    }

    // -----------------------------
    // ELIMINAR
    // DELETE /paises/{id}
    // -----------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        paisService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
