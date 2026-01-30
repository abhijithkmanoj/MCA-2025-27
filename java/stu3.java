import java.util.Scanner;

class Student {
    int rollno;
    String name;
    int marks;
    static int count = 0;

    Student() {
        rollno = 0;
        name = "No Name";
        marks = 0;
        count++;
    }

    Student(int r, String n, int m) {
        rollno = r;
        name = n;
        marks = m;
        count++;
    }

    Student(Student s) {
        rollno = s.rollno;
        name = s.name;
        marks = s.marks;
        count++;
    }

    void display() {
        System.out.println(rollno + "\t" + name + "\t" + marks);
    }

    static void compare(Student s1, Student s2) {
        if (s1.marks > s2.marks)
            System.out.println(s1.name + " have higher marks");
        else if (s1.marks < s2.marks)
            System.out.println(s2.name + " have higher marks");
        else
            System.out.println("Equal marks");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] s = new Student[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of student " + (i + 1));
            System.out.print("Roll No: ");
            int r = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Marks: ");
            int m = sc.nextInt();

            s[i] = new Student(r, name, m);
        }

      
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s[i].marks < s[j].marks) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        System.out.println("\n-----Rank-List-----");
        System.out.println("RollNo\tName\tMarks");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }

        System.out.println("\nTotal number of students: " + Student.count);
        System.out.println("\nEnter roll number of first student to compare: ");
        int a = sc.nextInt();
        System.out.println("\nEnter roll number of second student to compare: ");
        int b = sc.nextInt();
        public void compare(s[a],s[b]){
            if(s[a].marks>s[b].marks){
                System.out.println(+s[a].name+"have higher marks");
            }
            else{
                System.out.println(+s[b].name+"have higher marks");
            }
        }

        sc.close();
    }
}
