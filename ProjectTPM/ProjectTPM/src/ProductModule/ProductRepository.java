package ProductModule;

import java.io.IOException;

public interface ProductRepository {
    void add(Product product) throws IOException;
    void delete(Product product);

}

