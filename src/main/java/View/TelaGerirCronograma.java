/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Espaco de Inovacao
 */
public class TelaGerirCronograma extends JFrame {
    

    public TelaGerirCronograma(){

        setTitle("Gerir Cronogramas");
        setSize(800, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        Container container = this.getContentPane();
        container.setLayout(null);

        //Criação de componentes
        JLabel lbTitulo =new JLabel("Título");
        JTextField tfTitulo = new JTextField(30);
        JLabel lbEmail = new JLabel("E-mail");
        JTextField tfEmail=new JTextField(30);
        JLabel lbTurma = new JLabel("Turma");
        JComboBox cbTurmas = new JComboBox<>();
        JButton btnActualizar = new JButton("Actualizar");
        JLabel lbListaCronogramas = new JLabel("Lista de Cronogramas");
        JList listaCronogramas = new JList<>();
        JButton btnApagar = new JButton("APagar");
        JButton btnCriarCronograma = new JButton("Gerar");
        JLabel lbPrevia = new JLabel("Imagem");
        //Alocação de coordenadas no painel.

        lbTitulo.setBounds(50,100,250,20);
        tfTitulo.setBounds(50,120,200,20);
        lbEmail.setBounds(50,140,120,20);
        tfEmail.setBounds(50,160,250,20);
        lbTurma.setBounds(50,180,120,20);
        cbTurmas.setBounds(50,200,150,20);
        btnCriarCronograma.setBounds(50,240,80,20);
        btnActualizar.setBounds(150,240,100,20);
        lbListaCronogramas.setBounds(580,100,200,20);
        listaCronogramas.setBounds(580,120,200,120);
        lbPrevia.setBounds(380,120,120,120);
        btnApagar.setBounds(580,240,80,20);
        //Adicionando compenentes ao painel.
        container.add(lbTitulo);
        container.add(tfTitulo);
        container.add(lbEmail);
        container.add(tfEmail);
        container.add(lbTurma);
        container.add(cbTurmas);
        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnCriarCronograma);
        container.add(listaCronogramas);
        container.add(lbPrevia);
        container.add(lbListaCronogramas);
        }
        
        public static void main(String[] args) {
            
        
            TelaGerirCronograma tela=new TelaGerirCronograma();
        }
        
}
