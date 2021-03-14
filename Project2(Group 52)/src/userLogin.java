import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.sql.*;
public class userLogin implements ActionListener {
	boolean isBasicUserBool = false;
	ArrayList<ArrayList<Object>> data;
	static Connection conn = DatabaseConnection.connect();
	static JFrame userLoginFrame = new JFrame();
	static JPanel userLoginPanel = new JPanel(null);
	JPanel timerPanel = new JPanel(null);
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
		backgroundUI.add(timerPanel);
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
			int ID = 2;
			String username = "placeholder";
			String password = "pass";
			String firstname = "placeholder";
			String surname = "placeholder";
			boolean isBasicUser = true;
			
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
				userLoginMethod();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	} 
	
	private void userLoginMethod() throws SQLException{
		String sql = "SELECT Username,Password,IsBasicUser FROM UserLogin";
        Statement stmt  = conn.createStatement();
        data = new ArrayList<ArrayList<Object>>();
        
        String usernameInput = usernameField.getText();
        String passwordInput = new String(passwordField.getPassword());

        ResultSet res = stmt.executeQuery(sql);
        
 	    ArrayList<Object> rec = new ArrayList<Object>();
 	   
            // loop through the result set
        while (res.next()){
      	   
             String correctUsername = res.getString("Username"); //needs to be arraylist
      	     String correctPassword = res.getString("Password"); //needs to be arraylist
      	     int correctIsBasicUser = res.getInt("IsBasicUser");
               	 rec.add(correctUsername);
             	 rec.add(correctPassword);
             	 rec.add(correctIsBasicUser);
             	 data.add(rec); 	 
           	 if(usernameInput.equals(correctUsername) && passwordInput.equals(correctPassword)) {
           		 JOptionPane.showMessageDialog(null, "Correct Login Details");
           		 usernameField.setText(null); //clears username text box
           		 passwordField.setText(null); //clears password text box
           		 if(correctIsBasicUser == 0) { // 0 represents advanced user
           			 isBasicUserBool = false; // user is not advanced user
           		 }
           		 if(correctIsBasicUser == 1) { //1 represents basic user
           			isBasicUserBool = true;
           		 }
           		 if(isBasicUserBool = true) {
           			 
           		 }
           		 break; 
           	 }
           	 else if(!usernameInput.equals(correctUsername) && !passwordInput.equals(correctPassword)) {
          		 JOptionPane.showMessageDialog(null, "Wrong Login Details");
          	 System.out.println("Records Exist: "+ res.next());
          	 
          	 System.out.println("Username Inputted: "+usernameInput);
          	 System.out.println("Password Inputted: "+passwordInput);
             break;
           	 }
      	    }
            printData(data);
	}
	public static void printData (ArrayList<ArrayList<Object>> data)
	{
		for (int i=0; i<data.size(); i++)
		{
			for (int j=0; j<data.get(i).size(); j++)
			{
				System.out.print(data.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
}