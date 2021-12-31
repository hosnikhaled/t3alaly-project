package assignment1;

import java.util.ArrayList;

public class AdminUser {
    String adminName;
    String Password;
    static ArrayList<Driver> DriverList = new ArrayList<Driver>();
    static ArrayList<Driver> PendingDriverList = new ArrayList<Driver>();
    
    public AdminUser() {
    };

    public AdminUser(String adminname, String password) {
        adminName = adminname;
        Password = password;
    }
    
    public void setAdminUser() {
        Controller.addAdmin("admin","admin");
    }

    public void setAdminName(String name) {
        adminName = name;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setPassword(String Pass) {
        Password = Pass;
    }

    public String getPassword() {
        return Password;
    }

    public static void addPendingDriver(Driver driver) {
        PendingDriverList.add(driver);
    }

    public ArrayList<Driver> getPendingDriverList() {
        return PendingDriverList;
    }

    public void verifyPendingDriverList() {
        boolean bool = true;
        int i = 0;
        do {
            if (DriverList.size() == 0) {
                Controller.addDriver(PendingDriverList.get(0));
                DriverList.add(PendingDriverList.get(0));
            } else {
                for (i = 0; i < PendingDriverList.size(); i++) {
                    int z = 0;
                    for (int x = 0; x < DriverList.size(); x++) {
                        if (PendingDriverList.get(i).nationalID == DriverList.get(x).nationalID) {
                            z++;
                            break;
                        }
                    }
                    if (z == 0) {
                        Controller.addDriver(PendingDriverList.get(i));
                        DriverList.add(PendingDriverList.get(i));
                    }
                        
                }
            }
            if(i==PendingDriverList.size())
                bool = false;
        } while (bool);
        int x = PendingDriverList.size();
        for(i=0; i<x;i++)
            PendingDriverList.remove(0);
    }

    public ArrayList<Driver> getDriverList() {
        return DriverList;
    }
}
