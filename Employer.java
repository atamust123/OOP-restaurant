
public class Employer {
    private String name;
    private double salary;
    private int allowedMaxTables;

    public Employer(String name, double salary, int allowedMaxTables) {
        this.name = name;
        this.salary = salary;
        this.allowedMaxTables = allowedMaxTables;
    }
    

    public int getAllowedMaxTables() {
        return allowedMaxTables;
    }

    public void setAllowedMaxTables(int allowedMaxTables) {
        this.allowedMaxTables = allowedMaxTables;
    }  
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return  salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
    
    
    
    
}
