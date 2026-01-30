package com.appweb.userapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private long idPais;

    @Column(name = "nombre")
    private String nombre;

    // Getters y Setters


    public long getIdPais() {return idPais;}
    public void setIdPais(long idPais) {this.idPais = idPais;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
}
