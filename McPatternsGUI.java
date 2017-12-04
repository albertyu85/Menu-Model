import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;

class McPatternsGUI extends JFrame {
	McPatternsPresenter presenter;
	JTextArea totalDetails;
	JTextArea receiptDetails;
	private JButton cancel;
	private JButton confirm;
	String[] j;
	String d;
	public McPatternsGUI(McPatternsPresenter presenter) throws FileNotFoundException {

		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();
	}
	public void updateTotal()
	{

		j = d.split("\\s+");
		double total1 = 0;
		for (int i = 1; i < j.length; i++)
		{
			if (j[i].equals("|")){
				i++;
				String number = j[i];

				total1 = Double.parseDouble(number) + total1;

			}
		}

		totalDetails.setText("Total: " + "$" + Math.round(total1 * 100.0) / 100.0);
	}
	private void showGUI() throws FileNotFoundException {


		JFrame theFrame = new JFrame("Menu");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());

		JPanel title = new JPanel(new FlowLayout());
		title.add(new JLabel("Welcome"));

		JPanel orderPane = new JPanel();
		orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
		JLabel orderDetails = new JLabel("Your order");
		orderPane.setBorder(BorderFactory.createRaisedBevelBorder());
		orderPane.add(orderDetails);
		JTextField ccEntry = new JTextField("Enter CC #");
		receiptDetails = new JTextArea("Receipt: ");
		orderPane.add(receiptDetails);
		receiptDetails.setEditable(false);
		totalDetails = new JTextArea("Total: ");
		orderPane.add(totalDetails);
		totalDetails.setEditable(false);

		confirm = new JButton("Place Order");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreditCard1 a = CreditCard.createType(ccEntry.getText());
				


				if (a.getType().equals("Invalid"))
				{
					orderDetails.setText("Please Enter a Valid Credit Card Number");
				}
				else if (a.getType().equals("Discover"))
				{
					orderDetails.setText("Sorry. We do not accept Discover. Please try a different card.");
				}
				
				else if (receiptDetails.getText().equals("Receipt: "))
				{
					orderDetails.setText("Please Order Something before Placing Order");
				}
				else
				{
					cancel.setEnabled(false);
					confirm.setEnabled(false);

					for (int i = 0; i < presenter.items.size(); i++)
					{
						presenter.items.get(i).setEnabled(false);
					}

					orderDetails.setText("Order confrimed for " +  a.getType());
					System.out.println(a.getType()  + " <"+ a.getNumber()+ ">");
					System.out.println(d);
					System.out.println( totalDetails.getText());



				}
			}	
			});
		cancel = new JButton("Cancel Order");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderDetails.setText("Order cancelled");
				receiptDetails.setText("Receipt: ");
				totalDetails.setText("Total: ");
				ccEntry.setText("Enter CC #");
				theFrame.pack();
			}

		});
		orderPane.add(ccEntry);
		orderPane.add(confirm);
		orderPane.add(cancel);
		presenter.loadMenuItems();


		int a = presenter.items.size();

		for (int i = 0; i < a; i++)
		{
			int p = i;
			presenter.items.get(i).addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					int k = p;
					receiptDetails.append( "\n" + presenter.b.get(p) + " | " + presenter.a.get(p));
					d = receiptDetails.getText();
					updateTotal();
				}
			});
			presenter.buttonPanel.add(presenter.items.get(i));	
		}

		JScrollPane orderScroll = new JScrollPane(orderPane,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//orderScroll.setPreferredSize(new Dimension(250, 0));
		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(presenter.scroll, BorderLayout.CENTER);
		theFrame.add(orderScroll, BorderLayout.EAST);
		theFrame.setSize(800,600);
		theFrame.pack();
		theFrame.setVisible(true);

		}
	}

