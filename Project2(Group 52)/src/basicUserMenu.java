import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class basicUserMenu {
	JFrame basicUserMenuFrame = new JFrame();
	JPanel basicUserMenuPanel = new JPanel(null);
	JLabel topBar = new JLabel();
	JLabel backgroundUI = new JLabel();
	Font topBarFont = new Font("",Font.BOLD,20);
	Color topFontColor = new Color(0,0,0);
	
	JLabel header = new JLabel("Inventory Management System");
	
	public basicUserMenu() {
		basicUserMenuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		basicUserMenuFrame.setTitle("Inventory Management System");
		basicUserMenuFrame.setSize(700,300);
		basicUserMenuFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		backgroundUI.setBackground(Color.BLACK);
		backgroundUI.setBounds(1,40,750,750);
		backgroundUI.setOpaque(true);

		
		topBar.setBounds(1,1,700,40);
		header.setBounds(1,1,700,40);
		header.setBackground(Color.WHITE);
		basicUserMenuPanel.add(topBar);
		topBar.setOpaque(true);
		topBar.setBackground(Color.WHITE); 
		topBar.setFont(topBarFont);
		header.setFont(topBarFont);
		header.setForeground(topFontColor);
		header.setOpaque(true);
		topBar.add(header);
		
        basicUserMenuPanel.add(backgroundUI);
		basicUserMenuPanel.add(topBar);
		
		basicUserMenuFrame.add(basicUserMenuPanel);
		basicUserMenuFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		basicUserMenu basicUserMenuGUI = new basicUserMenu();
	}

}
