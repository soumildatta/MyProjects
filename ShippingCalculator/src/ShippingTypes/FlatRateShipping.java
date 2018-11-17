package ShippingTypes;

public class FlatRateShipping implements ShippingCost{
	private final double RATE_PER_POUND = 0.50;
	
	public double getShippingCost(double weight)
	{
		return weight * RATE_PER_POUND;
	}
	
	public String getLabel()
	{
		String str = "Flat Rate Shipping";
		return str;
	}
}
