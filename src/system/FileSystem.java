package system;


import humans.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

public class FileSystem  {

    public static String[] read(String filename) throws IOException {

        FileReader fr = null;
        String Line = "";
        String usr[]= new String [10];
        int i=0;


        // OTWIERANIE PLIKU:
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("blad przy otwieraniu pliku");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);
        // ODCZYT KOLEJNYCH LINII Z PLIKU:
        try {
            while((Line= bfr.readLine()) != null){
                usr[i]=Line;
                i++;

            }
        } catch (IOException e) {
            System.out.println("wystąpił błąd");
            System.exit(2);

        }

        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("blad przy zamekaniu pliku");
            System.exit(3);
        }
        return usr;
    }




    public static void SaveToFile(String data,String filePath){

        try {

            FileWriter fw = new FileWriter(filePath, true);
            fw.write(System.lineSeparator());

            for (int i = 0; i < data.length(); i++) {
                fw.write(data.charAt(i));
            }


            System.out.println("zapisano pomyslnie");
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static boolean checkIdIfExistUsers(String id) throws IOException {
        String[] userstab = new String[20];
        userstab = system.FileSystem.read("users.txt");
        boolean resault=true;
        for (int i = 0; i < userstab.length; i++) {
            System.out.println("sprawdzam " + userstab[i]);
            System.out.println("resault 1= "+resault);
            if(userstab[i]!=null) {

                String usr = userstab[i];
                String IdRead = TextSearching.findText(usr, "id=", ',');
                System.out.println("znaleziono id w pliku "+IdRead+" a podano id "+id);

                if (IdRead.equals(id)) {
                    System.out.println("Wybrane Id juz istnieje!!!: " + userstab[i]);
                    resault = true;
                    System.out.println("czytam resault "+resault);
                    break;
                } else if (userstab[i] == null) {
                    System.out.println("nie znaleziono odpowiadajacego id");
                    resault = false;
                    break;
                }
                else {
                    System.out.println("nie znaleziono odpowiadajacego id");
                    resault=false;
                }
            }
            else
                break;
        }
        System.out.println("resault= "+resault);
        return resault;

    }

    public static boolean checkIdIfExistEmpolyees(String id) throws IOException {
        String[] userstab = new String[20];
        userstab = system.FileSystem.read("employees.txt");
        for (int i = 0; i < userstab.length; i++) {
            String usr=userstab[i];
            String IdRead=TextSearching.findText(usr, "id=" ,',');
            if (IdRead.equals(id)) {
                System.out.println("Wybrane Id juz istnieje: "+userstab[i]);
                return true;
            }
            else if (userstab[i] == null){
                return false;

            }
        }
        return true;
    }
}

