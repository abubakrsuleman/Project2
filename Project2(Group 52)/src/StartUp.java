import java.awt.*;

import javax.swing.*;
public class StartUp {
	static JFrame startUpFrame = new JFrame();
	static JPanel startUpPanel = new JPanel(null);
	static JLabel topBar = new JLabel("Inventory Management System");
	Color topFontColor = new Color(255,255,255);
	Font topBarFont = new Font("Serif",Font.PLAIN,36);
public StartUp() { //setting up StartUp Frame and Panel using Constructor Method
		
		startUpFrame.setTitle("Start Menu");
		startUpFrame.setSize(750,250);
		startUpFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	    
		startUpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		topBar.setBounds(1,1,750,30);
		startUpPanel.add(topBar);
		topBar.setOpaque(true);
		topBar.setBackground(Color.BLACK); //Black Background
		topBar.setForeground(topFontColor); //White Text
		
		
		startUpFrame.add(startUpPanel);
		startUpFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		StartUp startUpGui = new StartUp();
	}

}
