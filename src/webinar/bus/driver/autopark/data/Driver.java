package webinar.bus.driver.autopark.data;

/**
 * class Driver
 */
public class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Driver:" + name;
    }
}
