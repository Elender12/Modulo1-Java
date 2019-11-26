package UserModule;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class User {
    private String username;
    private String password;
    private String name;
    private String role;
    public User(String username, String password, String name){
        this.username= username;
        this.password= password;
        this.name= name;
       // this.role= role; hay que ver qué hago con este campo...
        // creo que el set de cada clase soluciona el asunto

    }
    //constructor for Login method
    public User(String username, String pass){
        this.username= username;
        this.password= pass;
    }
    //getters and setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //borrar este método cuando funcionen las ventanas
    @Override
    public String toString() {
        return "username: '" + username + '\'' +
                ", password: '" + password + '\'' +
                ", name: '" + name + '\'' +
                ", role: '" + role + '\'' +
                '}';
    }

    //reads the file and returns the founded user
    public static User check(BufferedReader br) throws IOException {
        String username = br.readLine();
        if (username == null) {
            return null;
        } else {
            String pass = br.readLine();
            String name = br.readLine();
            String role = br.readLine();
            if (role.equals("admin")) {
                return new Admin(username, pass, name);
            } else if (role.equals("customer")) {
                return new Customer(username, pass, name);
            } else if (role.equals("store")) {
                return new Store(username, pass, name);
            }else{
                return null;
            }
        }

    }

    public  boolean equalTo(User x){
        return this.username.equals(x.username)&&this.password.equals(x.password) && this.name.equals(x.name)&& this.role.equals(x.role);
    }
    public boolean checkAdmin(){
        boolean admin = false;

        return admin;

    }

}
