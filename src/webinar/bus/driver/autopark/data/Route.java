package webinar.bus.driver.autopark.data;

import java.util.ArrayList;

public class Route {
    private String startPoint;
    private String endPoint;
    private int distance;
    private ArrayList<Strecke> stations;

    public Route(String startPoint, String endPoint, int distance) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
    }

    public Route(String endPoint, int distance) {
        startPoint = "Berlin";
        this.endPoint = endPoint;
        this.distance = distance;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public int getDistance() {
        return distance;
    }

    public void setStations(ArrayList<Strecke> stations) {
        this.stations = stations;
    }

    public ArrayList<Strecke> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "from " + startPoint + " to " +
                endPoint + " - " + distance + " km" +
                " Stations: " + stations;
    }
}