package com.appweb.userapp.dto.response;

//Response ---> todos los datos que vas a regresar
public class PaisResponseDTO {
    private Long id;
    private String nombre;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
