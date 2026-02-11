import java.util.Scanner;

class Person {
    String name, gender, address;
    int age;

    Person(String n, String g, String addr, int a) {
        name = n; gender = g; address = addr; age = a;
    }

    void display() {
        System.out.print("Name: " + name + " | Age: " + age + " | Gender: " + gender + " | Addr: " + address);
    }
}

class Employee extends Person {
    int empId;
    String company, qualification;
    double salary;

    Employee(String n, String g, String addr, int a, int id, String comp, String qual, double sal) {
        super(n, g, addr, a);
        empId = id; company = comp; qualification = qual; salary = sal;
    }

    void display() {
        super.display();
        System.out.print(" | ID: " + empId + " | Qual: " + qualification + " | Salary: " + salary);
    }
}

class Teacher extends Employee {
    String subject, department;

    Teacher(String n, String g, String addr, int a, int id, String comp, String qual, double sal, String sub, String dept) {
        super(n, g, addr, a, id, comp, qual, sal);
        subject = sub; department = dept;
    }

    @Override
    void display() {
        super.display();
        System.out.println(" | Subject: " + subject + " | Dept: " + department);
    }
}

public class Persons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of teachers: ");
        int N = sc.nextInt();
        Teacher[] t = new Teacher[N];

        for (int i = 0; i < N; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1) + ":");
            t[i] = new Teacher("Name"+i, "M/F", "City", 30+i, 100+i, "School", "PhD", 50000, "Math", "Science");
        }

        System.out.println("\n--- Teacher Details ---");
        for (Teacher teacher : t) teacher.display();
    }
}