package com.appweb.userapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "codigo_postal")
public class CodigoPostal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cp")

    private long id_cp;

    public long getId_cp() {return id_cp;}
    public void setId_cp(long id_cp) {this.id_cp = id_cp;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "cp")

    private int cp;

    public int getCp() {return cp;}
    public void setCp(int cp) {this.cp = cp;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "id_colonia")

    private Colonia colonia;

    public Colonia getColonia() {return colonia;}
    public void setColonia(Colonia colonia) {this.colonia = colonia;}

}
