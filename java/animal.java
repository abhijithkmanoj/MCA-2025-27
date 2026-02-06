abstract class Animal {
    private String species;
    protected int age;
    protected double weight;
    protected String color;

    Animal() {
        species = "Unknown";
        age = 0;
        weight = 0.0;
        color = "Unknown";
    }

    Animal(String species, int age, double weight, String color) {
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    Animal(Animal a) {
        this.species = a.species;
        this.age = a.age;
        this.weight = a.weight;
        this.color = a.color;
    }

    String getSpecies() {
        return species;
    }

    abstract void display();
}

class Dog extends Animal {
    String breed;
    String name;
    String owner;

    Dog(String species, int age, double weight, String color,
        String breed, String name, String owner) {

        super(species, age, weight, color);
        this.breed = breed;
        this.name = name;
        this.owner = owner;
    }

    @Override
    void display() {
        System.out.println("Dog Details:");
        System.out.println("Species: " + getSpecies());
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
        System.out.println("Owner: " + owner);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
        System.out.println("Color: " + color);
    }
}

class Cat extends Animal {
    String name;
    String eyeColor;
    double tailLength;

    Cat(String species, int age, double weight, String color,
        String name, String eyeColor, double tailLength) {

        super(species, age, weight, color);
        this.name = name;
        this.eyeColor = eyeColor;
        this.tailLength = tailLength;
    }

    void getDetails() {
        System.out.println("Cat Details:");
        System.out.println("Species: " + getSpecies());
        System.out.println("Name: " + name);
        System.out.println("Eye Color: " + eyeColor);
        System.out.println("Tail Length: " + tailLength);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
        System.out.println("Color: " + color);
    }

    @Override
    void display() {
        getDetails();
    }

}

class animal {
    public static void main(String[] args) {

        Animal a1 = new Dog("Canine", 5, 22.5, "Yellow",
                "Golden Retriever", "Diana", "Prince");

        Animal a2 = new Cat("Feline", 3, 4.1, "White and Grey",
                "Subhash", "Blue", 9.5);

        a1.display();
        System.out.println();
        a2.display();
    }
}
