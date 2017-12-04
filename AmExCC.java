
public class AmExCC implements CreditCard1{
	private String number;
	public AmExCC(String number)
	{
		this.number = number;
	}
	public String getType()
	{
		return "American Express";
	}
	public String getNumber()
	{
		return number;
	}
}
