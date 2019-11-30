package UserModule;

import ProductModule.Product;
import ProductModule.ProductFileRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class CartWindow extends JFrame {
     JPanel cartWindow;
    private JTable tableCart;
    private ProductFileRepository productFRepository;
    public CartWindow( ){
        super("Shopping cart");
        String[] columnNames = {"Name","Description","Price","Store Name","Type"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);


            //ArrayList<Product> data = productFRepository.getProductList();

         /*   for (String product : products) {

                tableModel.addRow(new Object[]{products});
            }*/


    }
}
