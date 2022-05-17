package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

import Model.Turma;

public class TelaEntrada extends JFrame{


public TelaEntrada(){
//Criando o frame
setTitle("Tela de Entrada");
setSize(400, 350);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
setLocationRelativeTo(null);

//Criação de componentes para adicionar ao painel.
JLabel lblEmail=new JLabel("E-mail");
JTextField tfNome = new JTextField(50);
JLabel lblSenha = new JLabel("Senha");
JPasswordField tfSenha= new JPasswordField(20);
JButton btnEntrar = new JButton("Entrar"); 
JButton btnRecuperarSenha = new JButton("Recuperar Senha");
JButton btnAjuda = new JButton("Ajuda");

Container container=this.getContentPane(); //Cria painel

container.setLayout(null);

lblEmail.setBounds(30, 100, 150, 20);
lblSenha.setBounds(30, 140, 150, 20);
btnAjuda.setBounds(284, 290, 100, 20);
btnEntrar.setBounds(30, 180, 150, 20);
tfNome.setBounds(70, 100, 250, 20);
tfSenha.setBounds(70, 140, 250, 20);
btnRecuperarSenha.setBounds(200, 180, 135, 20);

container.add(btnAjuda);
container.add(btnEntrar);
container.add(btnRecuperarSenha);
container.add(lblEmail);
container.add(lblSenha);
container.add(tfNome);
container.add(tfSenha);








}

public static void main(String[] args) {
    

    TelaEntrada tela=new TelaEntrada();
   
}





}