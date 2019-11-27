package UserModule;

public class Admin extends User {

    public Admin(String username, String password, String name) {
        super(username, password, name);
        //por narices todos los de aquí son admin
        this.setRole("Admin");
    }
    public Admin(String username, String password){
        super(username, password);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
