package system;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialize {

    public static void serialize(ArrayList buldingsWtiteList) {

        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("buldings.bin", false));
            o.writeObject(buldingsWtiteList);
            o.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
