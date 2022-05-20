/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;

import com.toedter.calendar.JCalendar;


/**
 *
 * @author Espaco de Inovacao
 */
public class TelaGerirActividades extends JFrame {

    public TelaGerirActividades(){

        setTitle("Gerir Actividades");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        Container container = this.getContentPane();
        container.setLayout(null);

        //Criação de componentes
        JLabel lbNome =new JLabel("Nome");
        JTextField tfNome = new JTextField();
        JLabel lbPeriodo = new JLabel("Período");
        JCalendar jcPeriodo=new JCalendar();
        JLabel Area = new JLabel("Areas");
        JComboBox cbAreas = new JComboBox<>();
        JButton btnActualizar = new JButton("Actualizar");
        JLabel lbACtividades = new JLabel("Lista de Actividades");
        JList listaDeActividades = new JList<>();
        JButton btnApagar = new JButton("Apagar");
        JButton btnCriarActividades = new JButton("Criar");
        
      
        //Alocação de coordenadas no painel.
        lbNome.setBounds(50,100,250,20);
        tfNome.setBounds(50,120,250,20);
        lbPeriodo.setBounds(50,140,120,20);
        jcPeriodo.setBounds(50,160,250,20);
        Area.setBounds(50,180,120,20);
        cbAreas.setBounds(50,200,150,20);
        btnCriarActividades.setBounds(50,240,80,20);
        btnActualizar.setBounds(150,240,100,20);
        lbACtividades.setBounds(320,100,200,20);
        listaDeActividades.setBounds(320,120,200,120);
        btnApagar.setBounds(320,240,80,20);
        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(lbPeriodo);
        container.add(jcPeriodo);
        container.add(Area);
        container.add(cbAreas);
        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnCriarActividades);
        container.add(listaDeActividades);
        container.add(lbACtividades);
        
        
        
        
        }
        
        public static void main(String[] args) {
            
        
            TelaGerirActividades tela=new TelaGerirActividades();
        }
        
    
}
