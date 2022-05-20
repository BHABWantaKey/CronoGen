/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Espaco de Inovacao
 */
public class Instituicao {

    String nome;
    ArrayList<Secretario> secretarios;
    Turma turmas[];
    Docente docentes[];

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
