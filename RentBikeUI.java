
/**
 *
 * @author (Vijay Pathak)
 * @version v1.0
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.util.List;
/**
 * Ths bike extends JFrame class
 */

public class RentBikeUI  extends JFrame implements ActionListener
{
    private JLabel lblRentBike, lblBikeId, lblDescription, lblCustomerName, lblContact, lblHireDate, lblDailyRate, lblTotalAmount, lblCompany, lblEmail, lblNumberOfDays;
    private JTextField txtBikeId, txtDescription, txtCustomerName, txtContact, txtHireDate, txtDailyRate, txtTotalAmount, txtCompany, txtEmail, txtNumberOfDays;
    private JButton btnCheck, btnCalculateRent, btnClear, btnConfirm;
    
    public RentBikeUI(){
        
        setTitle("Motors: Rent Bike"); //set title
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //close window
        Container pane = getContentPane();
        setBounds(100, 100, 450, 300);
        setSize(720,480);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); //layout
        
        lblRentBike = new JLabel("Rent Bike"); //rent bike label message
        lblRentBike.setFont(new Font("tahoma", Font.PLAIN, 30));
        lblRentBike.setForeground(Color.BLUE);
        lblRentBike.setBounds(306, 16, 145, 34);
        add(lblRentBike);
        
        lblBikeId = new JLabel("Bike Id"); //
        lblBikeId.setBounds(43, 85, 69, 20);
        add(lblBikeId);
        
        lblDescription = new JLabel("Description"); //
        lblDescription.setBounds(43, 132, 85, 27);
        add(lblDescription);

        lblCustomerName = new JLabel("Customer Name"); //
        lblCustomerName.setBounds(43, 186, 119, 27);
        add(lblCustomerName);
        
        lblContact = new JLabel("Contact"); //
        lblContact.setBounds(43, 236, 69, 20);
        add(lblContact);
        
        lblHireDate = new JLabel("Hire Date");
        lblHireDate.setBounds(43, 286, 69, 20); //
        add(lblHireDate);
        
        lblDailyRate = new JLabel("Daily Rate"); //
        lblDailyRate.setBounds(412, 93, 85, 20);
        add(lblDailyRate);

        lblTotalAmount = new JLabel("Total Amount"); //
        lblTotalAmount.setBounds(412, 136, 100, 20);
        add(lblTotalAmount);

        lblCompany = new JLabel("Company"); //
        lblCompany.setBounds(412, 186, 69, 20);
        add(lblCompany);

        lblEmail = new JLabel("Email"); //
        lblEmail.setBounds(412, 236, 51, 20);
        add(lblEmail);

        lblNumberOfDays = new JLabel("No Of Days"); //
        lblNumberOfDays.setBounds(412, 286, 85, 20);
        add(lblNumberOfDays);
     
        txtBikeId = new JTextField(); //
        txtBikeId.setBounds(177, 79, 146, 34);
        add(txtBikeId);
        txtBikeId.addActionListener(this);
        
        txtDescription = new JTextField(); //
        txtDescription.setBounds(177, 129, 146, 34);
        add(txtDescription);
        txtDescription.addActionListener(this);
        txtDescription.setEnabled(false);

        txtCustomerName = new JTextField(); //
        txtCustomerName.setBounds(177, 179, 146, 34);
        add(txtCustomerName);
        txtCustomerName.addActionListener(this);

        txtContact = new JTextField(); //
        txtContact.setBounds(177, 229, 146, 34);
        add(txtContact);
        txtContact.addActionListener(this);

        txtHireDate = new JTextField(); //
        txtHireDate.setBounds(177, 279, 146, 34);
        add(txtHireDate);
        txtHireDate.addActionListener(this);
  
        txtDailyRate = new JTextField(); //
        txtDailyRate.setBounds(527, 79, 146, 34);
        add(txtDailyRate);
        txtDailyRate.addActionListener(this);
        txtDailyRate.setEnabled(false);
        
        txtTotalAmount = new JTextField(); //
        txtTotalAmount.setBounds(527, 129, 146, 34);
        add(txtTotalAmount);
        txtTotalAmount.addActionListener(this);
        txtTotalAmount.setEnabled(false);

        txtCompany = new JTextField(); //
        txtCompany.setBounds(527, 179, 146, 34);
        add(txtCompany);
        txtCompany.addActionListener(this);
        txtCompany.setEnabled(false);
        
        txtEmail = new JTextField(); //
        txtEmail.setBounds(527, 229, 146, 34);
        add(txtEmail);
        txtEmail.addActionListener(this);
        
        txtNumberOfDays = new JTextField();
        txtNumberOfDays.setBounds(527, 279, 146, 34);
        pane.add(txtNumberOfDays);
        txtNumberOfDays.addActionListener(this);
        
        btnCheck = new JButton("Check"); //
        btnCheck.setBounds(282, 353, 115, 43);
        add(btnCheck);
        btnCheck.addActionListener(this);
        
        btnClear = new JButton("Clear"); //
        btnClear.setBounds(152, 353, 115, 43);
        add(btnClear);
        btnClear.addActionListener(this);
        
        btnCalculateRent = new JButton("Calculate Rent"); //
        btnCalculateRent.setBounds(412, 353, 131, 43);
        add(btnCalculateRent);
        btnCalculateRent.addActionListener(this);
        
        btnConfirm = new JButton("Confirm"); //
        btnConfirm.setBounds(558, 353, 115, 43);
        add(btnConfirm);
        btnConfirm.addActionListener(this);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            Object obj = ae.getSource(); //create object 
            if(obj == btnCheck){
                int index = Integer.parseInt(txtBikeId.getText()); //convert into integer
                BikeToRent rentBike = (BikeToRent) BikeRentalUI.list.get(index-1);
                if (rentBike.getBikeLoanStatus() == false){ //if false
                    JOptionPane.showMessageDialog(null,"The Bike is Avaibale!","Information Message",JOptionPane.INFORMATION_MESSAGE);
                    txtDescription.setText(rentBike.getDescription());
                    txtCompany.setText(rentBike.getManufacturer());
                    txtDailyRate.setText(Integer.toString(rentBike.getDailyRate()));
                    btnCalculateRent.setEnabled(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Sorry, The Bike is Not Avaibale!","Information Message",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        
    else if(obj == btnCalculateRent){ //calculate button
       
        int numberOfDays = Integer.parseInt(txtNumberOfDays.getText());
        int dr = Integer.parseInt(txtDailyRate.getText());
        
        if(!txtNumberOfDays.getText().equals("")){
                int intDailyRate = numberOfDays * dr;
                txtTotalAmount.setText(Integer.toString(intDailyRate));
        }
        else{
                JOptionPane.showMessageDialog(null, "Please, Don't leave fields blanked!", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    else if(obj == btnConfirm){ //confirm button
        String customerName = txtCustomerName.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String bikeHireDate = txtHireDate.getText();
        int numberOfDays = Integer.parseInt(txtNumberOfDays.getText());
        if(!customerName.equals("") && !contact.equals("") && !email.equals("") && !bikeHireDate.equals("")){ //condition
            int index = Integer.parseInt(txtBikeId.getText());
            BikeToRent rentBike = (BikeToRent)BikeRentalUI.list.get(index-1);
            rentBike.rentalBike(customerName,contact,email,bikeHireDate,numberOfDays);
            BikeRentalUI.list.add(rentBike);
            BikeRentalUI.count =+1;
            
            txtBikeId.setText(""); //set all empty
            txtDescription.setText("");
            txtCustomerName.setText("");
            txtContact.setText("");
            txtEmail.setText("");
            txtHireDate.setText("");
            txtCompany.setText("");
            txtDailyRate.setText("");
            txtNumberOfDays.setText("");
            txtTotalAmount.setText("");
            JOptionPane.showMessageDialog(null,"The Bike has been rented","Information Message",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Please, don't leave fields blanked","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    else{
        txtBikeId.setText("");
        txtDescription.setText(""); //set all empty
        txtCustomerName.setText("");
        txtContact.setText("");
        txtHireDate.setText(""); 
        txtDailyRate.setText(""); 
        txtTotalAmount.setText(""); 
        txtCompany.setText("");
        txtEmail.setText("");
        txtNumberOfDays.setText("");
        JOptionPane.showMessageDialog(null, "All the fields has been cleared!","Information Message",JOptionPane.INFORMATION_MESSAGE);
       }
     }
    catch(Exception e){ //exception
        JOptionPane.showMessageDialog(null, "Please enter valid number!","Error Message",JOptionPane.ERROR_MESSAGE);
    
    }
  }
}