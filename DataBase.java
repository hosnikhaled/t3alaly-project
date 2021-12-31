package assignment1;

import java.util.ArrayList;

public class DataBase {
    static ArrayList<User> UserList = new ArrayList<User>();
    static ArrayList<Driver> Driverlist = new ArrayList<Driver>();
    static ArrayList<AdminUser> AdminList = new ArrayList<AdminUser>();

    public static void addUser(User user) {
        UserList.add(user);
    }

    public static void addAdmin(String n, String p) {
        AdminUser admin = new AdminUser(n, p);
        AdminList.add(admin);
    }

    public ArrayList<AdminUser> getAdminList(Driver driver) {
        return AdminList;
    }

    public static void addDriver(Driver driver) {
        Driverlist.add(driver);
    }

    public ArrayList<User> getUserList() {
        return UserList;
    }

    public ArrayList<Driver> getDriverlist() {
        return Driverlist;
    }

    public static void addRequestTrip(RequestTrip requesttrip) {

    }
}