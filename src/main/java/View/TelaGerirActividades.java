/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Actividade;
import Model.AreaActividade;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


/**
 * @author Espaco de Inovacao
 */
public class TelaGerirActividades extends JFrame implements ActionListener {


    //Criação de componentes
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField();
    JLabel lbNumeroDeOcorrencias = new JLabel("Ocorrências por Ciclo");
    JSpinner jspNumeroDeVezes = new JSpinner();
    JLabel lbArea = new JLabel("Areas");
    JComboBox cbAreas = new JComboBox<AreaActividade>();
    JButton btnActualizar = new JButton("Actualizar");
    JLabel lbACtividades = new JLabel("Lista de Actividades");
    JList<Actividade> listaDeActividades = new JList<Actividade>();
    JButton btnApagar = new JButton("Apagar");
    JButton btnCriarActividades = new JButton("Criar");
    JCheckBox chTarde = new JCheckBox("Periodo da Tarde");
    JCheckBox chManha = new JCheckBox("Período da Manhã");
    JCheckBox chNoite = new JCheckBox("Período da Noite");
    JCheckBox chIncluirFinalDeSemana = new JCheckBox("Incluir Finais de semana");
    JLabel lbFiltros = new JLabel("Filtros");
    DefaultListModel<Actividade> listModel = new DefaultListModel<>();

    public TelaGerirActividades() {

        setTitle("Gerir Actividades");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);

        listaDeActividades.setModel(listModel);
        btnCriarActividades.addActionListener(this);

        //Alocação de coordenadas no painel.
        lbNome.setBounds(50, 100, 250, 20);
        tfNome.setBounds(50, 120, 250, 20);
        lbNumeroDeOcorrencias.setBounds(50, 140, 200, 20);
        jspNumeroDeVezes.setBounds(50, 160, 60, 20);
        lbArea.setBounds(50, 180, 120, 20);
        cbAreas.setBounds(50, 200, 150, 20);
        lbFiltros.setBounds(50, 240, 80, 20);
        chManha.setBounds(50, 260, 160, 20);
        chTarde.setBounds(50, 280, 160, 20);
        chNoite.setBounds(50, 300, 160, 20);
        btnCriarActividades.setBounds(30, 340, 80, 20);
        chIncluirFinalDeSemana.setBounds(50, 320, 200, 20);
        lbACtividades.setBounds(320, 100, 200, 20);
        listaDeActividades.setBounds(320, 120, 200, 120);
        btnApagar.setBounds(320, 240, 80, 20);
        lbFiltros.setBounds(50, 240, 120, 20);


        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(lbNumeroDeOcorrencias);
        container.add(jspNumeroDeVezes);
        container.add(lbArea);
        container.add(cbAreas);
        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnCriarActividades);
        container.add(listaDeActividades);
        container.add(lbACtividades);
        container.add(lbFiltros);
        container.add(chManha);
        container.add(chNoite);
        container.add(chTarde);
        container.add(chIncluirFinalDeSemana);

    }

    public static void main(String[] args) {


        TelaGerirActividades tela = new TelaGerirActividades();
    }


    @Override
    public void actionPerformed(ActionEvent accao) {
        listaDeActividades.getSelectionModel().addListSelectionListener(e -> {
            Actividade actividade = new Actividade();
            actividade = listaDeActividades.getSelectedValue();
            tfNome.setText(actividade.getNome());
            jspNumeroDeVezes.setValue(actividade.getNumeroDeOcorrencias());
            if (actividade.getManha() == true) chManha.setSelected(true);
            if (actividade.getTarde() == true) chTarde.setSelected(true);
            if (actividade.getNoite() == true) chNoite.setSelected(true);
            if (actividade.getIncluirFinalDeSemana() == true) chIncluirFinalDeSemana.setSelected(true);
            //Pôr a ler do ficheiro!!!!!!!!!!!!!!!!!!


        });
        if (accao.getSource() == btnCriarActividades) {
            ArrayList<Actividade> actividades = new ArrayList<>();
            Actividade actividade = new Actividade();
            actividade.setNome(tfNome.getText());
            //  actividade.setArea(cbAreas.getSelectedItem().toString());
            actividade.setNumeroDeOcorrencias((int) jspNumeroDeVezes.getValue());

            if (chManha.isSelected()) actividade.setManha(true);
            if (chTarde.isSelected()) actividade.setTarde(true);
            if (chNoite.isSelected()) actividade.setNoite(true);
            if (chIncluirFinalDeSemana.isSelected()) actividade.setIncluirFinalDeSemana(true);
            actividades.add(actividade);
            File ficheiro = new File("Actividades.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(actividades);
                objecto.close();

                ObjectInputStream objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                actividades = (ArrayList<Actividade>) objectoLer.readObject();
                objectoLer.close();

                listModel.addElement(actividade);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Actividade");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao Actualizar a lista de Actividades!");
                throw new RuntimeException(e);
            }


        }
        if (accao.getSource() == listaDeActividades) {


        }

    }
}
