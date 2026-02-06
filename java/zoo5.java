


class Zoo {

    String name;
    String[] regions;
    Contact contact;

   
    Zoo(String name, String[] regions, Contact contact) {
        this.name = name;
        this.regions = regions;
        this.contact = contact;
    }

  
    class Enclosure {
        String name;
        String type;
        String[] animals;

        Enclosure(String name, String type, String[] animals) {
            this.name = name;
            this.type = type;
            this.animals = animals;
        }

        void displayEnclosure() {
            System.out.println("  Enclosure Name : " + name);
            System.out.println("  Type           : " + type);
            System.out.print("  Animals        : ");
            for (String animal : animals) {
                System.out.print(animal + " ");
            }
            System.out.println("\n");
        }
    }

    
    static class Contact {
        String address;
        String phoneNo;

        Contact(String address, String phoneNo) {
            this.address = address;
            this.phoneNo = phoneNo;
        }

        void displayContact() {
            System.out.println("Address  : " + address);
            System.out.println("Phone No : " + phoneNo);
        }
    }

    void displayZooDetails() {
        System.out.println("Zoo Name : " + name);
        System.out.print("Regions  : ");
        for (String region : regions) {
            System.out.print(region + " ");
        }
        System.out.println("\n");
        contact.displayContact();
        System.out.println();
    }

    public static void main(String[] args) {

        Contact contact = new Contact(
                "National Park Road, City Center",
                "9876543210"
        );

        
        String[] regions = {"Area-1", "Area-2", "Area-3"};
        Zoo zoo = new Zoo("Wildlife Wonder Zoo", regions, contact);

        zoo.displayZooDetails();

    
        Zoo.Enclosure grassland = zoo.new Enclosure(
                "Grassland",
                "Outdoor",
                new String[]{"Lion", "Deer", "Zebra"}
        );

        Zoo.Enclosure flyZone = zoo.new Enclosure(
                "Fly Zone",
                "Indoor",
                new String[]{"Parrot", "Eagle", "Owl"}
        );

        Zoo.Enclosure aquatic = zoo.new Enclosure(
                "Aquatic",
                "Indoor",
                new String[]{"Shark", "Dolphin", "Octopus"}
        );

        System.out.println("Enclosure Details:");
        grassland.displayEnclosure();
        flyZone.displayEnclosure();
        aquatic.displayEnclosure();
    }
}
