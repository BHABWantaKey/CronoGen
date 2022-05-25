/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Espaco de Inovacao
 */
public class Instituicao implements Serializable {

    String nome;
    ArrayList<Secretario> secretarios;
    Turma turmas[];
    Docente docentes[];

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Secretario> getSecretarios() {
        return secretarios;
    }

    public void setSecretarios(ArrayList<Secretario> secretarios) {
        this.secretarios = secretarios;
    }

    public Turma[] getTurmas() {
        return turmas;
    }

    public void setTurmas(Turma[] turmas) {
        this.turmas = turmas;
    }

    public Docente[] getDocentes() {
        return docentes;
    }

    public void setDocentes(Docente[] docentes) {
        this.docentes = docentes;
    }


}
