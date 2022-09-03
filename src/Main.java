public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        addEmployeeToEmployees(new Employee("Иванов", "Иван", "Иванович", 1, 45000));
        addEmployeeToEmployees(new Employee("Петров", "Петр", "Петрович", 2, 35000));
        addEmployeeToEmployees(new Employee("Павлов", "Павел", "Павлович", 3, 85000));
        addEmployeeToEmployees(new Employee("Сергеев", "Сергей", "Сергеевич", 4, 25000));
        addEmployeeToEmployees(new Employee("Антонова", "Антонина", "Антоновна", 5, 25000));
        addEmployeeToEmployees(new Employee("Маринова", "Марина", "Викторовна", 5, 55000));

        printEmployees();
        System.out.println("Расходы на зарплату в месяц - " + calculateSalaryPerMonth());
        printEmployeeMinSalary();
        printEmployeeMaxSalary();
        System.out.println(calculateMediumSalary());
        printNameEmployees();

    }

    public static void addEmployeeToEmployees(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }


    public static void printEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.printf("ФИО сотрудника - %s %s %s. Отдел - %d. Зарплата - %d рублей." +
                                "Уникальный номер - %d.\n", employees[i].getLastName(), employees[i].getFirstName(),
                        employees[i].getSecondName(), employees[i].getDepartment(), employees[i].getSalary(),
                        employees[i].getId());
            }
        }
    }

    public static int calculateSalaryPerMonth() {
        int salaryPerMonth = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                salaryPerMonth = salaryPerMonth + employees[i].getSalary();
            } else if (employees[i] == null) {
                return salaryPerMonth;
            }
        }
        return salaryPerMonth;
    }

    public static Employee findEmployeeMinSalary() {
        int countMinSalary = 0;
        int minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    countMinSalary = i;
                }
            }
        }
        return employees[countMinSalary];
    }

    public static void printEmployeeMinSalary() {
        System.out.printf("Сотрудник %s %s %s получает самую маленькую зарплату в размере" +
                        " %d рублей.\n", findEmployeeMinSalary().getLastName(), findEmployeeMinSalary().getFirstName(),
                findEmployeeMinSalary().getSecondName(), findEmployeeMinSalary().getSalary());
    }

    public static Employee findEmployeeMaxSalary() {
        int countMaxSalary = 0;
        int maxSalary = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    countMaxSalary = i;
                }
            }
        }
        return employees[countMaxSalary];
    }

    public static void printEmployeeMaxSalary() {
        System.out.printf("Сотрудник %s %s %s получает самую маленькую зарплату в размере" +
                        " %d рублей.\n", findEmployeeMaxSalary().getLastName(), findEmployeeMaxSalary().getFirstName(),
                findEmployeeMaxSalary().getSecondName(), findEmployeeMaxSalary().getSalary());
    }

    public static int calculateMediumSalary() {
        int salaryPerMonth = calculateSalaryPerMonth();
        return salaryPerMonth / Employee.countID;           //Можно ли использовать countID в циклах в методах выше?
    }

    public static void printNameEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("ФИО сотрудника - %s %s %s.\n", employee.getLastName(),
                        employee.getFirstName(), employee.getSecondName());
            }
        }
    }
}