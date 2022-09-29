package mainManu;

import area.Bulding;
import area.Farm;
import area.Field;
import machines.Machine;
import management.FieldsManagement;
import system.Load;
import system.Serialize;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class FieldsManuMamagment implements Serializable {
    public static String fieldsManagementManu(ArrayList<Bulding> buldingsL, Farm farm, ArrayList<Machine> machinesL){
        ArrayList<Field> fields= FieldsManagement.fieldsManagementList(buldingsL); // ta metoda usuwa pola z listy!!!
        int op=9999999;
        String end="n";
        while (!end.equals("t")){
            System.out.println();
            if (!fields.isEmpty()) {
                for (int i = 0; i < fields.size(); i++) {
                    System.out.println(i + ". pole nr: " + fields.get(i).getNumber() + " " + fields.get(i).toString());
                }

                System.out.println();
                System.out.println("wybiez pole");
                op= Load.getInt();

                for (int j=0;j< fields.size();j++){

                    if (op==j){
                        int op2=0;
                        System.out.println("1. zaktualizuj stan pola");
                        System.out.println("2. zbiez plony");
                        op2=Load.getInt();
                        switch (op2){
                            case 1:{
                                Field field=fields.get(j);
                                field.grow();
                                buldingsL.addAll(fields); //bo usunięto wszystkie pola z listy buldingsL
                                Serialize.serializationList(buldingsL,"buldings.bin");
                                System.out.println("wykonano aktualizacje");
                                System.out.println("powrót do main manu");
                                end="t";
                                break;
                            }
                            case 2:{
                                Field field=fields.get(j);
                                field.harvest(machinesL,farm,buldingsL);
                                // serializacje wykonano w metodzie harvest
                                System.out.println("wykonano zbiory");
                                System.out.println("powrót do main manu");
                                end="t";
                                break;
                            }
                        }
                    }
                }
            }else {
                System.out.println("lista pol jest pusta");
                end="t";

            }
        }
        return end;
    }
}
