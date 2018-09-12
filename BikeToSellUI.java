
/**
 * Write a lblDescription of class lblAddBikeToSell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.util.List;
/**
 * This bike extends JFrame class
 */

public class BikeToSellUI extends JFrame implements ActionListener {

    private JLabel lblAddBikeToSell, lblBikeId, lblDescription, lblPrice, lblTaxRate, lblCompany;
    private JTextField txtBikeId, txtDescription, txtPrice, txtTaxRate, txtCompany;
    private JButton btnClear, btnConfirm;

    public BikeToSellUI() {
        setTitle("Everest Motors: Rent Bike"); //title
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //close window
        setBounds(100, 100, 450, 300);
        setSize(720, 480);
        setLocationRelativeTo(null); //frame location
        setResizable(false);
        Container pane = getContentPane(); //container
        setLayout(null); 

        lblAddBikeToSell = new JLabel("Add Bike To Sell"); // bike to sell label
        lblAddBikeToSell.setFont(new Font("tahoma", Font.PLAIN, 27));
        lblAddBikeToSell.setForeground(Color.BLUE);
        lblAddBikeToSell.setBounds(250, 31, 223, 32);
        add(lblAddBikeToSell);

        lblBikeId = new JLabel("Bike Id"); 
        lblBikeId.setBounds(207, 112, 49, 20);
        add(lblBikeId);

        lblDescription = new JLabel("Description"); 
        lblDescription.setBounds(207, 157, 81, 26);
        add(lblDescription);

        lblPrice = new JLabel("Price"); 
        lblPrice.setBounds(207, 208, 34, 20);
        add(lblPrice);

        lblTaxRate = new JLabel("Tax Rate(%)"); 
        lblTaxRate.setBounds(207, 256, 91, 20);
        add(lblTaxRate);

        lblCompany = new JLabel("Company"); 
        lblCompany.setBounds(207, 304, 69, 20);
        add(lblCompany);

        txtBikeId = new JTextField(); 
        txtBikeId.setBounds(303, 106, 284, 32);
        add(txtBikeId);
        txtBikeId.addActionListener(this);
        txtBikeId.setText(Integer.toString(BikeRentalUI.count));
        txtBikeId.setEnabled(false);

        txtDescription = new JTextField(); 
        txtDescription.setBounds(303, 154, 284, 32);
        add(txtDescription);
        txtDescription.addActionListener(this);

        txtPrice = new JTextField(); 
        txtPrice.setBounds(303, 202, 284, 32);
        add(txtPrice);
        txtPrice.addActionListener(this);

        txtTaxRate = new JTextField(); 
        txtTaxRate.setBounds(303, 250, 284, 32);
        add(txtTaxRate);
        txtTaxRate.addActionListener(this);

        txtCompany = new JTextField(); 
        txtCompany.setBounds(303, 298, 284, 32);
        add(txtCompany);
        txtCompany.addActionListener(this);

        btnClear = new JButton("Clear"); 
        btnClear.setBounds(404, 357, 115, 39);
        add(btnClear);
        btnClear.addActionListener(this);

        btnConfirm = new JButton("Confirm"); 
        btnConfirm.setBounds(553, 357, 115, 39);
        add(btnConfirm);
        btnConfirm.addActionListener(this); //add action listener

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) { //void 
        Object obj = ae.getSource(); //create object
        try {
            if (obj == btnConfirm) { //confirm button
                String bikeId = txtBikeId.getText();
                String description = txtDescription.getText();
                String company = txtCompany.getText();
                String price = txtPrice.getText();
                String taxRate = txtTaxRate.getText();
                int intPrice = Integer.parseInt(price);
                int intTaxRate = Integer.parseInt(taxRate);
                if (description != "" && company != "" && taxRate != "") { //condition
                    BikeToSell sellBike = new BikeToSell(description, company, intPrice, intTaxRate);
                    BikeRentalUI.list.add(sellBike);
                    BikeRentalUI.count += 1; //add counter one
                    txtBikeId.setText(Integer.toString(BikeRentalUI.count)); //convert to string
                    txtDescription.setText("");
                    txtCompany.setText("");
                    txtPrice.setText(""); //set text empty
                    txtTaxRate.setText("");
                    JOptionPane.showMessageDialog(null,"The bike has been added for sale","Information Message",JOptionPane.INFORMATION_MESSAGE); //info message

                } 
                else {
                    JOptionPane.showMessageDialog(null, "Please, do not leave fields empty", "Error Message",JOptionPane.ERROR_MESSAGE);
                }
            } 
            else {
                txtDescription.setText(""); //set text empty
                txtPrice.setText("");
                txtTaxRate.setText("");
                txtCompany.setText("");
                JOptionPane.showMessageDialog(null, "All the field has been cleared!", "Error Message",JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (Exception e) { //exception
            JOptionPane.showMessageDialog(null, "Please, enter valid number!", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
}
