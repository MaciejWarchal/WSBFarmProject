import area.*;
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
/*
                System.out.println("nalezy okreslic granice nowej farmy w [m] (przyjmoje tylko wartosci dodatnie, farma ma ksztalt prostokatu");
                System.out.println("podaj polnocno-zachodni punkt graniczny");

                System.out.println("x ");
                double x1=getDouble();
                System.out.println("y ");
                double y1=getDouble();

                Point2D lu = null;
                        lu.setLocation(x1,y1);

                System.out.println("podaj polnocno-wschodni punkt graniczny");

                System.out.println("x ");
                double x2=getDouble();
                System.out.println("y ");
                double y2=getDouble();

                Point2D ru = null;
                ru.setLocation(x2,y2);

                System.out.println("podaj poludniowo-zachodni punkt graniczny");

                System.out.println("x ");
                double x3=getDouble();
                System.out.println("y ");
                double y3=getDouble();

                Point2D ld = null;
                ld.setLocation(x3,y3);

                System.out.println("podaj poludniowo-wschodni punkt graniczny");

                System.out.println("x ");
                double x4=getDouble();
                System.out.println("y ");
                double y4=getDouble();

                Point2D rd = null;
                rd.setLocation(x4,y4);




                Border farm=new Border(lu
                ,ru,ld,rd);  */

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            } else {
                User LOG=Log.logIn();
               // Load.loadEmployeesToFarm("users.txt");  // tutaj wczytujemy pracownikow z pliku txt
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
