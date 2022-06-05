/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Cadeira;
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

    ArrayList<Turma> turmas = new ArrayList<Turma>();
    ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
    //Criação de componentes
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(30);
    JButton btnActualizar = new JButton("Actualizar");
    JLabel lbListaDeTurmas = new JLabel("Lista de Turmas");
    JComboBox<Turma> listaDeTurmas = new JComboBox<>();
    JButton btnApagar = new JButton("APagar");
    JButton btnCriarTurma = new JButton("Criar");
    JList listaDeCadeiras= new JList();
    JLabel lbListaDeCadeiras= new JLabel("Lista de cadeiras");
    JComboBox<Cadeira> cadeiraJComboBox= new JComboBox<>();
    JLabel lbCadeira= new JLabel("Cadeiras");
    JButton btnAssociar = new JButton("Associar");
    DefaultListModel<Turma> listModel = new DefaultListModel();

    public TelaGerirTurma() {

        setTitle("Gerir Turma");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


        setTitle("Gerir Turmas");
        setSize(550, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);


        //Alocação de coordenadas no painel.
        btnAssociar.setBounds(50,210,100,20);
        lbNome.setBounds(50, 50, 250, 20);
        tfNome.setBounds(50, 70, 250, 20);
        lbListaDeCadeiras.setBounds(350,50,120,20);
        listaDeCadeiras.setBounds(350,70,150,190);
        btnCriarTurma.setBounds(50,240, 80, 20);
        btnCriarTurma.addActionListener(this);
        btnActualizar.setBounds(150,240, 100, 20);
        lbListaDeTurmas.setBounds(50,110, 200, 20);
        listaDeTurmas.setBounds(50,130, 180, 20);
        btnApagar.setBounds(240,130, 80, 20);
        lbCadeira.setBounds(50,160,200,20);
        cadeiraJComboBox.setBounds(50,180,180,20);

        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnCriarTurma);
        container.add(listaDeTurmas);
        container.add(lbListaDeTurmas);
        container.add(listaDeCadeiras);
        container.add(lbListaDeCadeiras);
        container.add(lbCadeira);
        container.add(cadeiraJComboBox);
        container.add(btnAssociar);
    }



    public void carregarTurmas() throws IOException, ClassNotFoundException {


        Turma turma = new Turma();



        turmas.add(turma);
        File ficheiro = new File("turmas.crono");
        ObjectInputStream objectoLer = null;
        try {
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            turmas = (ArrayList<Turma>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < turmas.size(); i++) {

                turma = turmas.get(i);
                listaDeTurmas.addItem(turma);
            }
            JOptionPane.showMessageDialog(null, "Turmas carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as turmas");
            throw new RuntimeException(e);
        }


    }
    public void carregarCadeiras() throws IOException, ClassNotFoundException {


        Cadeira cadeira = new Cadeira();



        cadeiras.add(cadeira);
        File ficheiro = new File("areasDeActividade.crono");
        ObjectInputStream objectoLer = null;
        try {
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            cadeiras = (ArrayList<Cadeira>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < cadeiras.size(); i++) {

                cadeira = cadeiras.get(i);
                cadeiraJComboBox.addItem(cadeira);
            }
            JOptionPane.showMessageDialog(null, "Áreas de actividade carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as áreas de actividade.");
            throw new RuntimeException(e);
        }


    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {


        TelaGerirTurma tela = new TelaGerirTurma();
        tela.carregarTurmas();
        tela.carregarCadeiras();
    }


    @Override
    public void actionPerformed(ActionEvent accao) {



        if (accao.getSource() == btnCriarTurma) {

            Turma turma = new Turma();

            turma.setNome(tfNome.getText());


            turmas.add(turma);
            File ficheiro = new File("turmas.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(turmas);
                objecto.close();

                ObjectInputStream objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                turmas = (ArrayList<Turma>) objectoLer.readObject();
                objectoLer.close();
                listModel.addElement(turma);
                JOptionPane.showMessageDialog(null, "Turma " + turma.getNome() + " registada com sucesso.");

            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Actividade");
                throw new RuntimeException(e);
            }


        }
    }
}
