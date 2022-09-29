package machines;

import area.Farm;
import area.Field;
import system.CheckNumbers;
import system.Load;
import system.Serialize;

import java.io.Serializable;
import java.util.ArrayList;

public class Tractor extends Machine implements Serializable {

    public Tractor() {
    }

    public Tractor(int number, Boolean isReadyToUse, double fuelconsumption_l_Per_h, double performance_m2_Per_h, double fuelPrice) {
        super(number, isReadyToUse, fuelconsumption_l_Per_h, performance_m2_Per_h, fuelPrice);
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

            tractor = new Tractor(number,isReadyToUse, fuelConsumption, performance, fuelPrice);
            machinesL.add(tractor);
            Serialize.serializationList(machinesL, "machines.bin");
        }else {
            System.out.println("numer maszyny zajety");
            tractor=null;
        }
        return tractor;
    }

    public static int tractorFindI (ArrayList<Machine> machinesL){

        int tractorFoundInIndex=9999999;
        Tractor tractor=null;

        if (!machinesL.isEmpty()){
            for (int i=0;i<machinesL.size();i++) {
                if (machinesL.get(i)instanceof Tractor) {
                    tractor = (Tractor) machinesL.get(i);
                } else
                    System.out.println("nie znaleziono maszyny");
            }
        }else {
            System.out.println("nie wczytano listy maszyn");
            tractor=null;
        }

        return tractorFoundInIndex;
    }

    public static Tractor tractorFind (ArrayList<Machine> machinesL){

        int tractorFoundInIndex=9999999;
        Tractor tractor=null;

        if (!machinesL.isEmpty()){
            for (int i=0;i<machinesL.size();i++) {
                if (machinesL.get(i)instanceof Tractor) {
                    tractor = (Tractor) machinesL.get(i);
                } else
                    System.out.println("nie znaleziono maszyny");
            }
        }else {
            System.out.println("nie wczytano listy maszyn");
            tractor=null;
        }

        return tractor;
    }

    public void useTractor(ArrayList<Machine> machinesL, Farm farm, Field field){
        if (this.isReadyToUse){
            double fuelExpenses=(field.getArea_m2()*this.getFuelconsumption_l_Per_h()*this.getFuelPrice())/this.getPerformance_m2_Per_h();
            farm.setCash(farm.getCash()-fuelExpenses);
            System.out.println("traktor zuzyl paliwa za "+fuelExpenses+" zl");
        }
    }



    @Override
    public String toString() {
        return "Tractor{" +
                "number=" + number +
                ", isReadyToUse=" + isReadyToUse +
                ", fuelconsumption_l_Per_h=" + fuelconsumption_l_Per_h +
                ", performance_m2_Per_h=" + performance_m2_Per_h +
                ", fuelPrice=" + fuelPrice +
                '}';
    }
}
