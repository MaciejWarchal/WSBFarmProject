package users;

public class UserEmployee extends User{
    public UserEmployee(int id, String name, boolean isSuperUser, boolean isManager, boolean isEmployee, String password) {
        super(id, name, isSuperUser, isManager, isEmployee, password);
    }
}
