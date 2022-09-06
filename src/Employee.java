public class Employee {
    private String lastName = "";
    private String firstName = "";
    private String secondName = "";
    private int department = 0;
    private int salary = 0;

    static int countID = 0;
    private int id = countID++;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public static int getCountID() {
        return countID;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String lastName, String firstName, String secondName, int department, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
        this.id = countID;
    }

}
