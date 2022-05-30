/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.AreaActividade;
import Model.Docente;
import Model.Instituicao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Espaco de Inovacao
 */
public class TelaRegistarInstituicao extends JFrame implements ActionListener {

    ArrayList<AreaActividade> areasActividade = new ArrayList<AreaActividade>();
    //Criação de componentes
    JLabel lbNome = new JLabel("Nome da Instituição");
    JTextField tfNome = new JTextField(30);

    JButton btnRegistarInstituicao = new JButton("Criar");

    JList<AreaActividade> listaAreas =new JList<AreaActividade>();
    JLabel lbAreas= new JLabel("Áreas");
    JButton btnAddArea= new JButton("Adicionar");
    JButton btnApagarArea = new JButton("Apagar");
    JTextField tfAreas = new JTextField();
    DefaultListModel<AreaActividade> listModel= new DefaultListModel<>();

    public TelaRegistarInstituicao() {

        setTitle("Instituição");
        setSize(350, 400);
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
        listaAreas.setModel(listModel); //Definindo ListModel da lista de Áreas.
        lbAreas.setBounds(50,150,100,20);
        listaAreas.setBounds(50,210,180,120);
        btnApagarArea.setBounds(50,330,80,20);
        btnAddArea.setBounds(150,170,90,20);
        btnAddArea.addActionListener(this);
        tfAreas.setBounds(50,170,90,20);
        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(btnRegistarInstituicao);
        container.add(lbAreas);
        container.add(listaAreas);
        container.add(btnAddArea);
        container.add(btnApagarArea);
        container.add(tfAreas);

    }

    public void carregarAreas() throws IOException, ClassNotFoundException {


        AreaActividade areaActividade = new AreaActividade();
        areasActividade.add(areaActividade);
        File ficheiro = new File("areasDeActividade.crono");
        ObjectInputStream objectoLer = null;
        try {
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            areasActividade = (ArrayList<AreaActividade>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < areasActividade.size(); i++) {

                areaActividade = areasActividade.get(i);
                listModel.addElement(areaActividade);
            }
            JOptionPane.showMessageDialog(null, "Áreas de actividade carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as áreas de actividade.");
            throw new RuntimeException(e);
        }


    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {


        TelaRegistarInstituicao tela = new TelaRegistarInstituicao();
        tela.carregarAreas();


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
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Instituição");
                throw new RuntimeException(e);
            }


    }


        if (accao.getSource() == btnAddArea) {

            AreaActividade areaActividade = new AreaActividade();

            areaActividade.setArea(tfAreas.getText());



            areasActividade.add(areaActividade);
            File ficheiro = new File("areasDeActividade.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(areasActividade);
                objecto.flush();
                objecto.close();

                ObjectInputStream objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                areasActividade = (ArrayList<AreaActividade>) objectoLer.readObject();
                objectoLer.close();

                listModel.addElement(areaActividade);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Actividade");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao Actualizar a lista de Actividades!");
                throw new RuntimeException(e);
            }


        }




    }}
