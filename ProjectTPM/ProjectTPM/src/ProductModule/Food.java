package ProductModule;

public class Food extends Product {
    public Food(String name, String description, double price, String storeName) {
        super(name, description, price, storeName);
        this.setType("food");
    }
}
