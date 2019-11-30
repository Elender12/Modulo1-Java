import UserModule.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Admin adm= new Admin("admin12","1234","Lena");
        Customer cst= new Customer("customer","000","usuario");
        Store str= new Store("storeUn","09","tienda");

        //UserFileRepository ficherito = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        UserFileRepository ficherito = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        LoginWindow mainWindow= new LoginWindow();
        mainWindow.setContentPane(new LoginWindow().mainPanel);
        mainWindow.setSize(700,600);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
