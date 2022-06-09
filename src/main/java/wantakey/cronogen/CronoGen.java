/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package wantakey.cronogen;

import View.TelaEntrada;
import View.TelaRegistarSecretario;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author Espaco de Inovacao
 */
public class CronoGen {

    public static void main(String[] args) {
       //Adiciona Look And feel ao sistema
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        File secretariosFicheiro = new File("Secretarios.crono");
        if (secretariosFicheiro.exists()==false){
        TelaRegistarSecretario telaRegistarSecretario = new TelaRegistarSecretario();} else {
            TelaEntrada telaEntrada=new TelaEntrada();
        }

    }
}
