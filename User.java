package assignment1;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    Info userInfo;
    ArrayList<Offer> OfferList = new ArrayList<Offer>();
    ArrayList<RideHistory> rideHistory = new ArrayList<RideHistory>();

    public User() {
    }

    public User(Info userinfo) {
        userInfo = userinfo;
    }

    public void setUserInfo(Info userinfo) {
        userInfo = userinfo;
    }

    public Info getUserInfo() {
        return userInfo;
    }

    public void setIndex(int i) {
        Index = i;
    }

    public int getIndex() {
        return Index;
    }

    public void getNotification() {
        System.out.println("=================================================================");
        System.out.println("User(" + (Controller.UserList.indexOf(User.this) + 1) + ") has a new offer.");
    }

    public void setOffer(Double price) {
        int i;
        for (i = 0; i < getOffer().size(); i++) {
            if (OfferList.get(i).getPrice() == price) {
                break;
            }
        }
        Controller.SelectOffer(getOffer().get(i));
        for (int x = 0; x < i; x++) {
            getOffer().remove(0);
        }
        for (int x = i + 1; x < getOffer().size(); x++) {
            getOffer().remove(x);
        }
    }

    public void requestTrip(RequestTrip requesttrip) {
        Controller.addRequestTrip(requesttrip);
    }

    public void addOffer(Offer f) {
        OfferList.add(f);
        getNotification();
    }

    public ArrayList<Offer> getOffer() {
        return OfferList;
    }

    public void rateRide(String bool) {
        int r = 0;
        if (bool.equals("y")) {
            for (int i = 0; i < rideHistory.size(); i++) {
                if (rideHistory.get(i).getRate() != -1) {
                    System.out.println("Enter the rate of driver(" + (i + 1) + "):");
                    r = input.nextInt();
                    rideHistory.get(i).setRate(r);
                    System.out.println("The rate of driver(" + (i + 1) + ")was Updated.");
                }
                if (r == 0) {
                    System.out.println("You rated all driver before");
                }
            }
        } else {
            for (int i = 0; i < rideHistory.size(); i++) {
                if (rideHistory.get(i).getRate() != -1) {
                    r++;
                }
            }
            if (r == 0) {
                System.out.print("Enter the number of drivers you want to rated them:");
                int count = input.nextInt();
                for (int x = 0; x < count; x++) {
                    System.out.print("Enter the name of driver:");
                    String name = input.next();
                    System.out.print("Enter the rate of driver:");
                    r = input.nextInt();
                    for (int i = 0; i < rideHistory.size(); i++) {
                        if (rideHistory.get(i).getOffer().getDriver().driverInfo.getUserName().equals(name)) {
                            rideHistory.get(i).setRate(r);
                            System.out.println("The rate was Updated.");
                        } else
                            System.out.println("Driver name was entered wrong.");
                    }
                }
            }
            else
                System.out.println("You rated all driver before");
        }
    }

    public ArrayList<RideHistory> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory() {
        System.out.println("==============================User(" + (Controller.UserList.indexOf(User.this) + 1)
                        + ")==============================");
        System.out.println("User(" + (Controller.UserList.indexOf(User.this) + 1) + ") was arrived");
        System.out.print("Do you want to rate now?(y/n)");
        String ch = input.next();
        if (ch.equals("y")) {
            System.out.print("Enter the rate of driver:");
            int r = input.nextInt();
            RideHistory ridehistory = new RideHistory(User.this, getOffer().get(0), r);
            rideHistory.add(ridehistory);
            getOffer().remove(0);
        } else {
            RideHistory ridehistory = new RideHistory(User.this, getOffer().get(0), -1);
            rideHistory.add(ridehistory);
            getOffer().remove(0);
        }
        System.out.println(
                "==================================================================");
    }

    public void printOffers() {
        for (int i = 0; i < getOffer().size(); i++) {
            System.out.println("======================" + (i + 1) + ")Offer(" + (i + 1) + ") For The User("
                    + (Controller.UserList.indexOf(User.this) + 1)
                    + ")======================");
            System.out.println("OFFER(" + (i + 1) + ")");
            System.out.println("Driver name: " + getOffer().get(i).getDriver().driverInfo.userName);
            System.out.println("Source area: " + getOffer().get(i).getRequestTrip().getSourceArea());
            System.out.println("Destination area: " +  getOffer().get(i).getRequestTrip().getDestinationArea());
            System.out.println("Price: " + getOffer().get(i).getPrice());
        }
    }

    public void printDriverDeyailsToEachOffer() {
        for (int i = 0; i < getOffer().size(); i++) {
            System.out.println("======================Driver Details Offer(" + (i + 1) + ")Details For The User("
                    + (Controller.UserList.indexOf(User.this) + 1)
                    + ")======================");
            System.out.println("Driver Name: " + getOffer().get(i).getDriver().driverInfo.getUserName());
            System.out.println("Driver Email: " + getOffer().get(i).getDriver().driverInfo.getEmail());
            System.out.println("Phone Number: " + getOffer().get(i).getDriver().driverInfo.getMobileNumber());
            System.out.println("Driver NationaOd: " + getOffer().get(i).getDriver().getNationalID());
            System.out.println("Driver DrivingLicense: " + getOffer().get(i).getDriver().getDrivingLicence());
        }
    }

    public void printRideHistory() {
        System.out.println("===========================================================");
        for (int i = 0; i < rideHistory.size(); i++) {
            System.out.println("Driver name: " + rideHistory.get(i).getOffer().getDriver().driverInfo.getUserName());
            System.out.println("Driver Phone Number: " + rideHistory.get(i).getOffer().getDriver().driverInfo.getMobileNumber());
            System.out.println("Source area: " + rideHistory.get(i).getOffer().getRequestTrip().getSourceArea());
            System.out.println("Destination area: " + rideHistory.get(i).getOffer().getRequestTrip().getDestinationArea());
            System.out.println("Price: " + rideHistory.get(i).getOffer().getPrice());
            System.out.println("Rate: " + rideHistory.get(i).getRate());
            System.out.println("===========================================================");
        }
    }

    public void printUser() {
        System.out.println("User name: " + userInfo.getUserName());
        System.out.println("Email: " + userInfo.getEmail());
        System.out.println("Password: " + userInfo.getPassword());
        System.out.println("PhoneNumber: " + userInfo.getMobileNumber());
    }

}