package UserModule;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

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
        User currentLoggedUser;
        currentLoggedUser = checkUser(username, pass);
        return currentLoggedUser;
    }

    @Override
    public User checkUser(String username, String pass) throws IOException {
        File f = new File(this.filename);
        BufferedReader br = new BufferedReader(new FileReader(f));
        User current;
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

    public ArrayList<User> getStoreList() throws IOException {
        FileInputStream is = new FileInputStream(this.filename);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        ArrayList<User> result = new ArrayList<>();
        User current = User.check(br);
        while (current != null) {
            if(current.getRole().equals("Store")){
                result.add(current);
            }
            current = User.check(br);
        }
        br.close();
        return result;
    }

}
