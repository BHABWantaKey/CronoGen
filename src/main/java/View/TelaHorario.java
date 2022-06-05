//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package View;

import Model.Secretario;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaHorario {
    private static JTextField textAula;

    public TelaHorario() {
    }

    public static void main(String[] args) {
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
        textAula = new JTextField();
        textAula.setBounds(131, 385, 230, 45);
        frame.getContentPane().add(textAula);
        textAula.setColumns(10);
        JLabel lblAula = new JLabel("Aula");
        lblAula.setFont(new Font("Tahoma", 0, 20));
        lblAula.setBounds(20, 388, 88, 42);
        frame.getContentPane().add(lblAula);
        JButton btnADD = new JButton("ADD");

        btnADD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                File ficheiro = new File("Secretario.crono");

                try {
                    ObjectInputStream objecto = new ObjectInputStream(new FileInputStream(ficheiro));
                    Secretario secretario = (Secretario) objecto.readObject();
                    objecto.close();

                    row[0] = secretario.getEmail();
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null, "Actividade carregada com sucesso!" + secretario.getNome());

                } catch (IOException clique) {
                    throw new RuntimeException(clique);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

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
