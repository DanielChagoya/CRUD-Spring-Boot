package com.appweb.userapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//Request ---> los campos que el cliente manda para crear/actualizar
public class PaisRequestDTO {

    @NotBlank(message = "El nombre del país es obligatorio")
    @Size(min = 3, max = 60, message = "El nombre del país debe tener entre 3 y 60 caracteres")
    private String nombre;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

}
