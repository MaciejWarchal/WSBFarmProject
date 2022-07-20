package system;

import area.Border;
import area.Bulding;
import area.Farm;
import humans.*;
import users.User;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Load {

    public static ArrayList<User> loadusersToFarm(String path) throws IOException {
        ArrayList<User>users=new ArrayList<>(10);
        String[] usersTab=new String[FileSystem.read(path).length];

        usersTab=FileSystem.read(path);


        for (int i=0;i< usersTab.length;i++){
            if (usersTab[i]!=null) {
                String id=TextSearching.findText(usersTab[i], "id=", ',');
                String name=TextSearching.findText(usersTab[i],"name='",'\'');
                String phoneNumber=TextSearching.findText(usersTab[i],"phoneNumber=",',');
                String isSuperUser=TextSearching.findText(usersTab[i],"isSuperUser=",',');
                Boolean IsSuperuser;
                if (isSuperUser.equals("true"))
                    IsSuperuser=true;
                else
                    IsSuperuser=false;
                String isManager=TextSearching.findText(usersTab[i],"isManager=",',');
                Boolean IsManager;
                if (isManager.equals("true"))
                    IsManager=true;
                else
                    IsManager=false;

                String isEmployee=TextSearching.findText(usersTab[i],"isEmployee=true",',' );
                Boolean IsEmployee;
                if (isEmployee.equals("true"))
                    IsEmployee=true;
                else
                    IsEmployee=false;
                String pass=TextSearching.findText(usersTab[i],"password='",'\'');

                users.add(new User(Integer.parseInt(id), name,IsSuperuser,IsManager,IsEmployee,pass));
            }

        }
        return users;
    }

    public static ArrayList<Employee> loadEmployeesToFarm(String path) throws IOException {
        ArrayList<Employee>employees=new ArrayList<>(10);

        List<String> employeeList = Arrays.asList(FileSystem.read(path));


        for (int i=0;i< employeeList.size();i++){
            if (employeeList.get(i) !=null) {
                String id=TextSearching.findText(employeeList.get(i), "id=", ',');
                String name=TextSearching.findText(employeeList.get(i),"name='",'\'');
                String phoneNumber=TextSearching.findText(employeeList.get(i),"phoneNumber=",',');
                String age=TextSearching.findText(employeeList.get(i),"age=",'}');

                int ID=Integer.parseInt(id);
                int phone=Integer.parseInt(phoneNumber);
                System.out.println(ID);
                System.out.println(phone);

                employees.add(new Employee(Integer.parseInt(id),name,Integer.parseInt(phoneNumber),age));
            }

        }
        return employees ;
    }

    public static Border loadfarmBorder(String farmPath) throws IOException {
        String[] borderTab= new String[FileSystem.read(farmPath).length];

        borderTab=FileSystem.read(farmPath);
        Border farm=null;

        for (int i=0; i< borderTab.length;i++){    //Czytamy [i] lineie z pliku txt
            if (borderTab[i]!=null){
                Point2D LU= loadPoint2D("LU",borderTab[i]);
                Point2D RU= loadPoint2D("RU",borderTab[i]);
                Point2D LD= loadPoint2D("LD",borderTab[i]);
                Point2D RD= loadLastPoint2D("RD",borderTab[i]);

                Border Farm=new Border(LU,RU,LD,RD);
                farm=Farm;

            }
        }
        return farm;


    }

    public static Border loadBuldingBorder(String path) throws IOException {
        String[] borderTab= new String[FileSystem.read(path).length];

        borderTab=FileSystem.read(path);
        Border buldingBorder=null;

        for (int i=0; i< borderTab.length;i++){    //Czytamy [i] lineie z pliku txt
            if (borderTab[i]!=null){
                Point2D LU= loadPoint2D("LU",borderTab[i]);
                Point2D RU= loadPoint2D("RU",borderTab[i]);
                Point2D LD= loadPoint2D("LD",borderTab[i]);
                Point2D RD= loadLastPoint2D("RD",borderTab[i]);

                buldingBorder=new Border(LU,RU,LD,RD);

            }else {
                System.out.println("nie utworzono granic budynku");
                return null;
            }
        }
      return buldingBorder;
    }

    public static Point2D loadPoint2D(String pointName,String borderTabi){
        String beforeValue="=Point2D.Doubl";
        String beforeWithPointName=pointName+beforeValue;
        String pointCoordinates=TextSearching.findText(borderTabi,beforeWithPointName,'B');
        String x=TextSearching.findText(pointCoordinates,"e[",',');
        String XFindafter=x+", ";
        String y=TextSearching.findText(pointCoordinates,XFindafter,']');
        Point2D point=new Point2D.Double(Double.parseDouble(x),Double.parseDouble(y));
        return point;

    }

    public static Point2D loadLastPoint2D(String pointName,String borderTabi) {
        String beforeValue = "=Point2D.Doubl";
        String beforeWithPointName = pointName + beforeValue;
        String pointCoordinates = TextSearching.findText(borderTabi, beforeWithPointName, '}');
        String x = TextSearching.findText(pointCoordinates, "e[", ',');
        String XFindafter = x + ", ";
        String y = TextSearching.findText(pointCoordinates, XFindafter, ']');
        Point2D point = new Point2D.Double(Double.parseDouble(x), Double.parseDouble(y));
        return point;
    }


    public static Farm loadfarm(String farmpath) throws IOException {

        String[] farmsTab=new String[FileSystem.read(farmpath).length];
        farmsTab=FileSystem.read(farmpath);
        Farm farm=null;

        for (int i=0;i< farmsTab.length;i++){
            if (farmsTab[i]!=null){
                String name=TextSearching.findText(farmsTab[i],"farmName='",'\'');
                String addres=TextSearching.findText(farmsTab[i],"farmAddres='",'\'');
                Border farmBorder=loadfarmBorder(farmpath);
                String cash=TextSearching.findText(farmsTab[i],"cash=",',');
                Farm thisFarm=new Farm(name,addres,farmBorder,Double.parseDouble(cash));
                farm=thisFarm;

            }
        }
        return farm;
    }

    public static Bulding loadBuldingToFarm(String path,Bulding buldingType) throws IOException {
        ArrayList<Bulding> buldings=new ArrayList<>(10);

        String[] buildingsTab=new String[FileSystem.read(path).length];
        buildingsTab=FileSystem.read(path);

        for (int i=0; i<buildingsTab.length;i++){
            if (buildingsTab[i]!=null){
                String thisnumber=TextSearching.findText(buildingsTab[i],"number=",',');
                Border thisBorder=Load.loadBuldingBorder(path);      // tu potrzebne będą importy przy migracji
                String thisPrice=TextSearching.findText(buildingsTab[i],"price=",',');
            }
        }
        return null;
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
