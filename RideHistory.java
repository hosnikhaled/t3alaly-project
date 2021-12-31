package assignment1;

public class RideHistory {
    Offer offer;
    int rate = -1;
    User user;

    public RideHistory() {
    }

    public RideHistory(User us, Offer f, int r) {
        offer = f;
        rate = r;
        user = us;
    }

    public void setOffer(Offer f) {
        offer = f;
    }

    public void setUser(User us) {
        user = us;
    }

    public User getUser() {
        return user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setRate(int r) {
        rate = r;
    }

    public int getRate() {
        return rate;
    }

}