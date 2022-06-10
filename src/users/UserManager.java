package users;

public class UserManager extends User {

    public UserManager(int id, String name, boolean isSuperUser, boolean isManager, boolean isEmployee, String password) {
        super(id, name, isSuperUser, isManager, isEmployee, password);
    }
}
