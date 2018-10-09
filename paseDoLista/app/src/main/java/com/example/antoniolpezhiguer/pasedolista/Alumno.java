package com.example.antoniolpezhiguer.pasedolista;

public class Alumno {
    String nombre;
    String matricula;
    int grupo;
    boolean asistencia;
    int imagenAlumno;

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getImagenAlumno() {
        return imagenAlumno;
    }

    public void setImagenAlumno(int imagenAlumno) {
        this.imagenAlumno = imagenAlumno;
    }

    public Alumno(String nombre, String matricula, int grupo, int imagenAlumno, boolean asistencia) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.grupo = grupo;
        this.imagenAlumno = imagenAlumno;
        this.asistencia = asistencia;
    }
}
