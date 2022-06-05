/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 * @author Espaco de Inovacao
 */
public class Actividade  implements Serializable {
    String nome;
    int numeroDeOcorrencias;

    @Override
    public String toString() {
        return
                nome;
    }

    Boolean incluirFinalDeSemana, manha, tarde, noite;

    public Actividade() {
        this.incluirFinalDeSemana = incluirFinalDeSemana;
        this.manha = false;
        this.tarde = false;
        this.noite = false;
    }

    public Boolean getIncluirFinalDeSemana() {
        return incluirFinalDeSemana;
    }

    public void setIncluirFinalDeSemana(Boolean incluirFinalDeSemana) {
        this.incluirFinalDeSemana = incluirFinalDeSemana;
    }

    public int getNumeroDeOcorrencias() {
        return numeroDeOcorrencias;
    }

    public Boolean getManha() {
        return manha;
    }

    public void setManha(Boolean manha) {
        this.manha = manha;
    }

    public Boolean getTarde() {
        return tarde;
    }

    public void setTarde(Boolean tarde) {
        this.tarde = tarde;
    }

    public Boolean getNoite() {
        return noite;
    }

    public void setNoite(Boolean noite) {
        this.noite = noite;
    }

    public Cadeira getAreaActividade() {
        return cadeira;
    }

    public void setAreaActividade(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public void setNumeroDeOcorrencias(int numeroDeOcorrencias) {
        this.numeroDeOcorrencias = numeroDeOcorrencias;
    }

    Cadeira cadeira;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
