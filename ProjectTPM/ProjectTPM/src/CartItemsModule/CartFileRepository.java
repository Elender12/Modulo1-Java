package CartItemsModule;

import ProductModule.Product;

public class CartFileRepository implements CartRepository {
    private String path;
    public CartFileRepository(String path){
        this.path= path;
    }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void chooseStore() {

    }
}
