package system;

import humans.*;
import users.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load {

    public static ArrayList<User> loadEmployeesToFarm(String path) throws IOException {
        ArrayList<User>users=new ArrayList<>(10);
        String[] usersTab=new String[20];

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



}
