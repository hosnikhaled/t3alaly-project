package assignment1;

public class DriverRegister {
    public void register(Driver driver) {
        AdminUser.addPendingDriver(driver);
    }
}