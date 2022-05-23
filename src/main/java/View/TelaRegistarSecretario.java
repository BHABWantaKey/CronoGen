package View;

import Model.Secretario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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

    File ficheiro =new File("src\\main\\java\\Ficheiros\\Secretario.crono");
    Secretario secretario1 = new Secretario();
    secretario1.setEmail(tfEmail.getText());
    secretario1.setNome(String.valueOf(tfSenha.getPassword()));
    try {
        ObjectOutputStream objecto= new ObjectOutputStream(new FileOutputStream(ficheiro));
        objecto.writeObject(secretario1);
        objecto.close();
        JOptionPane.showMessageDialog(null,"Email"+secretario1.getEmail());

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Occorreu um erro ao Registar o secretário.");
    }


}

    }
}
