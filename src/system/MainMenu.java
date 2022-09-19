package system;

import area.Border;
import area.Bulding;
import area.Farm;
import area.FreshWaterWell;
import humans.Employee;
import humans.Manager;
import users.User;
import users.UserEmployee;
import users.UserManager;
import users.UserSuperUser;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu extends FileSystem {
    /*public static void main(String[]args) throws FileNotFoundException, IOException {
        System.out.println("Witamy w systemie zarządzania farmą main manu");


        File user = new File("users.txt");  //sprawdzenie jezeli istnieje plik z danymi o urzytkownikach
        boolean exist = user.exists();

        try {


                System.out.println("proszę o zalogowanie main manu");         // czytanie pliku z danymi urzytkowników
                String[] userstab = new String[20];
                userstab = system.FileSystem.read("users.txt");
                for (int i = 0; i < userstab.length; i++) {
                    if (userstab[i] == null)
                        break;
                }

                System.out.println("podaj ID urzytkownika");              //tu zaczynamy logowanie pierwszego urzytkownika
                String idin=getString();
                String id;
                String pass;

                for (int j = 0; j < userstab.length; j++) {
                    if (userstab[j] == null) {
                        break;
                    } else {
                        id = TextSearching.findText(userstab[j], "id=", ',');
                        System.out.println(id);
                        if (id.equals(idin)){
                            System.out.println("podaj haslo:");
                            String passin=getString();
                            pass=TextSearching.findText(userstab[j],"password='",'\'');
                            if (pass.equals(passin)){
                                String superuser=TextSearching.findText(userstab[j],"isSuperUser=",',');
                                String manager=TextSearching.findText(userstab[j],"isManager=",',');
                                String employee=TextSearching.findText(userstab[j],"isEmployee=",',');
                                if (superuser.equals("true")){
                                    String name=TextSearching.findText(userstab[j],"name='",'\'');
                                    UserSuperUser Admin= new UserSuperUser(Integer.parseInt(id),name,true,false, false, pass);
                                    System.out.println("zalogowano administratora systemu "+name);
                                }
                                else if (manager.equals("true")){
                                    String name=TextSearching.findText(userstab[j],"name='",'\'');
                                    UserSuperUser Manager= new UserSuperUser(Integer.parseInt(id),name,false,true, false, pass);
                                    System.out.println("zalogowano managera "+name);
                                }
                                else if (employee.equals("true")){
                                    String name=TextSearching.findText(userstab[j],"name='",'\'');
                                    UserSuperUser Employee= new UserSuperUser(Integer.parseInt(id),name,false,false, true, pass);
                                    System.out.println("zalogowano managera "+name);
                                }

                            } else {
                                System.out.println("wystąpil blad przy logowaniu");
                            }
                        }
                    }
                }
        }
        catch(IllegalArgumentException e){
            e.getStackTrace();
            System.out.println("wysrapił bład podczas wprowadzania urzytkownika");
        }
    }*/

    public static void manuManager(User LOG, Farm FARM, ArrayList buldingsL, ArrayList machinesL) throws IOException {
        int op = 999999999;
        if (LOG != null) {
            while (op != 0) {
                System.out.println("ID: " + LOG.getId() + "  " + LOG.getName());
                System.out.println("wpisz i zatwierdz:");
                System.out.println("1. wypisz dane urzytkownika");
                System.out.println("2. dodaj pracownika do systemu");
                System.out.println("3. wypisz wszystkich pracowników");
                System.out.println("4. zbuduj budynek");
                System.out.println("5. wypisz informacje o farmie farmie");
                System.out.println("6. wyloguj i zakoncz program");

                op = getInt();
                switch (op) {
                    case 1: {
                        System.out.println(LOG.toString());
                        System.out.println();
                        System.out.println("powrot do manu glownego [t/n]");
                        String ar = getString();
                        while (!ar.equals("t")) {
                            System.out.println(LOG.toString());
                            System.out.println("powrot do manu glownego [t/n]");
                            ar = getString();
                        }
                        break;
                    }

                    case 2: {
                        System.out.println("[1] dodaj managera");
                        System.out.println("[2] dodaj pracownika");
                        int opr = getInt();

                        switch (opr) {
                            case 2: {
                                createEmployee();
                                break;
                            }
                            case 1: {
                                createManager();
                                break;
                            }
                        }
                        break;
                    }

                    case 3: {
                        String empTab[] = new String[20];
                        empTab = read("employees.txt");
                        String end = "";
                        while (!(end.equals("t")))
                            for (int i = 0; i < empTab.length; i++) {
                                if (empTab[i] != null) {
                                    System.out.println(empTab[i]);
                                } else {
                                    System.out.println("czy powrocic do glownego manu[t/n]");
                                    end = getString();
                                    break;
                                }
                            }
                        break;
                    }
                    case 4: {
                        String end = "";
                        int op1 = 0;
                        while (!(end.equals("t"))) {
                            System.out.println("1. Zbuduj studnie");
                            System.out.println("2. Zbuduj spichlerz");
                            System.out.println("3. Zasadz pole");
                            op1 = getInt();
                            switch (op1) {
                                case 1: {


                                    System.out.println("czy powrocic do glownego manu[t/n]");
                                    end = getString();
                                }
                                break;
                            }
                        }
                    }

                        case 5: {
                            System.out.println(Load.loadfarm("farm.txt"));
                            break;
                        }
                        case 6: {
                            LOG = null;
                            System.out.println("wylogowano");
                            System.exit(0);           // status "0" bo wychodzimy bez bledow.

                        }

                }
            }
        }
    }


        public static Employee createEmployee() throws IOException {

            System.out.println("podaj id");
            String id = getString();
            if (!FileSystem.checkIdIfExistUsers(id)) {
                System.out.println("podaj imie i nazwisko");
                String name = getString();
                System.out.println("numer telfonu:");
                int ph = getInt();
                System.out.println("wiek pracownika:");
                int ag = getInt();
                System.out.println("haslo");
                String pass = getString();
                System.out.println("miesieczne wynagrodzenie");
                double sal = getDouble();


                Employee employee = new Employee(Integer.parseInt(id), name, ph, ag, sal,
                        sal, 0, 0, 0, 0,
                        0, 0, null, 0);
                FileSystem.SaveToFile(employee.toString(), "employees.txt");

                UserEmployee Employee = new UserEmployee(Integer.parseInt(id), name, false, false,
                        true, pass);
                FileSystem.SaveToFile(Employee.toString(), "users.txt");
                return employee;
            } else {
                System.out.println("podane id juz istnieje");
                return null;
            }

        }


        public static Manager createManager () throws IOException {

            System.out.println("podaj id");
            String id = getString();
            if (!FileSystem.checkIdIfExistUsers(id)) {
                System.out.println("podaj imie i nazwisko");
                String name = getString();
                System.out.println("numer telfonu:");
                int ph = getInt();
                System.out.println("wiek pracownika:");
                int ag = getInt();
                System.out.println("haslo");
                String pass = getString();
                System.out.println("miesieczne wynagrodzenie");
                double sal = getDouble();


                Manager manager = new Manager(Integer.parseInt(id), name, ph, ag, sal, sal, 0,
                        0, 0, 0, 0, 0, null,
                        0, null);
                FileSystem.SaveToFile(manager.toString(), "employees.txt");
                System.out.println(manager.toString());

                UserManager Manager = new UserManager(Integer.parseInt(id), name, false, true, false, pass);
                FileSystem.SaveToFile(Manager.toString(), "users.txt");
                return manager;
            } else {
                System.out.println("podane id juz istnieje");
                return null;
            }
        }



    public static String getString() {
        return new Scanner(System.in).next();
    }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }

    public static boolean getBoolean() {
        return new Scanner(System.in).nextBoolean();
    }

    public static double getDouble() {
        return new Scanner(System.in).nextDouble();
    }

}
