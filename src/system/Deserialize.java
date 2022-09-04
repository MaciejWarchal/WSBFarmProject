package system;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Deserialize {


    public static ArrayList deserialize(ArrayList buldingsL) {
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("buldings.bin"));
            buldingsL = (ArrayList<Object>) o.readObject();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buldingsL;
    }
}
