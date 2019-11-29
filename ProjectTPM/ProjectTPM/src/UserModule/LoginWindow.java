package UserModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class LoginWindow extends JFrame {
    private JTextField userTF;
    private JPasswordField passTF;
    private JButton buttonLogin;
    public JPanel mainPanel;
    private JButton buttonRegister;
    private UserFileRepository file; //cambiar este nombre

    public LoginWindow() {
        super();
        this.buttonLogin.setText("Log in");
        // passTF.addActionListener((ActionListener) this);

        //este es el login
        buttonLogin.addActionListener(this::actionPerformed);
        // passTF.setActionCommand(OK);

        //este es el register dentro del constructor??
        buttonRegister.addActionListener(e -> {
            RegisterCustomer   ventanita2 = new RegisterCustomer();
           // ventanita2.setContentPane(new RegisterCustomer().panelRegister);
           // ventanita2.pack();
           //ventanita2.setVisible(true);
           // this.setVisible(false);
           // ventanita2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

    //método del login in
    private void actionPerformed(ActionEvent actionEvent) {
        String user = userTF.getText();
        char[] pass = passTF.getPassword();
        //esto me ignora
        this.setVisible(false);
        //System.out.println(user);
        userTF.setText("");
        passTF.setText("");

        String pass1 = (String.valueOf(pass));
        //file = new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        file = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        try {

            //if login is true -> opens a new window:  customer/admin/store
            //the admin is loggin in
            User userLogged = file.login(user, pass1);
            // System.out.println(userLogged.toString());
            if (userLogged != null) {

                switch (userLogged.getRole()) {
                    case "Admin":
                        //the admin exists and must open a new window
                        //JFrame windowRegStore = new JFrame("RegisterCustomer Store");
                        LoginWindow adminWindow = new LoginWindow();
                        //cambiar estos nombres
                        adminWindow.setContentPane(new AdminWindow().mainPanelS);
                        adminWindow.pack();
                        adminWindow.setVisible(true);
                        this.setVisible(false);
                        adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        break;
                    case "Customer":
                        //it's a customer
                        System.out.println("I am a customer");
                        //AÑADIR AQUI LAS VENTANAS
                        //si es un cliente: abrir ventana de tiendas a elegir y luego el carrito
                        break;
                    case "Store":
                        //it's a store
                        String path = "C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\"+userLogged.getUsername()+".txt";
                        String storeName = userLogged.getUsername();
                        System.out.println(path);
                        System.out.println(storeName);
                        //Creates a file for each store
                        File storeBD = new File(path);
                        if(storeBD.createNewFile()){
                            System.out.println("The store has a new file.");
                        }else {
                            System.out.println("The store already has a file.");
                        }
                        StoreWindow storeWindow = new StoreWindow(path, storeName);
                        storeWindow.setContentPane(new StoreWindow(path, storeName).panelSW);
                        storeWindow.pack();
                        storeWindow.setVisible(true);
                        break;


                }
            } else {
                throw new UserException("The user DOES NOT exist!");
                //
            }

        } catch (IOException | UserException e) {
            e.getMessage();
        }


    }
}
