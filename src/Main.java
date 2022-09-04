import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) throws IOException {
        addEmployeeToEmployees(new Employee("Иванов", "Иван", "Иванович", 1, 45000));
        addEmployeeToEmployees(new Employee("Иванов1", "Иван1", "Иванович1", 1, 55000));
        addEmployeeToEmployees(new Employee("Петров", "Петр", "Петрович", 2, 35000));
        addEmployeeToEmployees(new Employee("Петров1", "Петр1", "Петрович1", 2, 25000));
        addEmployeeToEmployees(new Employee("Павлов", "Павел", "Павлович", 3, 85000));
        addEmployeeToEmployees(new Employee("Павлов1", "Павел1", "Павлович1", 3, 95000));
        addEmployeeToEmployees(new Employee("Павлов2", "Павел2", "Павлович2", 3, 65000));
        addEmployeeToEmployees(new Employee("Сергеев", "Сергей", "Сергеевич", 4, 25000));
        addEmployeeToEmployees(new Employee("Антонова", "Антонина", "Антоновна", 5, 25000));
        addEmployeeToEmployees(new Employee("Маринова", "Марина", "Викторовна", 5, 55000));

//        Базовая сложность. (Как правильно выводить на печать - в main'e делать sout или же в методах?)
        printEmployees();
        System.out.println("Расходы на зарплату в месяц - " + calculateSalaryPerMonth());
        printEmployeeMinSalary();
        printEmployeeMaxSalary();
        System.out.println("Средняя зарплата - " + calculateMediumSalary());
        printNameEmployees();

//        Повышенная сложность.

        System.out.println();
        System.out.println("-------------- Задачи повышенной сложности --------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("На сколько % повысить зарплату? ");
        int indexSalary = Integer.parseInt(reader.readLine());
        calculateIndexSalary(indexSalary * 1.0 / 100);

        System.out.print("Выберите отдел (от 1 до 5) для получения данных о сотрудниках отдела: ");
        int department = Integer.parseInt(reader.readLine());
        infoByDepartment(department, indexSalary);

        System.out.println("Градация сотрудников относительно заданной зарплаты. Введите зарплату: ");
        int findSalary = Integer.parseInt(reader.readLine());
        findEmployeeBySalary(findSalary);
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
        System.out.printf("Сотрудник %s %s %s получает самую большую зарплату в размере" +
                        " %d рублей.\n", findEmployeeMaxSalary().getLastName(),
                findEmployeeMaxSalary().getFirstName(),
                findEmployeeMaxSalary().getSecondName(),
                findEmployeeMaxSalary().getSalary());
    }

    public static int calculateMediumSalary() {
        return (calculateSalaryPerMonth() / Employee.countID);           //Можно ли использовать countID в циклах в методах выше?
    }

    public static void printNameEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("ФИО сотрудника - %s %s %s.\n", employee.getLastName(),
                        employee.getFirstName(), employee.getSecondName());
            }
        }
    }

    // Индексация зарплаты
    public static void calculateIndexSalary(double indexSalary) {
        double newSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                newSalary = employees[i].getSalary() * (1 + (double) (indexSalary / 100));
                employees[i].setSalary((int) newSalary);
            }
        }
    }

    // Получение данных о сотрудниках отдела
    public static void infoByDepartment(int department, double indexSalary) {
        int indexEmployeeDepartment = 0;
        Employee[] employeesByDepartment = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                employeesByDepartment[indexEmployeeDepartment++] = employees[i];
            }
        }
        System.out.println("Расходы на зарплату в отделе " + department +
                " составляют " + calculateSalaryPerMonth(employeesByDepartment) + " рублей.");
        printEmployeeMinSalaryByDepartment(employeesByDepartment);
        printEmployeeMaxSalaryByDepartment(employeesByDepartment);
        System.out.println("Средняя зарплата - " + calculateMediumSalaryByDepartment(employeesByDepartment));
        calculateIndexSalaryByDepartment(employeesByDepartment, indexSalary);
        printNameEmployeesByDepartment(employeesByDepartment);

    }

    public static int calculateSalaryPerMonth(Employee[] employees) {
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

    public static Employee findEmployeeMinSalaryByDepartment(Employee[] employees) {
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

    public static void printEmployeeMinSalaryByDepartment(Employee[] employees) {
        System.out.printf("Сотрудник %s %s %s получает самую маленькую зарплату в размере" +
                        " %d рублей.\n", findEmployeeMinSalaryByDepartment(employees).getLastName(),
                findEmployeeMinSalaryByDepartment(employees).getFirstName(),
                findEmployeeMinSalaryByDepartment(employees).getSecondName(),
                findEmployeeMinSalaryByDepartment(employees).getSalary());
    }

    public static Employee findEmployeeMaxSalary(Employee[] employees) {
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

    public static void printEmployeeMaxSalaryByDepartment(Employee[] employees) {
        System.out.printf("Сотрудник %s %s %s получает самую большую зарплату в размере" +
                        " %d рублей.\n", findEmployeeMaxSalary(employees).getLastName(),
                findEmployeeMaxSalary(employees).getFirstName(),
                findEmployeeMaxSalary(employees).getSecondName(),
                findEmployeeMaxSalary(employees).getSalary());
    }

    public static int calculateMediumSalaryByDepartment(Employee[] employees) {
        int count = 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count++;
            }
        }
        return (calculateSalaryPerMonth(employees) / count);
    }

    public static void calculateIndexSalaryByDepartment(Employee[] employees, double indexSalaryForDepartment) {
        double newSalaryByDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                newSalaryByDepartment = employees[i].getSalary() * indexSalaryForDepartment;
                employees[i].setSalary((int) newSalaryByDepartment);
            }
        }
    }

    public static void printNameEmployeesByDepartment(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("ФИО сотрудника - %s %s %s. Зарплата - %d. Уникальный номер - %d\n",
                        employee.getLastName(), employee.getFirstName(),
                        employee.getSecondName(), employee.getSalary(), employee.getId());
            }
        }
    }

    public static void findEmployeeBySalary(int findSalary) {
        Employee[] employeesWithHighSalary = new Employee[10];
        int indexHighSalary = 0;
        Employee[] employeesWithLowSalary = new Employee[10];
        int indexLowSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < findSalary) {
                employeesWithLowSalary[indexLowSalary++] = employees[i];
            } else if (employees[i].getSalary() >= findSalary) {
                employeesWithHighSalary[indexHighSalary++] = employees[i];
            }
        }

        System.out.println("Список сотрудников с зарплатой меньше " + findSalary + " рублей.");
        for (int i = 0; i < employeesWithLowSalary.length; i++) {
            if (employeesWithLowSalary[i] != null) {
                System.out.printf("%s %s %s с зарплатой %d. ID - %d\n", employeesWithLowSalary[i].getLastName(),
                        employeesWithLowSalary[i].getFirstName(), employeesWithLowSalary[i].getSecondName(),
                        employeesWithLowSalary[i].getSalary(), employeesWithLowSalary[i].getId());
            }
        }

        System.out.println();

        System.out.println("Список сотрудников с зарплатой больше " + findSalary + " рублей.");
        for (int i = 0; i < employeesWithHighSalary.length; i++) {
            if (employeesWithHighSalary[i] != null) {
                System.out.printf("%s %s %s с зарплатой %d. ID - %d\n", employeesWithHighSalary[i].getLastName(),
                        employeesWithHighSalary[i].getFirstName(), employeesWithHighSalary[i].getSecondName(),
                        employeesWithHighSalary[i].getSalary(), employeesWithHighSalary[i].getId());
            }
        }
    }
}
