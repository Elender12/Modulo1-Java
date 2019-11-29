package ProductModule;

public class Drink extends  Product {
    public Drink(String name, String description, double price, String storeName) {
        super(name, description, price, storeName);
        this.setType("drink");
    }

}
