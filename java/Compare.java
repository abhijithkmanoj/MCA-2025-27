interface Comparable {
    double findVolume();
    int compareTo(Comparable obj);
}

class Cuboid implements Comparable {
    double length, width, height;

    Cuboid(double l, double w, double h) {
        length = l;
        width = w;
        height = h;
    }

    public double findVolume() {
        return length * width * height;
    }

    public int compareTo(Comparable obj) {
        if (this.findVolume() > obj.findVolume())
            return 1;
        else if (this.findVolume() < obj.findVolume())
            return -1;
        else
            return 0;
    }
}

class Cylinder implements Comparable {
    double radius, height;

    Cylinder(double r, double h) {
        radius = r;
        height = h;
    }

    public double findVolume() {
        return Math.PI * radius * radius * height;
    }

    public int compareTo(Comparable obj) {
        if (this.findVolume() > obj.findVolume())
            return 1;
        else if (this.findVolume() < obj.findVolume())
            return -1;
        else
            return 0;
    }
}

public class Compare {
    public static void main(String[] args) {

        Cuboid c1 = new Cuboid(5, 4, 3);
        Cylinder c2 = new Cylinder(3, 5);

        System.out.println("Cuboid Volume: " + c1.findVolume());
        System.out.println("Cylinder Volume: " + c2.findVolume());

        int result = c1.compareTo(c2);

        if (result > 0)
            System.out.println("Cuboid has greater volume.");
        else if (result < 0)
            System.out.println("Cylinder has greater volume.");
        else
            System.out.println("Both have equal volume.");
    }
}