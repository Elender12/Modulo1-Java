import ProductModule.Product;
import ProductModule.ProductFileRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class CartWindow extends JFrame {
    private JPanel cartWindow;
    private JTable tableCart;
    private JButton button1;
    private ProductFileRepository productFRepository;
    public CartWindow(){
        super("Shopping cart");
        String[] columnNames = {"Name","Description","Price","Store Name","Type"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        try{

            ArrayList<Product> data = productFRepository.getProductList();

            for (Product product : data) {

                tableModel.addRow(new Object[]{product.getName(),product.getDescription(),product.getPrice(),product.getStoreName(),product.getType()});
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
