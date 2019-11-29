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
    private JButton storeListButton;
    private UserFileRepository file;

    public RegisterStore() {
        //adds a store
        registerStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String user= usernameTF.getText();
                System.out.println(user);
                char[] pass= passTF.getPassword();
                String name = nameTF.getText();
                Store store = new Store(user,String.valueOf(pass),name);

                try {
                    //file= new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
                   file = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
                   file.create(store);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        deleteStoreButton.addActionListener(new ActionListener() {
            //deletes the store
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });
        //LISTA DE TODAS LAS TIENDAS
        storeListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
