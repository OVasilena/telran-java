package telran_20190402.management.entity;

import telran_20190402.management.stateconstants.StateConstante;

public class SalesManager extends Employee {
    private double salesValue;
    private double percent;

    public SalesManager(String firsName, String lastName, double hours, double percent, double value) {
        super(firsName, lastName, hours);
        this.percent = percent;
        this.salesValue = value;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    @Override
    public double calculateSalary() {
        double salary = salesValue * percent;
        if(salary <= StateConstante.MIN_WAGE * getHours()) {
            salary = StateConstante.MIN_WAGE * getHours();
        }
        //System.out.println("Salary WageEmployee: " + salary + "€ (only percent: "+ salesValue * percent + "€)");
        return salary;
    }

    @Override
    public String toString() {
        return "SalesManager{" +
                super.toString() +
                "salesValue=" + salesValue +
                ", percent=" + percent +
                "} ";
    }
}
