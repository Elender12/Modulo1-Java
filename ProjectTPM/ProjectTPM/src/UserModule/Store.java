package UserModule;

public class Store extends User {

    public Store(String username, String password, String name) {
        super(username, password, name);
        //todos son tiendas
        this.setRole("store");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}