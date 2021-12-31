package assignment1;

import java.util.ArrayList;

public class FavArea {
    String favArea;
    Driver driver;

    public FavArea(){}

    public FavArea(Driver dv, String favarea) {
        driver = dv;
        favArea = favarea;
    }

    public void setFavArea(String f) {
        favArea = f;
    }

    public void setDriver(Driver d) {
        driver = d;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getfavArea() {
        return favArea;
    }

    public void addFavArea(Driver dr, String favarea) {
        FavArea favArea = new FavArea(dr, favarea);
        dr.addFavArea(favArea);
    }
}