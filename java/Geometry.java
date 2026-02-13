import java.util.Scanner;

class Geometry {

    int area(int side) {
        return side * side;
    }

    int area(int length, int breadth) {
        return length * breadth;
    }

    double area(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Geometry g = new Geometry();

        System.out.print("Enter side of square: ");
        int side = sc.nextInt();
        System.out.println("Area of square: " + g.area(side));

        System.out.print("Enter length of rectangle: ");
        int length = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int breadth = sc.nextInt();
        System.out.println("Area of rectangle: " + g.area(length, breadth));
        
        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();
        System.out.println("Area of circle: " + g.area(radius));

        sc.close();
    }
}
