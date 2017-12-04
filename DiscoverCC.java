
public class DiscoverCC implements CreditCard1{
private String number;
	public DiscoverCC(String number)
	{
		this.number = number;
	}
	public String getType()
	{
		return "Discover";
	}
	public String getNumber()
	{
		return number;
	}
	
}
