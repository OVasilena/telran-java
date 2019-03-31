package webinar.bus.driver.autopark.data;

public class Strecke extends Route {

    public Strecke(String startPoint, String endPoint, int distance) {
        super(startPoint, endPoint, distance);
    }

    public String toString() {
        return "from " + super.getStartPoint() + " to " +
                super.getEndPoint() + " - " + super.getDistance() + " km";
    }
}