package machines;

import java.util.ArrayList;

public abstract class FindMachine {

    public static Machine machineFind (ArrayList<Machine> machinesL,Class<Machine> machineClass){
        
        Machine machineFound=null;
        
        if (!machinesL.isEmpty()){
            for (int i=0;i<machinesL.size();i++) {
                if (machinesL.get(i).getClass().equals(machineClass)) {
                    machineFound = machinesL.get(i);
                } else
                    System.out.println("nie znaleziono maszyny");
            }
        }else {
            System.out.println("nie wczytano listy maszyn");
            machineFound=null;
        }
        
        return machineFound;
    }
}
