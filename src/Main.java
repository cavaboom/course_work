import java.util.Arrays;

public class Main {
   private static Employee[] employees = new Employee[10];
   public static void main(String[] args) {
      employees[0] = new Employee("Иванов", "Петр", "Сидорович", 1, 10000);
      employees[1] = new Employee("Петрович", "Иван", "Александрович", 1, 12000);
      employees[2] = new Employee("Сидоров", "Максим", "Сергеевич", 2, 15000);
      employees[3] = new Employee("Смирнов", "Александр", "Петрович", 2, 13000);
      employees[4] = new Employee("Кузнецов", "Алексей", "Иванович", 3, 14000);
      employees[5] = new Employee("Попов", "Алексей", "Иванович", 3, 14000);
      employees[6] = new Employee("Соколов", "Михаил", "Иванович", 4, 13000);
      employees[7] = new Employee("Васильев", "Алексей", "Иванович", 4, 16000);
      employees[8] = new Employee("Михайлов", "Алексей", "Иванович", 5, 14000);
      employees[9] = new Employee("Рябов", "Алексей", "Иванович", 5, 9000);

      printAllEmployee();
      System.out.println("Сумма затрат на зарплаты в месяц: " + sumExpenses());
      System.out.println("Минимальная зарплата " + minSalary());
      System.out.println("Максимальная зарплата " + maxSalary());
      System.out.println("Cреднее значение зарплат " + avgSalary());
      System.out.println();
      System.out.println("Список сотрудников после индексации");
      double percent = 10;
      indexSalary(percent);
      printAllEmployee();
      int department = 1;
      System.out.println("Минимальная зарплата в отделе " + department + " " + minSalaryInDepartment(department));
      System.out.println("Максимальная зарплата в отделе " + department + " " + maxSalaryInDepartment(department));
      System.out.println("Сумма затрат на зарплаты в отделе " + department + " " + sumExpensesInDepartment(department));
      System.out.println("Cреднее значение зарплат в отделе " + department + " " + avgSalaryInDepartment(department));
      System.out.println();
      System.out.println("Список сотрудников в отделе " + department + " после индексации");
      indexSalaryInDepartment(department, percent);
      printAllEmployeeInDepartment(department);
      System.out.println();
      double number = 13000;
      System.out.println("Сотрудники с зарплатой меньше " + number);
      salaryLessThen(number);
      System.out.println();
      System.out.println("Сотрудники с зарплатой больше или равно " + number);
      salaryMoreThen(number);
  }

  // Сумма затрат на зарплаты
   public static double sumExpenses(){
      double expenses = 0;
      for (var employee : employees){
         expenses += employee.getSalary();
      }
      return expenses;
   }

   // Минимальная зарплата
   public static double minSalary(){
      double min = employees[0].getSalary();
      for (var employee : employees){
         if (min > employee.getSalary()) {
            min = employee.getSalary();
         }
      }
      return min;
   }

   // Максимальная зарплата
   public static double maxSalary(){
      double max = employees[0].getSalary();
      for (var employee : employees){
         if (max < employee.getSalary()) {
            max = employee.getSalary();
         }
      }
      return max;
   }

   // Средняя зарплата
   public static double avgSalary(){
      double avg = 0;
      avg = sumExpenses()/employees.length;
      return avg;
   }

   // Вывод всех сотрудников со всеми данными
    public static void printAllEmployee() {
        for (var employee : employees) {
            System.out.println(employee);
        }
    }

   // Индексация зарплаты
    public static void indexSalary(double percent) {
       for (var employee : employees) {
           employee.setSalary(employee.getSalary() + (employee.getSalary() * percent / 100));
       }
    }

    // Поиск сотрудника с минимальной зарплатой по отделам
    public static double minSalaryInDepartment(int department) {
       double min = employees[0].getSalary();
       for (var employee : employees) {
           if (employee.getDepartment() == department) {
               if (min > employee.getSalary()) {
                   min = employee.getSalary();
               }
           }
       }
       return min;
    }

    // Поиск сотрудника с максимальной зарплатой по отделам
    public static double maxSalaryInDepartment(int department) {
        double max = employees[0].getSalary();
        for (var employee : employees) {
            if (employee.getDepartment() == department) {
                if (max < employee.getSalary()) {
                    max = employee.getSalary();
                }
            }
        }
        return max;
    }

    // Сумма затрат на зарплаты в отделе
    public static double sumExpensesInDepartment(int department){
        double expenses = 0;
        for (var employee : employees){
            if (employee.getDepartment() == department) {
                expenses += employee.getSalary();
            }
        }
        return expenses;
    }

    // Количество работников в отделе
    public static int employeesInDepartment(int department) {
       int countEmployee = 0;
       for (var employee : employees) {
           if (employee.getDepartment() == department) {
               countEmployee++;
           }
       }
       return countEmployee;
    }

    // Средняя зарплата в отделе
    public static double avgSalaryInDepartment(int department){
        double avg = 0;
        avg = sumExpensesInDepartment(department)/employeesInDepartment(department);
        return avg;
    }

    // Индексация зарплат в отделе
    public static void indexSalaryInDepartment(int department, double percent) {
        for (var employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + (employee.getSalary() * percent / 100));
            }
        }
    }

    // Все сотрудники в отделе
    public static void printAllEmployeeInDepartment(int department) {
        for (var employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPatronymic() + " " + employee.getSalary());
            }
        }
    }

    // Сотрудники с зарплатой меньше
    public static void salaryLessThen(double number) {
        for (var employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPatronymic() + " " + employee.getSalary());
            }
        }
    }

    // Сотрудники с зарплатой больше или равно
    public static void salaryMoreThen(double number) {
        for (var employee : employees) {
            if (employee.getSalary() >= number) {
                System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getPatronymic() + " " + employee.getSalary());
            }
        }
    }
}