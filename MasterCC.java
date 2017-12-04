
public class MasterCC implements CreditCard1{
	private String number;
	public MasterCC(String number)
	{
		this.number = number;
		
	}
	public String getType()
	{
		return "MasterCard";
	}
	public String getNumber()
	{
		return number;
	}
	
}
