/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Espaco de Inovacao
 */
public class Cronograma {
    int codigo;
    Actividades actividades;
    Area[] area;
    Docente[] docente;
    Turma turma;
    Instituicao instituicao;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
