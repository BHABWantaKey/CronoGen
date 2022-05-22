package View;

import Model.Secretario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRegistarSecretario extends JFrame implements ActionListener {

    //Criação de componentes para adicionar ao painel.
    JLabel lblEmail=new JLabel("E-mail");
    JTextField tfEmail = new JTextField(50);
    JLabel lblSenha = new JLabel("Senha");
    JPasswordField tfSenha= new JPasswordField(20);
    JButton btnEntrar = new JButton("Registar");
public TelaRegistarSecretario() {


    setTitle("Registar Secretário");
    setSize(400, 250);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    this.setVisible(true);




    Container container=this.getContentPane(); //Cria painel

    container.setLayout(null);
//Criando componentes para adicionar ao container.
    lblEmail.setBounds(30, 100, 150, 20);
    lblSenha.setBounds(30, 140, 150, 20);
    btnEntrar.setBounds(70, 180, 100, 20);
    tfEmail.setBounds(70, 100, 250, 20);
    tfSenha.setBounds(70, 140, 250, 20);

    //Adicionando os componentes ao container.
    container.add(btnEntrar);
    container.add(lblEmail);
    container.add(lblSenha);
    container.add(tfEmail);
    container.add(tfSenha);
    //Colocando botões em prontidão

    btnEntrar.addActionListener(this);


}



    public static void main(String[] args) {

        TelaRegistarSecretario tela=new TelaRegistarSecretario();
        Secretario secretario = new Secretario();



    }


    @Override
    public void actionPerformed(ActionEvent accao) {
if(accao.getSource()==btnEntrar){
    Secretario secretario = new Secretario();
    secretario.email=tfEmail.getText();
    secretario.senha= String.valueOf(tfSenha.getPassword());


}

    }
}
