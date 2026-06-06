package com.ucv.lab09.model;

import java.io.Serializable;

public abstract class Estudiante implements Serializable, IConstantes {

    private String codigo;
    private String apellidos;
    private String nombres;
    private String semestreIngreso;

    public Estudiante() {}

    public Estudiante(String codigo, String apellidos, String nombres, String semestreIngreso) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.semestreIngreso = semestreIngreso;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getSemestreIngreso() { return semestreIngreso; }
    public void setSemestreIngreso(String s) { this.semestreIngreso = s; }

    public abstract double pagoParcialPension();
    public abstract double descuentos();

    public double pagoFinalPension() {
        return pagoParcialPension() - descuentos();
    }
}