//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package View;

import Model.Cadeira;
import Model.Turma;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
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

public class TelaHorario {
    private static JComboBox cbTurmas;
    ArrayList <Turma> turmas = new ArrayList<>();

    public TelaHorario() {

    }
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        TelaHorario tela= new TelaHorario();




        final JTable table = new JTable();
        Object[] columns = new Object[]{"SEG", "TER", "QUA", "QUI", "SEX"};
        final DefaultTableModel model = new DefaultTableModel();
        final JFrame frame = new JFrame("HORARIO");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 753, 601);
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().setLayout((LayoutManager) null);
        frame.setLocationRelativeTo((Component) null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.WHITE);
        table.setBackground(Color.BLACK);
        table.setSelectionBackground(Color.RED);
        table.setGridColor(Color.RED);
        table.setFont(new Font("Tahoma", 0, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        final Object[] row = new Object[5];
        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.WHITE);
        pane.setBackground(Color.BLACK);
        pane.setBounds(10, 10, 721, 364);
        frame.getContentPane().add(pane);
        cbTurmas = new JComboBox<Turma>();
        cbTurmas.setBounds(131, 385, 230, 45);
        frame.getContentPane().add(cbTurmas);
        JLabel lblAula = new JLabel("Turma");
        lblAula.setFont(new Font("Tahoma", 0, 20));
        lblAula.setBounds(20, 388, 88, 42);
        frame.getContentPane().add(lblAula);
        JButton btnADD = new JButton("Gerar Cronograma");

        tela.carregarTurmas();
        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accao) {

                ArrayList <Cadeira> cadeiras = new ArrayList<>();
                Turma turma = new Turma();
                turma= (Turma) cbTurmas.getSelectedItem();
                cadeiras=turma.cadeiras;
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
                row[4] = cadeiras.get(8);
                model.addRow(row);

                row[0] = cadeiras.get(9);
                row[1] = cadeiras.get(10);
                row[2] = cadeiras.get(11);
                row[3] = cadeiras.get(12);
                row[4] = cadeiras.get(13);
                model.addRow(row);





                JOptionPane.showMessageDialog(null, "Actividade carregada com sucesso!" );

            }
        });




        btnADD.setBounds(20, 491, 341, 34);
        frame.getContentPane().add(btnADD);
        JButton btnDELETE = new JButton("DELETE");
        btnDELETE.setBackground(Color.WHITE);
        btnDELETE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    model.removeRow(i);
                } else {
                    JOptionPane.showMessageDialog(frame, "Delete Error");
                }

            }
        });
        btnDELETE.setBounds(390, 491, 341, 34);
        frame.getContentPane().add(btnDELETE);
        frame.revalidate();
        frame.setVisible(true);

    }
}
