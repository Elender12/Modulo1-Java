package UserModule;

import ProductModule.Product;
import ProductModule.ProductFileRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerWindow  extends  JFrame{
     JPanel storeList;
    private JTable tableStore;
    private JButton selectStoreButton;
    private JTable tableProducts;
    private UserFileRepository userFileRepository;
    private ProductFileRepository productFileRepository;

    public CustomerWindow (String path){
        super("Customer Panel");
        this.userFileRepository = new UserFileRepository(path);
      //this.refreshData();
        String[] columnNames = {"Username","Name"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        // tableModel.getDataVector().elementAt(tableStore.getSelectedRow());
        tableStore.setModel(tableModel);


        try{
            ArrayList<User> storeList;
            storeList = userFileRepository.getStoreList();


            for (User user : storeList) {
                tableModel.addRow(new Object[]{user.getUsername(), user.getName()});
            }



            }catch (IOException e) {
            e.printStackTrace();
           // int column = 0;
            //int row = tableStore.getSelectedRow();
            //String value = tableStore.getModel().getValueAt(row, column).toString();
           // System.out.println(value);
           // tableStore.setRowSelectionInterval(0, 0);
           // int rowIndex = tableStore.getSelectedRow();
            //System.out.println(rowIndex);
        }
      /*  tableStore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (tableStore.getCellSelectionEnabled()) {
                    tableStore.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    int colIndex = tableStore.getSelectedColumn();
                  //System.out.println(rowIndex+colIndex);
                }
            }
        });*/
        selectStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // tableStore.setRowSelectionInterval(0, 0);
                int rowIndex = tableStore.getSelectedRow();
                int colIndex= tableStore.getSelectedColumn();
                //shows the index
                tableStore.getValueAt(rowIndex,colIndex);
                String storeUsername = tableStore.getModel().getValueAt(rowIndex, colIndex).toString();
                System.out.println(storeUsername);
                Store chosenStore = new Store(storeUsername,"","");
                String path = "C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\StoreProducts\\"+storeUsername+".txt";
                productFileRepository = new ProductFileRepository(path);
                try {
                    //ArrayList<Product> data = productFileRepository.getProductList();
                    ArrayList<Product> data= productFileRepository.getProductList();
                    String[] columnNames1 = {"Name","Description","Price","Store Name","Type"};
                    DefaultTableModel tableModel1 = new DefaultTableModel(columnNames1, 0);
                    tableProducts.setModel(tableModel1);
                    for (Product product : data) {
                        tableModel1.addRow(new Object[]{product.getName(),product.getDescription(),product.getPrice(),product.getStoreName(),product.getType()});
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //opens a new window

            }
        });

    }
}