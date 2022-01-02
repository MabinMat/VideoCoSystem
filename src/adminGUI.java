import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class adminGUI implements ActionListener {
	 JFrame frame = new JFrame();
	 JPanel panel = new JPanel();
	JLabel adminLabel = new JLabel("Admin Page");
	JButton movButton = new JButton("Add Movie");
	JButton custButton = new JButton("Add Customer");
	JButton moveditButton = new JButton("Edit Movie");
	JButton custeditButton = new JButton("Edit Customer");
	JButton movdelButton = new JButton("Delete Movie");
	JButton custdelButton = new JButton("Delete Customer");
	String user;
	JTable movtable;
	JTable custable;
	String[] movcolumnNames = { "Title", "Category", "Date of Release", "Actors", "Directors", "Description",
    "Stock" };
	String[][] movData = { 
            { "Venom: let There be Carnage","Action", "2021","Tom Hardy, Woody Harresion, Michelle Williams","Andy Serkis","Eddie Brock attempts to reignite his career by interviewing serial killer Cletus Kasady who becomes the host of the symbiote Carnage and escapes prison after a failed execution",
            	"5" }, 
            {
            "Iron Man","Adventure","2008","Robert Downey Jr,Jon Favreau,Gwyneth Paltrow,Don Cheadle","Jon Favreau","A billionaire industrialist and genius inventor, Tony Stark (Robert Downey Jr.), is conducting weapons tests overseas, but terrorists kidnap him to force him to build a devastating weapon. Instead, he builds an armored suit and upends his captors. Returning to America, Stark refines the suit and uses it to combat crime and terrorism.",
            		"8"},
            {
            "The Matrix","Sci-fi", "1999","	Keanu Reeves,Carrie-Moss,Laurence Fishburne,Hugo Weaving","Lana Wachowski,Lilly Wachowski","Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix? Neo is contacted by Trinity (Carrie-Anne Moss), a beautiful stranger who leads him into an underworld where he meets Morpheus. They fight a brutal battle for their lives against a cadre of viciously intelligent secret agents. It is a truth that could cost Neo something more precious than his life.",
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
            "Lord of the Rings Fellowship of Rings","Fantasy" ,"2001",	"Elijah Wood,Ian McKellen,Orlando Bloom,Viggo Mortensen","Peter Jackson", "The future of civilization rests in the fate of the One Ring, which has been lost for centuries. Powerful forces are unrelenting in their search for it. But fate has placed it in the hands of a young Hobbit named Frodo Baggins (Elijah Wood), who inherits the Ring and steps into legend. A daunting task lies ahead for Frodo when he becomes the Ringbearer - to destroy the One Ring in the fires of Mount Doom where it was forged."
            , "19"},
            {
            "Tenet","Sci-fi", "2020","Elizabeth Debicki,Robert Pattinson,John David Washington,Kenneth Branagh",	"Christopher Nolan", "A secret agent is given a single word as his weapon and sent to prevent the onset of World War III. He must travel through time and bend the laws of nature in order to be successful in his mission.",
            	"8"},
            {
            "Space Jam: A new Legacy","Fantasy", "2021","LeBron James,Michael B. Jordan,Cedric Joe,Zendaya","Malcolm D. Lee","Superstar LeBron James and his young son, Dom, get trapped in digital space by a rogue AI. To get home safely, LeBron teams up with Bugs Bunny, Daffy Duck and the rest of the Looney Tunes gang for a high-stakes basketball game against the AI's digitized champions of the court -- a powered-up roster called the Goon Squad.",
            	"14"}
     
    				};
	
	String[] cuscolumnNames = { "Name", "User", "Email","Password", "Loyalty Points", "Shipping Info", "OrderID"};
	
	String[][] cusData = {{ "Mike Wazuski", "WazuM","MikeW@gmail.com","mw123", "4","Missussauga","XM23W3"},
							{"Igor Nyet","IgNy","Nyet.Igor@gmail.com","ruswes","5","Toronto","QW23R4"},
							{"Cleetus McKeneddy","CleetMc","McKenTheMan@gmail.com","CleMck345","5","Toronto","TY56U8"},
							{"Mathew Sebastian","mSebt","myemail@gmail.com","45t234235","34","Toronto","ZX76U9"},
							{"Jaskaran Singh","daBoi45","JaskySingh@gmail.com","password","2","Brampton","AQ14E3"},
							{"Jacques Frontier","JackF","JacquesFront@gmail.com","jackedAsf","20","Montreal","VE14E3"},
							{"Terry Crews","MuscleMan","Muscleman@gmail.com","i<3muscles","8","Alberta","WV55W2"},
							{"Philip Jordan","PJuserName","Philipjordan@gmail.com","PJ123","9","Scarborough","GR23R4"},
							{"Dan Espinoza","DanTheMan","DanMan@gmail.com","yeet345","14","Brampton","HJ12R5"},
							{"Mathew Thadius","MattThad","mattThad@gmail.com","MT123","1","Brampton","VE11E1"}
							};
	
adminGUI(String username){
	user = username;
	//JLabel cusLabel = new JLabel("VideoCo Main Page");
	frame.setSize(700, 700);
	frame.setLayout(null);
	frame.setVisible(true);
	panel.setLayout(null);
	panel.setSize(700,700);
	frame.add(panel);
	frame.setTitle("Admin Interface");
	
	adminLabel.setBounds(250,10,200,30);
	movButton.setBounds(525,50,150,30);
	moveditButton.setBounds(350, 50, 150, 30);
	custButton.setBounds(525,100, 150, 30);
	custeditButton.setBounds(350, 100, 150, 30);
	movdelButton.setBounds(175, 50, 150, 30);
	custdelButton.setBounds(175, 100, 150, 30);
	
	movtable = new JTable(movData, movcolumnNames);
    JScrollPane sp = new JScrollPane(movtable);
    sp.setBounds(10, 200, 670, 200);
    
    custable = new JTable(cusData, cuscolumnNames);
    JScrollPane sp2 = new JScrollPane(custable);
    sp2.setBounds(10, 425, 670, 200);
    

    panel.add(adminLabel);
    panel.add(movButton);
    panel.add(custButton);
    panel.add(custeditButton);
    panel.add(moveditButton);
    panel.add(movdelButton);
    panel.add(custdelButton);
    
    
    panel.add(sp2);
    panel.add(sp);
    panel.add(sp2);
	
    frame.setVisible(true);
    
    movButton.addActionListener(this); 
	custButton.addActionListener(this);
	custeditButton.addActionListener(this);
	moveditButton.addActionListener(this);
	movdelButton.addActionListener(this);
	custdelButton.addActionListener(this);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Admin admin = Database.findAdmin(user);
		
		if(e.getSource()==movButton) {
			String title,category,dateOfRelease,actors,directors,description,stock;
			title=JOptionPane.showInputDialog(frame,"Enter  movie title");
			category=JOptionPane.showInputDialog(frame,"Enter  Category");
			dateOfRelease=JOptionPane.showInputDialog(frame,"Enter  Date of release");
			actors=JOptionPane.showInputDialog(frame,"Enter actors seperated by a list of commas");
			directors=JOptionPane.showInputDialog(frame,"Enter directors seperated by a list of commas");
			description=JOptionPane.showInputDialog(frame,"Enter description");
			stock=JOptionPane.showInputDialog(frame,"Enter stock");
			
			
			String[] arrOfActors = actors.split(",");
			List<String> actorsOut = new ArrayList<String>();
			
			for(String a:arrOfActors)
				actorsOut.add(a);
			
			String[] arrOfdirs = directors.split(",");
			List<String> dirsOut = new ArrayList<String>();
			
			for(String d:arrOfdirs)
				dirsOut.add(d);
			
			Movie out = new Movie();
			out.setTitle(title);
			out.setCategory(category);
			out.setDateOfRelease(Integer.valueOf(dateOfRelease));
			out.setActors(actorsOut);
			out.setDirectors(dirsOut);
			out.setDescription(description);
			out.setStock(Integer.valueOf(stock));
			Database.addMovie(out);
			
			try {
				Database.update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(frame, "Movie added succesfully");
		}
		
		if(e.getSource()==custButton) {
			String newUsername,newName,newPass,newEmail,newLP,newOrder;
			newUsername=JOptionPane.showInputDialog(frame,"Enter new username");
			newName=JOptionPane.showInputDialog(frame,"Enter new name");
			newPass=JOptionPane.showInputDialog(frame,"Enter new password");
			newEmail=(JOptionPane.showInputDialog(frame,"Enter new email"));
			newLP=JOptionPane.showInputDialog(frame,"Enter new Loyalty Points");
			newOrder=JOptionPane.showInputDialog(frame,"Enter new OrderID");
			
			Order orderOut = new Order();
			orderOut.setOrderID(newOrder);
			
			Customer c = new Customer();
			c.setUserName(newUsername);
			c.setName(newName);
			c.setPassword(newPass);
			c.setEmail(newEmail);
			c.setLoyaltyPoints(Integer.valueOf(newLP));
			c.setOrder(orderOut);
			Database.addCustomer(c);
			
			try {
				Database.update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(frame, newName + "'s Information added succesfully");
			
			}
		
		if(e.getSource()==moveditButton) {
			String currtitle,title,category,actors,directors,description,dateOfRelease,stock;
	
			
			currtitle = JOptionPane.showInputDialog(frame,"Enter Movie name to edit:");
			
			
			if(!Database.movieCheck(currtitle))
				JOptionPane.showMessageDialog(frame, "Movie not found");
			else {
			Movie m = Database.findMovie(currtitle);
			title=JOptionPane.showInputDialog(frame,"Enter new Title");
			category=JOptionPane.showInputDialog(frame,"Enter new Category");
			dateOfRelease=JOptionPane.showInputDialog(frame,"Enter new Date of Release");
			actors=JOptionPane.showInputDialog(frame,"Enter new Actors seperated by commas");
			directors=JOptionPane.showInputDialog(frame,"Enter new Directors seperated by commas");
			description=JOptionPane.showInputDialog(frame,"Enter new description");
			stock=JOptionPane.showInputDialog(frame,"Enter new stock");
			
			if(dateOfRelease.equals("")) 
				dateOfRelease = String.valueOf(m.getDateOfRelease());
			if(stock.equals(""))
				stock = String.valueOf(m.getStock());
			
			List<String> actorsOut = new ArrayList<String>();
			
			if(!actors.equals("")) {
				String[] arrOfActors = actors.split(",");
						
				for(String a:arrOfActors)
					actorsOut.add(a);
			}
			List<String> dirsOut = new ArrayList<String>();
			if(!directors.equals("")) {
				String[] arrOfdirs = directors.split(",");
				
				for(String d:arrOfdirs)
					dirsOut.add(d);
			}
			
			admin.updateMovie(currtitle, title, category,Integer.valueOf(dateOfRelease), actorsOut, dirsOut, description,Integer.valueOf(stock));
			
			try {
				Database.update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(frame, "Movie updated succesfully");
			}
			
		}
		
		if(e.getSource()==custeditButton) {
			String currUsername,newUsername,newName,newPass,newEmail,newLP,newOrder;
			
			currUsername = JOptionPane.showInputDialog(frame,"Enter curr username");
			if(!Database.customerCheck(currUsername))
				JOptionPane.showMessageDialog(frame, "No User found");
			else {
				Customer c = Database.findCustomer(currUsername);
				newUsername=JOptionPane.showInputDialog(frame,"Enter new username");
				newName=JOptionPane.showInputDialog(frame,"Enter new name");
				newPass=JOptionPane.showInputDialog(frame,"Enter new password");
				newEmail=(JOptionPane.showInputDialog(frame,"Enter new email"));
				newLP=JOptionPane.showInputDialog(frame,"Enter new Loyalty Points");
				newOrder=JOptionPane.showInputDialog(frame,"Enter new OrderID");
				
				if(newLP.equals(""))
					newLP = String.valueOf(c.getLoyaltyPoints());
				
				Order orderOut = new Order();
				orderOut.setOrderID(newOrder);
				
				admin.updateCustomer(currUsername, newUsername, newName, newPass, newEmail, Integer.valueOf(newLP), orderOut);
				try {
					Database.update();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, newName + "'s Information updated succesfully");
				
				
			
			}
			}
	
	if(e.getSource()==custdelButton) {
		String username = JOptionPane.showInputDialog(null,"Enter username to delete:");
		
		if(Database.customerCheck(username)) {
			
			Customer c = Database.findCustomer(username);
			Order o = Database.findOrder(c.getOrder().getOrderID());
			
			Database.removeCustomer(c);
			Database.removeOrder(o);
			
			JOptionPane.showMessageDialog(frame,"Customer removed succesfully");
			
			try {
				Database.update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else 
			JOptionPane.showMessageDialog(frame,"Customer not found");
		
		
	}
	
	if(e.getSource()==movdelButton) {
		String movname = JOptionPane.showInputDialog(null,"Enter movie to delete:");
		
		if(Database.movieCheck(movname)) {
			
			Movie m = Database.findMovie(movname);
			
			Database.removeMovie(m);
			JOptionPane.showMessageDialog(frame,"Movie removed succesfully");
			
			try {
				Database.update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}
	
	}

}
