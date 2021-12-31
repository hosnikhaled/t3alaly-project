package assignment1;

public class Login {
    int userIndex, driverIndex;
    Info info;

    public Login() {
    }

    public Driver logInAsDriver(String name, String Pass) {
        for (int i = 0; i < Controller.Driverlist.size(); i++) {
            if (Controller.Driverlist.get(i).driverInfo.getUserName().equals(name)) {
                if (Controller.Driverlist.get(i).driverInfo.getPassword().equals(Pass)) {
                    driverIndex = i+1;
                    return Controller.Driverlist.get(i);
                }
            }
        }
        System.out.println("The password or email that you've entered is incorrect or in pending list");
        return null;
    }

    public int getDriverIndex() {
        return driverIndex;
    }

    public int getUserIndex() {
        return userIndex;
    }

    public User logInAsUser(String name, String Pass) {
        for (int i = 0; i < Controller.UserList.size(); i++) {
            if(Controller.UserList.get(i).userInfo.getUserName().equals(name)) {
                if (Controller.UserList.get(i).userInfo.getPassword().equals(Pass)) {
                    userIndex = i + 1;
                    return Controller.UserList.get(i);
                }
            }
        }
        System.out.println("The password or email that you've entered is incorrect");
        return null;
    }

    public AdminUser logInAsAdmin(String name, String Pass) {
        if (Controller.AdminList.get(0).getAdminName().equals(name)) {
            if (Controller.AdminList.get(0).getPassword().equals(Pass))
                return Controller.AdminList.get(0);
        }
        System.out.println("The password or email that you've entered is incorrect");
        return null;
        
    }
}