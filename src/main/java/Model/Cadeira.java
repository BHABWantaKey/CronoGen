/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 * @author Espaco de Inovacao
 */
public class Cadeira implements Serializable {
    String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    int codigo;
    public String getNomeCadeira() {
        return nome;
    }

    public void setNomeCadeira(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return
                nome;
    }













}
