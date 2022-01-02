
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class customerGUI implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    //JTable table = new JTable();
    JLabel cusLabel = new JLabel("Customer Page");
    JLabel movLable = new JLabel("Movies available");
    JButton profButton = new JButton("View Profile");
    JButton viewButton = new JButton("View Order");
    JButton editProfButton = new JButton("Edit Profile");
    JButton searchbynameButton = new JButton("Find Movie by name");
    JButton searchbycatButton = new JButton("Find Movie by Category");
    String user;
    JTable table;
    String[] columnNames = { "Title", "Category", "Date of Release", "Actors", "Directors", "Description",
    "Stock" };

    customerGUI(String username) {
    	user = username;
    	JLabel cusLabel = new JLabel("VideoCo Main Page");
    	frame.setSize(700, 700);
    	frame.setLayout(null);
    	frame.setVisible(true);
    	panel.setLayout(null);
    	panel.setSize(700,700);
    	frame.add(panel);
    	frame.setTitle("Customer Interface");
    	cusLabel.setBounds(250,10,200,30);
    	movLable.setBounds(300,170,100,30);
    	profButton.setBounds(525,50,150,30);
    	viewButton.setBounds(525,100, 150, 30);
    	editProfButton.setBounds(350, 50, 150, 30);
    	searchbynameButton.setBounds(525,425,150,30);
    	searchbycatButton.setBounds(300, 425, 200, 30);
    	
    	

        String[][] data = { 
                { "Venom: let There be Carnage","Action", "2021","Tom Hardy, Woody Harresion, Michelle Williams","Andy Serkis","Eddie Brock attempts to reignite his career by interviewing serial killer Cletus Kasady who becomes the host of the symbiote Carnage and escapes prison after a failed execution",
                	"5" }, 
                {
                "Iron Man","Adventure","2008","Robert Downey Jr,Jon Favreau,Gwyneth Paltrow,Don Cheadle","Jon Favreau","A billionaire industrialist and genius inventor, Tony Stark (Robert Downey Jr.), is conducting weapons tests overseas, but terrorists kidnap him to force him to build a devastating weapon. Instead, he builds an armored suit and upends his captors. Returning to America, Stark refines the suit and uses it to combat crime and terrorism.",
                		"8"},
                {
                "The Matrix","Sci-fi", "1999","Keanu Reeves,Carrie-Moss,Laurence Fishburne,Hugo Weaving","Lana Wachowski,Lilly Wachowski","Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix? Neo is contacted by Trinity (Carrie-Anne Moss), a beautiful stranger who leads him into an underworld where he meets Morpheus. They fight a brutal battle for their lives against a cadre of viciously intelligent secret agents. It is a truth that could cost Neo something more precious than his life.",
                		"15"},
                {
                "Get Out","Horror","2017","Daniel Kaluuya,Allison Williams,Bradley Whitford,LaKeith Stanfeild","Jordan Peele","Now that Chris and his girlfriend, Rose, have reached the meet-the-parents milestone of dating, she invites him for a weekend getaway upstate with her parents, Missy and Dean. At first, Chris reads the family's overly accommodating behaviour as nervous attempts to deal with their daughter's interracial relationship, but as the weekend progresses, a series of increasingly disturbing discoveries leads him to a truth that he never could have imagined.",
                		"10"},
                {
                "A Quite Place","Horror","2018","Emily Blunt,Millicent Simmonds,Millicent Simmonds,Noah Jupe,Cillian Murphy","John Krasinski","If they hear you, they hunt you. A family must live in silence to avoid mysterious creatures that hunt by sound. Knowing that even the slightest whisper or footstep can bring death, Evelyn and Lee are determined to find a way to protect their children while desperately searching for a way to fight back.",
                		"12"},
                {
                "No Time to Die","Action","2021","Daniel Craig,Lea Seydoux,Rami Malek,Lashana Lynch", "Cary Fukunaga","James Bond is enjoying a tranquil life in Jamaica after leaving active service. However, his peace is short-lived as his old CIA friend, Felix Leiter, shows up and asks for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond on the trail of a mysterious villain who's armed with a dangerous new technology.",
                		"3"},
                {
                "Shang-Chi and the Legend of the Ten Rings","Adventure","2021","Simu Liu,Awkwafina,Tony Leung Chiu-wai,Meng'er Zhang","Destin Daniel Cretton","Martial-arts master Shang-Chi confronts the past he thought he left behind when he's drawn into the web of the mysterious Ten Rings organization.",
                		"5"},
                {
                "Lord of the Rings Fellowship of Rings","Fantasy" ,"2001","Elijah Wood,Ian McKellen,Orlando Bloom,Viggo Mortensen","Peter Jackson", "The future of civilization rests in the fate of the One Ring, which has been lost for centuries. Powerful forces are unrelenting in their search for it. But fate has placed it in the hands of a young Hobbit named Frodo Baggins (Elijah Wood), who inherits the Ring and steps into legend. A daunting task lies ahead for Frodo when he becomes the Ringbearer - to destroy the One Ring in the fires of Mount Doom where it was forged."
                , "19"},
                {
                "Tenet","Sci-fi", "2020","Elizabeth Debicki,Robert Pattinson,John David Washington,Kenneth Branagh","Christopher Nolan", "A secret agent is given a single word as his weapon and sent to prevent the onset of World War III. He must travel through time and bend the laws of nature in order to be successful in his mission.",
                	"8"},
                {
                "Space Jam: A new Legacy","Fantasy", "2021","LeBron James,Michael B. Jordan,Cedric Joe,Zendaya","Malcolm D. Lee","Superstar LeBron James and his young son, Dom, get trapped in digital space by a rogue AI. To get home safely, LeBron teams up with Bugs Bunny, Daffy Duck and the rest of the Looney Tunes gang for a high-stakes basketball game against the AI's digitized champions of the court -- a powered-up roster called the Goon Squad.",
                	"14"}
         
        				};

                
        table = new JTable(data, columnNames);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 200, 670, 200);
      
        panel.add(movLable);
        panel.add(cusLabel);
        panel.add(sp);
       
        panel.add(profButton);
        panel.add(viewButton);
        panel.add(editProfButton);
        panel.add(searchbynameButton);
        panel.add(searchbycatButton);
       
        
        frame.setVisible(true);
        
       profButton.addActionListener(this);
       viewButton.addActionListener(this);
       editProfButton.addActionListener(this);
       searchbynameButton.addActionListener(this);
       searchbycatButton.addActionListener(this);

    }
    
       
 
 
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource()==profButton) {
		
		Customer c = Database.findCustomer(user);
		String out = "------------PROFILE------------\n"
				+ "Username: " + c.getUserName() + "\n"
				+ "Name: " + c.getName() + "\n" 
				+ "Email: " + c.getEmail() + "\n"
				+ "Password: " + c.getPassword() + "\n"
				+ "Loyalty Points: " + c.getLoyaltyPoints() + "\n"
				+ "Order: " + c.getOrder().toString();
		
		JOptionPane.showMessageDialog(frame,out);
	}
	
	else if(e.getSource()==viewButton) {
		Order o = Database.findCustomer(user).getOrder();

		String out = "------------ORDER------------\n"
					+"LateFee: " + o.getLateFee() + "\n"
					+"OrderID: " + o.getOrderID() + "\n"
					+"Price: " + o.getPrice() + "\n"
					+"Status: "+ o.getStatus() + "\n"
					+"Movies: " + o.toString();
		
		String[] options = {"Remove from Order","Cancel Order","Exit"};
		
		int x = JOptionPane.showOptionDialog(null,out, "Order View", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		 
		if(x==0) {
			
			String movName = JOptionPane.showInputDialog(null,"Enter movie to remove from order");
			
			if(!Database.movieCheck(movName))
				JOptionPane.showMessageDialog(null, "Movie not in Order");
			else {
				Movie mov = Database.findMovie(movName);
				o.removeMovie(mov);
				
				try {
					JOptionPane.showMessageDialog(null, "Movie removed");
					Database.update();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		}
		
		if(x==1) {
			if(o.clearOrder()) {
				JOptionPane.showMessageDialog(null, "Order cleared");
				
				try {
					Database.update();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Order cannot be shipped due to status:"+ o.getStatus());
			}
			
		}
		
		
		
		
		
		//JOptionPane.showMessageDialog(frame,out);
		
	}
	
	else if(e.getSource()==editProfButton) {
			
		Customer c = Database.findCustomer(user);
					Database.removeCustomer(c);	
		String newName = JOptionPane.showInputDialog(frame,"Enter new name");
			if(newName.length()>1) 
				c.setName(newName);
			
		
		String newUserName = JOptionPane.showInputDialog(frame,"Enter new Username");
			if(newUserName.length()>1) 
				c.setUserName(newUserName);
					
		
		String newpass = JOptionPane.showInputDialog(frame,"Enter new password");
			if(newpass.length()>1) 
				c.setPassword(newpass);
		
		String newmail = JOptionPane.showInputDialog(frame,"Enter new email");
			if(newmail.length()>1) 
				c.setEmail(newmail);
		
		String newaddy = JOptionPane.showInputDialog(frame,"Enter new address");
			if(newaddy.length()>1) 
				c.setShipping_billingInfo(newaddy);
		
			Database.addCustomer(c);
			
		try {
			Database.update();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		user = c.getUserName();
			
	}
	
	else if(e.getSource()==searchbynameButton) {
		
		String movName = JOptionPane.showInputDialog(frame,"Enter movie name");
		
		if(Database.findMovie(movName) != null) {
			
			Movie m = Database.findMovie(movName);
			
			//String[][] data = {{m.getTitle(),m.getCategory(),m.getActors().toString(),m.getDirectors().toString(),m.getDescription(),String.valueOf(m.getStock())}};
			
			String[] options = {"Add to Order","Exit"};
			
			int x = JOptionPane.showOptionDialog(null,"-----" + m.getTitle() + "-----\n" 
														+ "Category: " + m.getCategory() +"\n"
														+ "Actors: " + m.actStr() +"\n"
														+ "Directors: " + m.dirStr() + "\n"
														+ "Description: " + m.getDescription() + "\n"
														+ "Date of Release: " + m.getDateOfRelease(), "Movie Found!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			 
			if(x==0) {
				Customer c = Database.findCustomer(user);
				//Database.removeCustomer(c);
				if(!c.addToOrderList(m))
					JOptionPane.showMessageDialog(null, "Movie already in order list.");
				else {
				try {
					JOptionPane.showMessageDialog(null, "Movie successfully added to order list.");
					Database.update();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
			}
		
		else {
			JOptionPane.showMessageDialog(null,"Movie not found \nTry again.");
		}
		
		
	}
	
	else if(e.getSource()==searchbycatButton) {
		
		String[] options = {"Action","Adventure","Sci-fi","Horror","Fantasy"};
		int x = JOptionPane.showOptionDialog(null,"Select category to sort by:", "Category sort", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		
		
		java.util.List<Movie> out = Database.sortMovie(options[x]);
			
		String txt = "*******" + options[x] + " Movies******* \n";
			
		for(Movie m: out) 
			txt+= m.getTitle() + "\n";
		
		JOptionPane.showMessageDialog(null, txt);
			
			
			
		
		
	}


	
}

}
 

