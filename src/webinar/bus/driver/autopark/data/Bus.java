package webinar.bus.driver.autopark.data;


import webinar.bus.driver.autopark.dao.Trip;

/**
 * class Bus
 */
public class Bus {
    private String number;
    private int capacity;
    private String type;
    private int people;
    ;
    private int kmStand;

    /**
     * Constructor
     *
     * @param number String
     *               <ul><li>people = 0</li><li>kmStand = 0</li></ul>
     */
    public Bus(String number) {
        this.number = number;
        people = 0;
        kmStand = 0;
    }

    /**
     * Constructor
     *
     * @param number
     * @param capacity <ul><li>people = 0</li><li>kmStand = 0</li></ul>
     */
    public Bus(String number, int capacity) {
        this.number = number;
        this.capacity = capacity;
        people = 0;
        kmStand = 0;
    }

    public String getNumber() {
        return number;
    }

    /**
     * Method adds passangers to the bus
     *
     * @param num
     */
    public void addPeople(int num) {
        System.out.println("Auf der Haltestelle stehen: " + num + " Menschen");
        if (num > (capacity - people)) {
            System.out.println("Alle passen nicht rein!");
            System.out.println("Eingestiegen: " + (capacity - people) + " zurückgeblieben " + (num - (capacity - people)));
            people = capacity;

        } else {
            System.out.println("Alle einsteigen");
            people += num;
        }
    }

    /**
     * Method reduces the numbers of passangers on the bus
     *
     * @param num
     */
    public void subPeople(int num) {
        System.out.println("Aus dem Bus wollen: " + num + " Menschen aussteigen");

        if (num > people) {
            System.out.println("Es gibt im Bus nur " + people + " Menschen.");
        } else {
            System.out.println("Ausgestiegen: " + num + ". Im Bus sind " + (people - num) + " geblieben und es gibt " +
                    (capacity - (people - num)) + " freie Plätze");
            people -= num;
        }
    }

    public int getPeople() {
        return people;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Method set trip
     *
     * @param rt
     * @param dr
     * @return trip
     */
    public Trip doTrip(Route rt, Driver dr) {
        return new Trip(this, rt, dr);
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method adds kmStand
     *
     * @param km
     */
    public void move(int km) {
        kmStand += km;
    }

    public int getKmStand() {
        return kmStand;
    }

    @Override
    public String toString() {
        return "Bus " + number;
    }
}