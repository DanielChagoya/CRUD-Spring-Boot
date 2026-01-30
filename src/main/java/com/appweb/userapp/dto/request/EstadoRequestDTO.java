package com.appweb.userapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstadoRequestDTO {

    @NotBlank(message = "El nombre del estado es obligatorio")
    @Size(min = 3, max = 60, message = "El nombre del estado debe tener entre 3 y 60 caracteres")
    private String nombre;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

}
