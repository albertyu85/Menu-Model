
public class InvalidCC implements CreditCard1 {
	private String number;
	public InvalidCC(String number)
	{
		this.number = number;
		
	}
	public String getType()
	{
		return "Invalid";
	}
	public String getNumber()
	{
		return number;
	}
}
