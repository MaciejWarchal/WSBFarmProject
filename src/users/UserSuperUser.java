package users;

import system.FileSystem;


import java.io.IOException;
import java.util.Scanner;

public class UserSuperUser extends User implements userCreatable{

    public UserSuperUser(int id, String name, boolean isSuperUser, boolean isManager, boolean isEmployee, String password) {
        super(id, name, isSuperUser, isManager, isEmployee, password);
    }

    @Override
    public UserManager createUserManager() throws IOException {
        UserManager userObj = null;
        String ID="";
        while (userObj==null&&(!ID.equals("t"))) {

            System.out.println("podaj id lub wyjdz z kreatora[t] ");
            ID = getString();
            if (FileSystem.checkIdIfExistUsers(ID) == false) {
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

                userObj = new UserManager(id, name, false, Manager, Emp, pass);

                system.FileSystem.SaveToFile(userObj.toString(),"users.txt");
            } else {
                System.out.println("wybrane id juz istnieje");
            }
        }
        return userObj;
    }


    public UserEmployee createUserEmployee() throws IOException {
        UserEmployee userObj = null;
        String ID="";
        while (userObj==null&&(!ID.equals("t"))) {

            System.out.println("podaj id lub wyjdz z kreatora[t] ");
            ID = getString();
            if (FileSystem.checkIdIfExistUsers(ID) == false) {
                System.out.println("id");
                int id = getInt();
                System.out.println("imie i nazwisko");
                String name = getString();

                System.out.println("hasło:");
                String pass = getString();

                userObj = new UserEmployee(id, name, false, false, true, pass);

                system.FileSystem.SaveToFile(userObj.toString(),"users.txt");
            } else {
                System.out.println("wybrane id juz istnieje");
            }
        }
        return userObj;
    }


}
