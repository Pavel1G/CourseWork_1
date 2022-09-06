import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) throws IOException {
        var employeeBook = new EmployeeBook(10);
        employeeBook.addEmployee(new Employee("Иванов", "Иван", "Иванович", 1, 45000));
        employeeBook.addEmployee(new Employee("Иванов1", "Иван1", "Иванович1", 1, 55000));
        employeeBook.addEmployee(new Employee("Петров", "Петр", "Петрович", 2, 35000));
        employeeBook.addEmployee(new Employee("Петров1", "Петр1", "Петрович1", 2, 25000));
        employeeBook.addEmployee(new Employee("Павлов", "Павел", "Павлович", 3, 85000));
        employeeBook.addEmployee(new Employee("Павлов1", "Павел1", "Павлович1", 3, 95000));
        employeeBook.addEmployee(new Employee("Павлов2", "Павел2", "Павлович2", 3, 65000));
        employeeBook.addEmployee(new Employee("Сергеев", "Сергей", "Сергеевич", 4, 25000));
        employeeBook.addEmployee(new Employee("Антонова", "Антонина", "Антоновна", 5, 25000));
        employeeBook.addEmployee(new Employee("Маринова", "Марина", "Викторовна", 5, 55000));

//        Базовая сложность. (Как правильно выводить на печать - в main'e делать sout или же в методах?)
        employeeBook.printEmployees();
        System.out.println("Расходы на зарплату в месяц - " + employeeBook.calculateSalaryPerMonth());
        employeeBook.printEmployeeMinSalary();
        employeeBook.printEmployeeMaxSalary();
        System.out.println("Средняя зарплата - " + employeeBook.calculateMediumSalary());
        employeeBook.printNameEmployees();

//      Повышенная сложность.

        System.out.println();
        System.out.println("-------------- Задачи повышенной сложности --------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("На сколько % повысить зарплату? ");
        int indexSalary = Integer.parseInt(reader.readLine());
        employeeBook.calculateIndexSalary(indexSalary * 1.0 / 100);

        System.out.print("Выберите отдел (от 1 до 5) для получения данных о сотрудниках отдела: ");
        int department = Integer.parseInt(reader.readLine());
        employeeBook.infoByDepartment(department, indexSalary);

        System.out.println("Градация сотрудников относительно заданной зарплаты. Введите зарплату: ");
        int findSalary = Integer.parseInt(reader.readLine());
        employeeBook.separationEmployeesBySalary(findSalary);

//      Очень сложно.
        // Как избавить от проверок объектов массива EmployeeBook на null?
        System.out.println();
        System.out.println("-------------- Задачи 'очень сложно' --------------");

        employeeBook.deleteEmployeeByName("Павлов2", "Павел2", "Павлович2");
        employeeBook.deleteEmployeeByID(2);

        employeeBook.changeSalary("Маринова", "Марина", "Викторовна", 100000);
        employeeBook.changeDepartment("Маринова", "Марина", "Викторовна", 3);

        employeeBook.printByDepartment();
    }


}
