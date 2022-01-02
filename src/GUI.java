import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {
    private static JLabel userlabel;
    private static JTextField userText;
    private static JLabel passwordlabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        
        panel.setLayout(null);
        
        userlabel = new JLabel("User");
        /////////////////// x   y  width  height 
        userlabel.setBounds(10, 20,  80,    25);
        panel.add(userlabel);
        
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        //userText.setVisible(true);
        panel.add(userText);
        
        passwordlabel = new JLabel("Password");
        passwordlabel.setBounds(10,50,80,25);
        panel.add(passwordlabel);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        
        button = new JButton("Login");
        button.addActionListener(new GUI());
        button.setBounds(10,80,80,25);
        panel.add(button);
        
        success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);
        
        
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        String user = userText.getText();
        String password = passwordText.getText();
        
        
        if(user.equals("Shashwat") && password.equals("1234")) {
            success.setText("Login sucessful!");
        }
    }

}