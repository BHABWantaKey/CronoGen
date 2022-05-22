/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.toedter.calendar.JCalendar;

import java.io.Serializable;

/**
 *
 * @author Espaco de Inovacao
 */
public class Secretario extends Pessoa implements Serializable {
    
    int codigo;
    public String usuario;
    public String senha;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
