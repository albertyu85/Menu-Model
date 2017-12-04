import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuModel {
	private File file;
	private ArrayList<String> options;
	private ArrayList<String> prices;
	private ArrayList<Double> prices1;
	
	public MenuModel(String a)
	{
		file = new File (a);
		options = new ArrayList<String>();
		prices = new ArrayList<String>();
		prices1 = new ArrayList<Double>();
		
	}
	public void readFile() throws FileNotFoundException
	{
		Scanner in = new Scanner(file);
		while(in.hasNextLine()){
			String a = in.nextLine();
			int line = 0;
			if (a.contains("|"))
			{
				line = a.indexOf("|");
				options.add(a.substring(0, line));
				prices.add(a.substring(line + 1, a.length()));	
			}
		}
	}
	public ArrayList<String> getOptions()
	{
		return options;
	}
	public ArrayList<Double> getPrices()
	{
		for (int i = 0; i < prices.size(); i++)
		{
			double a = Double.parseDouble(prices.get(i));
			prices1.add(a);
		}
		return prices1;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		MenuModel a = new MenuModel("file1.txt");
		a.readFile();
		ArrayList b = a.getPrices();
		System.out.println(b.size());
	
		for (int i = 0; i < b.size(); i++)
		{
			System.out.println(b.get(i));
		}
		
	}
}
