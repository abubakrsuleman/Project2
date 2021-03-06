import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
public class userLogin {
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
	Font LabelFont = new Font("",Font.BOLD,20);
	
	static JButton userLoginBtn = new JButton("Login");
	public userLogin() {
		userLoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		userLoginFrame.setTitle("Inventory Management System");
		userLoginFrame.setSize(300,260);
		userLoginFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		backgroundUI.setBackground(Color.WHITE);
		backgroundUI.setOpaque(true);
		
		topBar.setBounds(1,1,300,40);
		userLoginPanel.add(topBar);
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
		userLoginPanel.add(backToStartUpBtn);
		
		backgroundUI.add(usernameLabel);
		backgroundUI.add(passwordLabel);
		backgroundUI.add(usernameField);
		backgroundUI.add(passwordField);
		backgroundUI.add(userLoginBtn);
		
		
		
		backgroundUI.setBounds(1,30,750,750);
		
		userLoginPanel.add(backgroundUI);
		userLoginFrame.add(userLoginPanel);
		userLoginFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userLogin userLoginGui = new userLogin();
		Connection conn = connect();
		/*
		try {         
			//write code here!
			int ID = 1;
			String username = "Jacob01";
			String password = "pass";
			String firstname = "Jacob";
			String surname = "James";
			//String pCat = "Drink";
			
			String sql = "INSERT INTO UserLogin(ID,Username,Password,Firstname,Surname) VALUES(?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ID); // we dont need this as we have defined this field as auto-increment and not null
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, firstname);
			pstmt.setString(5, surname);
				           
			pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        */
	}
	
	private static Connection connect ()
	{
		String fileName =  "C:/Users/Abubakr/git/Project2/Project2(Group 52)/Database/userLogin.db";
		String url = "jdbc:sqlite:" + fileName;
		// SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Db connection successful!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
	} 
	
	

}
