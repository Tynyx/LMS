//LaTroy Richardson CEN-3024c-31774 May 18th 2025
// Software Development 1
//Library manager Class
// This class is to be the "manager" or the librarian that would be managing the patrons and files of the library

import javax.xml.xpath.XPath;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LibraryManager {

    // Attributes

    // the only attribute we really have is the foreign key from patron
    // I set it as a List  because I believe this would give us the logic to call out any attribute
    // from the patron instead of just referring to its PK since we need to be able to remove a patron through ID
    //means as stated int the SDLC
    private List<Patron> patrons;

    //Constructors

    public LibraryManager(List<Patron> patrons) {
        this.patrons = patrons;
    }
    public LibraryManager() {
        this.patrons = new ArrayList<>();
    }


    //Custom Methods
    // addPatron(p: Patron):
    //This method gives the LBMan the ability to addPatrons to the library and display the new patron
    public void add(Patron patron) {
        // going to  engulf this with and try and catch to handle any errors
        try {


            if (patrons.contains(patron)) {
                throw new IllegalArgumentException("Patron already exists");
            } else {
                patrons.add(patron);
                System.out.println("Patron added: " + patron);
            }
        } catch (Exception e) {
            System.out.println("Patron could not be added: " + patron);

        }

    }



    //Remove patron This gives the LBM the ability to remove any patron through id
    // returns a boolean of true or false
    public boolean remove(Integer patronId) {
      // create a try and catch to handle any mishaps
        try {


            // use an iterator to remove while looping
            Iterator<Patron> iterator = patrons.iterator();
            while (iterator.hasNext()) {
                Patron patron = iterator.next();
                if (patron.getId() == patronId) {
                    iterator.remove();
                    System.out.println("Patron removed: " + patron);
                    return true;
                }
            }

            System.out.println("Patron with id " + patronId + " does not exist");
            System.out.println("Please input a valid patron Id");
            return false;


        } catch (Exception e) {
            System.out.println("Unexpected error while removing patron: " + patronId);
            return false;
        }
    }


    //loadFromFile(path: String)
    // this method allows the LBM to upload a file and have everything on the file be read an printed on the screen

    public void loadFileFrom(String path) {
        // path is the file name provided by the user
        try {
            File file = new File(path);
            Scanner filescanner = new Scanner(file);
            System.out.println("Loading file from " + path);
            System.out.println("-------Start of File -------");
            while(filescanner.hasNextLine()) {

                String line = filescanner.nextLine();
                String[] separated = line.split(",");
                // Now we will check make sure each section is only 4 parts and those parts follow our guidelines
                if(separated.length != 4) {
                    continue;
                }

            try {
                int id = Integer.parseInt(separated[0].trim());
                String name = separated[1].trim();
                String address = separated[2].trim();
                float fine = Float.parseFloat(separated[3].trim());

                // now we begin to validate id and the fine just like if we were adding a new patron with those constraints
                if (id < 1000000 || id > 9999999) {
                    throw new IllegalArgumentException("Patron id must be between 1000000 and 99999999");
                }

                if ( name.isEmpty()) {
                    throw new IllegalArgumentException("Patron name cannot be empty");
                }

                if ( address.isEmpty()) {
                    throw new IllegalArgumentException("Patron address cannot be empty");
                }

                // now we validate fine
                if (fine < 0 || fine > 250) {
                    throw new IllegalArgumentException("Fine must be between 0 and 250");
                }

                System.out.println("Valid patron: ID: " + id + ", name: " + name + ", address: " + address + ", fine: " + fine);


                } catch ( Exception e) {
                    System.out.println("Error in data: " + line);

                 }

            }
            System.out.println("-------End of File -------");
            filescanner.close();
        } catch (FileNotFoundException e)  {
            System.out.println("File not found" + path);
        }

    }
    // this is an greeting to the loadfileform so you know what u need to do
    // returns the txt file uploaded
    public void promptAndLoadFile() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter the path to the file: ");
        String path = inputScanner.nextLine();
        loadFileFrom(path);
    }

    // listallpatrons() allows the LBM to see every patron in the system
    //returns a list of patrons or no data found

    // need to make the patrons list is not empty and let the LBM know if the list is empty
    public void listAllPatrons() {
       try {
           if (patrons.isEmpty()) {
               System.out.println("No Patrons found");
               return;
           }
           System.out.println("-------Current Patrons------");
           for (Patron patron : patrons) {
               System.out.println(patron);

           }
           System.out.println("-------End of List---------");
       } catch (Exception e) {
           System.out.println("Unexpected error while listing all patrons: " + e.getMessage());
       }
    }

    public int getPatronCount() {
        return patrons.size();
    }
}
