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
public class TelaGerirTurma extends JFrame {
    

    public TelaGerirTurma(){

        setTitle("Gerir Turma");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        
        

        setTitle("Gerir Cronogramas");
        setSize(550, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        Container container = this.getContentPane();
        container.setLayout(null);

        //Criação de componentes
        JLabel lbNome =new JLabel("Nome");
        JTextField tfNome = new JTextField(30);
        JLabel lbDescricao = new JLabel("Descrição");
        JTextField tfDescricao=new JTextField(30);
        JLabel lbPlanoActividades = new JLabel("Plano de Actividades");
        JComboBox cpPlanoActividades = new JComboBox<>();
        JButton btnActualizar = new JButton("Actualizar");
        JLabel lbListaDeTurmas = new JLabel("Lista de Turmas");
        JList listaDeTurmas = new JList<>();
        JButton btnApagar = new JButton("APagar");
        JButton btnCriarTurma = new JButton("Criar");
        //Alocação de coordenadas no painel.

        lbNome.setBounds(50,100,250,20);
        tfNome.setBounds(50,120,250,20);
        lbDescricao.setBounds(50,140,120,20);
        tfDescricao.setBounds(50,160,250,20);
        lbPlanoActividades.setBounds(50,180,120,20);
        cpPlanoActividades.setBounds(50,200,150,20);
        btnCriarTurma.setBounds(50,240,80,20);
        btnActualizar.setBounds(150,240,100,20);
        lbListaDeTurmas.setBounds(320,100,200,20);
        listaDeTurmas.setBounds(320,120,200,120);
        btnApagar.setBounds(320,240,80,20);
        //Adicionando compenentes ao painel.
        container.add(lbNome);
        container.add(tfNome);
        container.add(lbDescricao);
        container.add(tfDescricao);
        container.add(lbPlanoActividades);
        container.add(cpPlanoActividades);
        container.add(btnActualizar);
        container.add(btnApagar);
        container.add(btnCriarTurma);
        container.add(listaDeTurmas);
        container.add(lbListaDeTurmas);
        
        }
        
        public static void main(String[] args) {
            
        
            TelaGerirTurma tela=new TelaGerirTurma();
        }
        



}
