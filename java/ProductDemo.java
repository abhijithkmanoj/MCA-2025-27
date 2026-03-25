// Create a class Product (name,price) .  
// Write a program for:   
// a)add     b)sort         c)display products

import java.util.*;

// Product class
class Product {
    String name;
    double price;

    // Constructor
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ProductDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        // a) Add products
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter product " + (i + 1) + " name:");
            String name = sc.nextLine();

            System.out.println("Enter product " + (i + 1) + " price:");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline

            products.add(new Product(name, price));
        }

        // b) Sort products by price (ascending)
        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });

        // c) Display products
        System.out.println("\nSorted Product List (by price):");
        for (Product p : products) {
            System.out.println("Name: " + p.name + ", Price: " + p.price);
        }

        sc.close();
    }
}