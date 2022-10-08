package br.com.edu.ufca;

public class Seller {
    public String name;

    private int salesN = 0;
    private double commission = 0.15;
    private double baseSalary = 0d;
    private double salary = baseSalary;

    private void updateSalary() {
        this.salary = baseSalary + baseSalary * commission * salesN;
    }

    public Seller(String name) {
        this.name = name;
    }

    public void setSalesN(int salesN) {
        this.salesN = salesN;
        updateSalary();
    }

    public int getSalesN() {
        return salesN;
    }

    public void setSalary(double salary) {
        baseSalary = salary;
        updateSalary();
    }

    public double getSalary() {
        return salary;
    }

    public void setCommission(double commission) {
        this.commission = commission;
        updateSalary();
    }

    public double getCommission() {
        return commission;
    }
}
