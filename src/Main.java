import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main implements ActionListener {
    private static JLabel userlabel = new JLabel("Enter Username");
    private static JTextField userText = new JTextField(20);
    private static JLabel passwordlabel = new JLabel("Enter Password");
    private static JPasswordField passwordText = new JPasswordField(20);
    private static JButton loginbutton = new JButton("Login");
    private static JButton adminLoginbutton = new JButton("Login as admin");
    private static JButton newCustButton = new JButton("New Customer");
    private static JPanel p = new JPanel();
	private static JFrame f = new JFrame();

    
    Main() {
    	f.setSize(400,400);
    	f.setLayout(null);
    	f.setVisible(true);
    	p.setLayout(null);
    	p.setSize(400,400);
    	f.add(p);
    	f.setTitle("VideoCo Login");
    	userlabel.setBounds(50, 50, 100, 30);
    	userText.setBounds(150, 50, 150, 30);
    	passwordlabel.setBounds(50,100,100,30);
    	passwordText.setBounds(150,100,150,30);
    	loginbutton.setBounds(50, 200, 100, 30);
    	adminLoginbutton.setBounds(175,200,125,30);
    	newCustButton.setBounds(50, 250, 250, 30);
    	    	
    	
    	
    	p.add(userlabel);
    	p.add(userText);
    	p.add(passwordlabel);
    	p.add(passwordText);
    	p.add(loginbutton);
    	p.add(adminLoginbutton);
    	p.add(newCustButton);
    	
    	f.setVisible(true);
    	
    	loginbutton.addActionListener(this);
    	adminLoginbutton.addActionListener(this);
    	newCustButton.addActionListener(this);
    	
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	
    	try {
			Database.load();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	if(e.getSource()==loginbutton) {
    		
    		String userName;
    		String userPass;
    		userName = userText.getText();
    		userPass = passwordText.getText();
    		
    		   		
    		if(Database.isCustomer(userName, userPass)) { 
    			//JOptionPane.showMessageDialog(f, "LOGIN SUCCESSFULL!");
    			f.dispose(); 
    			new customerGUI(userName);
    		}
    		else 
    			JOptionPane.showMessageDialog(f, "Invalid Username/password");
    	}
    	
    	else if(e.getSource()==adminLoginbutton) {
    		
    		
    		String userName;
    		String userPass;
    		userName = userText.getText();
    		userPass = passwordText.getText();
    		
    			if(Database.isAdmin(userName, userPass)) {
					f.dispose();
    				new adminGUI(userName);
    			}
				else 
					JOptionPane.showMessageDialog(f, "Invalid Admin Username/password");
			
    	}
    	
    	else if(e.getSource()==newCustButton) {
    		String userName,name,password,email,shippingInfo,payment;
    		
    		name = JOptionPane.showInputDialog(f, "Welcome to VideoCo!\nEnter your name:");
    		userName = JOptionPane.showInputDialog(f, "Enter your username:");
    		password = JOptionPane.showInputDialog(f, "Enter your Password:");
    		email = JOptionPane.showInputDialog(f, "Enter your Email:");
    		
    		if(!Database.isUnique(userName, email))
    			JOptionPane.showMessageDialog(f, "Invalid username/email!\nTry again");
    		else {
    		
    		shippingInfo = JOptionPane.showInputDialog(f, "Enter your Location:");
    		payment = JOptionPane.showInputDialog(f,"Enter your payment service:");
			
    		
    		 Customer c = new Customer();
    		c.setUserName(userName);
    		c.setName(name);
    		c.setPassword(password);
    		c.setEmail(email);
    		c.setLoyaltyPoints(0);
    		c.setShipping_billingInfo(shippingInfo);
    		c.setPaymentService(payment);
    		Order o = new Order();
    		c.setOrder(o);
    		Database.addCustomer(c);
    		Database.addOrder(o);
    		
    		try {
				Database.update();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		JOptionPane.showMessageDialog(f,"New user created.\nPlease log in using main page");
    		}
    	}
    		
    	}
    

    public static void main(String[] args) {
    	
    	new Main();

}
}