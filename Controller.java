package assignment1;

import java.util.ArrayList;

public class Controller {
    static int z = 0;
    static ArrayList<User> UserList = new ArrayList<User>();
    static ArrayList<Driver> Driverlist = new ArrayList<Driver>();
    static ArrayList<AdminUser> AdminList = new ArrayList<AdminUser>();
    
    public static void addUser(User user) {
        UserList.add(user);
        DataBase.addUser(user);
    }

    public static void addAdmin(String n, String p) {
        AdminUser admin = new AdminUser(n, p);
        AdminList.add(admin);
        DataBase.addAdmin(n, p);
    }

    public ArrayList<AdminUser> getAdminList(Driver driver) {
        return AdminList;
    }

    public ArrayList<User> getUserList() {
        return UserList;
    }

    public ArrayList<Driver> getDriverlist() {
        return Driverlist;
    }

    public static void addDriver(Driver driver) {
        Driverlist.add(driver);
        DataBase.addDriver(driver);
    }

    public static void addRequestTrip(RequestTrip requestTrip) {
        for (int i = 0; i < Driverlist.size(); i++) {
            for (int x = 0; x < Driverlist.get(i).getFavArea().size(); x++) {
                if (requestTrip.getSourceArea().equals(Driverlist.get(i).getFavArea().get(x).getfavArea())) {
                    Driverlist.get(i).setIndex(i);
                    Driverlist.get(i).addRequestTrip(requestTrip);
                    break;
                }
            }
        }
    }

    public static void addOffer(Offer f) {
        f.getRequestTrip().getUser().addOffer(f);
    }

    public static void SelectOffer(Offer f) {
        f.getDriver().selectOffer(f);
    }

    public static void endRide(Offer f) {
        f.getRequestTrip().getUser().setRideHistory();
    }
}