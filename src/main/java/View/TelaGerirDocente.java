/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Espaco de Inovacao
 */
public class TelaGerirDocente extends JFrame {

    public TelaGerirDocente(){

        setTitle("Gerir Docente");
        setSize(800, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        //Criação de componentes e do Painel
        Container container = this.getContentPane();

        JLabel lblNome = new JLabel("Nome");
        JTextField tfNome= new JTextField(30);

        JLabel lblApelido = new JLabel("Apelido");
        JTextField tfApelido= new JTextField(30);

        JLabel lblMorada = new JLabel("Morada");
        JTextField tfMorada= new JTextField(30);

        JLabel lbEmail = new JLabel("Email");
        JTextField tfEmail= new JTextField(30);

        JLabel lblArea = new JLabel("Areas");
        JComboBox cbArea= new JComboBox<>();
        
        JLabel lbBI = new JLabel("Número de BI");
        JTextField tfBi= new JTextField(30);

        JLabel lbDocentes = new JLabel("Lista de Docentes");

        JButton btnAdicionarDocente = new JButton("Adicionar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnApagar = new JButton("Apagar");
        JList listaDocentes=new JList<>();


        container.setLayout(null);

        lblNome.setBounds(30,100,150,20);
        tfNome.setBounds(30,120,250,20);
       lblApelido.setBounds(30,140,150,20);
       tfApelido.setBounds(30,160,250,20);
        lbBI.setBounds(30,180,150,20);
        tfBi.setBounds(30,200,250,20);
        lbEmail.setBounds(30,220,150,20);
        tfEmail.setBounds(30,240,250,20);
        lblMorada.setBounds(30,260,150,20);
        tfMorada.setBounds(30,280,250,20);
        btnAdicionarDocente.setBounds(30,305,100,20);
        btnActualizar.setBounds(140,305,100,20);
        lbDocentes.setBounds(600,100,120,20);
        listaDocentes.setBounds(600,120,160,180);
        btnApagar.setBounds(600,305,75,20);
        lblArea.setBounds(350,100,150,20);
        cbArea.setBounds(350,120,150,20);


        //Coluna Oeste
        container.add(lblNome);
        container.add(tfNome);
        container.add(lblApelido);
        container.add(tfApelido);
        container.add(lblMorada);
        container.add(tfMorada);
        container.add(lbEmail);
        container.add(tfEmail);
        container.add(lbBI);
        container.add(tfBi);
        container.add(btnAdicionarDocente);
        container.add(btnApagar);
        container.add(btnActualizar);
        //Coluna central
        container.add(lblArea);
        container.add(cbArea);

        //Coluna Este
        container.add(lbDocentes);
        container.add(listaDocentes);


             
        }
        
        public static void main(String[] args) {
            
        
            TelaGerirDocente tela=new TelaGerirDocente();
        }
        
    
}
