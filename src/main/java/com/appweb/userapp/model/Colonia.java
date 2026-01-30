package com.appweb.userapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colonia")
public class Colonia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colonia")
    private long id_colonia;

    public long getId_colonia() {
        return id_colonia;
    }

    public void setId_colonia(long id_colonia) {
        this.id_colonia = id_colonia;
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
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
