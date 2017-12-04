
public  class CreditCard {
	CreditCard1 a;
	private String number;

	public static CreditCard1 createType(String number)
	{
		for (int i = 0; i < number.length(); i++)
		{
			if (!Character.isDigit(number.charAt(i)))
			{
				CreditCard1 a = new InvalidCC(number);
				return a;
			}
		}
		if ( number.length() > 19 || number.length() < 13)
		{
			CreditCard1 a = new InvalidCC(number);
			return a;
		}

		else if (number.substring(0,1).equals("4")){
			if (number.length() == 13 || number.length() == 16)
			{
				CreditCard1 a = new VisaCC(number);
				return a ;
			}
		}
		else if (number.substring(0,1).equals("5"))
		{
			if (Integer.parseInt(number.substring(1,2)) <= 5 && Integer.parseInt(number.substring(1,2)) >= 1)
			{
				if (number.length() == 16)
				{
					CreditCard1 a = new MasterCC(number);
					return a ;
				}

			}
		}
		else if (number.substring(0,1).equals("3"))
		{
			if (number.substring(1,2).equals("4") || number.substring(1,2).equals("7") )
			{
				if (number.length() == 15)
				{
					CreditCard1 a = new AmExCC(number);
					return a ;
				}
			}
		}

		else if (number.substring(0,4).equals("6011"))
		{
			if (number.length() == 16)
			{
				CreditCard1 a = new DiscoverCC(number);
				return a;
			}
		}
		return null;



	}




}


/*protected String number;
public CreditCard(String number)
{
	this.number = number;
}
public boolean validateCardNumber() 
{
	if (isVisaCC() || isAmExCC() ||isMasterCC())
		return true;
	else
	{
		return false;
	}

} 	
public boolean isMasterCC()
{

	if (number.substring(0,1).equals("5"))
	{
		if (Integer.parseInt(number.substring(1,2)) <= 5 && Integer.parseInt(number.substring(1,2)) >= 1)
		{
			if (number.length() == 16)
				return true;
		}
	}
	return false;
}
public boolean isVisaCC()
{
	if (number.substring(0,1).equals("4"))
		if (number.length() == 13 || number.length() == 16)
			return true;
	return false;
}
public boolean isAmExCC()
{

	if (number.substring(0,1).equals("3"))
		if (number.substring(1,2).equals("4") || number.substring(1,2).equals("7") )
			if (number.length() == 15)
				return true;
	return false;
}
public boolean isDiscoverCC()
{

	if (number.substring(0,4).equals("6011"))
		if (number.length() == 16)
			return true;
	return false;
}
public String getType()
{
	return "Credit Card";
}
public String getNumber()
{
	return number;
}
}*/
