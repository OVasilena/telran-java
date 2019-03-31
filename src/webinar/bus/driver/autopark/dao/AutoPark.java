package webinar.bus.driver.autopark.dao;

import webinar.bus.driver.autopark.data.Bus;
import webinar.bus.driver.autopark.data.Driver;

import java.util.Arrays;

/**
 * class AutoPark
 */
public class AutoPark {
    private int quantityBuses;
    private int quantityDrivers;

    private Bus[] buses;
    private Driver[] drivers;

    /**
     * Constructor
     *
     * @param abus   int
     * @param driver int
     */
    public AutoPark(int abus, int driver) {
        this.quantityBuses = abus;
        this.quantityDrivers = driver;

        buses = new Bus[quantityBuses];
        drivers = new Driver[quantityDrivers];

        // generate buses
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus("M200" + (i + 1));
        }

        // generate drivers
        for (int i = 0; i < drivers.length; i++) {
            drivers[i] = new Driver("id-100" + (i + 1));
        }
    }

    /**
     * Method random getBus()
     *
     * @return bus
     */
    public Bus getBus() {
        int index = (int) (Math.random() * buses.length);
        System.out.println("index random: " + index);
        return buses[index];
    }

    public Driver getDriver() {
        int index = (int) (Math.random() * drivers.length);
        return drivers[index];
    }

    public Bus[] getBuses() {
        return buses;
    }

    public Driver[] getDrivers() {
        return drivers;
    }

    public String toStringBuses() {
        return Arrays.toString(buses);
    }

    public String toStringDrivers() {
        return Arrays.toString(drivers);
    }
}