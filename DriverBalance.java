package assignment1;

import assignment1.Driver;

public class DriverBalance {
    int price;
    Driver driver;

    public DriverBalance() {
    }

    public DriverBalance(Driver dr, int p) {
        driver = dr;
        price = p;
    }

    public void setPrice(int p) {
        price = p;
    }

    public int getPrice() {
        return price;
    }

    public void setDriver(Driver d) {
        driver = d;
    }

    public Driver getDriver() {
        return driver;
    }

    public void addNewBalance(Driver dr, int p) {
        DriverBalance driverBalance = new DriverBalance(dr, p);
        dr.addDriverBalance(driverBalance);
    }
}