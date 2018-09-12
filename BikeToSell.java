
/**
 * @author Vijay Pathak
 * @version v1.0
 */
public class BikeToSell extends Bike {
	int price; //Initilization of attributes
	int taxAmount;
	int totalAmount;
	String sellingDate;
	boolean sellingStatus;

	public BikeToSell(String description, String manufacturer, int price, int tax) {
		super(description, manufacturer);
		this.price = price;
		taxAmount = tax;
		sellingStatus = false;
		totalAmount = 0;
		sellingDate = "";
	}

	public int getPrice() {
		return price;
	}

	public int getTaxAmount() {
		return taxAmount;
	}

	public String getSellingDate() {
		return sellingDate;
	}

	public boolean getSellingStatus() {
		return sellingStatus;
	}

	public void sellingBike(String customerName, String contactNumber, String email, String sellingDate) {
		if (sellingStatus == false) {
			setCustomerName(customerName);
			setContactNumber(contactNumber);
			setEmail(email);
			totalAmount = price + taxAmount;
			sellingStatus = false;
		}
		else {
			System.out.println("Sorry, the bike has been already sold!");
		}
	}
}