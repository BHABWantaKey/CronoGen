package View;

import Model.Secretario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class TelaRegistarSecretario extends JFrame implements ActionListener {

    ArrayList <Secretario> secretarios =new ArrayList<>();

    JButton btnVoltar = new JButton("Voltar");
    //Criação de componentes para adicionar ao painel.
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(50);

    JLabel lbEmail = new JLabel("E-mail");
    JTextField tfEmail = new JTextField();
    JLabel lblSenha = new JLabel("Senha");
    JPasswordField tfSenha = new JPasswordField(20);
    JButton btnEntrar = new JButton("Registar");

    public TelaRegistarSecretario() {


        setTitle("Registar Secretário");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);


        Container container = this.getContentPane(); //Cria painel

        container.setLayout(null);
//Criando componentes para adicionar ao container.
        lbNome.setBounds(30, 100, 150, 20);
        tfNome.setBounds(70, 100, 250, 20);
        lbEmail.setBounds(30, 140, 150, 20);
        tfEmail.setBounds(70, 140, 250, 20);
        lblSenha.setBounds(30, 180, 150, 20);
        tfSenha.setBounds(70, 180, 250, 20);
        btnEntrar.setBounds(70, 220, 100, 20);
        btnVoltar.setBounds(1,1,70,20);

        //Adicionando os componentes ao container.
        container.add(btnEntrar);
        container.add(lbNome);
        container.add(lblSenha);
        container.add(tfNome);
        container.add(tfSenha);
        container.add(lbEmail);
        container.add(tfEmail);
        container.add(btnVoltar);
        //Colocando botões em prontidão
        btnEntrar.addActionListener(this);


    }


    public static void main(String[] args) {

        TelaRegistarSecretario tela = new TelaRegistarSecretario();
        Secretario secretario = new Secretario();


    }


    @Override
    public void actionPerformed(ActionEvent accao) {
if (accao.getSource()==btnVoltar)
{this.dispose(); TelaMenuSecretario telaMenuSecretario= new TelaMenuSecretario();}


        if (accao.getSource() == btnEntrar) {





            //Cria Ficheiro
            File ficheiro = new File("Secretarios.crono");
            Secretario secretario = new Secretario();


            //Captura informaçoes da textfield para o objecto secretário
            secretario.setNome(tfNome.getText());
            secretario.setEmail(tfEmail.getText());
            secretario.setSenha(String.valueOf(tfSenha.getPassword()));

            //Por implementar envio de dados por E-mail antes de encerrar a tela.
            if (tfEmail.getText().length()>6 && tfNome.getText().length()>2 && tfSenha.getText().length()>7) {
                try {
                    secretarios.add(secretario);
                    //bloco para detecção de erros/excepções.
                    ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(ficheiro));
                    objecto.writeObject(secretarios);
                    objecto.close();
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Secretário: " + secretario.getNome() + " registado com sucesso");
                    TelaEntrada telaEntrada = new TelaEntrada();

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Occorreu um erro ao Registar o secretário.");
                }
            } else if  (tfEmail.getText().length()==0  && tfNome.getText().length()==0 && tfSenha.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos");
            }


        }

    }
}
