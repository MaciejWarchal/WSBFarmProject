package system;

import area.Bulding;
import machines.Machine;

import java.util.ArrayList;

public class CheckNumbers {

    public static boolean checkBuldingNumber(ArrayList buldingsL,int numberToCheck){
        boolean numberUsed=true;

        if (!buldingsL.isEmpty()){
        for (int i=0;i<buldingsL.size();i++){
            Bulding bulding=(Bulding)buldingsL.get(i);
            System.out.println("found number "+bulding.getNumber());
            if (bulding.getNumber()==numberToCheck){
                numberUsed=true;
                break;
            }else {
                numberUsed=false;
            }

        }}else if (buldingsL.isEmpty()){
            System.out.println("brak numerow, nie wczytano listy");
            numberUsed=false;
        }
        return numberUsed;
    }

    public static boolean checkMachineNumber(ArrayList machinesL,int numberToCheck){
        boolean numberUsed=true;

        if (!machinesL.isEmpty())
        for (int i=0;i<machinesL.size();i++) {
            Machine machine = (Machine) machinesL.get(i);
            System.out.println("found number " + machine.getNumber());
            if (machine.getNumber() == numberToCheck) {
                numberUsed = true;
                break;
            } else {
                numberUsed = false;
            }
        }else if (machinesL.isEmpty()) {
            System.out.println("nie wczytano listy z maszynami");
            numberUsed=false;
        }


        return numberUsed;
    }
}
