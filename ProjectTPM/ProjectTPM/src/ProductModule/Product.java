package ProductModule;

public abstract class Product {
    private String name;
    private String description;
    private double price;
    private String storeName;
    private String type;
    //constructor
    public Product(String name, String description, double price, String storeName){
        this.name= name;
        this.description = description;
        this.price =price;
        this.storeName= storeName;

    }
    //getters y setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
