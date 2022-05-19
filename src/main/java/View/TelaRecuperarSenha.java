package View;

import javax.swing.*;
import java.awt.*;

public class TelaRecuperarSenha extends JFrame {


public TelaRecuperarSenha(){

    setTitle("Recuperar Senha");
    setSize(400, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    setLocationRelativeTo(null);

    //Criar container

    Container container =this.getContentPane();
    container.setLayout(null);

    //Criar componentes para adicionar aos containers
    JLabel lbEmail = new JLabel("Email de recuperação");
    JTextField tfEMail = new JTextField();
    JButton btnEnviarPedido = new JButton("Enviar Pedido");

    //Alocar componentes no container

    lbEmail.setBounds(30,30,160,20);
    tfEMail.setBounds(30,50,220,20);
    btnEnviarPedido.setBounds(30,90,160,20);

    container.add(lbEmail);
    container.add(btnEnviarPedido);
    container.add(tfEMail);
    

}

public static void main(String[] args) {
    TelaRecuperarSenha tela = new TelaRecuperarSenha();
}



}




