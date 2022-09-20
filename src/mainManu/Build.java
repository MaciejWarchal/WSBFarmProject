package mainManu;

import area.Bulding;
import area.Farm;
import area.FreshWaterWell;

import java.util.ArrayList;

import static system.Load.getInt;
import static system.Load.getString;

public class Build {

    public static void buildConstruction(ArrayList<Bulding> buldingsL, Farm farm) {
        String end = "";
        int op1 = 0;
        while (!(end.equals("t"))) {
            System.out.println("1. Zbuduj studnie");
            System.out.println("2. Zbuduj spichlerz");
            System.out.println("3. Zasadz pole");
            System.out.println("4. Zbuduj kurnik");
            System.out.println("5. Zbuduj obore");
            System.out.println("6. Zbuduj zbiornik na mleko");
            System.out.println("7. Zbuduj garaz");
            op1 = getInt();
            switch (op1) {

                case 1: {
                    FreshWaterWell.buildFreshWatrWelll(farm, buldingsL);
                    System.out.println("czy powrocic do glownego manu[t/n]");
                    end = getString();
                    break;
                }
            }
        }

    }
}
