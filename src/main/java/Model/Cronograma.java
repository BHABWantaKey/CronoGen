/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 * @author Espaco de Inovacao
 */
public class Cronograma implements Serializable {
    int codigo;
    Actividade actividades;
    AreaActividade[] area;
    Docente[] docente;
    Turma turma;
    Instituicao instituicao;
    String[] [] tabela= new String[6][23]; // Aqui serão armazenadas as combinações entre docente, área e disponiblidade, onde as posições nos arrays representam o dia e hora pra esssa acividades.


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
