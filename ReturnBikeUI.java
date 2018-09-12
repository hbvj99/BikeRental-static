
/**
 * @author (your name)
 * @version v1.0
 */

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * This class extends JFrame class
 */
public class ReturnBikeUI extends JFrame implements ActionListener {

	//private attributes
	private JLabel lblReturnRentBike, lblBikeId;
	private JTextField txtBikeId;
	private JButton btnClear, btnConfirm;

	public ReturnBikeUI() {

		setTitle("Everest Motors: Return Rent Bike"); //title
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //close window
		setBounds(100, 100, 450, 300);
		setSize(509, 315);
		setLocationRelativeTo(null);
		setResizable(false);
		Container pane = getContentPane(); //container
		setLayout(null);

		lblReturnRentBike = new JLabel("Return Rent Bike");
		lblReturnRentBike.setFont(new Font("tahoma", Font.PLAIN, 23));
		lblReturnRentBike.setForeground(Color.BLUE);
		lblReturnRentBike.setBounds(161, 26, 177, 26);
		add(lblReturnRentBike);

		lblBikeId = new JLabel("Bike Id");
		lblBikeId.setBounds(106, 106, 60, 20);
		add(lblBikeId);

		txtBikeId = new JTextField();
		txtBikeId.setBounds(163, 101, 269, 30);
		add(txtBikeId);
		txtBikeId.addActionListener(this);

		btnClear = new JButton("Clear");
		btnClear.setBounds(187, 187, 115, 26);
		add(btnClear);
		btnClear.addActionListener(this);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(317, 187, 115, 26);
		add(btnConfirm);
		btnConfirm.addActionListener(this);

		setVisible(true); //set visible

	}

	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource(); //object
		try {
			if (obj == btnConfirm) {
				int index = Integer.parseInt(txtBikeId.getText()); 
				if(index>0 && index<BikeRentalUI.list.size()){ //condition
				BikeToRent bikeRent = (BikeToRent) BikeRentalUI.list.get(index - 1); //index minus one
				if (bikeRent.getBikeLoanStatus() == true) {
					bikeRent.bikeAvability();
					JOptionPane.showMessageDialog(null, "Bike is now available", "Information Message",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Bike is already available", "Information Message",JOptionPane.INFORMATION_MESSAGE);
				}
			} 
                       }
			else {
				txtBikeId.setText(""); //set text empty
				JOptionPane.showMessageDialog(null, "Field has been cleared!", "Information Message",JOptionPane.INFORMATION_MESSAGE);
			}
		} 
		catch (Exception e) { //exception e
			JOptionPane.showMessageDialog(null, "Sorry, Please enter valid number", "Error Message",JOptionPane.ERROR_MESSAGE);
		}
	}
}