package UserModule;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserRepository {
     void create(User x) throws IOException; //check parameters
     void remove(User x) throws IOException; // check parameters
     boolean login(String username, String pass) throws IOException;

}
