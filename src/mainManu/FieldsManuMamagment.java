package mainManu;

import area.Bulding;
import area.Farm;
import area.Field;
import machines.Machine;
import management.FieldsManagement;
import system.Serialize;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class FieldsManuMamagment implements Serializable {
    public static void fieldsManagementManu(ArrayList<Bulding> buldingsL, Farm farm, ArrayList<Machine> machinesL){
        ArrayList<Field> fields= FieldsManagement.fieldsManagementList(buldingsL);
        int op=0;
        String end="";
        while (!end.equals("t")){
            for (int i=0;i< fields.size();i++){
                if (i==0){
                    System.out.println("wybiez pole");
                    System.out.println();
                }
                System.out.println(i+". pole nr: "+fields.get(i).getNumber()+" "+fields.get(i).toString());
            }
            System.out.println();
            for (int j=0;j< fields.size();j++){
                if (op==j){
                    int op2=0;
                    System.out.println("1. zaktualizuj stan pola");
                    System.out.println("2. zbiez plony");
                    switch (op2){
                        case 1:{
                            Field field=fields.get(j);
                            field.grow();
                            buldingsL.addAll(fields);
                            Serialize.serializationList(buldingsL,"buldings.bin");
                            System.out.println("wykonano aktualizacje");

                        }
                    }
                }

            }








        }
    }
}
