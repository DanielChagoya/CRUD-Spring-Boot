package com.appweb.userapp.controller;

import com.appweb.userapp.dto.request.ColoniaRequestDTO;
import com.appweb.userapp.dto.response.ColoniaResponseDTO;
import com.appweb.userapp.service.ColoniaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colonias")
public class ColoniaController {

    private ColoniaService coloniaService;

    public ColoniaController(ColoniaService coloniaService){
        this.coloniaService = coloniaService;
    }

    // CREAR
    // POST /colonia
    @PostMapping
    public ResponseEntity<ColoniaResponseDTO> crear(
           @Valid @RequestBody ColoniaRequestDTO dto){
        ColoniaResponseDTO response = coloniaService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // LISTAR TODOS
    // GET /colonia
    @GetMapping
    public ResponseEntity<List<ColoniaResponseDTO>> listar(){
        return ResponseEntity.ok(coloniaService.listar());
    }

    // BUSCAR POR ID
    // GET /colonia/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ColoniaResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(coloniaService.buscar(id));
    }

    // ACTUALIZAR
    // PUT /colonia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ColoniaResponseDTO> actualizar(@PathVariable Long id,
                                                           @RequestBody ColoniaRequestDTO dto){
        return ResponseEntity.ok(coloniaService.actualizar(id,dto));
    }

    // ELIMINAR
    // DELETE /colonia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        coloniaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
