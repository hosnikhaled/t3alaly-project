
package assignment1;

import java.util.ArrayList;

public class Driver {
    Info driverInfo;
    String drivingLicence;
    int nationalID;
    static ArrayList<Driver> driverlist;
    static ArrayList<Integer> offerList;
    FavArea favArea;
    int price;
    Offer offer;
    public void register(String name,int phone,String email,String pass,String licence,int ID)
    {
        Driver drive = null;
        driverlist = new ArrayList<Driver>();
        drive.driverInfo.setUserName(name);
        drive.driverInfo.setEmail(email);
        drive.driverInfo.setMobileNumber(phone);
        drive.driverInfo.setPassword(pass);
        drive.nationalID=ID;
        drive.drivingLicence = licence;
        driverlist.add(drive);
    }
    public void setDrivingLicence(String l){
            drivingLicence=l;
    }
    
    public void setNationalID(int i)
    {
        nationalID = i;
    }
    
    public String getDrivingLicence()
    {
        return drivingLicence;
    }
    public int getNationalID()
    {
        return nationalID;
    }
    public void setOffer(Integer offer)
    {
        offerList = new ArrayList<Integer>();
        price = offer;
        offerList.add(price);
    }        
    
}
