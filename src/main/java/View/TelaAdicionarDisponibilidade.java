/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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
public class TelaAdicionarDisponibilidade extends JFrame implements ActionListener {
    ArrayList<Docente> docentes = new ArrayList<Docente>();
    //Criação de componentes
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField();
    JLabel lbDias = new JLabel("Dias");
    String [] dias= new String[]{"Segunda","Terça","Quarta","Quinta","Sexta","Sábado","Domingo"};

    JComboBox<String> cbDias = new JComboBox<String>(dias);

    JLabel lbHoras = new JLabel("Horas");
    String [] horas= new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
    JComboBox<String> cbHoras = new JComboBox<String>(horas);
    JButton btnActualizar = new JButton("Actualizar");
    JLabel lbDocentes2 = new JLabel("Lista de Docentes");
    JList<Docente> listaDocentes = new JList<Docente>();
    JButton btnApagar = new JButton("Apagar");
    JButton btnAdicionarDisponibilidade = new JButton("Adicionar");
    JList  listaDisponibilidade = new JList();
    JLabel lbDisponibilidade = new JLabel("Disponibilidade");

    DefaultListModel<Docente> listModelDocentes = new DefaultListModel<>();
    DefaultListModel<Docente> listModelDisponibilidade = new DefaultListModel<>();

    public TelaAdicionarDisponibilidade() {

        setTitle("Gerir Disponibilidade");
        setSize(550, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);
        listaDisponibilidade.setModel(listModelDisponibilidade);
        listaDocentes.setModel(listModelDocentes);
        btnAdicionarDisponibilidade.addActionListener(this);

        //Alocação de coordenadas no painel.
        lbNome.setBounds(50, 50, 250, 20);
        tfNome.setBounds(50, 70, 250, 20);
        lbDias.setBounds(50, 90, 200, 20);
        cbDias.setBounds(50, 110, 120, 20);
        lbHoras.setBounds(50, 130, 120, 20);
        cbHoras.setBounds(50, 150, 100, 20);
        lbDisponibilidade.setBounds(50,170,150,20);
        listaDisponibilidade.setBounds(50,190,150,150);
        btnAdicionarDisponibilidade.setBounds(50, 350, 80, 20);
        lbDocentes2.setBounds(320, 50, 200, 20);
        listaDocentes.setBounds(320, 70, 200, 250);
        btnApagar.setBounds(320, 350, 80, 20);


        //Adicionando compenentes ao painel.
        container.add(lbDisponibilidade);
        container.add(listaDisponibilidade);
        container.add(lbNome);
        container.add(tfNome);
        container.add(lbDias);
        container.add(cbDias);
        container.add(lbHoras);
        container.add(cbHoras);
        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnAdicionarDisponibilidade);
        container.add(listaDocentes);
        container.add(lbDocentes2);

    }

    public void carregarDocentes() throws IOException, ClassNotFoundException {

        //ArrayList<Docente> docentes = new ArrayList<Docente>();
        Docente docente = new Docente();

        docentes.add(docente);
        File ficheiro = new File("docentes.crono");
        ObjectInputStream objectoLer = null;
        try {
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            docentes = (ArrayList<Docente>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < docentes.size(); i++) {

                docente = docentes.get(i);
                listaDocentes.setModel(listModelDocentes);
                listModelDocentes.addElement(docente);
            }
            JOptionPane.showMessageDialog(null, "Docentes carregados com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar a Lista de docentes.");
            throw new RuntimeException(e);
        }

    }
    public  void preencherCbs(){



    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        TelaAdicionarDisponibilidade tela = new TelaAdicionarDisponibilidade();
        tela.carregarDocentes();
    }

    @Override
    public void actionPerformed(ActionEvent accao) {

        listaDocentes.getSelectionModel().addListSelectionListener(e -> {
            Docente docente = new Docente();

            docente = listaDocentes.getSelectedValue();
            //listModelDisponibilidade.addElement(docente.dias[]+docente.horas[]);


        });


        if (accao.getSource() == btnAdicionarDisponibilidade) {

            Docente docente = new Docente();
            docente.setNome(tfNome.getText());
            //  docente.setArea(cbDocentes.getSelectedItem().toString());


            File ficheiro = new File("docentes.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(docentes);
                objecto.close();

                ObjectInputStream objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                docentes = (ArrayList<Docente>) objectoLer.readObject();
                objectoLer.close();

                listModelDocentes.addElement(docente);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Actividade");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao Actualizar a lista de Actividades!");
                throw new RuntimeException(e);
            }


        }
        if (accao.getSource() == listaDocentes) {


        }

    }
}
