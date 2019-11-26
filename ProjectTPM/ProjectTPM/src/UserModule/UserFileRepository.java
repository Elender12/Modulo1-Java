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
    public boolean login(String username, String pass) throws IOException {
        File f = new File(this.filename);
        BufferedReader br = new BufferedReader(new FileReader(f));
        User current= null;
       // current.setUsername(username);
       // current.setPassword(pass);
        current = User.check(br);
        boolean login=false;

        //there will be only an admin
        if(username.equals("adminE")&& current.getPassword().equals(pass)){

        }

            while (current != null) {
            if ((current.getUsername().equals(username)) && current.getPassword().equals(pass)) {

                    login =true;
            }
            current = User.check(br);
        }
        br.close();
        return login;
    }

    // campo de pruebas :3
    public static void main(String[] args) {
        Admin adm= new Admin("admin12","1234","Lena");
        Customer cst= new Customer("customer","000","usuario");
        Store str= new Store("storoo","09","tienda");
        Store str1= new Store("story","019","tienda147");
        UserFileRepository ficherito = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\Users.txt");
        //Login ventanita=  new Login();
       //ventanita.setVisible(true);
       //ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame ventanita= new JFrame("Ventanita");
        ventanita.setContentPane(new Login().mainPanel);
        ventanita.setSize(500,500);
        ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanita.pack();
        ventanita.setVisible(true);




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
