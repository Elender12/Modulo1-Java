package CartItemsModule;

import ProductModule.Product;

public interface CartRepository {
    void addItem(Product product);
    void chooseStore();
}
