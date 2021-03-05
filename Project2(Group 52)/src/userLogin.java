import java.awt.Color;

import javax.swing.*;
public class userLogin {
	static JFrame userLoginFrame = new JFrame();
	static JPanel userLoginPanel = new JPanel();
	
	static JLabel userNameLabel = new JLabel("Username");
	static JLabel passwordLabel = new JLabel("Password");
	
	public userLogin() {
		userLoginFrame.setTitle("User Login");
		userLoginFrame.setSize(750,350);
		userLoginFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		userLoginFrame.add(userLoginPanel);
		userLoginFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userLogin userLoginGui = new userLogin();
	}

}
