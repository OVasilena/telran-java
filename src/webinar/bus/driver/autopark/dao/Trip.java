package webinar.bus.driver.autopark.dao;

import webinar.bus.driver.autopark.data.Driver;
import webinar.bus.driver.autopark.data.Bus;
import webinar.bus.driver.autopark.data.Route;

public class Trip {

    private Bus bus;
    private Route route;
    private Driver driver;

    public Trip(Bus bus, Route route, Driver driver) {
        this.bus = bus;
        this.route = route;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "\nbus=" + bus +
                ", \nroute=" + route +
                ", \ndriver=" + driver +
                "\n}";
    }
}