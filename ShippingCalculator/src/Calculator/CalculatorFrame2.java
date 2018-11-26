package Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;

public class CalculatorFrame2 {

	private JFrame frmShippingCalculator;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					CalculatorFrame2 window = new CalculatorFrame2();
					window.frmShippingCalculator.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorFrame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShippingCalculator = new JFrame();
		frmShippingCalculator.setTitle("Shipping Calculator");
		frmShippingCalculator.setBounds(100, 100, 271, 430);
		frmShippingCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShippingCalculator.getContentPane().setLayout(null);
		
		JLabel lblEnterTheWeight = new JLabel("Enter the weight of the object (lbs)");
		lblEnterTheWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterTheWeight.setBounds(47, 11, 229, 14);
		frmShippingCalculator.getContentPane().add(lblEnterTheWeight);
		
		textField = new JTextField();
		textField.setBounds(83, 30, 156, 20);
		frmShippingCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSelectYourShipping = new JLabel("Select your shipping type");
		lblSelectYourShipping.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectYourShipping.setBounds(83, 74, 162, 14);
		frmShippingCalculator.getContentPane().add(lblSelectYourShipping);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Flat rate: 6-8 business days");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(60, 95, 219, 23);
		frmShippingCalculator.getContentPane().add(rdbtnNewRadioButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 290, 2);
		frmShippingCalculator.getContentPane().add(separator);
		
		JRadioButton rdbtnStandardShipping = new JRadioButton("Standard shipping: 3-5 days");
		buttonGroup.add(rdbtnStandardShipping);
		rdbtnStandardShipping.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnStandardShipping.setBounds(60, 121, 189, 23);
		frmShippingCalculator.getContentPane().add(rdbtnStandardShipping);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Express shipping: 1-2 days");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(60, 147, 175, 23);
		frmShippingCalculator.getContentPane().add(rdbtnNewRadioButton_1);
	}
}
