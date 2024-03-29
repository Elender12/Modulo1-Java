package ProductModule;

import java.io.BufferedReader;
import java.io.IOException;

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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", storeName='" + storeName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    //checks the type of the drink
    public static Product check(BufferedReader br) throws IOException {
        String name = br.readLine();
        if (name == null) {
            return null;
        } else {
            String description = br.readLine();
            double price = Double.parseDouble(br.readLine());
            String storeName = br.readLine();
            String type = br.readLine();
            switch (type) {
                case "drink":
                    return new Drink(name, description, price, storeName);
                case "dessert":
                    return new Dessert(name, description, price, storeName);
                case "food":
                    return new Food(name, description, price, storeName);
                default:
                    return null;
            }
        }

    }




}
