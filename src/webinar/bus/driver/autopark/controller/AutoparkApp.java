package webinar.bus.driver.autopark.controller;

import webinar.bus.driver.autopark.dao.AutoPark;
import webinar.bus.driver.autopark.dao.Trip;
import webinar.bus.driver.autopark.data.Bus;
import webinar.bus.driver.autopark.data.Driver;
import webinar.bus.driver.autopark.data.Route;
import webinar.bus.driver.autopark.data.Strecke;

import java.util.ArrayList;

public class AutoparkApp {
    public static void main(String[] args) {

        // generate Autopark (bus depot) with 5 buses and 9 drivers
        AutoPark autoPark = new AutoPark(5,9);

        // get all buses
        Bus[] buses = autoPark.getBuses();
        // print all buses
        System.out.println("\n************ BUS ************");
        System.out.println(autoPark.toStringBuses());

        // get all drivers
        Driver[] drivers = autoPark.getDrivers();
        // print all drivers
        System.out.println("\n************ DRIVER ************");
        System.out.println(autoPark.toStringDrivers());

        // set type of bus
        buses[0].setType("city");
        buses[1].setType("country");
        buses[2].setType("village");

        // set capacity of bus
        buses[0].setCapacity(140);
        buses[1].setCapacity(80);
        buses[2].setCapacity(16);


        // set route for trip
        Route routeCity = new Route("Alex", "Wannsee", 25);

        // additions example for station list
        // set stations
        ArrayList<Strecke> stations = new ArrayList<>();
        stations.add(new Strecke(routeCity.getStartPoint(), "Potsdamer Platz", 9));
        stations.add(new Strecke("Potsdamer Platz", "Südkreuz", 6));
        stations.add(new Strecke("Südkreuz", "Botanischer Garten", 4));
        stations.add(new Strecke("Botanischer Garten", routeCity.getEndPoint(), 6));
        routeCity.setStations(stations);

        System.out.println("\n************ We're going to get on the bus **********\n");
        for (Strecke strecke: stations
        ) {
            System.out.println("Drive from station" + strecke.getStartPoint()
                                + "to station: " + strecke.getEndPoint() + " - "
                                + strecke.getDistance() + " km");
            buses[0].move(strecke.getDistance());

        }
        System.out.println("Bus move on Route: " + buses[0].getKmStand() + " km");

        System.out.println("Capacity bus: " + buses[0].getCapacity());
        System.out.println("Aktuell passanger: " + buses[0].getPeople());

        buses[0].addPeople(12);
        System.out.println("Aktuell passanger: " + buses[0].getPeople());

        buses[0].addPeople(10);

        System.out.println("Aktuell passanger: " + buses[0].getPeople());
        buses[0].subPeople(3);
        System.out.println("Aktuell passanger: " + buses[0].getPeople());

        buses[0].subPeople(15);
        System.out.println("Aktuell passanger: " + buses[0].getPeople());


        System.out.println("\n************* Drive on Route ************");
        // set trip for city
        Trip tripCity = buses[0].doTrip(routeCity, drivers[2]);
        // add Route
        Route routeCityAlex = new Route("Alex", "Potsdam", 25);
        Route routeCityZoo = new Route("Zoo", "Alex", 13);
        Route routeCityPotsdam = new Route("PotsdamH", "PotsdamE", 17);
        Route routeCityRing = new Route("Wedding", "Tempelhof", 45);

        System.out.println("************ Liste of Trips ****************\n");
        Trip tripCityAlex = buses[1].doTrip(routeCityAlex, drivers[1]);
        Trip tripCityPotsdam = buses[1].doTrip(routeCityPotsdam, drivers[0]);
        Trip tripCityBerlin = buses[2].doTrip(routeCityAlex, drivers[4]);
        Trip tripCityRing = buses[3].doTrip(routeCityRing, drivers[5]);
        Trip tripCityZoo = buses[4].doTrip(routeCityZoo, drivers[7]);

        TripList listeCity = new TripList();
        listeCity.add(tripCity);;
        listeCity.add(tripCityAlex);
        listeCity.add(tripCityBerlin);
        listeCity.add(tripCityPotsdam,6);
        listeCity.add(tripCityRing,2);
        listeCity.add(tripCityZoo,2);
        // print liste
        listeCity.printTrip();

        System.out.println("\n************** REMOVE first trip ***************");
        listeCity.removeFirst();
        listeCity.printTrip();

        System.out.println();
        System.out.println("\n************** REMOVE on pos 3 ***************");
        listeCity.remove(3);
        listeCity.printTrip();

        System.out.println();
        System.out.println("\n************** REMOVE last trip ***************");
        listeCity.removeLast();
        listeCity.printTrip();
    }
}