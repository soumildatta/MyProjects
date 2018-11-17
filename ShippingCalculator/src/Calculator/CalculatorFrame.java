package Calculator;
import javax.swing.*;

import ShippingTypes.FlatRateShipping;
import ShippingTypes.ExpressShipping;
import ShippingTypes.ShippingCost;
import ShippingTypes.StandardShipping;

import java.awt.event.*;

public class CalculatorFrame extends JFrame
{
	//window size
	private final int WINDOW_WIDTH = 350;
	private final int WINDOW_HEIGHT = 200;
	
	private JPanel panel;
	private JLabel messageLabel;
	private JTextField weightTextField;
	private JRadioButton flatButton;
	private JRadioButton standardButton;
	private JRadioButton expressButton;
	private JButton calcButton;
	private ButtonGroup group;
	
	public CalculatorFrame()
	{
		setTitle("Shipping Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buildPanel();
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void buildPanel()
	{
		//weight input here
		messageLabel = new JLabel("Enter the weight of the item (lbs) ");
		weightTextField = new JTextField(10);
		
		//radio buttons for three shipping options
		flatButton = new JRadioButton("Flat rate: 6-8 business days");		
		standardButton = new JRadioButton("Standard shipping: 3-5 days");		
		expressButton = new JRadioButton("Express shipping: 1-2 days");
		
		//calculate button
		calcButton = new JButton("Calculate Shipping Cost");
		calcButton.addActionListener(new CalcButtonListener());
		
		group = new ButtonGroup();
		group.add(flatButton);
		group.add(standardButton);
		group.add(expressButton);
		
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(weightTextField);
		panel.add(flatButton);
		panel.add(standardButton);
		panel.add(expressButton);
		panel.add(calcButton);
	}
	
	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//retrieve text from text box
			String input = weightTextField.getText();

			if(flatButton.isSelected())
			{
				//try catch for non-numerical user input
				try
				{
					double weight = Double.parseDouble(input);
					
					ShippingCost shipping = new FlatRateShipping();
					double cost = shipping.getShippingCost(weight);
					String type = shipping.getLabel();
					
					JOptionPane.showMessageDialog(null, String.format("Shipping format:    %s"
							+ "\nShipping cost:        $%.2f", type, cost));
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "You have entered a non-numerical value\nPlease try again");
				}
			}
			else if(standardButton.isSelected())
			{
				//try catch for non-numerical user input
				try
				{
					double weight = Double.parseDouble(input);
					
					ShippingCost shipping = new StandardShipping();
					double cost = shipping.getShippingCost(weight);
					String type = shipping.getLabel();
					
					JOptionPane.showMessageDialog(null, String.format("Shipping format:    %s"
							+ "\nShipping cost:        $%.2f", type, cost));
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "You have entered a non-numerical value\nPlease try again");
				}
			}
			else if(standardButton.isSelected())
			{
				//try catch for non-numerical user input
				try
				{
					double weight = Double.parseDouble(input);
					
					ShippingCost shipping = new StandardShipping();
					double cost = shipping.getShippingCost(weight);
					String type = shipping.getLabel();
					
					JOptionPane.showMessageDialog(null, String.format("Shipping format:    %s"
							+ "\nShipping cost:        $%.2f", type, cost));
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "You have entered a non-numerical value\nPlease try again", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				//no option selected error message
				JOptionPane.showMessageDialog(null, "No option selected", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args)
	{
		//shift main to a different file later
		CalculatorFrame shipping = new CalculatorFrame();
		System.out.println("Executed");	
		
	}
}