package com.ucv.labt09;

public class EstudiantePostGrado extends Estudiante {

    private String gradoAcademico; // "Bachiller" o "Titulado"
    private static int contador = 0;

    public EstudiantePostGrado() {
        super();
        contador++;
        this.setCodigo(generarCodigo());
    }

    public EstudiantePostGrado(String apellidos, String nombres,
                               String semestre, String grado) {
        super("", apellidos, nombres, semestre);
        contador++;
        this.setCodigo(generarCodigo());
        this.gradoAcademico = grado;
    }

    public String getGradoAcademico() { return gradoAcademico; }
    public void setGradoAcademico(String g) { this.gradoAcademico = g; }

    public static int getContador() { return contador; }

    public final String generarCodigo() {
        return String.format("EPOS%04d", contador);
    }

    @Override
    public double pagoParcialPension() {
        return "Bachiller".equalsIgnoreCase(gradoAcademico) ? 400.0 : 350.0;
    }

    @Override
    public double descuentos() {
        return pagoParcialPension() * IGV; // 19%
    }
}