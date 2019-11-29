package UserModule;

import ProductModule.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StoreWindow extends JFrame {
     JPanel panelSW;
    private JTextField prodNameTF;
    private JTextField descrTF;
    private JTextField priceTF;
    private JTextField storeTF;
    private JTextField typeTF;
    private JButton addProductButton;
    private JTable table1;
    private JButton deleteProductButton;
    private ProductFileRepository productFRepository;

    public StoreWindow() {
        super("Store Panel Control");
        productFRepository = new ProductFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule");


        //add product
        addProductButton.addActionListener(actionEvent -> {
            //  File f = new File(productFRepositor);
            //ileInputStream is = new FileInputStream(f);
          //  InputStreamReader isr = new InputStreamReader(is);
           // BufferedReader br = new BufferedReader(isr);
            String prodName = prodNameTF.getText();
            String descr = descrTF.getText();
            double price = Double.parseDouble(priceTF.getText());
            String store = storeTF.getText();

            String type = typeTF.getText();
            try {
                switch (type) {
                    case "dessert": {
                        Dessert product = new Dessert(prodName, descr, price, store);
                        break;
                    }
                    case "food": {
                        Food product = new Food(prodName, descr, price, store);
                        break;
                    }
                    case "drink": {
                        Drink product = new Drink(prodName, descr, price, store);
                        break;
                    }
                    default:
                        throw new ProductTypeException("The product type does NOT exists.");
                }

                //productFRepository.add();

            } catch (ProductTypeException e) {
                e.printStackTrace();
            }
        });
    }

}
