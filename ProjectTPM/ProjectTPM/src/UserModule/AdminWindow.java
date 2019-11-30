package UserModule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AdminWindow extends JFrame {
    JPanel mainPanelS;
    private JTextField usernameTF;
    private JPasswordField passTF;
    private JTextField nameTF;
    private JButton registerStoreButton;
    private JButton deleteStoreButton;
    // private JButton storeListButton;
    private JTable userTable;
    private JTextField toDeleteStore;
    private UserFileRepository userFileRepository;

    public AdminWindow() {
        super("AdminWindow");
        this.setContentPane(this.mainPanelS);
        this.userFileRepository = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        this.refreshData();
        String[] columnNames = {"Username", "Name", "Role"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        userTable.setModel(tableModel);
        try {
            ArrayList<User> data = userFileRepository.getStoreList();
            for (User user : data) {
                tableModel.addRow(new Object[]{user.getUsername(), user.getName(), user.getRole()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //adds a store
        registerStoreButton.addActionListener(actionEvent -> {
            String user = usernameTF.getText();
            System.out.println(user);
            char[] pass = passTF.getPassword();
            String name = nameTF.getText();
            Store store = new Store(user, String.valueOf(pass), name);
            try {
                //file= new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
                userFileRepository = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
                userFileRepository.create(store);
                refreshData();
                usernameTF.setText("");
                passTF.setText("");
                nameTF.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        //deletes the store
        /*
        deleteStoreButton.addActionListener((ActionEvent actionEvent) -> {
            //file= new UserFileRepository("C:\\Users\\Elena Cirstea\\Desktop\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
            userFileRepository = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");

            try {
                File f = new File("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
                FileInputStream is = new FileInputStream(f);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                User storeRM;
                User storeWithJustName = new Store("", "", "");
                storeWithJustName.setUsername(toDeleteStore.getText());
                storeRM = storeWithJustName.check(br);
                System.out.println(storeRM);

                //userFileRepository.remove(storeRM);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });

         */
        deleteStoreButton.addActionListener((ActionEvent actionEvent) ->{
            if (userTable.getSelectedRow() != -1) {
                // remove selected row from the model
                userTable.setModel(tableModel);
                tableModel.removeRow(userTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
               // refreshData();
            }
        });

    }

    private void refreshData() {
        try {
            ArrayList<User> data = userFileRepository.getStoreList();
            String[] columnNames = {"Username", "Name", "Role"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            userTable.setModel(tableModel);

            for (User user : data) {
                tableModel.addRow(new Object[]{user.getUsername(), user.getName(), user.getRole()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
        public void actionPerformed(ActionEvent ae) {
            // check for selected row first
            if (userTable.getSelectedRow() != -1) {
                // remove selected row from the model
                DefaultTableModel tableModel = new DefaultTableModel();
                userTable.setModel(tableModel);
                tableModel.removeRow(userTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            }

    }*/
}
