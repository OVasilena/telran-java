package telran_20190402.management.dao;

import telran_20190402.management.entity.Employee;
import telran_20190402.management.entity.SalesManager;
import telran_20190402.management.entity.WageEmployee;
import webinar.bus.driver.programmer_20190318.Employe;

import java.util.Arrays;

/**
 * class Company
 */
public class Company {
    private Employee[] employees;
    private int currentSize;

    /**
     * Constructor
     * @param size int
     */
    public Company(int size) {
        employees = new Employee[size];
        this.currentSize = 0;
    }

    /**
     * getEmployees
     * @return employees[]
     */
    public Employee[] getEmployees() {
        return employees;
    }

    /**
     * addEmployee
     * @param emp Employee
     * @return boolean
     */
    public boolean addEmployee(Employee emp) {
        if(currentSize < employees.length) {
            employees[currentSize]=emp;
            currentSize ++;
            return true;
        }
        return false;
    }

    /**
     * removeEmployee
     * @param emp Employee
     * @return boolean
     */
    public boolean removeEmployee(Employee emp) {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].equals(emp)) {
                employees[i] = employees[currentSize-1];
                currentSize --;
                return true;
            }
        }
        return false;
    }

    /**
     * removeEmployee
     * @param id int
     * @return boolean
     */
    public boolean removeEmployee(int id) {
        if(id <= currentSize) {
            employees[id] = employees[currentSize-1];
            currentSize--;
            return true;
        }
        return false;
    }

    /**
     * removeEmployee
     * @param name String
     * @return boolean
     */
    public boolean removeEmployee(String name) {
        for(int i = 0; i < currentSize; i++) {
            if(employees[i].getLastName().equals(name)) {
                employees[i] = employees[currentSize-1];
                currentSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * removeEmployee
     * @param firstName String
     * @param lastName String
     * @return boolean
     */
    public boolean removeEmployee(String firstName, String lastName) {
        for(int i = 0; i < currentSize; i++) {
            if(employees[i].getFirsName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                employees[i] = employees[currentSize-1];
                currentSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * Method return one Employee with min salary from company
     * @return Employee
     */
    public Employee minSalaryEmployee() {
        sortByMinSalary();

        return employees[0];
    }

    /**
     * Method return min salary
     * @return double
     */
    public double minSalary() {
        sortByMinSalary();

        return employees[0].calculateSalary();
    }

    // return 5 employee with min salary

    /**
     * Method return number salary from company with min salary
     * @param value int
     * @return Employee[]
     */
    public Employee[] minSalaryLast(int value) {
        sortByMinSalary();
        Employee[] emp = new Employee[value];
        for (int i = 0; i < value; i++) {
            emp[i] = employees[i];
        }
        return emp;
    }

    /**
     * Method return employee with max salary from company
     * @return Employee
     */
    public Employee maxSalaryEmployee() {
        sortByMaxSalary();

        return employees[0];
    }

    /**
     * Method return max salary
     * @return double
     */
    public double maxSalary() {
        sortByMaxSalary();

        return employees[0].calculateSalary();
    }

    /**
     * Method return total samary
     * @return double
     */
    public double sumSalary() {
        double summe = 0;
        for (int i = 0; i < currentSize; i++) {
            summe += employees[i].calculateSalary();
        }
        return summe;
    }

    /**
     * Method to promotion wage employee to sales
     * @param empl Employee
     * @return boolean
     */
    public boolean promotionEmployee(Employee empl) {
        for(int i= 0; i < currentSize; i++) {
            if(empl.equals(employees[i]) && empl instanceof WageEmployee) {
                WageEmployee we = (WageEmployee) empl;
                SalesManager se = new SalesManager(we.getFirsName(), we.getLastName(), we.getHours(), 0.7, we.getWage());
                employees[i] = se;
                return true;
            }
        }
        return false;
    }

    /**
     * sort by min
     */
    private void sortByMinSalary() {
        for(int i = 0; i < currentSize-1; i++)
        {
            for(int j = 0; j < currentSize-1; j++) {
                if(employees[j].calculateSalary()>employees[j+1].calculateSalary()) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j+1];
                    employees[j+1] = tmp;
                }
            }
        }
    }

    /**
     * sort by max
     */
    private void sortByMaxSalary() {
        for(int i = 0; i < currentSize-1; i++)
        {
            for(int j = 0; j < currentSize-1; j++) {
                if(employees[j].calculateSalary()<employees[j+1].calculateSalary()) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j+1];
                    employees[j+1] = tmp;
                }
            }
        }
    }

    /**
     * sort by id
     */
    public void sortById() {
        for(int i = 0; i < currentSize-1; i++) {
            for (int j = 0; j < currentSize - 1; j++) {
                if(employees[j].getId() > employees [j+1].getId()) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j+1];
                    employees[j+1] = tmp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + Arrays.toString(employees) +
                ", currentSize=" + currentSize +
                '}';
    }
}
