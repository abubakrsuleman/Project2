import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
public class userLogin implements ActionListener {
	static Connection conn = DatabaseConnection.connect();
	PreparedStatement pst = null;
	static JFrame userLoginFrame = new JFrame();
	static JPanel userLoginPanel = new JPanel(null);
	
	static JLabel topBar = new JLabel("User Login",SwingConstants.CENTER);
	Font topBarFont = new Font("",Font.BOLD,30);
	Color topFontColor = new Color(255,255,255);
	static JLabel backgroundUI = new JLabel();
	static JLabel usernameLabel = new JLabel("Username");
	static JLabel passwordLabel = new JLabel("Password");
	
	static ImageIcon backBtnIcon = new ImageIcon("./Images/backBtn_icon.png");
	static JButton backToStartUpBtn = new JButton(backBtnIcon);
	
	static JTextField usernameField = new JTextField();
	static JPasswordField passwordField = new JPasswordField();
	
	static JLabel loginBoxRounded = new JLabel();
	static ImageIcon userIcon = new ImageIcon("./Images/user_Icon.png");
	static JLabel userIconBigLabel = new JLabel(userIcon);
	Font LabelFont = new Font("",Font.BOLD,20);
	
	static JButton userLoginBtn = new JButton("Login");
	public userLogin() {
		userLoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		userLoginFrame.setTitle("Inventory Management System");
		userLoginFrame.setSize(700,300);
		userLoginFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		backgroundUI.setBackground(Color.WHITE);
		backgroundUI.setOpaque(true);
		
		topBar.setBounds(1,1,700,40);
		userLoginPanel.add(topBar);
		topBar.setOpaque(true);
		topBar.setBackground(Color.BLACK); //Black Background
		topBar.setForeground(topFontColor); //White Text
		topBar.setFont(topBarFont);
		
		usernameLabel.setFont(LabelFont);
		usernameLabel.setBounds(200,30,150,50);
		
		passwordLabel.setFont(LabelFont);
		passwordLabel.setBounds(200,90,150,50);
		
		usernameField.setBounds(300,45,150,20);
		
		passwordField.setBounds(300,110,150,20);
		
		
		userLoginBtn.setBounds(300,150,130,30);
		userLoginBtn.addActionListener(this);
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
		userLoginPanel.add(backToStartUpBtn);
		
	//	loginBoxRounded.setBounds(200,20,300,200);
		loginBoxRounded.setBounds(90,20,500,200);
		loginBoxRounded.setBackground(Color.GRAY);
		loginBoxRounded.setOpaque(true);
		
		userIconBigLabel.setBounds(25,20,150,150);
		
		loginBoxRounded.add(usernameLabel);
		loginBoxRounded.add(passwordLabel);
		loginBoxRounded.add(usernameField);
		loginBoxRounded.add(passwordField);
		loginBoxRounded.add(userLoginBtn);
		loginBoxRounded.add(userIconBigLabel);
		
		backgroundUI.add(loginBoxRounded);
		backgroundUI.setBounds(1,30,700,700);
		
		userLoginPanel.add(backgroundUI);
		userLoginFrame.add(userLoginPanel);
		userLoginFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userLogin userLoginGui = new userLogin();
		/*
		try {         
			//write code here!
			int ID = 1;
			String username = "Jacob01";
			String password = "pass";
			String firstname = "Jacob";
			String surname = "James";
			boolean isBasicUser = false;
			
	        String sql = "INSERT INTO UserLogin(ID,Username,Password,Firstname,Surname,isBasicUser) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ID); // we dont need this as we have defined this field as auto-increment and not null
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, firstname);
			pstmt.setString(5, surname);
			pstmt.setBoolean(6,isBasicUser);           
			pstmt.executeUpdate();
        }catch(Exception e) {
        	
        } 
		*/
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == userLoginBtn) {
			
			try {
				String sql = "select * from UserLogin where Username = ? & Password = ?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, usernameField.getText());
				pst.setString(2, passwordField.getText());
				System.out.println(pst.toString());
				ResultSet rs = pst.executeQuery();
				int tries = 0;
			while(rs.next()) {
				tries = tries + 1;	
			}
			if(tries == 1) {
				JOptionPane.showMessageDialog(null, "Correct Username & Password");
			}else if(tries > 1) {
				JOptionPane.showMessageDialog(null, "Duplicate Login Details");
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Login Details. Try Again...");
			}
			rs.close();
			pst.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Error is: "+ ex);
			}
		}
	} 
	
	

}
