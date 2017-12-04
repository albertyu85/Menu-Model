
public class VisaCC implements CreditCard1 {
private String number;
	public VisaCC(String number)
	{
		this.number = number;
	}
	public String getType()
	{
		return "Visa";
	}
	public String getNumber()
	{
		return number;
	}
}
