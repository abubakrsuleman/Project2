import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartUp implements ActionListener{
	static JFrame startUpFrame = new JFrame();
	static JPanel startUpPanel = new JPanel(null);
	static JLabel topBar = new JLabel("Inventory Management System",SwingConstants.CENTER);
	static JLabel welcomeLabel = new JLabel("Welcome");
	Color topFontColor = new Color(255,255,255);
	Color WelcomeTextColor = new Color(0,0,0);
	Font WelcomeFont = new Font("",Font.BOLD,20);
	Font topBarFont = new Font("",Font.BOLD,30);
	static ImageIcon exitIcon = new ImageIcon("./Images/Exit_Button.png");
	static JLabel backgroundUI = new JLabel();
	static JButton exitBtn = new JButton(exitIcon);
	static ImageIcon userIcon = new ImageIcon("./Images/user_Icon.png");
	static JLabel userIconLabel = new JLabel(userIcon);
	static ImageIcon adminIcon = new ImageIcon("./Images/admin_Icon.png");
	static JLabel adminIconLabel = new JLabel(adminIcon);
	static JButton userLoginBtn = new JButton("User Login");
	static JButton adminLoginBtn = new JButton("Admin Login");
	
	public StartUp() { //setting up StartUp Frame and Panel using Constructor Method
		
		startUpFrame.setTitle("Start Menu");
		startUpFrame.setSize(750,350);
		startUpFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	    
		startUpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		topBar.setBounds(1,1,750,40);
		startUpPanel.add(topBar);
		topBar.setOpaque(true);
		topBar.setBackground(Color.BLACK); //Black Background
		topBar.setForeground(topFontColor); //White Text
		topBar.setFont(topBarFont);
		
		welcomeLabel.setBounds(320,5,90,50);
		welcomeLabel.setForeground(WelcomeTextColor);
		welcomeLabel.setBackground(Color.WHITE); 
		welcomeLabel.setOpaque(true);
		welcomeLabel.setFont(WelcomeFont);
		backgroundUI.add(welcomeLabel);
		
		userIconLabel.setBounds(20,50,150,150);
		backgroundUI.add(userIconLabel);
		
		userLoginBtn.setBounds(30,230,130,30);
		userLoginBtn.addActionListener(this);
		userLoginBtn.setBackground(Color.BLACK);
		userLoginBtn.setForeground(Color.WHITE);
		userLoginBtn.setOpaque(true);
		backgroundUI.add(userLoginBtn);
		
		adminIconLabel.setBounds(20,50,1150,165);
		backgroundUI.add(adminIconLabel);
		
		adminLoginBtn.setBounds(525,230,130,30);
		adminLoginBtn.addActionListener(this);
		adminLoginBtn.setBackground(Color.BLACK);
		adminLoginBtn.setForeground(Color.WHITE);
		adminLoginBtn.setOpaque(true);
		backgroundUI.add(adminLoginBtn);
		
		backgroundUI.setBounds(1,30,750,750);
		backgroundUI.setOpaque(true);
		backgroundUI.setBackground(Color.WHITE); //White Background
		startUpPanel.add(backgroundUI);
		
		exitBtn.setBounds(700,1,35,40);
		exitBtn.addActionListener(this);
		startUpPanel.add(exitBtn);
		
		startUpFrame.add(startUpPanel);
		startUpFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		StartUp startUpGui = new StartUp();
	}

	@Override //add functions for clickable buttons
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== exitBtn) { //Exit Button Exits Program
			System.exit(0);
		}
		if(e.getSource() == userLoginBtn) {
			userLogin.main(null);
			startUpFrame.dispose();
		}
		
		if(e.getSource() == adminLoginBtn) {
			adminLogin.main(null);
			startUpFrame.dispose();
		}
	}

}
