package mainManu;

import area.Farm;
import area.Field;
import area.FreshWaterWell;
import area.Granary;
import machines.CombineHarvester;
import machines.Machine;
import machines.Tractor;

import java.util.ArrayList;

import static system.Load.getInt;
import static system.Load.getString;

public class BuyMachine {

    public static void buyMachine(ArrayList<Machine> machinesL, Farm farm) {
        String end = "";
        int op1 = 0;
        while (!(end.equals("t"))) {
            System.out.println("1. zakup traktora");
            System.out.println("2. zakup kombajnu");
            System.out.println("3. zakup auta");
            System.out.println("4. zakup przyczpy");
            System.out.println("5. Powrot do mainmanu");

            op1 = getInt();
            switch (op1) {

                case 1: {
                    Tractor.buyTractor(farm, machinesL);
                    System.out.println("czy powrocic do glownego manu[t/n]");
                    end = getString();
                    break;
                }
                case 2: {
                    CombineHarvester.buyCombineHarvester(farm, machinesL);
                    System.out.println("czy powrocic do glownego manu[t/n]");
                    end = getString();
                    break;
                }
                case 3: {

                }
                case 4: {

                    break;
                }
                case 5: {
                    end="t";
                    break;

                }


            }
        }
    }
}
