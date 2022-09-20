package mainManu;

import system.Load;

public class ReturnBack {
    public static String returnToMainManu(String terminate){
        System.out.println("powrot do manu glownego [t/n]");
        terminate= Load.getString();
        return terminate;
    }
}
