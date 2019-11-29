package UserModule;

import ProductModule.*;
import javafx.beans.binding.DoubleExpression;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Currency;

public class StoreWindow extends JFrame {
     JPanel panelSW;
    private JTextField prodNameTF;
    private JTextField descrTF;
    private JTextField priceTF;
    //private JTextField storeTF;
    private JTextField typeTF;
    private JButton addProductButton;
    private JTable tableProducts;
    private JButton deleteProductButton;
    private ProductFileRepository productFRepository;

    public StoreWindow(String path, String storeName) {
        super("Store Panel Control");
        productFRepository = new ProductFileRepository(path);
        //tableProducts.setDefaultEditor(Double.class,
          //      new Currency(0, 100));
        this.refreshData();

        try{
            ArrayList<Product> data = productFRepository.getProductList();
            String[] columnNames = {"Name","Description","Price","Store Name","Type"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            tableProducts.setModel(tableModel);
            for (Product product : data) {
                tableModel.addRow(new Object[]{product.getName(),product.getDescription(),product.getPrice(),product.getStoreName(),product.getType()});
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //add product
        addProductButton.addActionListener(actionEvent -> {
            String prodName = prodNameTF.getText();
            String descr = descrTF.getText();
           Double price = 0.0;
            try {
                price = Double.parseDouble(priceTF.getText());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "That price isn't correct.");
                nfe.printStackTrace();
            }
            //String store = storeTF.getText();

            String type = typeTF.getText();
            try {
                switch (type) {
                    case "dessert": {
                        Dessert product = new Dessert(prodName, descr, price, storeName);
                        productFRepository.add(product);
                        break;
                    }
                    case "food": {
                        Food product = new Food(prodName, descr, price, storeName);
                        productFRepository.add(product);
                        break;
                    }
                    case "drink": {
                        Drink product = new Drink(prodName, descr, price, storeName);
                        productFRepository.add(product);
                        break;
                    }
                    default:
                        throw new ProductTypeException("The product type does NOT exists.");
                }
                refreshData();
                prodNameTF.setText("");
                descrTF.setText("");
                priceTF.setText("");
                typeTF.setText("");

            } catch (ProductTypeException | IOException e) {
                e.printStackTrace();
            }
        });
    }
    private void refreshData(){
        try{
            ArrayList<Product> data = productFRepository.getProductList();
            String[] columnNames = {"Name","Description","Price","Store Name","Type"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            tableProducts.setModel(tableModel);

            for (Product product : data) {
                tableModel.addRow(new Object[]{product.getName(),product.getDescription(),product.getPrice(),product.getStoreName(),product.getType()});
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
