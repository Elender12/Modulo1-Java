package ProductModule;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductFileRepository implements ProductRepository {
    private String file_path; //path to the file

    public ProductFileRepository(String filename) {

        this.file_path = filename;
    }

    @Override
    public void add(Product product) throws IOException {
        //para cada tienda hay una lista de productos
        //debe escribir en el fichero de la tienda
        FileWriter fw = new FileWriter(file_path+"\\"+product.getStoreName()+".txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(product.getName()+"\n");
        pw.print(product.getDescription()+"\n");
        pw.print(product.getPrice()+"\n");
        pw.print(product.getStoreName()+"\n");
        pw.print(product.getType()+"\n");
        pw.close();


    }

    @Override
    public void delete(Product product) {

    }
}
