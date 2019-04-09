package telran_20190402.management.controller;

import telran_20190402.management.dao.Company;
import telran_20190402.management.entity.Employee;
import telran_20190402.management.entity.SalesManager;
import telran_20190402.management.entity.WageEmployee;

public class ManagementApp {
    public static void main(String[] args) {

        // new Employees
        SalesManager sm1 = new SalesManager("Max", "Meier", 120, 0.35, 10000);
        WageEmployee wm1 = new WageEmployee("Ira", "Weiss", 150, 3.5);
        WageEmployee wm2 = new WageEmployee("Kat", "Marx", 180, 15.5);
        WageEmployee wm3 = new WageEmployee("Igor", "Keil", 150, 10.5);
        SalesManager sm2 = new SalesManager("Vlad", "Abt", 175,0.25, 50000);
        SalesManager sm3 = new SalesManager("Albert", "Schum", 100,0.3, 25000);

        System.out.println("*************** COMPANY ******************");

        Company cmp = new Company(20);

        cmp.addEmployee(sm1);
        cmp.addEmployee(wm1);
        cmp.addEmployee(sm2);
        cmp.addEmployee(sm3);
        cmp.addEmployee(wm2);
        cmp.addEmployee(wm3);

        System.out.println(cmp.toString());

        for (Employee ee:
             cmp.getEmployees()) {
            if(ee!=null) System.out.println(ee.getFirsName() +" " + ee.getLastName() +": " +ee.calculateSalary());

        }

        System.out.println("*************** COMPANY Salary ******************");
        System.out.println("Summe: " +cmp.sumSalary());

        double minSalary = cmp.minSalary();

        System.out.println("Min salary: " +minSalary);
        System.out.println("Max salary: " +cmp.maxSalary());

        Employee[] emp = cmp.minSalaryLast(3);
        for (Employee ee:
             emp) {
            System.out.println(ee.getLastName() + ": " + ee.calculateSalary());
        }

        System.out.println("********** Promotion ************");
        System.out.println("Before: " + wm2.calculateSalary());
        System.out.println(cmp.promotionEmployee(wm2));
        System.out.println("After: " +wm2.calculateSalary());

        cmp.sortById();
        System.out.println(cmp.toString());

    }
}
