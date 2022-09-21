package system;

import area.Bulding;

import java.util.ArrayList;

public class CheckNumbers {

    public static boolean checkBuldingNumber(ArrayList buldingsL,int numberToCheck){
        boolean numberUsed=true;
        for (int i=0;i<buldingsL.size();i++){
            Bulding bulding=(Bulding)buldingsL.get(i);
            System.out.println("found number "+bulding.getNumber());
            if (bulding.getNumber()==numberToCheck){
                numberUsed=true;
                break;
            }else {
                numberUsed=false;
            }

        }
        return numberUsed;
    }

    public static boolean checkMachineNumber(ArrayList machinesL,int numberToCheck){
        boolean numberUsed=true;
        for (int i=0;i<machinesL.size();i++){
            Bulding bulding=(Bulding)machinesL.get(i);
            System.out.println("found number "+bulding.getNumber());
            if (bulding.getNumber()==numberToCheck){
                numberUsed=true;
                break;
            }else {
                numberUsed=false;
            }

        }
        return numberUsed;
    }
}
