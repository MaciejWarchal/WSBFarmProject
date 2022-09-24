package mainManu;

import area.*;

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
            System.out.println("8. Powrot do mainmanu");
            op1 = getInt();
            switch (op1) {

                case 1: {
                    FreshWaterWell.buildFreshWatrWelll(farm, buldingsL);
                    System.out.println("czy powrocic do glownego manu[t/n]");
                    end = getString();
                    break;
                }
                case 2: {
                    Granary.buildGranary(farm,buldingsL);
                    System.out.println("czy powrocic do glownego manu[t/n]");
                    end = getString();
                    break;
                }
                case 3: {
                    Field.buildField(farm,buldingsL);
                    System.out.println("czy powrocic do glownego manu[t/n]");
                    end = getString();
                    break;
                }
                case 4: {

                    break;
                }
                case 5: {
                    break;
                }
                case 6: {

                    break;
                }
                case 7: {
                    break;
                }
                case 8:{
                    System.out.println("[t/n]");
                    end=getString();
                }
            }
        }
    }
}
