//add submit button

package Calculator;
import javax.swing.*;

import ShippingTypes.FlatRateShipping;
import ShippingTypes.ExpressShipping;
import ShippingTypes.ShippingCost;
import ShippingTypes.StandardShipping;

import java.awt.event.*;

public class CalculatorFrame extends JFrame
{
	private final int WINDOW_WIDTH = 350;
	private final int WINDOW_HEIGHT = 200;
	
	private JPanel panel;
	private JLabel messageLabel;
	private JTextField weightTextField;
	private JRadioButton flatButton;
	private JRadioButton standardButton;
	private JRadioButton expressButton;
	private ButtonGroup group;
	
	public CalculatorFrame()
	{
		setTitle("Shipping Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		add(panel);
		setVisible(true);
	}
	
	private void buildPanel()
	{
		messageLabel = new JLabel("Enter the weight of the item (lbs) ");
		weightTextField = new JTextField(10);
		
		flatButton = new JRadioButton("Flat rate: 6-8 business days");
		flatButton.addActionListener(new RadioButtonListener());
		
		standardButton = new JRadioButton("Standard shipping: 3-5 days");
		standardButton.addActionListener(new RadioButtonListener());
		
		expressButton = new JRadioButton("Express shipping: 1-2 days");
		expressButton.addActionListener(new RadioButtonListener());
		
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
	}
	
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String input = weightTextField.getText();
			
			///
			if(flatButton.isSelected())
			{
				//add try catch for numberformatexception
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
				//add try catch for numberformatexception

				double weight = Double.parseDouble(input);
				
				ShippingCost shipping = new StandardShipping();
				double cost = shipping.getShippingCost(weight);
				String type = shipping.getLabel();
				
				JOptionPane.showMessageDialog(null, String.format("Shipping format:    %s"
						+ "\nShipping cost:        $%.2f", type, cost));
			}
			else
			{
				//add try catch for numberformatexception
				
				double weight = Double.parseDouble(input);
				
				ShippingCost shipping = new StandardShipping();
				double cost = shipping.getShippingCost(weight);
				String type = shipping.getLabel();
				
				JOptionPane.showMessageDialog(null, String.format("Shipping format:    %s"
						+ "\nShipping cost:        $%.2f", type, cost));
			}
		}
	}
	
	public static void main(String[] args)
	{
		//shift main to a different file later
		new CalculatorFrame();
		System.out.println("Executed");	
	}
}

