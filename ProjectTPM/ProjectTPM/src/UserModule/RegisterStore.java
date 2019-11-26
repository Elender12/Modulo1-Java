package UserModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterStore {
     JPanel mainPanelS;
    private JTextField usernameTF;
    private JPasswordField passTF;
    private JTextField nameTF;
    private JButton registerStoreButton;
    private JButton deleteStoreButton;
    private UserFileRepository ficherito;

    public RegisterStore() {
        registerStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {   String user= usernameTF.getText();
                System.out.println(user);
                char[] pass= passTF.getPassword();
                String name = nameTF.getText();
                Store alfa = new Store(user,String.valueOf(pass),name);

                System.out.println(alfa.toString());
                try {
                    ficherito= new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\Users.txt");
                    ficherito.create(alfa);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
