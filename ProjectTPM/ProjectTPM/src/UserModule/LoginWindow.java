package UserModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


public class LoginWindow extends JFrame {
    private JTextField userTF;
    private JPasswordField passTF;
    private JButton buttonLogin;
    public JPanel mainPanel;
    private JButton buttonRegister;
    private UserFileRepository userFileRepository;

    public LoginWindow() {
        super("Login Window");
        this.buttonLogin.setText("Log in");

        // login
        buttonLogin.addActionListener(this::actionPerformed);

        //register
        buttonRegister.addActionListener(e -> {
            RegisterCustomer customerRegister = new RegisterCustomer();
            customerRegister.setContentPane(new RegisterCustomer().panelRegister);
             customerRegister.pack();
            customerRegister.setVisible(true);
            this.setVisible(false);
           customerRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

    //login in
    private void actionPerformed(ActionEvent actionEvent) {
        String user = userTF.getText();
        char[] pass = passTF.getPassword();
        this.setVisible(false);
        userTF.setText("");
        passTF.setText("");
        String pass1 = (String.valueOf(pass));
        //file = new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        userFileRepository = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        try {

            //if login is true -> opens a new window:  customer/admin/store
            //the admin is loggin in
            User userLogged = userFileRepository.login(user, pass1);
            // System.out.println(userLogged.toString());
            if (userLogged != null) {

                switch (userLogged.getRole()) {
                    case "Admin":
                        //the admin exists and must open a new window
                        LoginWindow adminWindow = new LoginWindow();
                        adminWindow.setContentPane(new AdminWindow().mainPanelS);
                        adminWindow.pack();
                        adminWindow.setVisible(true);
                        this.setVisible(false);
                        adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    case "Customer":
                        //it's a customer
                        System.out.println("I am a customer");
                        String storesPath= "C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt";
                        CustomerWindow customerWindow = new CustomerWindow(storesPath);
                        customerWindow.setContentPane(new CustomerWindow(storesPath).storeList);
                        customerWindow.pack();
                        customerWindow.setVisible(true);

                        break;
                    case "Store":
                        //it's a store
                        String path = "C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\StoreProducts\\"+userLogged.getUsername()+".txt";
                        String storeName = userLogged.getUsername();
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
                        this.setVisible(false);
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
