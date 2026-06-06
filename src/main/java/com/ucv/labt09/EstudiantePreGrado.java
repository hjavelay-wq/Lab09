package com.ucv.labt09.model;

public class EstudiantePreGrado extends Estudiante {

    private String categoria;           // "A" o "B"
    private double promedioPonderado;
    private String colegioProcedencia;  // "Estatal" o "Particular"
    private static int contador = 0;

    public EstudiantePreGrado() {
        super();
        contador++;
        this.setCodigo(generarCodigo());
    }

    public EstudiantePreGrado(String apellidos, String nombres, String semestre,
                              String categoria, double promedio, String colegio) {
        super("", apellidos, nombres, semestre);
        contador++;
        this.setCodigo(generarCodigo());
        this.categoria = categoria;
        this.promedioPonderado = promedio;
        this.colegioProcedencia = colegio;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String c) { this.categoria = c; }

    public double getPromedioPonderado() { return promedioPonderado; }
    public void setPromedioPonderado(double p) { this.promedioPonderado = p; }

    public String getColegioProcedencia() { return colegioProcedencia; }
    public void setColegioProcedencia(String c) { this.colegioProcedencia = c; }

    public static int getContador() { return contador; }

    public final String generarCodigo() {
        return String.format("EPRE%04d", contador);
    }

    @Override
    public double pagoParcialPension() {
        if ("A".equalsIgnoreCase(categoria))
            return "Estatal".equalsIgnoreCase(colegioProcedencia) ? 320.0 : 450.0;
        else
            return "Estatal".equalsIgnoreCase(colegioProcedencia) ? 300.0 : 420.0;
    }

    @Override
    public double descuentos() {
        double pct = (promedioPonderado >= 13.0) ? 0.08 : 0.0;
        return pagoParcialPension() * pct;
    }
}