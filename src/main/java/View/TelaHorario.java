//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package View;

import Model.Cadeira;
import Model.Turma;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaHorario extends JFrame implements ActionListener{


    //Criando Componentes
    Container container = this.getContentPane(); //Cria painel

    DefaultTableModel model = new DefaultTableModel();
   JComboBox cbTurmas = new JComboBox<Turma>();

    ArrayList <Turma> turmas = new ArrayList<>();

    JLabel lblAula = new JLabel("Turmas");
    JButton btnADD = new JButton("Gerar Cronograma");
    Object[] row = new Object[5];
    JButton btnVoltar = new JButton("Voltar");
    JTable table = new JTable();
    JScrollPane pane = new JScrollPane(table);
    Object[] columns = new Object[]{"SEG", "TER", "QUA", "QUI", "SEX"};

    public void carregarTurmas() throws IOException, ClassNotFoundException {


        Turma turma = new Turma();


        turmas.add(turma);
        File ficheiro = new File("turmas.crono");
        ObjectInputStream objectoLer = null;

        try {
            objectoLer = new ObjectInputStream(new FileInputStream(ficheiro));
            turmas = (ArrayList<Turma>) objectoLer.readObject();
            objectoLer.close();
            for (int i = 0; i < turmas.size(); i++) {

                turma = turmas.get(i);
                cbTurmas.addItem(turma);
            }
            JOptionPane.showMessageDialog(null, "Turmas carregadas com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as turmas");
            throw new RuntimeException(e);
        }


    }
    public  TelaHorario()
    {
        try {
            carregarTurmas();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Configurando frame componentes
        setTitle("Horário");
        setBackground(Color.WHITE);
        setLayout(null);
       setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.GREEN);
        table.setBackground(Color.BLACK);
        table.setSelectionBackground(Color.RED);
        table.setGridColor(Color.RED);
        table.setFont(new Font("Tahoma", 0, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        pane.setForeground(Color.WHITE);
        pane.setBackground(Color.BLACK);
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);
        lblAula.setFont(new Font("Tahoma", 0, 20));

        //Alocando componentes na tela
        cbTurmas.setBounds(120, 180, 220, 20);
        lblAula.setBounds(20, 180, 80, 20);
        btnVoltar.setBounds(1,1,70,20);
        btnADD.setBounds(20, 220, 200, 20);
        pane.setBounds(10, 50, 721, 120);


        //adicionando componentes a tela
        container.add(cbTurmas);
        container.add(pane);
        container.add(lblAula);
        container.add(btnADD);
        container.add(btnVoltar);

        //Adicionando action listenners aos componentes
        btnADD.addActionListener(this);
        btnVoltar.addActionListener(this);

        //Definindo UI manager



    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        TelaHorario tela=new TelaHorario();
        tela.setVisible(true);







    }

    @Override
    public void actionPerformed(ActionEvent accao) {

        if (accao.getSource() == btnVoltar){ this.dispose();
            TelaMenuSecretario telaMenuSecretario= new TelaMenuSecretario();}
        if (accao.getSource()==btnADD){ArrayList<Cadeira> cadeiras = new ArrayList<>();
            Turma turma = new Turma();
            turma = (Turma) cbTurmas.getSelectedItem();
            cadeiras = turma.cadeiras;
            cadeiras.add(turma.cadeiras.get(0));
            cadeiras.add(turma.cadeiras.get(1));
            cadeiras.add(turma.cadeiras.get(2));
            cadeiras.add(turma.cadeiras.get(3));
            cadeiras.add(turma.cadeiras.get(4));
            cadeiras.add(turma.cadeiras.get(0));
            cadeiras.add(turma.cadeiras.get(1));
            cadeiras.add(turma.cadeiras.get(2));
            cadeiras.add(turma.cadeiras.get(3));
            cadeiras.add(turma.cadeiras.get(4));
            Collections.shuffle(cadeiras);

            row[0] = cadeiras.get(0);
            row[1] = cadeiras.get(1);
            row[2] = cadeiras.get(2);
            row[3] = cadeiras.get(3);
            row[4] = cadeiras.get(4);
            model.addRow(row);

            row[0] = cadeiras.get(5);
            row[1] = cadeiras.get(6);
            row[2] = cadeiras.get(7);
            row[3] = cadeiras.get(8);
            row[4] = cadeiras.get(9);
            model.addRow(row);

            row[0] = cadeiras.get(10);
            row[1] = cadeiras.get(11);
            row[2] = cadeiras.get(12);
            row[3] = cadeiras.get(13);
            row[4] = cadeiras.get(14);
            model.addRow(row);


            JOptionPane.showMessageDialog(null, "Actividade carregada com sucesso!");

        }
        }

    }

