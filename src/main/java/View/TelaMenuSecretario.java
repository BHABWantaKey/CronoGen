/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Espaco de Inovacao
 */
public class TelaMenuSecretario extends JFrame implements ActionListener {


    JButton btnDocentes = new JButton("Docentes");
    JButton btnActividades = new JButton("Actividades");
    JButton btnCronogramas = new JButton("Cronogramas");
    JButton btnCriarCronogramas = new JButton("Criar Cronogramas");
    JButton btnTurmas = new JButton("Turmas");
    JButton btnRelatorios = new JButton("Relatórios");
    JButton btnSair = new JButton("Sair");

    public TelaMenuSecretario() {

        setTitle("Menu Principal");
        setSize(590, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


        Container container = this.getContentPane();
        container.setLayout(null);

        btnDocentes.setBounds(50, 50, 120, 50);
        btnActividades.setBounds(200, 50, 120, 50);
        btnCronogramas.setBounds(350, 50, 120, 50);
        btnCriarCronogramas.setBounds(50, 200, 120, 50);
        btnTurmas.setBounds(200, 200, 120, 50);
        btnRelatorios.setBounds(350, 200, 120, 50);
        btnSair.setBounds(470, 330, 103, 30);

        //Adicionando ActionListenners aos botões
        btnDocentes.addActionListener(this);
        btnActividades.addActionListener(this);
        btnCronogramas.addActionListener(this);
        btnCriarCronogramas.addActionListener(this);
        btnTurmas.addActionListener(this);
        btnRelatorios.addActionListener(this);
        btnSair.addActionListener(this);

        container.add(btnDocentes);
        container.add(btnActividades);
        container.add(btnCronogramas);
        container.add(btnCriarCronogramas);
        container.add(btnTurmas);
        container.add(btnRelatorios);
        container.add(btnSair);


    }


    public static void main(String[] args) {


        TelaMenuSecretario tela = new TelaMenuSecretario();
    }


    @Override
    public void actionPerformed(ActionEvent accao) {

        if (accao.getSource() == btnDocentes) {

            TelaGerirDocente telaGerirDocente = new TelaGerirDocente();
            try {
                telaGerirDocente.carregarDocentes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else if (accao.getSource() == btnActividades) {
            TelaGerirActividades telaGerirActividades = new TelaGerirActividades();
        } else if (accao.getSource() == btnRelatorios) {
            TelaRelatorios telaRelatorios = new TelaRelatorios();

        } else if (accao.getSource() == btnSair) {
            this.dispose();
            TelaEntrada telaEntrada = new TelaEntrada();
        } else if (accao.getSource() == btnCriarCronogramas) {
            TelaHorario telaHorario = new TelaHorario();
        } else if (accao.getSource() == btnCronogramas) {
            TelaGerirCronograma telaGerirCronograma = new TelaGerirCronograma();
        } else if (accao.getSource() == btnTurmas) {
            TelaGerirTurma telaGerirTurma = new TelaGerirTurma();

        }

    }
}
