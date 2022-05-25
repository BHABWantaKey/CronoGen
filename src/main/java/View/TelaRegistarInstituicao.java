/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Instituicao;
import Model.Turma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Espaco de Inovacao
 */
public class TelaRegistarInstituicao extends JFrame implements ActionListener {


    //Criação de componentes
    JLabel lbNome = new JLabel("Nome da Instituição");
    JTextField tfNome = new JTextField(30);

    JButton btnRegistarInstituicao = new JButton("Criar");


    public TelaRegistarInstituicao() {

        setTitle("Registar Instituição");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);


        //Alocação de coordenadas no painel.
        lbNome.setBounds(50, 50, 250, 20);
        tfNome.setBounds(50, 70, 250, 20);
        btnRegistarInstituicao.setBounds(50, 110, 80, 20);
        btnRegistarInstituicao.addActionListener(this);

        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(btnRegistarInstituicao);


    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        TelaRegistarInstituicao tela = new TelaRegistarInstituicao();

    }


    @Override
    public void actionPerformed(ActionEvent accao) {
        if (accao.getSource() == btnRegistarInstituicao) {

            Instituicao instituicao = new Instituicao();

            instituicao.setNome(tfNome.getText());
            //  docente.setArea((AreaActividade) cbArea.getSelectedItem());


            File ficheiro = new File("instituicao.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(instituicao);
                objecto.close();

                JOptionPane.showMessageDialog(null, "Instituição " + instituicao.getNome() + " registada com sucesso.");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Actividade");
                throw new RuntimeException(e);
            }


        }
    }
}
