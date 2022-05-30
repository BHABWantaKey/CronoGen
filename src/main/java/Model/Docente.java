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
  public   boolean [] dias = new boolean[6];



   public boolean horas[] = new boolean[23];


    public AreaActividade getArea() {
        return area;
    }

    public void setArea(AreaActividade areas) {
        this.area = areas;
    }


}
