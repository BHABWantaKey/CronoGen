package View;

import Model.Secretario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaEntrada extends JFrame implements ActionListener {

    ArrayList<Secretario> secretarios=new ArrayList<>();

    JLabel lblEmail = new JLabel("E-mail");
    JTextField tfEmail = new JTextField(50);
    JLabel lblSenha = new JLabel("Senha");
    JPasswordField tfSenha = new JPasswordField(20);
    JButton btnEntrar = new JButton("Entrar");
    JButton btnRecuperarSenha = new JButton("Recuperar Senha");
    JButton btnAjuda = new JButton("Ajuda");

    public TelaEntrada() {
//Criando o frame
        setTitle("Tela de Entrada");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

//Criação de componentes para adicionar ao painel.


        btnEntrar.addActionListener(this);

        Container container = this.getContentPane(); //Cria painel

        container.setLayout(null);

        lblEmail.setBounds(30, 100, 150, 20);
        lblSenha.setBounds(30, 140, 150, 20);
        btnAjuda.setBounds(284, 290, 100, 20);
        btnEntrar.setBounds(30, 180, 150, 20);
        tfEmail.setBounds(70, 100, 250, 20);
        tfSenha.setBounds(70, 140, 250, 20);
        btnRecuperarSenha.setBounds(200, 180, 135, 20);

        container.add(btnAjuda);
        container.add(btnEntrar);
        container.add(btnRecuperarSenha);
        container.add(lblEmail);
        container.add(lblSenha);
        container.add(tfEmail);
        container.add(tfSenha);


    }

    public static void main(String[] args) {


        TelaEntrada tela = new TelaEntrada();

    }


    @Override
    public void actionPerformed(ActionEvent accao) {
        if (accao.getSource() == btnEntrar) {
            File ficheiro = new File("Secretarios.crono");

            try {
                ObjectInputStream objecto = new ObjectInputStream(new FileInputStream(ficheiro));
                secretarios = (ArrayList<Secretario>) objecto.readObject();
                objecto.close();
                Secretario secretario = new Secretario();
                int i=0;
                TelaMenuSecretario telaMenuSecretario;
                boolean status=false;
                for (i=0;i<secretarios.size();i++){
                    secretario=secretarios.get(i);
                    if (secretario.getEmail().equalsIgnoreCase(tfEmail.getText()) && secretario.getSenha().equalsIgnoreCase(tfSenha.getText())){
                        JOptionPane.showMessageDialog(null,"Sessão iniciada como "+ secretario.getNome());
                        this.dispose();   new TelaMenuSecretario(); status=true;

                    }

                }if (tfEmail.getText()!=secretario.getEmail() && tfSenha.getText()!=secretario.getSenha()); JOptionPane.showMessageDialog(null,"Credênciais incorrectas, tente novamente!"); ;


            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }
    }
}