package CartItemsModule;

public class CartItems {
    private String productName;
    private String customerName;
    private int quantity;
    private String storeName;
    public CartItems(String productName, String customerName, int quantity, String storeName){
        this.productName = productName;
        this.customerName = customerName;
        this.quantity =  quantity;
        this.storeName= storeName;
    }
}
