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
    JLabel lbNumeroDeOcorrencias = new JLabel("Ocorrências por Ciclo");
    JSpinner jspNumeroDeVezes = new JSpinner();
    JLabel lbDocentes = new JLabel("Docentes");
    JComboBox<Docente> cbDocentes = new JComboBox<Docente>();
    JButton btnActualizar = new JButton("Actualizar");
    JLabel lbDocentes2 = new JLabel("Lista de Docentes");
    JList<Docente> listaDocentes = new JList<Docente>();
    JButton btnApagar = new JButton("Apagar");
    JButton btnCriarActividades = new JButton("Criar");
    JLabel lbFiltros = new JLabel("Filtros");
    JComboBox diasDisponivel = new JComboBox();
    JComboBox horasDisponivel = new JComboBox();
    DefaultListModel<Docente> listModel = new DefaultListModel<>();

    public TelaAdicionarDisponibilidade() {

        setTitle("Gerir Disponibilidade");
        setSize(550, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);

        listaDocentes.setModel(listModel);
        btnCriarActividades.addActionListener(this);

        //Alocação de coordenadas no painel.
        lbNome.setBounds(50, 50, 250, 20);
        tfNome.setBounds(50, 70, 250, 20);
        lbNumeroDeOcorrencias.setBounds(50, 90, 200, 20);
        jspNumeroDeVezes.setBounds(50, 110, 60, 20);
        lbDocentes.setBounds(50, 130, 120, 20);
        cbDocentes.setBounds(50, 150, 150, 20);
        lbFiltros.setBounds(50, 170, 80, 20);

        btnCriarActividades.setBounds(50, 350, 80, 20);
        lbDocentes2.setBounds(320, 50, 200, 20);
        listaDocentes.setBounds(320, 70, 200, 250);
        btnApagar.setBounds(320, 350, 80, 20);
        lbFiltros.setBounds(50, 170, 120, 20);


        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(lbNumeroDeOcorrencias);
        container.add(jspNumeroDeVezes);
        container.add(lbDocentes);
        container.add(cbDocentes);
        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnCriarActividades);
        container.add(listaDocentes);
        container.add(lbDocentes2);
        container.add(lbFiltros);

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
                listaDocentes.setModel(listModel);
                listModel.addElement(docente);
            }
            JOptionPane.showMessageDialog(null, "Docentes carregados com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar a Lista de docentes.");
            throw new RuntimeException(e);
        }

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
            tfNome.setText(docente.getNome());


        });
        if (accao.getSource() == btnCriarActividades) {

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

                listModel.addElement(docente);

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
