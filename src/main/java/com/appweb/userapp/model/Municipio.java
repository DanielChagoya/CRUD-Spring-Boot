package com.appweb.userapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio")
    private long id_municipio;

    public long getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(long id_municipio) {
        this.id_municipio = id_municipio;
    }

    //------------------------------------------------------------------------------------
    @Column(name = "nombre")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //------------------------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
