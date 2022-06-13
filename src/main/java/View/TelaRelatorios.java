/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class TelaRelatorios extends JFrame implements ActionListener {
    //Criando variáveis globais
    Departamento departamento = new Departamento();
    ArrayList<Cadeira>cadeiras= new ArrayList<>();
    ArrayList<Cronograma>cronogramas= new ArrayList();
    ArrayList<Docente> docentes=new ArrayList<>();
    ArrayList<Turma> turmas = new ArrayList<>();


    //Criando componentes
    JButton btnVoltar = new JButton(new ImageIcon("Imagens/back.png"));
    JLabel lbDepartamento=new JLabel();
    JLabel lbDocentes=new JLabel();
    JLabel lbCadeiras= new JLabel();
    JLabel lbCronogramas= new JLabel();
    JLabel lbImgCrono = new JLabel(new ImageIcon("Imagens/time.png"));
    JLabel lbImgDoc= new JLabel(new ImageIcon("Imagens/teacher.png"));
    JLabel lbImgCad= new JLabel(new ImageIcon("Imagens/book.png"));
    JLabel lbTurmas= new JLabel();
    JLabel lbImgTurma= new JLabel(new ImageIcon("Imagens/class.png"));
    public TelaRelatorios(){
        //Configurando o frame

        setTitle("Relatórios");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);
        //ALocando componentes no frame
        lbDepartamento.setBounds(140,10,120,40);
        lbImgCrono.setBounds(40,60,40,40);
        lbCronogramas.setBounds(10,110,100,20);
        lbImgCad.setBounds(120,60,60,40);
        lbCadeiras.setBounds(120,110,80,20);
        lbImgDoc.setBounds(220,60,60,40);
        lbDocentes.setBounds(220,110,80,20);
        lbImgTurma.setBounds(320,60,40,40);
        lbTurmas.setBounds(310,110,80,20);
        btnVoltar.setBounds(10,10,20,20);
        //Adicionando componentes ao painel
       container.add(lbDepartamento);
       container.add(lbCadeiras);
        container.add(lbDocentes);
        container.add(lbImgCad);
        container.add(lbCadeiras);
        container.add(lbCronogramas);
        container.add(lbImgCrono);
        container.add(lbImgDoc);
        container.add(lbImgTurma);
        container.add(lbTurmas);
        container.add(btnVoltar);
        btnVoltar.addActionListener(this);
        }



    public void carregarDepartamento() throws IOException, ClassNotFoundException {




        File ficheiro = new File("departamento.crono");
        ObjectInputStream objectoLer = null;
        try {

            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            departamento = (Departamento) objectoLer.readObject();
            objectoLer.close();
            lbDepartamento.setText("Departamento:"+departamento.getNome());
            JOptionPane.showMessageDialog(null, "Departamento carregado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar Departamento!");
            throw new RuntimeException(e);
        }


    }
    public void carregarCadeiras() throws IOException, ClassNotFoundException {


        Cadeira cadeira = new Cadeira();
        cadeiras.add(cadeira);
        File ficheiro = new File("cadeiras.crono");
        ObjectInputStream objectoLer = null;
        try {

            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            cadeiras = (ArrayList<Cadeira>) objectoLer.readObject();
            objectoLer.close();
            lbCadeiras.setText(String.valueOf(cadeiras.size())+" cadeiras");
            JOptionPane.showMessageDialog(null, "Áreas de actividade carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as áreas de actividade.");
            throw new RuntimeException(e);
        }


    }
    public void carregarDocentes() throws IOException, ClassNotFoundException {


        Docente docente = new Docente();
        docentes.add(docente);
        File ficheiro = new File("docentes.crono");
        ObjectInputStream objectoLer = null;
        lbDocentes.setText(String.valueOf(docentes.size())+" docentes");
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
            lbCronogramas.setText(String.valueOf(cronogramas.size())+" cronogramas");
            JOptionPane.showMessageDialog(null, "Cronogramas carregados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar os cronogramas!");
            throw new RuntimeException(e);
        }


    }
    public void carregarTurmas() throws IOException, ClassNotFoundException {


        Turma turma = new Turma();



        turmas.add(turma);
        File ficheiro = new File("turmas.crono");
        ObjectInputStream objectoLer = null;
        if (ficheiro.exists()==true)
            try {
                objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                turmas = (ArrayList<Turma>) objectoLer.readObject();
                objectoLer.close();
                lbTurmas.setText(String.valueOf(turmas.size())+" Turmas");
                JOptionPane.showMessageDialog(null, "Turmas carregadas com sucesso");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as turmas");
                throw new RuntimeException(e);
            }


    }




    public static void main(String[] args) throws IOException, ClassNotFoundException {
            
        
            TelaRelatorios tela=new TelaRelatorios();
            tela.carregarDocentes();
            tela.carregarCadeiras();
            tela.carregarCronogramas();
            tela.carregarDepartamento();
            tela.carregarTurmas();
        }


    @Override
    public void actionPerformed(ActionEvent accao) {

        if (accao.getSource()==btnVoltar){

            this.dispose();
            TelaMenuSecretario telaMenuSecretario= new TelaMenuSecretario();


        }

    }
}
