package ProductModule;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductFileRepository implements ProductRepository {
    private String filename; //path to the file

    public ProductFileRepository(String filename) {
        this.filename= filename;
    }

    @Override
    public void add(Product product) throws IOException {
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter pw = new PrintWriter(fw);
        //para cada tienda hay una lista de productos
        //debe escribir en el fichero de la tienda



    }

    @Override
    public void delete(Product product) {

    }
}
