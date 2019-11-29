package UserModule;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

public class UserFileRepository implements  UserRepository{
    private String filename; //path to the file

    public UserFileRepository(String filename) {
        this.filename= filename;
    }

    @Override
    public void create(User x) throws IOException {
        //adds a user
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(x.getUsername()+"\n");
        pw.print(x.getPassword()+"\n");
        pw.print(x.getName()+"\n");
        pw.print(x.getRole()+"\n");
        pw.close();
    }

    @Override
    public void remove(User x) throws IOException {
        //remove the specified user
        File f = new File(this.filename);
        FileInputStream is = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        File ftemp = new File("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\users-temporary.txt");
        //File ftemp = new File("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\users-temporary.txt");
        FileOutputStream os = new FileOutputStream(ftemp);
        PrintWriter pw = new PrintWriter(os);
        User current = User.check(br);

        while (current != null) {
            if (!current.equalTo(x)) {
                pw.println(current.getUsername());
                pw.println(current.getPassword());
                pw.println(current.getName());
                pw.println(current.getRole());
            }
            current = User.check(br);
        }
        br.close();
        pw.close();
        os.close();
        //rename the file in Windows
       Files.move(ftemp.toPath(), f.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    }
    @Override
    //checks who is going to log in into the app
    public User login(String username, String pass) throws IOException {
        User currentLoggedUser=null;
        currentLoggedUser = checkUser(username, pass);
        return currentLoggedUser;

    }

    @Override
    public User checkUser(String username, String pass) throws IOException {
        File f = new File(this.filename);
        BufferedReader br = new BufferedReader(new FileReader(f));
        User current = null;
        User loggedUser =null;
        //lee los usuarios de los ficheros
        current = User.check(br);
        while (current != null) {
            //busco si hay un usuario con los 2 parametros en el fichero
            if ((current.getUsername().equals(username)) && current.getPassword().equals(pass)) {
                loggedUser = current;

            }
            current = User.check(br);
        }
        br.close();

        return loggedUser;
    }

    // campo de pruebas :3
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
       // mainWindow.setContentPane(new LoginWindow().mainPanel);
        mainWindow.setSize(700,600);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);




       /* try {
            ficherito.create(cst);
            System.out.println("en el try");
            //ficherito.create(cst);
            //ficherito.create(str);
            //ficherito.create(str1);
            //ficherito.remove(str1);
         //   System.out.println(ficherito.login(adm));
           // System.out.println(ficherito.login(cst));

        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }
}
