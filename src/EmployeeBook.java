public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int size) {
        employees = new Employee[size];
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    // Очень сложно.
    public void deleteEmployeeByName(String lastName, String firstName, String secondName) {
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i].getLastName().equals(lastName)) && (employees[i].getFirstName().equals(firstName)) &&
                    (employees[i].getSecondName().equals(secondName))) {
                employees[i] = null;
                break;
            }
        }
    }

    public void deleteEmployeeByID(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getId() == id) {
                    employees[i] = null;
                    break;
                }
            }
        }
    }

    public void changeSalary(String lastName, String firstName, String secondName, int newSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if ((employees[i].getLastName().equals(lastName)) && (employees[i].getFirstName().equals(firstName)) &&
                        (employees[i].getSecondName().equals(secondName))) {
                    employees[i].setSalary(newSalary);
                    break;
                }
            }
        }
    }

    public void changeDepartment(String lastName, String firstName, String secondName, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if ((employees[i].getLastName().equals(lastName)) && (employees[i].getFirstName().equals(firstName)) &&
                        (employees[i].getSecondName().equals(secondName))) {
                    employees[i].setDepartment(newDepartment);
                    break;
                }
            }
        }
    }

    public void printByDepartment() {
        int indexDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (indexDepartment < employees[i].getDepartment()) {
                    indexDepartment = employees[i].getDepartment();
                }
            }
        }

        for (int j = 1; j < indexDepartment; j++) {

            System.out.printf("Список сотрудников отдела №%d\n", j);
            for (int k = 0; k < employees.length; k++) {
                if (employees[k] != null) {
                    if (employees[k].getDepartment() == j) {
                        System.out.printf("%s %s %s\n", employees[k].getLastName(), employees[k].getFirstName(), employees[k].getSecondName());
                    }
                }
            }
        }
    }

    public void printEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.printf("ФИО сотрудника - %s %s %s. Отдел - %d. Зарплата - %d рублей." + "Уникальный номер - %d.\n", employees[i].getLastName(), employees[i].getFirstName(), employees[i].getSecondName(), employees[i].getDepartment(), employees[i].getSalary(), employees[i].getId());
            }
        }
    }

    public int calculateSalaryPerMonth() {
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

    public Employee findEmployeeMinSalary() {
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

    public void printEmployeeMinSalary() {
        System.out.printf("Сотрудник %s %s %s получает самую маленькую зарплату в размере" + " %d рублей.\n", findEmployeeMinSalary().getLastName(), findEmployeeMinSalary().getFirstName(), findEmployeeMinSalary().getSecondName(), findEmployeeMinSalary().getSalary());
    }

    public Employee findEmployeeMaxSalary() {
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

    public void printEmployeeMaxSalary() {
        System.out.printf("Сотрудник %s %s %s получает самую большую зарплату в размере" + " %d рублей.\n", findEmployeeMaxSalary().getLastName(), findEmployeeMaxSalary().getFirstName(), findEmployeeMaxSalary().getSecondName(), findEmployeeMaxSalary().getSalary());
    }

    public int calculateMediumSalary() {
        return (calculateSalaryPerMonth() / Employee.countID);           //Можно ли использовать countID в циклах в методах выше?
    }

    public void printNameEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("ФИО сотрудника - %s %s %s.\n", employee.getLastName(), employee.getFirstName(), employee.getSecondName());
            }
        }
    }

    // Индексация зарплаты
    public void calculateIndexSalary(double indexSalary) {
        double newSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                newSalary = employees[i].getSalary() * (1 + (double) (indexSalary / 100));
                employees[i].setSalary((int) newSalary);
            }
        }
    }

    // Получение данных о сотрудниках отдела
    public void infoByDepartment(int department, double indexSalary) {
        int indexEmployeeDepartment = 0;
        Employee[] employeesByDepartment = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                employeesByDepartment[indexEmployeeDepartment++] = employees[i];
            }
        }
        System.out.println("Расходы на зарплату в отделе " + department + " составляют " + calculateSalaryPerMonth(employeesByDepartment) + " рублей.");
        printEmployeeMinSalaryByDepartment(employeesByDepartment);
        printEmployeeMaxSalaryByDepartment(employeesByDepartment);
        System.out.println("Средняя зарплата - " + calculateMediumSalaryByDepartment(employeesByDepartment));
        calculateIndexSalaryByDepartment(employeesByDepartment, indexSalary);
        printNameEmployeesByDepartment(employeesByDepartment);

    }

    public int calculateSalaryPerMonth(Employee[] employees) {
        int salaryPerMonth = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                salaryPerMonth = salaryPerMonth + employees[i].getSalary();
                break;
            }
        }
        return salaryPerMonth;
    }

    public Employee findEmployeeMinSalaryByDepartment(Employee[] employees) {
        int minSalaryIndex = 0;
        int minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    minSalaryIndex = i;
                }
            }
        }
        return employees[minSalaryIndex];
    }

    public void printEmployeeMinSalaryByDepartment(Employee[] employees) {
        System.out.printf("Сотрудник %s %s %s получает самую маленькую зарплату в размере" + " %d рублей.\n", findEmployeeMinSalaryByDepartment(employees).getLastName(), findEmployeeMinSalaryByDepartment(employees).getFirstName(), findEmployeeMinSalaryByDepartment(employees).getSecondName(), findEmployeeMinSalaryByDepartment(employees).getSalary());
    }

    public Employee findEmployeeMaxSalary(Employee[] employees) {
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

    public void printEmployeeMaxSalaryByDepartment(Employee[] employees) {
        System.out.printf("Сотрудник %s %s %s получает самую большую зарплату в размере" + " %d рублей.\n", findEmployeeMaxSalary(employees).getLastName(), findEmployeeMaxSalary(employees).getFirstName(), findEmployeeMaxSalary(employees).getSecondName(), findEmployeeMaxSalary(employees).getSalary());
    }

    public int calculateMediumSalaryByDepartment(Employee[] employees) {
        int count = 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count++;
            }
        }
        return (calculateSalaryPerMonth(employees) / count);
    }

    public void calculateIndexSalaryByDepartment(Employee[] employees, double indexSalaryForDepartment) {
        double newSalaryByDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                newSalaryByDepartment = employees[i].getSalary() * indexSalaryForDepartment;
                employees[i].setSalary((int) newSalaryByDepartment);
            }
        }
    }

    public void printNameEmployeesByDepartment(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.printf("ФИО сотрудника - %s %s %s. Зарплата - %d. Уникальный номер - %d\n", employee.getLastName(), employee.getFirstName(), employee.getSecondName(), employee.getSalary(), employee.getId());
            }
        }
    }

    public void separationEmployeesBySalary(int findSalary) {
        getEmployeesWithLowSalary(findSalary);
        System.out.println();
        getEmployeesWithHighSalary(findSalary);
    }

    public void getEmployeesWithLowSalary(int findSalary) {
        Employee[] employeesWithLowSalary = new Employee[10];
        int indexLowSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < findSalary) {
                employeesWithLowSalary[indexLowSalary++] = employees[i];
            }
        }

        System.out.println("Список сотрудников с зарплатой меньше " + findSalary + " рублей.");
        for (int i = 0; i < employeesWithLowSalary.length; i++) {
            if (employeesWithLowSalary[i] != null) {
                System.out.printf("%s %s %s с зарплатой %d. ID - %d\n", employeesWithLowSalary[i].getLastName(), employeesWithLowSalary[i].getFirstName(), employeesWithLowSalary[i].getSecondName(), employeesWithLowSalary[i].getSalary(), employeesWithLowSalary[i].getId());
            }
        }
    }

    public void getEmployeesWithHighSalary(int findSalary) {
        Employee[] employeesWithHighSalary = new Employee[10];
        int indexHighSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= findSalary) {
                employeesWithHighSalary[indexHighSalary++] = employees[i];
            }
        }

        System.out.println("Список сотрудников с зарплатой больше " + findSalary + " рублей.");
        for (int i = 0; i < employeesWithHighSalary.length; i++) {
            if (employeesWithHighSalary[i] != null) {
                System.out.printf("%s %s %s с зарплатой %d. ID - %d\n", employeesWithHighSalary[i].getLastName(), employeesWithHighSalary[i].getFirstName(), employeesWithHighSalary[i].getSecondName(), employeesWithHighSalary[i].getSalary(), employeesWithHighSalary[i].getId());
            }
        }
    }
}
