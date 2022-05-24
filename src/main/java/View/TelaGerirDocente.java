/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Actividade;
import Model.AreaActividade;
import Model.Docente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Espaco de Inovacao
 */
public class TelaGerirDocente extends JFrame implements ActionListener {


    //Criação de componentes e do Painel
    Container container = this.getContentPane();

    JLabel lblNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(30);

    JLabel lbEmail = new JLabel("Email");
    JTextField tfEmail = new JTextField(30);


    JLabel lblArea = new JLabel("Areas");
    JComboBox<AreaActividade> cbArea = new JComboBox<AreaActividade>();

    JLabel lbDocentes = new JLabel("Lista de Docentes");

    JButton btnAdicionarDocente = new JButton("Adicionar");
    JButton btnActualizar = new JButton("Actualizar");
    JButton btnApagar = new JButton("Apagar");
    JList<Docente> listaDocentes = new JList<Docente>();


    DefaultListModel<Docente> listModel = new DefaultListModel<>();

    public TelaGerirDocente() {

        setTitle("Gerir Docente");
        setSize(550, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


        container.setLayout(null);
        btnAdicionarDocente.addActionListener(this);
        lblNome.setBounds(30, 100, 150, 20);
        tfNome.setBounds(30, 120, 250, 20);
        lbEmail.setBounds(30, 140, 150, 20);
        tfEmail.setBounds(30, 160, 250, 20);
        btnAdicionarDocente.setBounds(30, 260, 100, 20);
        btnActualizar.setBounds(140, 260, 100, 20);
        lbDocentes.setBounds(350, 100, 120, 20);
        listaDocentes.setBounds(350, 120, 160, 180);
        btnApagar.setBounds(350, 305, 75, 20);
        lblArea.setBounds(30, 200, 150, 20);
        cbArea.setBounds(30, 220, 150, 20);


        //Coluna Oeste
        container.add(lblNome);
        container.add(tfNome);
        container.add(lbEmail);
        container.add(tfEmail);
        container.add(tfEmail);
        container.add(btnAdicionarDocente);
        container.add(btnApagar);
        container.add(btnActualizar);
        //Coluna central
        container.add(lblArea);
        container.add(cbArea);

        //Coluna Este
        container.add(lbDocentes);
        container.add(listaDocentes);

        listaDocentes.setModel(listModel);


    }

    public static void main(String[] args) {


        TelaGerirDocente tela = new TelaGerirDocente();
    }


    @Override
    public void actionPerformed(ActionEvent accao) {


        listaDocentes.getSelectionModel().addListSelectionListener(e -> {
            Docente docente = new Docente();
            docente = listaDocentes.getSelectedValue();
            tfNome.setText(docente.getNome());
            tfEmail.setText(docente.getEmail());

            //Pôr a ler do ficheiro!!!!!!!!!!!!!!!!!!

            
        });

        if (accao.getSource() == btnAdicionarDocente) {
            ArrayList<Docente> docentes = new ArrayList<Docente>();
            Docente docente = new Docente();
            docente.setEmail(tfEmail.getText());
            docente.setNome(tfNome.getText());
            //  docente.setArea((AreaActividade) cbArea.getSelectedItem());


            docentes.add(docente);
            File ficheiro = new File("Actividades.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(docentes);
                objecto.close();

                ObjectInputStream objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                docentes = (ArrayList<Docente>) objectoLer.readObject();
                objectoLer.close();

                listModel.addElement(docente);

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
