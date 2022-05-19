/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

import Model.Cronograma;

import java.awt.*;
/**
 *
 * @author Espaco de Inovacao
 */
public class TelaMenuDocente extends JFrame {

    public TelaMenuDocente(){

        setTitle("Menu Principal");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        //Criar Container e configurar
        Container container=this.getContentPane();
        container.setLayout(null);
        
        //Criação dos componentes da tela 
        JButton btnCronograma=new JButton("Cronogramas");
        JButton btnDispinibilidade=new JButton("Disponibilidade");
        JButton btnSair=new JButton("Sair");

        
        //alocação de coordenanadas.
        btnCronograma.setBounds(20,20,120,60);
        btnDispinibilidade.setBounds(200,20,120,60);
        btnSair.setBounds(334,136,50,50);

        //Adicionando conteúdo ao container
        container.add(btnCronograma);
        container.add(btnDispinibilidade);
        container.add(btnSair);


        
        }
        
        public static void main(String[] args) {
            
        
            TelaMenuDocente tela=new TelaMenuDocente();
        }
        
    
}
