package UserModule;

public class Store extends User {

    public Store(String username, String password, String name) {
        super(username, password, name);
        this.setRole("Store");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
