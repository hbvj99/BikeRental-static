
/**
 * This is the main class to run the GUI. In this class main method is set with actionListener for thier respected 
 *
 * @author Vijay Pathak
 * @version v1.0
 */

import javax.swing.JLabel; //import swing components
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Container; //import abstract window toolkits
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

import java.util.ArrayList; //import arraylist
/**
 * BikeRentalUI, this is the main class and it extends JFrame, implements ActionListener
 */
public class BikeRentalUI extends JFrame implements ActionListener {
    private JFrame frame; //reating private attributes
    private JLabel lblBikeCompany;
    private JButton btnAddBikeToRent, btnAddBikeToSell, btnRentBike, btnSellBike, btnReturnBike, btnDisplay;

    public static ArrayList<Bike> list; //create arraylist
    public static int count = 1; //Initilize counter 
    
    /**
     * Main method to all classes and also used for compiling with cmd
     */
    public static void main(String[]args){
        BikeRentalUI bikee = new BikeRentalUI();
    }
    
    /**
     * BikeRentalUI; creating actionlistener for buttons and text fields
     */
    public BikeRentalUI() {
        /**
         * create arraylist, title, close window, display color, frame location, resizable window and enabling setbounds
         */
        list = new ArrayList<Bike>(); 
        
        setTitle("Everest Motors: Bike Company"); 
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        setBounds(100, 100, 450, 300); 
        setSize(720, 480);
        setLocationRelativeTo(null); 
        setResizable(false); 
        Container Pane = getContentPane();
        setLayout(null); 
        
        lblBikeCompany = new JLabel("Bike Company"); //create label, set forground color, setbounds and add to container
        lblBikeCompany.setForeground(Color.BLUE);
        lblBikeCompany.setFont(new Font("tahoma", Font.PLAIN, 35));
        lblBikeCompany.setBounds(253, 32, 226, 41);
        add(lblBikeCompany);

        btnAddBikeToRent = new JButton("Add Bike To Rent"); //create button and add action listener
        btnAddBikeToRent.setBounds(85, 116, 211, 72);
        add(btnAddBikeToRent);
        btnAddBikeToRent.addActionListener(this);

        btnAddBikeToSell = new JButton("Add Bike To Sell"); 
        btnAddBikeToSell.setBounds(433, 116, 211, 72);
        add(btnAddBikeToSell);
        btnAddBikeToSell.addActionListener(this);

        btnRentBike = new JButton("Rent Bike");
        btnRentBike.setBounds(85, 220, 211, 72);
        add(btnRentBike);
        btnRentBike.addActionListener(this);

        btnSellBike = new JButton("Sell Bike"); //
        btnSellBike.setBounds(433, 220, 211, 72);
        add(btnSellBike);
        btnSellBike.addActionListener(this);

        btnReturnBike = new JButton("Return");
        btnReturnBike.setBounds(85, 322, 211, 72);
        add(btnReturnBike);
        btnReturnBike.addActionListener(this);

        btnDisplay = new JButton("Display"); //display button
        btnDisplay.setBounds(433, 322, 211, 72);
        add(btnDisplay);
        btnDisplay.addActionListener(this);

        setVisible(true); //set frame visible 

    }
    /**
     * Adding actionlistener in button and text fields 
     */
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource(); //button location
        if (obj == btnAddBikeToRent) {
            new BikeToRentUI(); //create object
        } 
        else if (obj == btnAddBikeToSell) {
            count = list.size() + 1; //increase list size by one
            BikeToSellUI bikeToSell = new BikeToSellUI();
        } 
        else if (obj == btnRentBike) {
            count = list.size() + 1;

            RentBikeUI rentBike = new RentBikeUI();
        } 
        else if (obj == btnSellBike) {
            count = list.size() + 1;

            SellBikeUI SellBike = new SellBikeUI();
        } 
        else if (obj == btnReturnBike) {
            count = list.size() + 1;

            ReturnBikeUI btnReturnBike = new ReturnBikeUI();
        } 
        
    else if (obj==btnDisplay){
            display();
        }
    }
    
    /**
     * Display method to print the customer details
     */
    private void display() {
        for (Bike val : list) { //iterators the values from list
            if (val instanceof BikeToRent) { //if instance of BikeToRent
                 BikeToRent rent = (BikeToRent) val;
                 System.out.println("-------   BIKE TO RENT  -----------");
                 System.out.println("Name: " + rent.getDescription() +"\nCompany: " + rent.getManufacturer() +"\nDaily Rate: " + rent.getDailyRate() +"\n" + "Loan Status: " + rent.getBikeLoanStatus());
                 System.out.println("-----------------------------------");
                 System.out.println("-----------------------------------"); //seprates the lines
                
                 if (rent.getBikeLoanStatus() == true){ //if true
                    System.out.println("-------Customer Details--------");
                    System.out.println("Customer Name: " + rent.getCustomerName() + "\nContact: "+ rent.getContactNumber() + "\nEmail: " + rent.getEmail());
                    System.out.println("-------------------------------"); 
                    System.out.println("-------------------------------");
                }
            } 
            else if (val instanceof BikeToSell) { //else if instance of BikeToSell
                BikeToSell sell = (BikeToSell) val;
                System.out.println("-----   BIKE TO SELL   ----------");
                System.out.println("Name: " + sell.getDescription() + "\nCompany: "+ sell.getManufacturer() + "\nPrice: " + sell.getPrice() +"\nTax Rate: "+ sell.getTaxAmount() +"\nSelling Status: " + sell.getSellingStatus());
                System.out.println("---------------------------------");
                System.out.println("---------------------------------");
                if (sell.getSellingStatus() == true){ //if status is true
                    System.out.println("----   Customer Details   -----");
                    System.out.println("Customer Name: " + sell.getCustomerName() + "\nContact: "+ sell.getContactNumber() + "\nEmail: " + sell.getEmail() +"\nSellingDate" + sell.getSellingDate());
                    System.out.println("-------------------------------");
                    System.out.println("-------------------------------"); 
                }
            }
        }
    }
}
