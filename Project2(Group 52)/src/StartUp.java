import javax.swing.*;
public class StartUp {
	static JFrame startUpFrame = new JFrame();
	static JPanel startUpPanel = new JPanel(null);
	
public StartUp() { //setting up StartUp Frame and Panel using Constructor Method
		
		startUpFrame.setTitle("Start Menu");
		startUpFrame.setSize(750,250);
		startUpFrame.setResizable(false);
		//setUndecorated(true);
	    //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	    
		startUpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		startUpFrame.add(startUpPanel);
		startUpFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		System.out.println("Commit #1");
		StartUp startUpGui = new StartUp();
	}

}
