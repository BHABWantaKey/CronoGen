/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Docente;
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
public class TelaGerirTurma extends JFrame implements ActionListener {


    //Criação de componentes
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(30);
    JButton btnActualizar = new JButton("Actualizar");
    JLabel lbListaDeTurmas = new JLabel("Lista de Turmas");
    JList<Turma> listaDeTurmas = new JList<Turma>();
    JButton btnApagar = new JButton("APagar");
    JButton btnCriarTurma = new JButton("Criar");
    DefaultListModel<Turma> listModel = new DefaultListModel();

    public TelaGerirTurma() {

        setTitle("Gerir Turma");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


        setTitle("Gerir Cronogramas");
        setSize(550, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);


        //Alocação de coordenadas no painel.

        lbNome.setBounds(50, 100, 250, 20);
        tfNome.setBounds(50, 120, 250, 20);

        btnCriarTurma.setBounds(50, 240, 80, 20);
        btnActualizar.setBounds(150, 240, 100, 20);
        lbListaDeTurmas.setBounds(320, 100, 200, 20);
        listaDeTurmas.setBounds(320, 120, 200, 120);
        btnApagar.setBounds(320, 240, 80, 20);
        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);

        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnCriarTurma);
        container.add(listaDeTurmas);
        container.add(lbListaDeTurmas);

    }

    public static void main(String[] args) {


        TelaGerirTurma tela = new TelaGerirTurma();
    }


    @Override
    public void actionPerformed(ActionEvent accao) {
        listaDeTurmas.getSelectionModel().addListSelectionListener(e -> {
            Turma turma = new Turma();
            turma = listaDeTurmas.getSelectedValue();
            tfNome.setText(turma.getNome());

        });

        if (accao.getSource() == btnCriarTurma) {
            ArrayList<Turma> turmas = new ArrayList<Turma>();
            Turma turma = new Turma();

            turma.setNome(tfNome.getText());
            //  docente.setArea((AreaActividade) cbArea.getSelectedItem());


            turmas.add(turma);
            File ficheiro = new File("Actividades.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(turmas);
                objecto.close();

                ObjectInputStream objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                turmas = (ArrayList<Turma>) objectoLer.readObject();
                objectoLer.close();

                listModel.addElement(turma);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Actividade");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao Actualizar a lista de Actividades!");
                throw new RuntimeException(e);
            }


        }
    }
}
