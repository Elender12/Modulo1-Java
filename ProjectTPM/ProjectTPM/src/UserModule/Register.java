package UserModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Register {
    private JTextField usernameTF;
    private JPasswordField passwordTF;
    private JTextField nameTF;
     JPanel panelRegister;
    private JButton buttonRegister;
    private JLabel passL;
    private JLabel nameL;
    private JLabel userL;
    private UserFileRepository ficherito;
    public Register() {
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //aquí debe añadir el usuario a la lista
                String user= usernameTF.getText();
                System.out.println(user);
                char[] pass= passwordTF.getPassword();
                String name = nameTF.getText();
                Customer alfa = new Customer(user,String.valueOf(pass),name);

                System.out.println(alfa.toString());
                try {
                    ficherito= new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\ProjectTPM\\ProjectTPM\\src\\Users.txt");

                    ficherito.create(alfa);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
