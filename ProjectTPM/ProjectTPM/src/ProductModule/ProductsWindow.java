package ProductModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductsWindow extends JFrame {
    private JPanel panelProducts;
    private JButton addProductButton;
    private JButton deleteProductButton;
    private JButton productListButton;

    public ProductsWindow() {
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //LLAMA AL MÉTODO DE AÑADIR

            }
        });
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //LLAMA AL MÉTODO DE BORRAR Y A SU PUTA MADRE

            }
        });
        productListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            //LLAMA AL MÉTODO DE VER LISTADO
            }
        });
    }
}
