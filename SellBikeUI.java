/**
 * @author Vijay Pathak
 * @version v1.0
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
/**
 * This class extends JFrame Class
 */
public class SellBikeUI extends JFrame implements ActionListener {
	private JLabel lblSellBike,lblBikeId,lblDescription,lblCustomerName,lblContact,lblSellDate,lblPrice,lblTotalAmount,lblCompany,lblEmail,lblTaxRate; // private attributes
	private JTextField txtBikeId,txtDescription,txtCustomerName,txtContact,txtSellDate,txtPrice,txtTotalAmount,txtCompany,txtEmail,txtTaxRate;
	private JButton btnCheck,btnClear,btnConfirm;

	public SellBikeUI() {

		setTitle("Everest Motors: Sell Bike"); //title
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //close operation
		setLocationRelativeTo(null);
		setResizable(false); //resizable 
		setBounds(100, 100, 450, 300);
		setSize(720, 480);
		setLocationRelativeTo(null); //frame location
		setResizable(false);
		Container pane = getContentPane();
		setLayout(null);

		lblSellBike = new JLabel("Sell Bike"); //sell bike label
		lblSellBike.setFont(new Font("tahoma", Font.PLAIN, 27));
		lblSellBike.setForeground(Color.BLUE);
		lblSellBike.setBounds(312, 28, 104, 32);
		add(lblSellBike);

		lblBikeId = new JLabel("Bike Id");
		lblBikeId.setBounds(32, 103, 69, 20);
		add(lblBikeId);

		lblDescription = new JLabel("Description");
		lblDescription.setBounds(32, 151, 69, 20);
		add(lblDescription);

		lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(32, 200, 104, 20);
		add(lblCustomerName);

		lblContact = new JLabel("Contact");
		lblContact.setBounds(32, 248, 69, 20);
		add(lblContact);

		lblSellDate = new JLabel("Sell Date");
		lblSellDate.setBounds(32, 296, 69, 20);
		add(lblSellDate);

		lblPrice = new JLabel("Price");
		lblPrice.setBounds(400, 103, 69, 20);
		add(lblPrice);

		lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(400, 151, 102, 20);
		add(lblTotalAmount);

		lblCompany = new JLabel("Company");
		lblCompany.setBounds(400, 200, 69, 20);
		add(lblCompany);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(400, 248, 69, 20);
		add(lblEmail);

		lblTaxRate = new JLabel("TaxRate(%)");
		lblTaxRate.setBounds(400, 296, 69, 20);
		add(lblTaxRate);

		txtBikeId = new JTextField();
		txtBikeId.setBounds(151, 97, 146, 32);
		add(txtBikeId);
		txtBikeId.addActionListener(this);

		txtDescription = new JTextField();
		txtDescription.setBounds(151, 145, 146, 32);
		add(txtDescription);
		txtDescription.addActionListener(this);
		txtDescription.setEnabled(false);

		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(151, 194, 146, 32);
		add(txtCustomerName);
		txtCustomerName.addActionListener(this);

		txtContact = new JTextField();
		txtContact.setBounds(151, 242, 146, 32);
		add(txtContact);
		txtContact.addActionListener(this);

		txtSellDate = new JTextField();
		txtSellDate.setBounds(151, 290, 146, 32);
		add(txtSellDate);
		txtSellDate.addActionListener(this);

		txtPrice = new JTextField();
		txtPrice.setBounds(517, 97, 146, 32);
		add(txtPrice);
		txtPrice.addActionListener(this);
		txtPrice.setEnabled(false);

		txtTotalAmount = new JTextField();
		txtTotalAmount.setBounds(517, 145, 146, 32);
		add(txtTotalAmount);
		txtTotalAmount.addActionListener(this);

		txtCompany = new JTextField();
		txtCompany.setBounds(517, 194, 146, 32);
		add(txtCompany);
		txtCompany.addActionListener(this);
		txtCompany.setEnabled(false);

		txtEmail = new JTextField();
		txtEmail.setBounds(517, 242, 146, 32);
		add(txtEmail);
		txtEmail.addActionListener(this);

		txtTaxRate = new JTextField(); //
		txtTaxRate.setBounds(517, 290, 146, 32);
		add(txtTaxRate);
		txtTaxRate.addActionListener(this);
		txtTaxRate.setEnabled(false);

		btnClear = new JButton("Clear");
		btnClear.setBounds(417, 351, 115, 39);
		add(btnClear);
		btnClear.addActionListener(this);

		btnCheck = new JButton("Check");
		btnCheck.setBounds(287, 351, 115, 39);
		add(btnCheck);
		btnCheck.addActionListener(this);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(548, 351, 115, 39);
		add(btnConfirm);
		btnConfirm.addActionListener(this); //add action listener

		setVisible(true); //visible 

	}
	
	public void actionPerformed(ActionEvent ae) { //actionevent
		Object obj = ae.getSource(); //object
		try {
			if (obj == btnCheck) {
				int index = Integer.parseInt(txtBikeId.getText()); //convert into integer
				BikeToSell sellBike = (BikeToSell) BikeRentalUI.list.get(index - 1); //index minus one
				if (sellBike.getSellingStatus() == false) {

					JOptionPane.showMessageDialog(null, "Bike is available", "",JOptionPane.INFORMATION_MESSAGE); //message
					txtDescription.setText(sellBike.getDescription());
					String pr = Integer.toString(sellBike.getPrice());
					txtPrice.setText(pr);
					String tx = Integer.toString(sellBike.getTaxAmount()); //convert to string
					txtTaxRate.setText(tx);
					txtCompany.setText(sellBike.getManufacturer());

					int tot = Integer.parseInt(txtTaxRate.getText()) + Integer.parseInt(txtPrice.getText());
					txtTotalAmount.setText(Integer.toString(tot));

				} else {
					JOptionPane.showMessageDialog(null, "Sorry, Please enter valid number", "Information Message",JOptionPane.ERROR_MESSAGE);
				}
			} else if (obj == btnConfirm) { //confirm button
				String customerName = txtCustomerName.getText();
				String contact = txtContact.getText();
				String email = txtEmail.getText();
				String sellingDate = txtSellDate.getText();
				if (!customerName.equals("") && !contact.equals("") && !email.equals("") && !sellingDate.equals("")) {
					int index = Integer.parseInt(txtBikeId.getText());
					BikeToSell sellBike = (BikeToSell) BikeRentalUI.list.get(index - 1);
					sellBike.sellingBike(customerName, contact, email, sellingDate);
					txtBikeId.setText("");
					txtDescription.setText("");
					txtCustomerName.setText("");
					txtContact.setText("");
					txtSellDate.setText("");
					txtPrice.setText("");
					txtTotalAmount.setText("");
					txtCompany.setText("");
					txtEmail.setText("");
					txtTaxRate.setText("");
					JOptionPane.showMessageDialog(null,"The bike has been selled","Information Message",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Please don't leave fields blanked","Error Message",JOptionPane.ERROR_MESSAGE);
				}
			} else if (obj == btnClear) {
				txtBikeId.setText(""); //set all text empty
				txtDescription.setText("");
				txtCustomerName.setText("");
				txtContact.setText("");
				txtSellDate.setText("");
				txtPrice.setText("");
				txtTotalAmount.setText("");
				txtCompany.setText("");
				txtEmail.setText("");
				txtTaxRate.setText("");
				JOptionPane.showMessageDialog(null, "All the fields has been cleared!", "Information Message",JOptionPane.INFORMATION_MESSAGE);
			}
		} catch(Exception e) { //exception
			JOptionPane.showMessageDialog(null, "Please enter valid numbers", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
}