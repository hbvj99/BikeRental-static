
/**
 * @author Vijay Pathak
 * @version v1.0
 */
import java.awt.Container; //Import abstract window toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel; //Import swing components
import javax.swing.JFrame;
import javax.swing.JButton; //Import textField
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.util.ArrayList; //import arraylist

/**
 * BikeToRent
 */
public class BikeToRentUI extends JFrame implements ActionListener {
    
    private JLabel lblAddBikeToRent, lblBikeId, lblDescription, lblDailyRate, lblCompany; //create private attributes
    private JTextField txtBikeId, txtDescription, txtDailyRate, txtCompany;
    private JButton btnClear, btnConfirm;

    private int count = 1; //counter as 1

    public BikeToRentUI() {
        
        /**
         * Create frame title, close window operation, setSize, and enable for setBounds
         */
        setTitle("Everest Motors: Add Bike To Rent");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setSize(720, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        Container pane = getContentPane();
        setLayout(null);

        lblAddBikeToRent = new JLabel("Add Bike To Rent"); //create window label 
        lblAddBikeToRent.setForeground(Color.BLUE);
        lblAddBikeToRent.setFont(new Font("tahoma", Font.PLAIN, 30));
        lblAddBikeToRent.setBounds(257, 16, 277, 54);
        add(lblAddBikeToRent);

        lblBikeId = new JLabel("Bike Id"); //create bikeid label
        lblBikeId.setBounds(209, 114, 61, 30);
        add(lblBikeId);

        lblDescription = new JLabel("Description"); //create description label
        lblDescription.setBounds(209, 164, 93, 37);
        add(lblDescription);

        lblDailyRate = new JLabel("Daily Rate"); //create daily rate label
        lblDailyRate.setBounds(209, 216, 87, 38);
        add(lblDailyRate);

        lblCompany = new JLabel("Company"); //create company label
        lblCompany.setBounds(209, 271, 77, 37);
        add(lblCompany);

        txtBikeId = new JTextField(); //create textField label
        txtBikeId.setEnabled(false); //disable text field
        txtBikeId.setText(Integer.toString(BikeRentalUI.count)); //convert into string
        txtBikeId.setBounds(299, 110, 277, 38);
        add(txtBikeId);
        txtBikeId.addActionListener(this);

        txtDescription = new JTextField(); //create text field description
        txtDescription.setBounds(299, 164, 277, 38);
        add(txtDescription);
        txtDescription.addActionListener(this);

        txtDailyRate = new JTextField(); // create text field daily rate
        txtDailyRate.setBounds(299, 218, 277, 37);
        add(txtDailyRate);
        txtDailyRate.addActionListener(this); //add action listener

        txtCompany = new JTextField(); //create text field company
        txtCompany.setBounds(299, 271, 277, 37);
        add(txtCompany);
        txtCompany.addActionListener(this);

        btnClear = new JButton("Clear"); // create text field 
        btnClear.setBounds(421, 338, 115, 48);
        add(btnClear);
        btnClear.addActionListener(this);

        btnConfirm = new JButton("Confirm"); //create confirm button
        btnConfirm.setBounds(551, 338, 115, 48);
        add(btnConfirm);
        btnConfirm.addActionListener(this); //add action listener

        setVisible(true);

    }
    
    /**
     * Create 
     */
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        try {
            if (obj == btnClear) { //clear button
                txtDescription.setText(""); //set all empty 
                txtDailyRate.setText("");
                txtCompany.setText("");
                JOptionPane.showMessageDialog(null, "All the fields has been cleared!", "Information Message",JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (obj == btnConfirm) { //confirm button
                String bikeId = txtBikeId.getText();
                String description = txtDescription.getText();
                String company = txtCompany.getText();
                String dailyRate = txtDailyRate.getText();
                int intDailyRate = Integer.parseInt(dailyRate);
                if (description != null || !description.equals("") && company != null || !company.equals("") && dailyRate != null || !dailyRate.equals("")) {
                    BikeToRent rentBike = new BikeToRent(description, company, intDailyRate);
                    BikeRentalUI.list.add(rentBike);
                    count += 1;
                    txtBikeId.setText(Integer.toString(count)); //convert into string
                    txtDescription.setText("");
                    txtCompany.setText("");
                    txtDailyRate.setText("");
                    JOptionPane.showMessageDialog(null,"The Bike has been added for rent","Information Message",JOptionPane.INFORMATION_MESSAGE); //info message
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Please, Don't Leave Text Fields Empty", "Error Message",JOptionPane.ERROR_MESSAGE); //display when both condition is false

                }
            } 
            else {
                JOptionPane.showMessageDialog(null, "Sorry, Please Enter Valid Number!", "Error Message", JOptionPane.ERROR_MESSAGE); //error message
            }
        } 
        catch (Exception e) { //exception handelinh
            JOptionPane.showMessageDialog(null, "Sorry, Please Enter Valid Number!", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
}
