package ProductModule;

public class Dessert extends Product {
    public Dessert(String name, String description, double price, String storeName) {
        super(name, description, price, storeName);
        this.setType("dessert");
    }
}
