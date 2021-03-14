import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
public class adminLogin implements ActionListener {
	    ArrayList<ArrayList<Object>> adminData;
	    static Connection conn = DatabaseConnection.connect();
		PreparedStatement pst = null;
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
		
		static JLabel loginBoxRounded = new JLabel();
		static ImageIcon adminIcon = new ImageIcon("./Images/admin_Icon.png");
		static JLabel adminIconBigLabel = new JLabel(adminIcon);
		Font LabelFont = new Font("",Font.BOLD,20);
		
		static JButton adminLoginBtn = new JButton("Login");
		
		public adminLogin() {
			adminLoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			adminLoginFrame.setTitle("Inventory Management System");
			adminLoginFrame.setSize(700,300);
			adminLoginFrame.setResizable(false);
			//setUndecorated(true);
		    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
			
			backgroundUI.setBackground(Color.WHITE);
			backgroundUI.setOpaque(true);
			
			topBar.setBounds(1,1,700,40);
			adminLoginPanel.add(topBar);
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
			
			
			adminLoginBtn.setBounds(300,150,130,30);
			adminLoginBtn.addActionListener(this);
			adminLoginBtn.setBackground(Color.BLACK);
			adminLoginBtn.setForeground(Color.WHITE);
			adminLoginBtn.setOpaque(true);
			backgroundUI.add(adminLoginBtn);
			
			backToStartUpBtn.setBounds(1,1,35,40);
			backToStartUpBtn.setBackground(Color.BLACK);
		    //backToStartUpBtn.setOpaque(true);
			backToStartUpBtn.setBorderPainted(false);
			backToStartUpBtn.setFocusPainted(false);
			//exitBtn.addActionListener(this);
			adminLoginPanel.add(backToStartUpBtn);
			
		//	loginBoxRounded.setBounds(200,20,300,200);
			loginBoxRounded.setBounds(90,20,500,200);
			loginBoxRounded.setBackground(Color.GRAY);
			loginBoxRounded.setOpaque(true);
			
			adminIconBigLabel.setBounds(25,20,150,150);
			
			loginBoxRounded.add(usernameLabel);
			loginBoxRounded.add(passwordLabel);
			loginBoxRounded.add(usernameField);
			loginBoxRounded.add(passwordField);
			loginBoxRounded.add(adminLoginBtn);
			loginBoxRounded.add(adminIconBigLabel);
			
			backgroundUI.add(loginBoxRounded);
			backgroundUI.setBounds(1,30,700,700);
			
			adminLoginPanel.add(backgroundUI);
			adminLoginFrame.add(adminLoginPanel);
			adminLoginFrame.setVisible(true);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		adminLogin adminLoginGui = new adminLogin();
		/*
		 try {         
			//write code here!
			int ID = 1;
			String username = "Robert01";
			String password = "admin";
			String firstname = "Robert";
			String surname = "Smith";
			//String pCat = "Drink";
			
			String sql = "INSERT INTO AdminLogin(ID,Username,Password,Firstname,Surname) VALUES(?,?,?,?,?)";
			
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
        }	*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			adminLoginMethod();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	} 
	
	private void adminLoginMethod() throws SQLException{
		String sql = "SELECT Username,Password FROM AdminLogin";
        Statement stmtADMIN  = conn.createStatement();
        adminData = new ArrayList<ArrayList<Object>>();
        
        String usernameInput = usernameField.getText();
        String passwordInput = new String(passwordField.getPassword());

        ResultSet res = stmtADMIN.executeQuery(sql);
        
 	    ArrayList<Object> rec = new ArrayList<Object>();
 	   
            // loop through the result set
        while (res.next()){
      	   
             String correctUsername = res.getString("Username"); //needs to be arraylist
      	     String correctPassword = res.getString("Password"); //needs to be arraylist
               	 rec.add(correctUsername);
             	 rec.add(correctPassword);
             	adminData.add(rec); 	 
           	 if(usernameInput.equals(correctUsername) && passwordInput.equals(correctPassword)) {
           		 JOptionPane.showMessageDialog(null, "Correct Login Details");
           		 usernameField.setText(null);
           		 passwordField.setText(null);
           		 break; 
           	 }
           	 else if(!usernameInput.equals(correctUsername) && !passwordInput.equals(correctPassword) || !usernameInput.equals(correctUsername) || !passwordInput.equals(correctPassword)) {
          		 JOptionPane.showMessageDialog(null, "Wrong Login Details");
          	 System.out.println("Records Exist: "+ res.next());
          	 
          	 System.out.println("Username Inputted: "+usernameInput);
          	 System.out.println("Password Inputted: "+passwordInput);
             break;
           	 }
      	    }
            printData(adminData);
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
