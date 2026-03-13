import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class NameManager {
    public static void main(String[] args){
        ArrayList<String>names=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int ch;

        do{
            System.out.println("\n Menu");
            System.out.println("1.Add Name");
            System.out.println("2.Remove Name");
            System.out.println("3.Search Name");
            System.out.println("4.Sort Names");
            System.out.println("5.Display Names");
            System.out.println("6.Exit");
            System.out.println("Enter your choice:");

            ch=sc.nextInt();
            sc.nextLine();


            switch(ch){
                case 1: 
                     System.out.print("Enter name to add:");
                     String addName = sc.nextLine();
                     names.add(addName);
                     System.out.println(addName + "added successfully");
                     break;

                case 2: 
                     System.out.print("Enter name to remove:");
                     String removeName = sc.nextLine();
                     if(names.remove(removeName)){
                        System.out.println(removeName + "removed successfully");

                     }else{
                        System.out.println("Name not found");
                     }
                     break;

                case 3:
                     System.out.print("Enter name to search:");
                     String searchName = sc.nextLine();
                     if(names.contains(searchName)){
                        System.out.println(searchName + "found in the list.");
                    
                     }
                     else{
                        System.out.println("Name not found.");
                     }
                     break;
            
                case 4:
                    Collections.sort(names);
                    System.out.println("Names sorted successfully.");
                    break;   
                    
                case 5:
                    if(names.isEmpty()){
                        System.out.println("List is empty.");

                    }
                    else{
                        System.out.println("List of names");
                        for(String name : names){
                            System.out.println(name);
                        }6
                    }
                    break;

                case 6: System.out.println("Exiting program");
                break;

                default: 
                    System.out.println("Invalid choice.");



                     
            }




        }while(ch!=6);

        sc.close();
    }


    
}
