package View;

import javax.swing.*;
import java.awt.*;

public class RecuperarSenha extends JFrame {

    //Criar componentes para adicionar aos containers
    JLabel lbCodigo = new JLabel("Código de verificação");
    JTextField tfCodigo = new JTextField();
    JLabel lbNovaSenha = new JLabel("Nova senha");
    JTextField tfNovaSenha = new JTextField();
    JLabel lbConfirmarSenha = new JLabel("Confirmar Senha");
    JTextField tfConfirmarSenha = new JTextField();
    JButton btnConfirmar = new JButton("Confirmar");
public RecuperarSenha(){

    setTitle("Recuperar Senha");
    setSize(300, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    setLocationRelativeTo(null);

    //Criar container

    Container container =this.getContentPane();
    container.setLayout(null);



    //Alocar componentes no container

    lbCodigo.setBounds(30,30,160,20);
    tfCodigo.setBounds(30,50,220,20);
    lbNovaSenha.setBounds(30,90,160,20);
    tfNovaSenha.setBounds(30,110,220,20);
    lbConfirmarSenha.setBounds(30,150,160,20);
    tfConfirmarSenha.setBounds(30,170,220,20);
    btnConfirmar.setBounds(30,210,160,20);

    container.add(lbConfirmarSenha);
    container.add(btnConfirmar);
    container.add(tfConfirmarSenha);
    container.add(lbCodigo);
    container.add(tfCodigo);
    container.add(lbNovaSenha);
    container.add(tfNovaSenha);


}

public static void main(String[] args) {
    RecuperarSenha tela = new RecuperarSenha();
}



}




