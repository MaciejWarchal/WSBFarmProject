package management;

import area.Bulding;
import area.Field;

import java.util.ArrayList;

public abstract class FieldsManagement {

    public static ArrayList<Field> fieldsManagementList(ArrayList<Bulding> buldingsL){

        ArrayList <Field> fieldsL=new ArrayList<>(10);
        for (int i=0;i<buldingsL.size();i++){
            if (buldingsL.get(i).getClass().equals(Field.class)){
                System.out.println("comparing class "+buldingsL.get(i).getClass()+" & "+Field.class);
                fieldsL.add((Field) buldingsL.get(i));
                buldingsL.remove(i);
                //System.out.println("field "+i+"."+buldingsL.get(i).toString()); // poniewaz usunieto pozycje z buldingsL
            }
        }
        return fieldsL;
    }


}
