class Employee {
    private String firstName;
    private String lastName;
    private String pesel;
    private String department;
    private double salary;

    public Employee(String firstName, String lastName, String pesel, String department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

}
