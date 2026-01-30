package com.appweb.userapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private long idEstado;

    public long getId_estado() {
        return idEstado;
    }
    public void setId_estado(long idEstado) {
        this.idEstado = idEstado;
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
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
