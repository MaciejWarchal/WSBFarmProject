package area;

import java.util.ArrayList;

public class BuldingsInfo {

    public static String showBuldingsList(ArrayList<Bulding> buldingsL){
        String end="t";
        for (Bulding x:buldingsL){
            System.out.println(x);
        }

        return end;
    }
}
