package UserModule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class AdminWindow extends JFrame{
     JPanel mainPanelS;
    private JTextField usernameTF;
    private JPasswordField passTF;
    private JTextField nameTF;
    private JButton registerStoreButton;
    private JButton deleteStoreButton;
   // private JButton storeListButton;
    private JTable userTable;
    private UserFileRepository userFileRepository;

    public AdminWindow() {
        super("AdminWindow");
        this.setContentPane(this.mainPanelS);
        this.userFileRepository= new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
        this.refreshData();

        try{

            ArrayList<User> data = userFileRepository.getStoreList();
            String[] columnNames = {"Username","Password","Name","Role"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            userTable.setModel(tableModel);

            for(int i = 0; i<data.size();i++){
                User user = data.get(i);
                tableModel.addRow(new Object[]{user.getUsername(),user.getPassword(),user.getName(),user.getRole()});
            }
        }catch (IOException e){
            e.printStackTrace();
        }





        //adds a store
        registerStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
            }
        });
        deleteStoreButton.addActionListener(new ActionListener() {
            //deletes the store
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });
        //LISTA DE TODAS LAS TIENDAS
    /*    storeListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //aqui debo llamar a la funcion de list
                ArrayList<User> result = new ArrayList<>();
                userFileRepository = new UserFileRepository("C:\\Users\\Ele\\Desktop\\Universidad\\Modulo1-Java\\ProjectTPM\\ProjectTPM\\src\\UserModule\\Users.txt");
                try {
                    result = userFileRepository.getStoreList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(result.toArray());

            }
        });*/
    }
        private void refreshData(){
            try{
                ArrayList<User> data = userFileRepository.getStoreList();
                String[] columnNames = {"Username","Password","Name","Role"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                userTable.setModel(tableModel);

                for(int i = 0; i<data.size();i++){
                    User user = data.get(i);
                    tableModel.addRow(new Object[]{user.getUsername(),user.getPassword(),user.getName(),user.getRole()});
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }



    }

