abstract class Statistics {
    static double avgSalary(Employee[] employees) {
        double sumSalary = 0;
        int employeesNumber = employees.length;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return sumSalary / employeesNumber;
    }

    static int employeesNumber(Employee[] employees) {
        return employees.length;
    }

    static int employeesNumberInThisDepartment(Employee[] employees, String departmentName) {
        int counter = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(departmentName)) {
                counter++;
            }
        }
        return counter;
    }
}
