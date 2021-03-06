import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class adminLogin {
	static JFrame adminLoginFrame = new JFrame();
	static JPanel adminLoginPanel = new JPanel(null);
	
	static JLabel topBar = new JLabel("Admin Login",SwingConstants.CENTER);
	Font topBarFont = new Font("",Font.BOLD,30);
	Color topFontColor = new Color(255,255,255);
	static JLabel backgroundUI = new JLabel();
	static JLabel usernameLabel = new JLabel("Username");
	static JLabel passwordLabel = new JLabel("Password");
	
	static ImageIcon backBtnIcon = new ImageIcon("./Images/backBtn_icon.png");
	static JButton backToStartUpBtn = new JButton(backBtnIcon);
	
	static JTextField usernameField = new JTextField();
	static JPasswordField passwordField = new JPasswordField();
	Font LabelFont = new Font("",Font.BOLD,20);
	
	static JButton userLoginBtn = new JButton("Login");
	public adminLogin() {
		adminLoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		adminLoginFrame.setTitle("Inventory Management System");
		adminLoginFrame.setSize(300,300);
		adminLoginFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		backgroundUI.setBackground(Color.WHITE);
		backgroundUI.setOpaque(true);
		
		topBar.setBounds(1,1,300,40);
		adminLoginPanel.add(topBar);
		topBar.setOpaque(true);
		topBar.setBackground(Color.BLACK); //Black Background
		topBar.setForeground(topFontColor); //White Text
		topBar.setFont(topBarFont);
		
		usernameLabel.setFont(LabelFont);
		usernameLabel.setBounds(10,30,150,50);
		
		passwordLabel.setFont(LabelFont);
		passwordLabel.setBounds(10,90,150,50);
		
		usernameField.setBounds(120,45,150,20);
		
		passwordField.setBounds(120,110,150,20);
		
		
		userLoginBtn.setBounds(75,150,130,30);
		//userLoginBtn.addActionListener(this);
		userLoginBtn.setBackground(Color.BLACK);
		userLoginBtn.setForeground(Color.WHITE);
		userLoginBtn.setOpaque(true);
		backgroundUI.add(userLoginBtn);
		
		backToStartUpBtn.setBounds(1,1,35,40);
		backToStartUpBtn.setBackground(Color.BLACK);
	    //backToStartUpBtn.setOpaque(true);
		backToStartUpBtn.setBorderPainted(false);
		backToStartUpBtn.setFocusPainted(false);
		//exitBtn.addActionListener(this);
		adminLoginPanel.add(backToStartUpBtn);
		
		backgroundUI.add(usernameLabel);
		backgroundUI.add(passwordLabel);
		backgroundUI.add(usernameField);
		backgroundUI.add(passwordField);
		backgroundUI.add(userLoginBtn);
		
		
		
		backgroundUI.setBounds(1,30,750,750);
		
		adminLoginPanel.add(backgroundUI);
		adminLoginFrame.add(adminLoginPanel);
		adminLoginFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		adminLogin adminLoginGui = new adminLogin();
	}

}
