package ShippingTypes;

public class StandardShipping implements ShippingCost {
	private final double BASE_WEIGHT = 5;
	private final double BASE_CHARGE = 2.50;
	private final double EXTRA_POUND_RATE = 1;
	
	public double getShippingCost(double weight)
	{
		double total = 0;
		double difference = 0;
		double extraPounds;;
		
		if(weight <= 5)
		{
			total = weight * BASE_CHARGE;
		}
		else if(weight > 5)
		{
			difference = Math.floor(weight) - 5;
			total = (BASE_WEIGHT * BASE_CHARGE) + (difference * EXTRA_POUND_RATE);
			
		}
		return total;
	}
	
	public String getLabel()
	{
		return "Standard Shipping";
	}
}
