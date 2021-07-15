
public class Waiter {

    private String name;
    private double Salary;
    private int MAX_TABLE_SERVICES;
    private int totalOrder;

    public Waiter(String name, double Salary, int MAX_TABLE_SERVICES) {
        this.name = name;
        this.Salary = Salary;
        this.MAX_TABLE_SERVICES = MAX_TABLE_SERVICES;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public int getMAX_TABLE_SERVICES() {
        return MAX_TABLE_SERVICES;
    }

    public void setMAX_TABLE_SERVICES(int MAX_TABLE_SERVICES) {
        this.MAX_TABLE_SERVICES = MAX_TABLE_SERVICES;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

}
