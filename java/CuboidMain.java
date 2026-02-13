import java.util.Scanner;
interface Measurable {
    double volume();
}

interface Printable {
    void display();
}

class Rectangle {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

class Cuboid extends Rectangle implements Measurable, Printable {

    double height;

    Cuboid(double length, double width, double height) {
        super(length, width);   
        this.height = height;
    }

    public double volume() {
        return length * width * height;
    }

    public void display() {
        System.out.println("Cuboid Details:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Volume: " + volume());
    }
}


public class CuboidMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        double length = sc.nextDouble();

        System.out.print("Enter width: ");
        double width = sc.nextDouble();

        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        Cuboid c = new Cuboid(length, width, height);
        c.display();

        sc.close();
    }
}
