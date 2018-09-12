/**
 * @author Vijay Pathak
 * @version v1.0
 */
public class Bike {
    
    private String description; //Initilization of attributes
    private String manufacturer;
    private String customerName;
    private String contactNumber;
    private String email;
    
    /**
     * constructor of the bike class
     * @param description
     * @param manufacturer
     */
    
    public Bike(String description, String manufacturer) {
        this.description = description;
        this.manufacturer = manufacturer;
        customerName = "";
        contactNumber = "";
        email = "";
    }
    /**
     * Acccesor method for description, manufacturer, customerName, contactNumber, email
     */
    public String getDescription() {
        return description;
    }

    public String getManufacturer() { 
        return manufacturer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }
    
    /**
     * Mutator Method for customerName, contactNumber, email with void return type
     */
    
    public void setCustomerName(String cutomerName) {
        this.customerName = customerName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * This is display method and displays variables and has if conditon
     */
    public void display() {
        System.out.println("The Description is " + description); //print description and manufacturer
        System.out.println("The Manufacturer is " + manufacturer);
        if (customerName != "" && contactNumber != "" && email != "") { //end loop if values if null
            System.out.println("The customer name is " + customerName);
            System.out.println("The Contact Number is" + contactNumber);
            System.out.println("The Email is " + email);
        }
    }
}
