/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Cadeira;
import Model.Docente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class TelaGerirDocente extends JFrame implements ActionListener {

    ArrayList<Docente> docentes = new ArrayList<Docente>();
    ArrayList<Cadeira> cadeiras =new ArrayList<>();
    //Criação de componentes e do Painel
    Container container = this.getContentPane();

    JLabel lblNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(30);

    JLabel lbCategoria = new JLabel("Categoria");
    JTextField tfCategoria = new JTextField(30);


    JLabel lblArea = new JLabel("Areas");
    JComboBox<Cadeira> cbArea = new JComboBox<Cadeira>();

    JLabel lbDocentes = new JLabel("Lista de Docentes");

    JButton btnAdicionarDocente = new JButton("Adicionar");
    JButton btnVoltar = new JButton("Voltar");
    JButton btnApagar = new JButton("Apagar");
    JList<Docente> listaDocentes = new JList<Docente>();
    JScrollPane scrollPane = new JScrollPane();

    DefaultListModel<Docente> listModel = new DefaultListModel<>();

    public TelaGerirDocente() {

        setTitle("Gerir Docente");
        setSize(550, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);



        container.setLayout(null);
        btnAdicionarDocente.addActionListener(this);
        lblNome.setBounds(30, 100, 150, 20);
        tfNome.setBounds(30, 120, 250, 20);
        lbCategoria.setBounds(30, 140, 150, 20);
        tfCategoria.setBounds(30, 160, 250, 20);
        btnAdicionarDocente.setBounds(30, 260, 100, 20);
        btnVoltar.setBounds(1, 1, 70, 20);
        lbDocentes.setBounds(350, 100, 120, 20);
        listaDocentes.setBounds(350, 120, 160, 180);
        scrollPane.setBounds(350, 120, 160, 180);
        btnApagar.setBounds(350, 305, 75, 20);
        lblArea.setBounds(30, 200, 150, 20);
        cbArea.setBounds(30, 220, 150, 20);


        //Coluna Oeste
        container.add(lblNome);
        container.add(tfNome);
        container.add(lbCategoria);
        container.add(tfCategoria);
        container.add(tfCategoria);
        container.add(btnAdicionarDocente);
        container.add(btnApagar);
        container.add(btnVoltar);
        //Coluna central
        container.add(lblArea);
        container.add(cbArea);
        container.add(scrollPane);
        //Coluna Este
        container.add(lbDocentes);
        container.add(listaDocentes);
        btnVoltar.addActionListener(this);
        btnApagar.addActionListener(this);
        listaDocentes.setModel(listModel);
        scrollPane.setViewportView(listaDocentes);
        listaDocentes.setLayoutOrientation(JList.VERTICAL);

    }

    public void carregarDocentes() throws IOException, ClassNotFoundException {


        Docente docente = new Docente();
        docentes.add(docente);
        File ficheiro = new File("docentes.crono");
        ObjectInputStream objectoLer = null;
        try {
            listModel.removeAllElements();
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            docentes = (ArrayList<Docente>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < docentes.size(); i++) {

                docente = docentes.get(i);
                docente.setCodigo(i);
                listModel.addElement(docente);
            }
          //  JOptionPane.showMessageDialog(null, "Docentes carregados com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar a Lista de docentes.");
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
                cbArea.addItem(cadeira);
            }
          //  JOptionPane.showMessageDialog(null, "Áreas de actividade carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as áreas de actividade.");
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        TelaGerirDocente tela = new TelaGerirDocente();
        tela.carregarCadeiras();
        tela.carregarDocentes();



    }


    @Override
    public void actionPerformed(ActionEvent accao) {

        if (accao.getSource() == btnVoltar){
            this.dispose();
        TelaMenuSecretario telaMenuSecretario= new TelaMenuSecretario();}


        listaDocentes.getSelectionModel().addListSelectionListener(e -> {
            try {
                Docente docente = new Docente();
                docente = listaDocentes.getSelectedValue();
                tfNome.setText(docente.getNome());
                tfCategoria.setText(docente.getUsuario());
                cbArea.setSelectedItem(docente.getCadeira());
            } catch (Exception exception){}


        });

        if (accao.getSource() == btnAdicionarDocente) {

            Docente docente = new Docente();
            docente.setUsuario(tfCategoria.getText());
            docente.setNome(tfNome.getText());
            docente.setCadeira((Cadeira) cbArea.getSelectedItem());
            ((Cadeira) cbArea.getSelectedItem()).setDocente(docente);
            tfCategoria.setText("");
            tfNome.setText("");

            docentes.add(docente);
            File ficheiro = new File("docentes.crono");

            try {

                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(docentes);
                objecto.flush();
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


        //Acção do botão para apagar docentes
        if (accao.getSource() == btnApagar){

            Docente docente = new Docente();
            docente= listaDocentes.getSelectedValue();
            docentes.remove(docente.getCodigo());
            JOptionPane.showMessageDialog(null,"Docente "+docente.getNome()+" removido com sucesso");

            File ficheiro = new File("docentes.crono");

            try {
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                objecto.writeObject(docentes);
                objecto.flush();
                objecto.close();
                carregarDocentes();



            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Falha ao apagar docente!");
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
