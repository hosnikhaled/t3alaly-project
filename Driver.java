package assignment1;

import java.util.ArrayList;

public class Driver {
    int nationalID;
    int Index;
    String drivingLicense;
    Info driverInfo;
    ArrayList<RequestTrip> requistTrip = new ArrayList<RequestTrip>();
    ArrayList<FavArea> favAreaList = new ArrayList<FavArea>();
    ArrayList<Offer> selectedOfferList = new ArrayList<Offer>();
    ArrayList<Offer> ridesHistory = new ArrayList<Offer>();
    ArrayList<DriverBalance> driverBalances = new ArrayList<DriverBalance>();

    public Driver() {
    }

    public Driver(Info driverinfo, int id, String license) {
        driverInfo = driverinfo;
        nationalID = id;
        drivingLicense = license;
    }

    public void setDrivingLicence(String l) {
        drivingLicense = l;
    }

    public void setNationalID(int i) {
        nationalID = i;
    }

    public String getDrivingLicence() {
        return drivingLicense;
    }

    public int getNationalID() {
        return nationalID;
    }

    public void addFavArea(FavArea favarea) {
        favAreaList.add(favarea);
    }

    public ArrayList<FavArea> getFavArea() {
        return favAreaList;
    }

    public void addRequestTrip(RequestTrip requesttrip) {
        requistTrip.add(requesttrip);
        getNotification();
    }

    public ArrayList<RequestTrip> getRequestTrip() {
        return requistTrip;
    }

    public void setIndex(int i) {
        Index = i;
    }

    public int getIndex() {
        return Index;
    }

    public void getNotification() {
        System.out.println("Driver(" + (getIndex() + 1) + ") has a new request ride.");
    }

    public void setOffer(Offer offer) {
        Controller.addOffer(offer);
    }

    public void selectOffer(Offer offer) {
        selectedOfferList.add(offer);
        System.out.println("Driver(" + (getIndex() + 1) + ") has a new selected offer.");
    }

    public void EndRide() {
        Controller.endRide(selectedOfferList.get(0));
        selectedOfferList.remove(0);
    }

    public void addDriverBalance(DriverBalance db) {
        driverBalances.add(db);
    }

    public void printDriverBalance() {
        for (int i = 0; i < driverBalances.size(); i++) {
            System.out.println("The price of trip(" + (i + 1) + ") is:" + driverBalances.get(i).getPrice());
        }
    }
    
    public void printRideHistory() {
        for (int i = 0; i < ridesHistory.size(); i++) {
            System.out.println("User Name:" + ridesHistory.get(i).getRequestTrip().getUser().userInfo.getUserName());
            System.out.println("User Phone Number:" + ridesHistory.get(i).getRequestTrip().getUser().userInfo.getMobileNumber());
            System.out.println("Source Area:" + ridesHistory.get(i).getRequestTrip().getSourceArea());
            System.out.println("Destination Area:" + ridesHistory.get(i).getRequestTrip().destinationArea);
            System.out.println("Price:" + ridesHistory.get(i).getPrice());
        }
    }

    public void printDriver() {
        System.out.println("User name: " + driverInfo.getUserName());
        System.out.println("Email: " + driverInfo.getEmail());
        System.out.println("Password: " + driverInfo.getPassword());
        System.out.println("PhoneNumber: " + driverInfo.getMobileNumber());
        System.out.println("National ID: " + getNationalID());
        System.out.println("Driving license: " + getDrivingLicence());

    }

    public void printRequestTrip() {
        for (int i = 0; i < getRequestTrip().size(); i++) {
            System.out.println("======================Request Trip(" + (i + 1) + ") For The Driver(" + (getIndex() + 1)
                    + ")======================");
            System.out.println("Client name: " + getRequestTrip().get(i).getUser().getUserInfo().getUserName());
            System.out.println("Source area: " + getRequestTrip().get(i).getSourceArea());
            System.out.println("Destination area: " + getRequestTrip().get(i).getDestinationArea());
        }
    }

}
