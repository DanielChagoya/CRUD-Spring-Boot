package com.appweb.userapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MunicipioRequestDTO {

    @NotBlank(message = "El nombre del municipio es obligatorio")
    @Size(min = 3, max = 60, message = "El nombre del municipio debe tener entre 3 y 60 caracteres")
    private String nombre;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

}
