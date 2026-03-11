import java.util.*;


interface Showable {
    void show();
}


class Person {
    String name;
    String gender;
    String phoneNo;

    Person(String name, String gender, String phoneNo) {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }
}


class Student extends Person {
    String course;
    double score;

    Student(String name, String gender, String phoneNo,
            String course, double score) {
        super(name, gender, phoneNo);
        this.course = course;
        this.score = score;
    }
}


class PGStudent extends Student implements Showable {

    String researchArea;
    String guide;

    PGStudent(String name, String gender, String phoneNo,
              String course, double score,
              String researchArea, String guide) {

        super(name, gender, phoneNo, course, score);
        this.researchArea = researchArea;
        this.guide = guide;
    }

    public void show() {
        System.out.println("--------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phoneNo);
        System.out.println("Course: " + course);
        System.out.println("Score: " + score);
        System.out.println("Research Area: " + researchArea);
        System.out.println("Guide: " + guide);
    }
}

public class PGStu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of PG Students: ");
        int n = sc.nextInt();
        sc.nextLine();

        PGStudent[] students = new PGStudent[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            System.out.print("Score: ");
            double score = sc.nextDouble();
            sc.nextLine();

            System.out.print("Research Area: ");
            String area = sc.nextLine();

            System.out.print("Guide: ");
            String guide = sc.nextLine();

            students[i] = new PGStudent(name, gender, phone,
                                        course, score,
                                        area, guide);
        }

        Arrays.sort(students, (a, b) -> Double.compare(b.score, a.score));

        System.out.println("\n===== Ranking Based on Score =====");
        for (int i = 0; i < n; i++) {
            System.out.println("Rank " + (i + 1));
            students[i].show();
        }


        Arrays.sort(students, (a, b) ->
                a.researchArea.compareToIgnoreCase(b.researchArea));

        System.out.println("\n===== Sorted by Research Area =====");
        for (PGStudent s : students) {
            s.show();
        }

        sc.close();
    }
}