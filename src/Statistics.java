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

    static double highestSalary(Employee[] employees) {
        double maxSalary = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    static double lowestSalary(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }
}
