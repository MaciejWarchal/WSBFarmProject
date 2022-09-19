package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserialize {
    public static ArrayList deserializationList(String file){
        ArrayList list;
        try {
            ObjectInputStream o=new ObjectInputStream(new FileInputStream(file));
            list=(ArrayList) o.readObject();
            o.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
