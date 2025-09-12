//LaTroy Richardson CEN-3024c-31774 May 18th 2025
// Software Development 1
// Menu class is the main class that initialize all the code in the LBM and Patron Class
// This needs to have the all features and listed in the SDLC and ensure the code follows the constraints listed as well


import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    // This is the main class that take all the code we used and make it work together the initializer

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // this helps with letting the user decide when to end the program

        while (running) {
            System.out.println("\n==== Library Management System ====");
            System.out.println("1. Add Patron");
            System.out.println("2. Remove Patron");
            System.out.println("3. Load Patrons from File");
            System.out.println("4. List All Patrons");
            System.out.println("5. Exit");


            String choice = scanner.nextLine();
            // this switch is used to generate multiple commands to use while the software is running and navigate them
            // easily. returns a list of 5 options and upon selecting one generates new options or commands.
            switch (choice) {
                case "1":
                    System.out.println("Please Enter 7 digit Patron ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Please enter the name of the Patron: ");
                    String name = scanner.nextLine();

                    System.out.print("Please enter the address of the Patron: ");
                    String address = scanner.nextLine();
                    float fine = (float) 0.0;

                    System.out.print("Does this patron owe any fines: Y/N?");
                    String hasFine = scanner.nextLine().trim();

                    try{


                        if (hasFine.equalsIgnoreCase("Y")) {
                            System.out.println("How much do they owe: ");
                            System.out.flush();
                            fine = scanner.nextFloat();
                            scanner.nextLine();

                        }
                        Patron newPatron = new Patron(id, name, address, fine);
                        manager.add(newPatron);
                        System.out.println("Thank you Patron " + name + " has been added to the library!");
                        manager.listAllPatrons();

                    } catch (InputMismatchException | NumberFormatException e){
                        System.out.println("Invalid input. Please enter numbers where they are required only!");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(" Validation Failed. Please try again!" + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Something went wrong. Please try again!" + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Please Enter 7 digit Patron ID that you wish to remove: ");
                    try{
                        int removeId = Integer.parseInt(scanner.nextLine());
                        if (manager.remove(removeId)){
                        System.out.println("Thank you Patron has been removed from library!");
                        }
                        manager.listAllPatrons();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Enter digits only!");
                    }
                    
                    break;
                case "3":
                    manager.promptAndLoadFile(scanner);
                    break;
                case "4":
                    manager.listAllPatrons();
                    break;
                case "5":
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }


}