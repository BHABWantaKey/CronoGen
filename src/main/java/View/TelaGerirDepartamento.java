/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Cadeira;
import Model.Departamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class TelaGerirDepartamento extends JFrame implements ActionListener {



    JScrollPane scrollPane = new JScrollPane();

    ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
    //Criação de componentes
    JLabel lbNome = new JLabel("Nome do Departamento");
    JTextField tfNome = new JTextField(30);
    JButton btnVoltar = new JButton("Voltar");

    JButton btnRegistarDepartamento = new JButton("Registar");

    JList<Cadeira> jListCadeiras =new JList<Cadeira>();
    JLabel lbAreas= new JLabel("Áreas");
    JButton btnAddCadeira = new JButton("Adicionar");
    JButton btnApagarCadeira = new JButton("Apagar");
    JTextField tfAreas = new JTextField();
    DefaultListModel<Cadeira> listModel= new DefaultListModel<>();

    public TelaGerirDepartamento() {




        setTitle("Departamento");
        setSize(350, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(null);


        //Alocação de coordenadas no painel.
        btnVoltar.setBounds(1,1,70,20);
        lbNome.setBounds(50, 50, 250, 20);
        tfNome.setBounds(50, 70, 250, 20);
        btnRegistarDepartamento.setBounds(50, 110, 80, 20);
        btnRegistarDepartamento.addActionListener(this);
        jListCadeiras.setModel(listModel); //Definindo ListModel da lista de Áreas.
        lbAreas.setBounds(50,150,100,20);
        jListCadeiras.setBounds(50,210,180,120);
        btnApagarCadeira.setBounds(50,330,80,20);
        btnAddCadeira.setBounds(150,170,90,20);
        btnAddCadeira.addActionListener(this);
        tfAreas.setBounds(50,170,90,20);
        scrollPane.setBounds(50,210,180,120);
        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(btnRegistarDepartamento);
        container.add(lbAreas);
        container.add(jListCadeiras);
        container.add(btnAddCadeira);
        container.add(btnApagarCadeira);
        container.add(tfAreas);
        scrollPane.setViewportView(jListCadeiras);
        jListCadeiras.setLayoutOrientation(JList.VERTICAL);
        container.add(scrollPane);
        container.add(btnVoltar);

        //Adicionando Actionlistenners nos componentes
        btnVoltar.addActionListener(this);
        btnApagarCadeira.addActionListener(this);
    }

    public void carregarCadeiras() throws IOException, ClassNotFoundException {


        Cadeira cadeira = new Cadeira();
        cadeiras.add(cadeira);
        File ficheiro = new File("cadeiras.crono");
        ObjectInputStream objectoLer = null;
        try {
            listModel.removeAllElements();
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            cadeiras = (ArrayList<Cadeira>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < cadeiras.size(); i++) {

                cadeira = cadeiras.get(i);
                cadeira.setCodigo(i);
                listModel.addElement(cadeira);
            }
          JOptionPane.showMessageDialog(null, "Áreas de actividade carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as áreas de actividade.");
            throw new RuntimeException(e);
        }


    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {


        TelaGerirDepartamento tela = new TelaGerirDepartamento();
        tela.carregarCadeiras();


    }


    @Override
    public void actionPerformed(ActionEvent accao) {
        //Definindo acção do botão para voltar.
        if (accao.getSource() == btnVoltar){this.dispose();
        TelaMenuSecretario telaMenuSecretario=new TelaMenuSecretario();}

        //Definindo a acção do botão para registar Departamento.
        if (accao.getSource() == btnRegistarDepartamento) {

            Departamento departamento = new Departamento();

            departamento.setNome(tfNome.getText());


            File ficheiro = new File("departamento.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(departamento);
                objecto.close();

                JOptionPane.showMessageDialog(null, "Departamento " + departamento.getNome() + " registado com sucesso.");
                tfNome.setText("");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Departamento");
                throw new RuntimeException(e);
            }


    }

        //Definindo acção do botão para adicionar cadeiras.
        if (accao.getSource() == btnAddCadeira) {

            Cadeira cadeira = new Cadeira();

            cadeira.setNomeCadeira(tfAreas.getText());



            cadeiras.add(cadeira);
            File ficheiro = new File("cadeiras.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(cadeiras);
                objecto.flush();
                objecto.close();

                ObjectInputStream objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
                cadeiras = (ArrayList<Cadeira>) objectoLer.readObject();
                objectoLer.close();

                listModel.addElement(cadeira);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao registar Cadeira");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao Actualizar a lista de Cadeiras!");
                throw new RuntimeException(e);
            }


        }

        //Definindo acção para o botão para apagar cadeiras
        if (accao.getSource() == btnApagarCadeira){

            Cadeira cadeira = new Cadeira();
            cadeira= jListCadeiras.getSelectedValue();
            cadeiras.remove(cadeira.getCodigo());
            JOptionPane.showMessageDialog(null,"Cadeira "+cadeira.getNomeCadeira()+"removida com sucesso");

            File ficheiro = new File("cadeiras.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(cadeiras);
                objecto.flush();
                objecto.close();
                carregarCadeiras();



            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Falha ao apagar cadeira!");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }




    }}
