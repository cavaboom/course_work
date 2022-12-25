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

      printAllEmployee(employees);
      System.out.println("Сумма затрат на зарплаты в месяц: " + sumExpenses());
      System.out.println("Минимальная зарплата " + minSalary());
      System.out.println("Максимальная зарплата " + maxSalary());
      System.out.println("Cреднее значение зарплат " + avgSalary());
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
   public static void printAllEmployee(Employee[] employees) {
      for (int i = 0; i < employees.length; i++) {
         System.out.println(employees[i]);
      }
   }
}