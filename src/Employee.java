public class Employee {
    private String lastName;
    private String firstName;
    private String patronymic;
    private int department;
    private double salary;
    /*private final long id = count;
    private static long count = 1L;*/
    private static int count;
    private final int id;

    public Employee(String lastName, String firstName, String patronymic, int department, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        count++;
        this.id = getIdCount();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    private int getIdCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return id + " " + lastName + " " + firstName + " " + patronymic + " " + department + " " + salary + "\n";
    }

}
