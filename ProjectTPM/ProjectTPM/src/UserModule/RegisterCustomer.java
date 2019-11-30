package UserModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterCustomer extends JFrame{
    private JTextField usernameTF;
    private JPasswordField passwordTF;
    private JTextField nameTF;
     JPanel panelRegister;
    private JButton buttonRegister;
    private JLabel passL;
    private JLabel nameL;
    private JLabel userL;
    private UserFileRepository ficherito;
    public RegisterCustomer() {
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adds the customer to the list
                String user= usernameTF.getText();
                System.out.println(user);
                char[] pass= passwordTF.getPassword();
                String name = nameTF.getText();
                Customer customer = new Customer(user,String.valueOf(pass),name);
                System.out.println(customer.toString());
                try {
                    ficherito= new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
                  //  ficherito= new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");

                    ficherito.create(customer);
                    //VERIFICAR PARA QUE VUELVA A LA PÁGINA DE LOGIN DESPUÉS DE REGISTRO
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
