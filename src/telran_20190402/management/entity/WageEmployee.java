package telran_20190402.management.entity;

import telran_20190402.management.stateconstants.StateConstante;

public class WageEmployee extends Employee {
    private double wage; // ставка в час

    public WageEmployee(String firsName, String lastName, double hours, double wage) {
        super(firsName, lastName, hours);
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double calculateSalary() {
        double salary = wage * getHours();
        double minSalary = getHours()* StateConstante.MIN_WAGE;
        if(salary <= minSalary) salary = minSalary;
        //System.out.println("Salary WageEmployee: " + salary + "€ (only hour: "+ wage * getHours() + "€)");
        return salary;
    }

    @Override
    public String toString() {
        return "WageEmployee{" +
                super.toString() +
                "percent=" + wage +
                "} " ;
    }
}