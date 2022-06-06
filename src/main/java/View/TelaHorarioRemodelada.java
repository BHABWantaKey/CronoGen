package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaHorarioRemodelada extends JFrame{
    final JTable table = new JTable();
    Object[] columns = new Object[]{"SEG", "TER", "QUA", "QUI", "SEX"};
    final DefaultTableModel model = new DefaultTableModel();
    final JFrame frame = new JFrame("HORARIO");
    final Object[] row = new Object[5];
    JLabel lblAula = new JLabel("Turma");
    JButton btnADD = new JButton("Gerar Cronograma");
    JButton btnDELETE = new JButton("DELETE");
    JTextField textAula = new JTextField();

    public  TelaHorarioRemodelada() {

        btnDELETE.setBounds(390, 491, 341, 34);
        frame.getContentPane().add(btnDELETE);
        frame.revalidate();
        frame.setVisible(true);
        btnADD.setBounds(20, 491, 341, 34);
        frame.getContentPane().add(btnADD);
        frame.getContentPane().add(table);
        table.setBounds(50,50,400,200);
        btnDELETE.setBackground(Color.WHITE);
        lblAula.setFont(new Font("Tahoma", 0, 20));
        lblAula.setBounds(20, 388, 88, 42);
        frame.getContentPane().add(lblAula);
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        setBounds(10, 10, 721, 364);
        frame.getContentPane();

        textAula.setBounds(131, 385, 230, 45);
        frame.getContentPane().add(textAula);
        textAula.setColumns(10);
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


    }

    public static void main(String[] args) {
        TelaHorarioRemodelada tela = new TelaHorarioRemodelada();
    }



}
