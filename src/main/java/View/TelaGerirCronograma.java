/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Model.Cadeira;
import Model.Cronograma;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TelaGerirCronograma extends JFrame {
    //Criando Variáveis Globais

    ArrayList<Cronograma> cronogramas=new ArrayList<>();

    //Criando componentes
    DefaultListModel<Cronograma> listModel= new DefaultListModel<>();


    JScrollPane scrollPane = new JScrollPane();

    JButton btnApagar = new JButton("Apagar");
    JLabel lbListaCronogramas = new JLabel("Lista de Cronogramas");
    JList listaCronogramas = new JList<>();
    JButton btnImprimir = new JButton("Imprimir");
    //Alocação de coordenadas no painel

    public TelaGerirCronograma(){

        setTitle("Gerir Cronogramas");
        setSize(400, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        Container container = this.getContentPane();
        container.setLayout(null);



        //Alocando componentes no painel
        scrollPane.setBounds(20,40,250,190);
        btnImprimir.setBounds(20,240,90,20);
        btnApagar.setBounds(150,240,100,20);
        lbListaCronogramas.setBounds(20,20,200,20);
        listaCronogramas.setBounds(20,40,250,190);
        listaCronogramas.setModel(listModel); //Definindo ListModel da lista de Áreas.

        //Adicionando compenentes ao painel.
        scrollPane.setViewportView(listaCronogramas);
        container.add(scrollPane);
        container.add(btnApagar);
        container.add(btnImprimir);
        container.add(listaCronogramas);
        container.add(lbListaCronogramas);
        }

    public void carregarCronogramas() throws IOException, ClassNotFoundException {


        Cronograma cronograma = new Cronograma();
        cronogramas.add(cronograma);
        File ficheiro = new File("cronogramas.crono");
        ObjectInputStream objectoLer = null;
        try {

            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            cronogramas = (ArrayList<Cronograma>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < cronogramas.size(); i++) {

                cronograma = cronogramas.get(i);
                cronograma.setCodigo(i);
                listModel.addElement(cronograma);
            }
            JOptionPane.showMessageDialog(null, "Cronogramas carregados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar os cronogramas!");
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
            
        
            TelaGerirCronograma tela=new TelaGerirCronograma();
            tela.carregarCronogramas();
        }
        
}
