package users;

import java.util.Scanner;

public class User{

    private int id;
    private String name;
    private boolean isSuperUser;
    private boolean isManager;
    private boolean isEmployee;
    private String password;

    public User(int id, String name, boolean isSuperUser, boolean isManager, boolean isEmployee, String password) {
        this.id = id;
        this.name = name;
        this.isSuperUser = isSuperUser;
        this.isManager = isManager;
        this.isEmployee = isEmployee;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isSuperUser=" + isSuperUser +
                ", isManager=" + isManager +
                ", isEmployee=" + isEmployee +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
