package system;

import users.User;
import users.UserEmployee;
import users.UserManager;
import users.UserSuperUser;

import java.io.IOException;
import java.util.Scanner;

public class Log {

    public static User logIn() throws IOException {
        User LOG = null;                  // LOG może przechowywac ponizsze obiekty zastosowanie polimorfizmu
        UserSuperUser Admin = null;
        UserManager Manager = null;
        UserEmployee Employee = null;
        while (Admin == null && Manager == null && Employee == null && LOG == null) {

            System.out.println("proszę o zalogowanie");         // czytanie pliku z danymi urzytkowników
            String[] userstab = new String[20];
            userstab = system.FileSystem.read("users.txt");
            for (int i = 0; i < userstab.length; i++) {

                if (userstab[i] == null)

                    break;
            }
            System.out.println("podaj ID urzytkownika");              //tu zaczynamy logowanie pierwszego urzytkownika
            String idin = getString();
            String id;
            String pass;

            for (int j = 0; j < userstab.length; j++) {
                if (userstab[j] == null) {
                    break;
                } else {
                    id = TextSearching.findText(userstab[j], "id=", ',');
                    if (id.equals(idin)) {
                        System.out.println("podaj haslo:");
                        String passin = getString();
                        pass = TextSearching.findText(userstab[j], "password='", '\'');
                        if (pass.equals(passin)) {
                            String superuser = TextSearching.findText(userstab[j], "isSuperUser=", ',');
                            String manager = TextSearching.findText(userstab[j], "isManager=", ',');
                            String employee = TextSearching.findText(userstab[j], "isEmployee=", ',');

                            if (superuser.equals("true")) {
                                String name = TextSearching.findText(userstab[j], "name='", '\'');
                                Admin = new UserSuperUser(Integer.parseInt(id), name, true, false, false, pass);
                                LOG = Admin;
                                System.out.println("zalogowano administratora systemu " + name);
                            } else if (manager.equals("true")) {
                                String name = TextSearching.findText(userstab[j], "name='", '\'');
                                Manager = new UserManager(Integer.parseInt(id), name, false, true, false, pass);
                                LOG = Manager;
                                System.out.println("zalogowano managera " + name);
                            } else if (employee.equals("true")) {
                                String name = TextSearching.findText(userstab[j], "name='", '\'');
                                Employee = new UserEmployee(Integer.parseInt(id), name, false, false, true, pass);
                                LOG = Employee;
                                System.out.println("zalogowano pracownika " + name);
                            }
                        } else {
                            System.out.println("bledne haslo");
                        }

                    } else if (j == userstab.length - 1) {
                        System.out.println("nie ma takiego id ");
                    }
                }
            }
        }
        return LOG;
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
