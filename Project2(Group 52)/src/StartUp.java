import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartUp implements ActionListener{
	static JFrame startUpFrame = new JFrame();
	static JPanel startUpPanel = new JPanel(null);
	static JLabel topBar = new JLabel("Inventory Management System");
	static JLabel welcomeLabel = new JLabel("Welcome");
	Color topFontColor = new Color(255,255,255);
	Color WelcomeTextColor = new Color(0,0,0);
	Font WelcomeFont = new Font("",Font.BOLD,20);
	static ImageIcon exitIcon = new ImageIcon("./Images/Exit_Button.png");
	static JLabel backgroundUI = new JLabel();
	static JButton exitBtn = new JButton(exitIcon);
	
	public StartUp() { //setting up StartUp Frame and Panel using Constructor Method
		
		startUpFrame.setTitle("Start Menu");
		startUpFrame.setSize(750,500);
		startUpFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	    
		startUpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		topBar.setBounds(1,1,750,30);
		startUpPanel.add(topBar);
		topBar.setOpaque(true);
		topBar.setBackground(Color.BLACK); //Black Background
		topBar.setForeground(topFontColor); //White Text
		
		welcomeLabel.setBounds(310,1,90,30);
		welcomeLabel.setForeground(WelcomeTextColor);
		welcomeLabel.setBackground(Color.WHITE); 
		welcomeLabel.setOpaque(true);
		welcomeLabel.setFont(WelcomeFont);
		backgroundUI.add(welcomeLabel);
		
		backgroundUI.setBounds(1,30,750,750);
		backgroundUI.setOpaque(true);
		backgroundUI.setBackground(Color.WHITE); //White Background
		startUpPanel.add(backgroundUI);
		
		exitBtn.setBounds(700,1,35,30);
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
	}

}
