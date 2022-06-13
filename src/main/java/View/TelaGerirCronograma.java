/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Cronograma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
public class TelaGerirCronograma extends JFrame implements ActionListener {
    //Criando Variáveis Globais

    ArrayList<Cronograma> cronogramas=new ArrayList<Cronograma>();

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
       // container.add(scrollPane);
        container.add(btnApagar);
        container.add(btnImprimir);
        container.add(listaCronogramas);
        container.add(lbListaCronogramas);
        btnImprimir.addActionListener(this);
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
           // JOptionPane.showMessageDialog(null, "Cronogramas carregados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar os cronogramas!");
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
            
        
            TelaGerirCronograma tela=new TelaGerirCronograma();
            tela.carregarCronogramas();
        }

    @Override
    public void actionPerformed(ActionEvent accao) {

        if (accao.getSource()==btnImprimir){
            Cronograma cronograma = new Cronograma();
            cronograma= (Cronograma) listaCronogramas.getSelectedValue();
            File ficheiro = new File("test.html");
           // ficheiro.

            try {

                PrintWriter pw = null;
                pw = new PrintWriter(new FileWriter("test.html"));
                pw.println("<TABLE BORDER><TR><TH>Segunda<TH>Terça<TH><TH>Quarta<TH><TH>Quinta<TH><TH>Sexta<TH></TR>");

                pw.println("<TR><TD>"+ cronograma.cadeiras.get(0)+ "<TD>" +cronograma.cadeiras.get(1)+ "<TD>"+"<TD>"+cronograma.cadeiras.get(2)+ "<TD>"+"<TD>"+ cronograma.cadeiras.get(3)+ "<TD>"+"<TD>"+cronograma.cadeiras.get(4)+"<TD>"+"<TR>");
                pw.println("<TR><TD>"+ cronograma.cadeiras.get(5)+ "<TD>" +cronograma.cadeiras.get(6)+ "<TD>"+"<TD>"+ cronograma.cadeiras.get(7)+ "<TD>"+"<TD>"+ cronograma.cadeiras.get(8)+ "<TD>"+"<TD>"+cronograma.cadeiras.get(9)+"<TD>"+"<TR>");
                pw.println("<TR><TD>"+ cronograma.cadeiras.get(10)+ "<TD>" +cronograma.cadeiras.get(11)+ "<TD>"+"<TD>"+ cronograma.cadeiras.get(12)+ "<TD>"+"<TD>"+ cronograma.cadeiras.get(13)+ "<TD>"+"<TD>"+cronograma.cadeiras.get(14)+"<TD>"+"<TR>");
                pw.println("</TABLE>");

                pw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }




        }

    }
}
