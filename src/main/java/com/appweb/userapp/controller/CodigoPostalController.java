package com.appweb.userapp.controller;

import com.appweb.userapp.dto.request.CodigoPostalRequestDTO;
import com.appweb.userapp.dto.response.CodigoPostalResponseDTO;
import com.appweb.userapp.service.CodigoPostalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codigos-postales")
public class CodigoPostalController {

    private CodigoPostalService codigoPostalService;

    public CodigoPostalController(CodigoPostalService codigoPostalService){
        this.codigoPostalService = codigoPostalService;
    }


    // CREAR
    // POST /codigos-postales
    @PostMapping
    public ResponseEntity<CodigoPostalResponseDTO> crear(
           @Valid @RequestBody CodigoPostalRequestDTO dto){
        CodigoPostalResponseDTO response = codigoPostalService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // LISTAR TODOS
    // GET /codigos-postales
    @GetMapping
    public ResponseEntity<List<CodigoPostalResponseDTO>> listar(){
        return ResponseEntity.ok(codigoPostalService.listar());
    }

    // BUSCAR POR ID
    // GET /codigos-postales/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CodigoPostalResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(codigoPostalService.buscar(id));
    }

    // ACTUALIZAR
    // PUT /codigos-postales/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CodigoPostalResponseDTO> actualizar(@PathVariable Long id,
                                                         @RequestBody CodigoPostalRequestDTO dto){
        return ResponseEntity.ok(codigoPostalService.actualizar(id,dto));
    }

    // ELIMINAR
    // DELETE /codigos-postales/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        codigoPostalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
