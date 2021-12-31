package assignment1;

import java.util.ArrayList;

public class AreaLocation {
    String Name;
    double lat1, lon1;
    ArrayList<AreaLocation> sourceArea = new ArrayList<AreaLocation>();

    public AreaLocation() {
        AreaLocation AreaLocation1 = new AreaLocation("Cairo", 30.444, 31.2357);
        sourceArea.add(AreaLocation1);
        AreaLocation AreaLocation2 = new AreaLocation("Giza", 30.0131, 31.2089);
        sourceArea.add(AreaLocation2);
        AreaLocation AreaLocation3 = new AreaLocation("Luxor", 25.6872, 32.6396);
        sourceArea.add(AreaLocation3);
        AreaLocation AreaLocation4 = new AreaLocation("Alexandria", 31.2001, 29.9187);
        sourceArea.add(AreaLocation4);
        AreaLocation AreaLocation5 = new AreaLocation("Aswan", 24.0889, 32.8998);
        sourceArea.add(AreaLocation5);
        AreaLocation AreaLocation6 = new AreaLocation("Hurghada", 27.2579, 33.8116);
        sourceArea.add(AreaLocation6);
        AreaLocation AreaLocation7 = new AreaLocation("Ismailia", 30.5965, 32.2715);
        sourceArea.add(AreaLocation7);
        AreaLocation AreaLocation8 = new AreaLocation("Asyut", 27.1783, 31.1859);
        sourceArea.add(AreaLocation8);
    }

    public AreaLocation(String name, Double l1, Double l2) {
        Name = name;
        lat1 = l1;
        lon1 = l2;
    }

    public void setLat1(Double l1) {
        lat1 = l1;
    }

    public void setLon1(Double l2) {
        lon1 = l2;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getLat1() {
        return lat1;
    }

    public double getLon1() {
        return lon1;
    }

    public String getName() {
        return Name;
    }

    public void setAreaLocationList() {
        
    }

    public ArrayList<AreaLocation> getAreaLocations() {
        return sourceArea;
    }

    public double latsearch(String name) {
        for (int i = 0; i < getAreaLocations().size(); i++) {
            if (getAreaLocations().get(i).getName().equals(name)) {
                return getAreaLocations().get(i).getLat1();
            }
        }
        System.out.println("You entered a wrong area name.");
        return 0;
    }

    public double lonsearch(String name) {
        for (int i = 0; i < getAreaLocations().size(); i++) {
            if (getAreaLocations().get(i).getName().equals(name)) {
                return getAreaLocations().get(i).getLon1();
            }
        }
        System.out.println("You entered a wrong area name.");
        return 0;
    }
}
