/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Espaco de Inovacao
 */
public abstract class Area implements Serializable {
    String[] area;

    public String[] getArea() {
        return area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }




    public Area() {


    }
}
