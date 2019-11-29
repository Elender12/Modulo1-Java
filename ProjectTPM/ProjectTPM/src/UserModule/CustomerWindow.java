package UserModule;

import ProductModule.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerWindow  extends  JFrame{
     JPanel storeList;
    private JTable tableStore;
    private UserFileRepository shoplist;
    public CustomerWindow (String path){
        super("Customer Panel");

        this.shoplist = new UserFileRepository(path);
      //this.refreshData();


        try{
            ArrayList<User> storeList= new ArrayList<>();
            storeList = shoplist.getStoreList();
        String[] columnNames = {"Username","Name"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
         // tableModel.getDataVector().elementAt(tableStore.getSelectedRow());
        tableStore.setModel(tableModel);

            for (User user : storeList) {
                tableModel.addRow(new Object[]{user.getUsername(), user.getName()});
            }
            }catch (IOException e) {
            e.printStackTrace();
           // int column = 0;
            //int row = tableStore.getSelectedRow();
            //String value = tableStore.getModel().getValueAt(row, column).toString();
           // System.out.println(value);
           /* if (tableStore.getCellSelectionEnabled()) {
                tableStore.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                int rowIndex = tableStore.getSelectedRow();
                int colIndex = tableStore.getSelectedColumn();
                System.out.println(rowIndex+colIndex);
            }*/
            tableStore.setRowSelectionInterval(0, 0);
        }
    }
}