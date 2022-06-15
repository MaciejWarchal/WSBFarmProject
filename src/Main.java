import area.*;
import system.FileSystem;
import system.Load;
import system.Log;
import system.MainMenu;
import system.TextSearching;

import users.*;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws FileNotFoundException, IOException {
        System.out.println("Witamy w systemie zarządzania farmą");



        File user = new File("users.txt");  //sprawdzenie jezeli istnieje plik z danymi o urzytkownikach
        boolean exist = user.exists();

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

                System.out.println("Nalezy wprowadzić podstawowe dane farmy");
                System.out.println("Podaj nazwe farmy");
                String farmName=getString();
                System.out.println("Podaj adres");
                String farmAddres=getString();
                System.out.println("Dostepne srodki finansowe");
                double dostepneSrodkiFinansowe=getDouble();
                Border farmBorder=Farm.createFarmBorder();
                Farm A1= new Farm(farmName,farmAddres,farmBorder,dostepneSrodkiFinansowe);
                FileSystem.SaveToFile(A1.toString(),"farm.txt");





/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            } else {
                User LOG=Log.logIn();
                Farm farm1=Load.loadfarm("farm.txt");
                farm1.setEmployees(Load.loadEmployeesToFarm("employess"));

                MainMenu.manuManager(LOG);

            }
        }
        catch(IllegalArgumentException e){
                e.getStackTrace();
                System.out.println("wysrapił bład podczas wprowadzania urzytkownika");
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
