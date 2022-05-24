/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Espaco de Inovacao
 */
public class Docente extends Pessoa implements Serializable {

    @Override
    public String toString() {
        return nome;
    }

    AreaActividade area;
    Date tempo_livre_inicial[];
    Date tempo_livre_final[];

    public Date[] getTempo_livre_inicial() {
        return tempo_livre_inicial;
    }

    public void setTempo_livre_inicial(Date[] tempo_livre_inicial) {
        this.tempo_livre_inicial = tempo_livre_inicial;
    }

    public AreaActividade getArea() {
        return area;
    }

    public void setArea(AreaActividade areas) {
        this.area = areas;
    }


}
