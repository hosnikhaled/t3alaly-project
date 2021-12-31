package assignment1;

public class RequestTrip {
    User user;
    String sourceArea;
    String destinationArea;

    public RequestTrip() {
    }

    public RequestTrip(User us, String source, String destination) {
        user = us;
        sourceArea = source;
        destinationArea = destination;
    }

    public void setSourceArea(String source) {
        sourceArea = source;
    }

    public void setdestinationArea(String destination) {
        destinationArea = destination;
    }

    public String getSourceArea() {
        return sourceArea;
    }

    public String getDestinationArea() {
        return destinationArea;
    }

    public void setUser(User us) {
        user = us;
    }

    public User getUser() {
        return user;
    }

}