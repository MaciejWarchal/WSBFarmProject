package machines;

import area.Farm;
import system.CheckNumbers;
import system.Load;
import system.Serialize;

import java.util.ArrayList;

public class Tractor extends Machine{

    public Tractor(Boolean isReadyToUse, double fuelconsumption_l_Per_h, double performance_m2_Per_h, double fuelPrice) {
        super(isReadyToUse, fuelconsumption_l_Per_h, performance_m2_Per_h, fuelPrice);
    }

    public static Tractor buyTractor(Farm farm, ArrayList<Machine> machinesL){
        Tractor tractor=null;
        System.out.println("Podaj numer maszyny");
        int number= Load.getInt();
        if (!CheckNumbers.checkMachineNumber(machinesL,number)) {
            System.out.println("czy maszyna jest sprawan?[t/n]");
            boolean isReadyToUse = false;
            String readyToUse = Load.getString();

            if (readyToUse.equals("t")) {
                isReadyToUse = true;
            } else if (readyToUse.equals("n")) {
                isReadyToUse = false;
            } else {
                System.out.println("nie podano wlasciwego znaku");
            }

            System.out.println("podaj zuzycie paliwa na godzine w [l/h]");
            double fuelConsumption = Load.getDouble();
            System.out.println("podaj wydajnosc maszyny [m2/h]");
            double performance = Load.getDouble();
            System.out.println("podaj cene paliwa");
            double fuelPrice = Load.getDouble();

            tractor = new Tractor(isReadyToUse, fuelConsumption, performance, fuelPrice);
            machinesL.add(tractor);
            Serialize.serializationList(machinesL, "machines.bin");
        }
        return tractor;


    }
}
