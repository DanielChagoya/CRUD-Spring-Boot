package com.appweb.userapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_usuario")
    private long idUsuario;

    public long getIdUsuario() {return idUsuario;}
    public void setIdUsuario(long id) {this.idUsuario = id;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;  // Libreria java.time, se utiliza para tipos de dato DATE

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "genero", length = 1)
    private String genero;

    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "salario", precision = 10, scale = 2)
    private BigDecimal salario;

    public BigDecimal getSalario() {return salario;}
    public void setSalario(BigDecimal salario) {this.salario = salario;}

    //------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------

    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private LocalDateTime fechaRegistro;  // LocalDateTime es un tipo de dato para marca el campo como no actualizable ni insertable

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

}
