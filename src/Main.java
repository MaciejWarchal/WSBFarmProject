import area.*;
import humans.Employee;
import system.*;
import machines.*;
import users.*;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[]args) throws FileNotFoundException, IOException {

        System.out.println("Witamy w systemie zarządzania farmą");


        File user = new File("users.txt");  //sprawdzenie jezeli istnieje plik z danymi o urzytkownikach
        boolean exist = user.exists();

        //jeżeli plik nie istnieje przechodzimy do utworzenia pierwszego użytkownika

        try {

            if (!exist) {
                System.out.println("nie zanleziono uzytkowników konieczne wprowadzenie administratora systemu");
                System.out.println("proszę podac dane administratora");
                System.out.println("id");
                int id = getInt();
                System.out.println("imie i nazwisko");
                String name = getString();
                System.out.println("czy bedzie tez managerem [T/N]");
                boolean Manager = false;
                String manager = getString();
                if (manager.equals("t")) {
                    Manager = true;
                }
                System.out.println("czy bedzie tez zwykłym pracownikiem [T/N]");
                boolean Emp = false;
                String emp = getString();
                if (emp.equals("t")) {
                    Emp = true;
                }
                System.out.println("hasło:");
                String pass = getString();

                UserSuperUser admin = new UserSuperUser(id, name, true, Manager, Emp, pass);

                system.FileSystem.SaveToFile(admin.toString(),"users.txt");

                //Tutaj tworzymy obiekt farme

                System.out.println("Nalezy wprowadzić podstawowe dane farmy");
                System.out.println("Podaj nazwe farmy");
                String farmName=getString();
                System.out.println("Podaj adres");
                String farmAddres=getString();
                System.out.println("Dostepne srodki finansowe");
                double dostepneSrodkiFinansowe=getDouble();
                Border farmBorder=Farm.createFarmBorder();
                Farm farm1= new Farm(farmName,farmAddres,farmBorder,dostepneSrodkiFinansowe);
                FileSystem.SaveToFile(farm1.toString(),"farm.txt"); //wlasna metoda na zapis obiektów for fun :)
                ArrayList<Object> buldingsL= new ArrayList<>(10); //pusta lista obiektów, na przyszłe potrzeby serializacji.
                Serialize.serialize(buldingsL);


                // Jeżeli istnieje użutkownik zapisany w pliku users.txt to odczytujemy użytkownika z pilku users.txt

            } else {


                User LOG=Log.logIn();
                Farm farm1=Load.loadfarm("farm.txt"); // odzczytujemy informacje o wcześniej utworzonej farmie
                farm1.setEmployees(Load.loadEmployeesToFarm("employees.txt"));
                ArrayList<Object> buldingsL=new ArrayList<>(10);

                    //Odczytujemy budynki utworzone wcześniej na farmie za pomocą mechanizmu serializacji

                buldingsL=Deserialize.deserialize(buldingsL);

                System.out.println("test");

                for (int i=0; i<buldingsL.size(); i++){
                    System.out.println(buldingsL.get(i));
                }
                MainMenu.manuManager(LOG,farm1,buldingsL);

            }
        }
        catch(IllegalArgumentException e){
                e.getStackTrace();
                System.out.println("wysrapił bład w main ");
                System.out.println(e);
        }
    }




    public static String getString(){
        return new Scanner(System.in).next();
    }
    public static int getInt(){
        return new Scanner(System.in).nextInt();
    }
    public static boolean getBoolean(){
        return new Scanner(System.in).nextBoolean();
    }
    public static double getDouble(){
        return new Scanner(System.in).nextDouble();
    }

}
