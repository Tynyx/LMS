// Patron Class
// This class represent the user that will be using the library, with these attributes and Id, name, address, and Overdue
//Fines

public class Patron {

    // Class attributes
    //ID will also be the class primary key
    private int id;

    private String name;

    private String address;

    private float fine;

    //Constructors
    public Patron() {}

    public Patron(int id, String name, String address, float fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;

    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 1000000 || id > 9999999) {

            //this forces the user to only input 7 digit id
            throw new IllegalArgumentException("Id must be a 7 digit number (1000000 to 9999999");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        if (fine < 0 || fine > 250) {
            // This forces the LibManager to only allow fines to be between the range of 0 to 250
            throw new IllegalArgumentException("Fine must be between 0 and 250");
        }
        this.fine = fine;
    }

    //Custom METHODS




}
