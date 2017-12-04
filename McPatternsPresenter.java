import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class McPatternsPresenter extends JFrame {
    MenuModel model;
    McPatternsGUI view;
    JPanel buttonPanel;
    ArrayList<JButton> items;
    ArrayList<Double> a;
    ArrayList<String> b;
    JScrollPane scroll;
 

    void loadMenuItems() throws FileNotFoundException {
    	model = new MenuModel("file1.txt");
    	model.readFile();
    	
    	 a = model.getPrices();
    	 b = model.getOptions();
    	items = new ArrayList<JButton>();
    	
    	buttonPanel = new JPanel();
    	scroll = new JScrollPane(buttonPanel);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    	for (int i = 0; i < b.size(); i++)
    	{
    		items.add (new JButton(b.get(i)));

    	}
    	
    	
   
    } 

    void attachView(McPatternsGUI view) {
        this.view = view;
      
    }

}