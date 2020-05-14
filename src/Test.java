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

        Employee[] employees = new Employee[4];
        int linesCount = 0;

        try (
                FileWriter fileWriter = new FileWriter(statisticsFileName);
                Scanner scanner = new Scanner(file)
        ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.stripLeading().split(";");
                double salary = Double.parseDouble(elements[4]);
                employees[linesCount] = new Employee(elements[0], elements[1], elements[2], elements[3], salary);
                linesCount++;
            }

            String avgSalaryInfo = "średnia pensja: " + Statistics.avgSalary(employees);
            String employeesNumberInfo = "Liczba pracowników: " + Statistics.employeesNumber(employees);
            String employeesNumberInIt = "Liczba pracowników w IT: " + Statistics.employeesNumberInThisDepartment(employees, "it");
            String employeesNumberInSupport = "Liczba pracowników w Support: " + Statistics.employeesNumberInThisDepartment(employees, "Support");
            String employeesNumberInManagement = "Liczba pracowników w Management: " + Statistics.employeesNumberInThisDepartment(employees, "Management");

            System.out.println(avgSalaryInfo + "\n" + employeesNumberInfo + "\n" + employeesNumberInIt + "\n" + employeesNumberInSupport +
                    "\n" + employeesNumberInManagement);
            fileWriter.write(avgSalaryInfo + "\n" + employeesNumberInfo + "\n" + employeesNumberInIt + "\n" + employeesNumberInSupport +
                    "\n" + employeesNumberInManagement);

        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
