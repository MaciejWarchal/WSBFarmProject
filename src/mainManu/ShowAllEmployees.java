package mainManu;

import java.io.IOException;

import static system.FileSystem.read;
import static system.Load.getString;

public class ShowAllEmployees {

    public static void showAllEmployees() throws IOException {
        String empTab[] = new String[20];
        empTab = read("employees.txt");

            for (int i = 0; i < empTab.length; i++) {
                if (empTab[i] != null) {
                    System.out.println(empTab[i]);
                }
            }
    }
}
