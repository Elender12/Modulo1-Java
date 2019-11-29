package CartItemsModule;

public class CartItems {
    private String productName;
    private String customerName;
    private int quantity;
    private String storeName;
    //constructor
    public CartItems(String productName, String customerName, int quantity, String storeName){
        this.productName = productName;
        this.customerName = customerName;
        this.quantity =  quantity;
        this.storeName= storeName;
    }
    //setters y getters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "productName='" + productName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", quantity=" + quantity +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
