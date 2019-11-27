package UserModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Login extends JFrame {
    private JTextField userTF;
    private JPasswordField passTF;
    private JButton buttonLogin;
    JPanel mainPanel;
    private JButton buttonRegister;
    private UserFileRepository file; //cambiar este nombre

    public Login() {
        super();
        this.buttonLogin.setText("Log in");
        // passTF.addActionListener((ActionListener) this);

        //este es el login
        buttonLogin.addActionListener(this::actionPerformed);
        // passTF.setActionCommand(OK);

        //este es el register dentro del constructor??
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanita2 = new JFrame("Register customer");
                ventanita2.setContentPane(new Register().panelRegister);
                ventanita2.pack();
                ventanita2.setVisible(true);
               // this.setVisible(false);
                ventanita2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
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
        file = new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        //file = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\Users.txt");
        try {

            //if login is true -> opens a new window:  customer/admin/store
            //the admin is loggin in
            User userLogged = file.login(user, pass1);
            // System.out.println(userLogged.toString());
            if (userLogged != null) {

                if (userLogged.getRole().equals("Admin")) {
                    //the admin exists and must open a new window
                    //JFrame windowRegStore = new JFrame("Register Store");
                    Login windowRegStore = new Login();
                    //cambiar estos nombres

                    windowRegStore.setContentPane(new RegisterStore().mainPanelS);
                    windowRegStore.pack();
                    windowRegStore.setVisible(true);
                    this.setVisible(false);
                    windowRegStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                } else if (userLogged.getRole().equals("Customer")) {
                    //it's a customer
                    System.out.println("I am a customer");
                    //si es un cliente: abrir ventana de tiendas a elegir y luego el carrito
                } else if (userLogged.getRole().equals("Store")) {
                    //it's a store
                    //si es una tienda: abrir ventana de productos
                    System.out.println("I'm a store");
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
