import UserModule.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Admin adm= new Admin("admin12","1234","Lena");
        Customer cst= new Customer("customer","000","usuario");
        Store str= new Store("storoo","09","tienda");
        Store str1= new Store("story","019","tienda147");
        //UserFileRepository ficherito = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        UserFileRepository ficherito = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        //LoginWindow ventanita=  new LoginWindow();
        //ventanita.setVisible(true);
        //ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginWindow mainWindow= new LoginWindow();
        mainWindow.setContentPane(new LoginWindow().mainPanel);
        mainWindow.setSize(700,600);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
