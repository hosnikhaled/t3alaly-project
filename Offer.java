package assignment1;

public class Offer {
    Driver driver;
    RequestTrip requestTrip;
    double price;

    public Offer() {
    }
    
    public Offer(Driver dv, RequestTrip requesttrip, double p) {
        driver = dv;
        requestTrip = requesttrip;
        price = p;
    }
    
    public void setRequistTrip(RequestTrip r) {
        requestTrip = r;
    }

    public void setPrice(double p) {
        price = p;
    }

    public RequestTrip getRequestTrip() {
        return requestTrip;
    }

    public double getPrice() {
        return price;
    }

    public void setDriver(Driver dr) {
        driver = dr;
    }

    public Driver getDriver() {
        return driver;
    }
}