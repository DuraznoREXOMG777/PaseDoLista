package com.example.antoniolpezhiguer.pasedolista;

public class Grupo {
    String nombreGrupo;
    int numeroGrupo;
    int imagenGrupo;

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public int getImagenGrupo() {
        return imagenGrupo;
    }

    public void setImagenGrupo(int imagenGrupo) {
        this.imagenGrupo = imagenGrupo;
    }

    public Grupo(String nombreGrupo, int numeroGrupo, int imagenGrupo) {

        this.nombreGrupo = nombreGrupo;
        this.numeroGrupo = numeroGrupo;
        this.imagenGrupo = imagenGrupo;
    }
}
