package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Model.Turma;

public class TelaEntrada extends JFrame{


public TelaEntrada(){
//Criando o frame
setTitle("Tela de Entrada");
setSize(400, 400);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);


//Criação de componentes para adicionar ao painel.
JLabel lblEmail=new JLabel("E-mail");
JTextField tfNome = new JTextField();
JLabel lblSenha = new JLabel("Senha");
JPasswordField tfSenha= new JPasswordField("");
JButton btnEntrar = new JButton("Entrar"); 
JButton btnRecuperarSenha = new JButton("Recuperar Senha");
JButton btnAjuda = new JButton("Ajuda");

JPanel painel= new JPanel(); //Cria painel
//Configura Painel
painel.setLayout(new BorderLayout());

//Adiciona componentes ao painel
painel.add(lblEmail,BorderLayout.CENTER);
painel.add(tfNome);
painel.add(lblSenha);
painel.add(tfSenha);
painel.add(btnEntrar);
painel.add(btnRecuperarSenha);
painel.add(btnAjuda,BorderLayout.SOUTH);

}

public static void main(String[] args) {
    

    TelaEntrada tela=new TelaEntrada();
}





}