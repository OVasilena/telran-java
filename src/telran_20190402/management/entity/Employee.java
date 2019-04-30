package telran_20190402.management.entity;

public abstract class Employee {
    private static int counter = 100;
    private int id;
    private String firsName;
    private String lastName;
    private double hours;

    public Employee(String firsName, String lastName, double hours) {
        this.id = ++counter;
        this.firsName = firsName;
        this.lastName = lastName;
        this.hours = hours;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hours=" + hours +
                '}';
    }
}
