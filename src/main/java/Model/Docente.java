/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 * @author Espaco de Inovacao
 */
public class Docente extends Pessoa implements Serializable {

    @Override
    public String toString() {
        return nome;
    }

    Cadeira cadeira;



    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira areas) {
        this.cadeira = areas;
    }


}
