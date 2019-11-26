package UserModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Login extends JFrame {
    private JTextField userTF;
    private JPasswordField passTF;
    private JButton buttonTF;
    JPanel mainPanel;
    private JButton button2TF;
    private UserFileRepository ficherito;

    public Login() {
        super();
        this.buttonTF.setText("Log in");
        // passTF.addActionListener((ActionListener) this);
        //este es el login
        buttonTF.addActionListener(this::actionPerformed);
        // passTF.setActionCommand(OK);
        //este es el register
        button2TF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanita2 = new JFrame("Register customer");
                ventanita2.setContentPane(new Register().panelRegister);
                ventanita2.pack();
                ventanita2.setVisible(true);
                ventanita2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }


    private void actionPerformed(ActionEvent actionEvent) {
        String user = userTF.getText();
        char[] pass = passTF.getPassword();
        //System.out.println(user);

        String pass1 = (String.valueOf(pass));
        //ficherito= new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\ProjectTPM\\ProjectTPM\\src\\Users.txt");
        ficherito = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\Users.txt");
        try {
            boolean login = false;
            login = ficherito.login(user, pass1);
            System.out.println("el valor final de login es..." + login);
            //if login is true -> opens a new window:  customer/admin/store
            if (user.contains("admin") && ficherito.login(user, pass1)){

                //the admin exists and must open a new window
                //System.out.println("the admin exists ");
                JFrame ventanita3 = new JFrame("Register Store");
                ventanita3.setContentPane(new RegisterStore().mainPanelS);
                ventanita3.pack();
                ventanita3.setVisible(true);
                ventanita3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }else{

        }



        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
