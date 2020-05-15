import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        String fileName = "pracownicy.txt";
        String statisticsFileName = "pracownicy_statystka.txt";
        File file = new File(fileName);
        int linesCount = 0;


        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                linesCount++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        }

        Employee[] employees = new Employee[linesCount];
        int employeeIndex = 0;

        try (
                FileWriter fileWriter = new FileWriter(statisticsFileName);
                Scanner scanner = new Scanner(file)
        ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.stripLeading().split(";");
                double salary = Double.parseDouble(elements[4]);
                employees[employeeIndex] = new Employee(elements[0], elements[1], elements[2], elements[3], salary);
                employeeIndex++;
            }

            String lowestSalary = "Najmniejsza wypłata: " + Statistics.lowestSalary(employees);
            String highestSalary = "Największa wypłata: " + Statistics.highestSalary(employees);
            String avgSalaryInfo = "średnia pensja: " + Statistics.avgSalary(employees);
            String employeesNumberInfo = "Liczba pracowników: " + Statistics.employeesNumber(employees);
            String employeesNumberInIt = "Liczba pracowników w IT: " + Statistics.employeesNumberInThisDepartment(employees, "it");
            String employeesNumberInSupport = "Liczba pracowników w Support: " + Statistics.employeesNumberInThisDepartment(employees, "Support");
            String employeesNumberInManagement = "Liczba pracowników w Management: " + Statistics.employeesNumberInThisDepartment(employees, "Management");

            System.out.println(lowestSalary + "\n" + highestSalary + "\n" + avgSalaryInfo + "\n" + employeesNumberInfo +
                    "\n" + employeesNumberInIt + "\n" + employeesNumberInSupport + "\n" + employeesNumberInManagement);
            fileWriter.write(lowestSalary + "\n" + highestSalary + "\n" + avgSalaryInfo + "\n" + employeesNumberInfo +
                    "\n" + employeesNumberInIt + "\n" + employeesNumberInSupport + "\n" + employeesNumberInManagement);

        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
