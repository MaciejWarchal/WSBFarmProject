package machines;

import area.Farm;
import system.CheckNumbers;
import system.Load;
import system.Serialize;

import java.io.Serializable;
import java.util.ArrayList;

public class CombineHarvester extends Machine implements Serializable {

    public CombineHarvester(int number, Boolean isReadyToUse, double fuelconsumption_l_Per_h, double performance_m2_Per_h, double fuelPrice) {
        super(number, isReadyToUse, fuelconsumption_l_Per_h, performance_m2_Per_h, fuelPrice);
    }

    public static CombineHarvester buyCombineHarvester(Farm farm, ArrayList<Machine> machinesL){
        CombineHarvester combineHarvester=null;
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

            combineHarvester = new CombineHarvester(number,isReadyToUse, fuelConsumption, performance, fuelPrice);
            machinesL.add(combineHarvester);
            Serialize.serializationList(machinesL, "machines.bin");
        }
        return combineHarvester;


    }

    @Override
    public String toString() {
        return "CombineHarvester{" +
                "number=" + number +
                ", isReadyToUse=" + isReadyToUse +
                ", fuelconsumption_l_Per_h=" + fuelconsumption_l_Per_h +
                ", performance_m2_Per_h=" + performance_m2_Per_h +
                ", fuelPrice=" + fuelPrice +
                '}';
    }
}
