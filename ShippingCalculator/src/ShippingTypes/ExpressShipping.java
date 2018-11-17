package ShippingTypes;

public class ExpressShipping extends StandardShipping implements ShippingCost{
	private final double EXPRESS_FEE = 10;
	
	public double getShippingCost(double weight)
	{
		return super.getShippingCost(weight) + EXPRESS_FEE;
	}
	
	public String getLabel()
	{
		return "Express Shipping";
	}
}
