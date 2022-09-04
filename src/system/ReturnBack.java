package system;

public class ReturnBack {

    public static String ReturnBack(String end){
        System.out.println("czy powrocic do glownego manu[t/n]");
        end = Load.getString();
        if (end.equals("t")) {
            return end = ("t");
        }else {
            return end= ("");
        }

    }
}
