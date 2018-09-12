
/**
 * @author Vijay Pathak
 * @version v1.0
 */
public class BikeToRent extends Bike {

    private String bikeHireDate; //Initilizing of attributes
    private int numberOfDays;
    private int dailyRate;
    private int totalRentalCost;
    private boolean bikeLoanStatus;
    /**
     * In this Constructer; description, manufacturer and dailyRate is initilized using parameter
     */
    public BikeToRent(String description, String manufacturer, int dailyRate) {
        super(description, manufacturer);
        this.dailyRate = dailyRate;
        numberOfDays = 0;
        totalRentalCost = 0;
        bikeLoanStatus = false;
    }
    
    /**
     * This is the Accessor method for BikeHireDate, NumberOfDays, DailyRate, totalRentalCost, BikeLoanStatus
     */
    public String getBikeHireDate() {
        return bikeHireDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public int getTotalRentalCost() {
        return totalRentalCost;
    }

    public boolean getBikeLoanStatus() {
        return bikeLoanStatus;
    }
    
    /**
     * rentalBike method that has paramters; customerName, contactNumber, email, bikeHireDate, numberOfDays
     */
    public void rentalBike(String customerName, String contactNumber, String email, String bikeHireDate, int numberOfDays) {
        if (bikeLoanStatus == true) { //if loan status true 
            System.out.println("Sorry, the bike is not available!");
            System.out.println("The bike was Hire on " + bikeHireDate);
            System.out.println("The Bike is hired for " + numberOfDays);
        } 
        else if (bikeLoanStatus == false) { //if loan status is false
            setCustomerName(customerName); //change value from parent class
            setContactNumber(contactNumber);
            setEmail(email);
            this.bikeHireDate = bikeHireDate; //initilize value as local 
            this.numberOfDays = numberOfDays;
            bikeLoanStatus = true;
            totalRentalCost = dailyRate * numberOfDays; //calculate total rent
        }
    }
    
    /**
     * bikeAvability class which check if bike is available or not
     */
    public void bikeAvability() { 
        if (bikeLoanStatus == false) { //if loanstatus is false
            System.out.println("The bike is currently available!");
        } 
        else { //loanstatus is true
            setCustomerName("");
            setContactNumber("");
            setEmail("");
            numberOfDays = 0;
            bikeHireDate = "";
            bikeLoanStatus = false;
        }
    }
}