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

    AreaActividade[] area;
    Docente[] docente;
    Turma turma;




    public void gerarCronograma(boolean dia, boolean tempo, Actividade actividade [][]){







    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }








}
