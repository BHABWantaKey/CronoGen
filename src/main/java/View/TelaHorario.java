//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package View;

import Model.Actividade;
import Model.Docente;
import Model.Secretario;
import Model.Turma;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaHorario {
    private static JComboBox cbTurmas;
    ArrayList<Actividade> actividades= new ArrayList<>();
    ArrayList<Docente> docentes= new ArrayList<>();
    ArrayList<Turma> turmas=new ArrayList<>();

    public TelaHorario() {
    }

    public static void main(String[] args) {
        final JtableComboBox table = new JtableComboBox();

        final JFrame frame = new JFrame("Cronograma");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 753, 601);
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().setLayout((LayoutManager) null);
        frame.setLocationRelativeTo((Component) null);
        frame.setVisible(true);



        cbTurmas = new JComboBox();
        cbTurmas.setBounds(131, 385, 230, 45);
        frame.getContentPane().add(cbTurmas);
        JLabel lblAula = new JLabel("Turma");
        lblAula.setFont(new Font("Tahoma", 0, 20));
        lblAula.setBounds(20, 388, 88, 42);
        frame.getContentPane().add(lblAula);
        JButton btnADD = new JButton("Gerar Cronograma");

        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==btnADD)
                    JOptionPane.showMessageDialog(null, "Actividade carregada com sucesso!" );


            }
        });
        btnADD.setBounds(20, 491, 341, 34);
        frame.getContentPane().add(btnADD);
        JButton btnDELETE = new JButton("DELETE");
        btnDELETE.setBackground(Color.WHITE);
        }}


