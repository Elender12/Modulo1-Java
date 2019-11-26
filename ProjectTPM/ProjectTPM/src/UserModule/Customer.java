package UserModule;

public class Customer extends User {
    public Customer(String username, String password, String name) {
        super(username, password, name);
        //todos son clientes
        this.setRole("customer");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
