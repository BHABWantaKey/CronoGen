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


public class TelaGerirTurma extends JFrame implements ActionListener {




    ArrayList<Turma> turmas = new ArrayList<Turma>();
    ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
    //Criação de componentes
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(30);
    JButton btnActualizar = new JButton("Actualizar");
    JLabel lbListaDeTurmas = new JLabel("Lista de Turmas");
    JComboBox<Turma> listaDeTurmas = new JComboBox<Turma>();
    JButton btnApagar = new JButton("APagar");
    JButton btnCriarTurma = new JButton("Criar");
    JList listaDeCadeiras= new JList();
    JLabel lbListaDeCadeiras= new JLabel("Lista de cadeiras");
    JComboBox<Cadeira> cadeiraJComboBox= new JComboBox<>();
    JLabel lbCadeira= new JLabel("Cadeiras");
    JButton btnAssociar = new JButton("Associar");
    DefaultListModel<Cadeira> listModel = new DefaultListModel();
    JButton btnVoltar = new JButton("Voltar");

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
        btnVoltar.setBounds(1,1,70,20);
        btnAssociar.setBounds(50,210,100,20);
        lbNome.setBounds(50, 50, 250, 20);
        tfNome.setBounds(50, 70, 250, 20);
        lbListaDeCadeiras.setBounds(350,50,120,20);
        listaDeCadeiras.setBounds(350,70,150,190);
        listaDeCadeiras.setModel(listModel);
        btnCriarTurma.setBounds(50,240, 80, 20);
        btnCriarTurma.addActionListener(this);
        btnActualizar.setBounds(150,240, 100, 20);
        lbListaDeTurmas.setBounds(50,110, 200, 20);
        listaDeTurmas.setBounds(50,130, 180, 20);
        btnApagar.setBounds(240,130, 98, 20);btnApagar.setIconTextGap(5);
        lbCadeira.setBounds(50,160,200,20);
        cadeiraJComboBox.setBounds(50,180,180,20);
btnAssociar.addActionListener(this);

        //Adicionando compenentes ao painel.
        container.add(btnVoltar);
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
        btnVoltar.setIcon((new ImageIcon("")));
        btnApagar.setIcon(new ImageIcon("Imagens/clear.png"));
        //Adicionando Action listeners aos botões
        btnVoltar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnApagar.addActionListener(this);
    }



    public void carregarTurmas() throws IOException, ClassNotFoundException {


        Turma turma = new Turma();



        turmas.add(turma);
        File ficheiro = new File("turmas.crono");
        ObjectInputStream objectoLer = null;
        listaDeTurmas.removeAllItems();
        if (ficheiro.exists()==true)
        try {
            listaDeTurmas.removeAllItems();
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            turmas = (ArrayList<Turma>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < turmas.size(); i++) {

                turma = turmas.get(i);
                turma.setCodigo(i);
                listaDeTurmas.addItem(turma);
            }
          //  JOptionPane.showMessageDialog(null, "Turmas carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as turmas");
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
            for (int i = 0; i < cadeiras.size(); i++) {

                cadeira = cadeiras.get(i);
                cadeira.setCodigo(i);
                cadeiraJComboBox.addItem(cadeira);
            }
       //     JOptionPane.showMessageDialog(null, "Cadeiras carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as cadeiras.");
            throw new RuntimeException(e);
        }


    }

    public void carregarCadeirasDasTurmas() throws IOException, ClassNotFoundException {


        Turma turma = new Turma();
        ArrayList<Cadeira> cadeiras= new ArrayList<Cadeira>();
        turma= (Turma) listaDeTurmas.getSelectedItem();

        cadeiras = turma.getCadeiras();
listModel.removeAllElements();
          //  JOptionPane.showMessageDialog(null,cadeiras.get(0).getNomeCadeira());
            for (int i = 0; i < cadeiras.size(); i++) {
                listModel.addElement(cadeiras.get(i));
              //  JOptionPane.showMessageDialog(null,cadeiras.get(i).getNomeCadeira());
            }



    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {


        TelaGerirTurma tela = new TelaGerirTurma();
        tela.carregarCadeiras();
        tela.carregarTurmas();


    }

    @Override
    public void actionPerformed(ActionEvent accao) {








        if (accao.getSource()==btnVoltar){
            this.dispose(); TelaMenuSecretario telaMenuSecretario=new TelaMenuSecretario(); this.dispose();}

        if (accao.getSource() == btnActualizar) {
            try {
                carregarCadeirasDasTurmas();
                JOptionPane.showMessageDialog(null,"Cadeiras carregadas com sucesso");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


        if (accao.getSource() == btnAssociar){
            Turma turma;
            Cadeira cadeira;
            cadeira=(Cadeira) cadeiraJComboBox.getSelectedItem();

            turma= (Turma) listaDeTurmas.getSelectedItem();
            turma.cadeiras.add(cadeira);

            JOptionPane.showMessageDialog(null,"Cadeira " + cadeira.getNomeCadeira()+ "Associada a turma"+ turma.getNome());
            File ficheiro = new File("turmas.crono");

            ObjectOutputStream objecto = null;
            try {
                objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                objecto.writeObject(turmas);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                objecto.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        if (accao.getSource() == btnCriarTurma) {

Turma turma= new Turma();

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

                JOptionPane.showMessageDialog(null, "Turma " + turma.getNome() + " registada com sucesso.");
                carregarTurmas();

            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Actividade");
                throw new RuntimeException(e);
            }


        }

        //Accões para o botão que serve para apagar turma
        if (accao.getSource() == btnApagar){

            Turma turma = new Turma();
            turma= (Turma) listaDeTurmas.getSelectedItem();
            turmas.remove(turma.getCodigo());
            JOptionPane.showMessageDialog(null,"Turma "+turma.getNome()+" removida com sucesso");

            File ficheiro = new File("turmas.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(turmas);
                objecto.flush();
                objecto.close();
                carregarTurmas();



            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Falha ao apagar turma!");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
