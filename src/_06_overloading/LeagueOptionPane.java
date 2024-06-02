package _06_overloading;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Overloading is when we have multiple methods with the SAME name, but DIFFERENT parameters.
 * This can mean a different number of parameters, or the parameter types can differ, or both!
 * An overloaded method can also have a different return type, in addition to changing the parameters.
 * 
 * GOAL: Create your own custom pop-up messages
 */
public class LeagueOptionPane {
	 JFrame frame;
	 JPanel panel;	
	 JLabel label;
	 JLabel image;
	
	
	public void showMessageDialog(String message) {
		// 1. Open example.png and make a GUI that looks like that
		//    The message parameter is what we want to show on our pop-up
		frame = new JFrame("Message");
		message = "The League is the Best";
		label = new JLabel(message);
		panel = new JPanel();
		image = new JLabel(loadImage("league.png"));
		panel.add(image);
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		
		// 2. Uncomment the line of code below. It sets the location of our frame to the center of the screen
		frame.setLocationRelativeTo(null);
	}
	
	// 3. Call this method in the Runner class
	

	// 4. Create another showMessageDialog() method that lets us also choose the Message and Title 
	//    2 String parameters (one for the message and one for the title)
	public void showMessageDialog(String message, String title) {
		title = JOptionPane.showInputDialog("What title would you like?");
		message = JOptionPane.showInputDialog("What message would you like?");
		frame = new JFrame(title);
		label = new JLabel(message);
		panel = new JPanel();
		image = new JLabel(loadImage("league.png"));
		panel.add(image);
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		
		
	}
	// 5. Call this method in the Runner class
	
	
	// 6. Create another showMessageDialog() method that lets us choose the Message, Title, and Image
	//    3 String parameters (one for the message, one for the title, and one for the fileName)
	public void showMessageDialog(String message, String title, String leagueImage) {
		message = JOptionPane.showInputDialog("What would you like your message to be?");
		title = JOptionPane.showInputDialog("What would you like your title to be?");
		leagueImage = JOptionPane.showInputDialog("What would you like your league icon to be? (Dark or Light)");
		if(leagueImage.equalsIgnoreCase("dark")) {
			leagueImage = "leagueDark.png";
		}
		if(leagueImage.equalsIgnoreCase("light")) {
			leagueImage = "league.png";
		}
		else {
			JOptionPane.showMessageDialog(null, message);
		}
		frame = new JFrame(title);
		label = new JLabel(message);
		panel = new JPanel();
		image = new JLabel(loadImage(leagueImage));
		panel.add(image);
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	// 7. Call this method in the Runner class
	
	// CHALLENGE: 
		//	1. Create another showMessageDialog() method that lets us choose the Message, Title, Image, and Background Color
		//     3 String parameters (one for the message, one for the title, and one for the fileName)
		//	   1 Color parameter for the backgroundColor
		//			
		//	2. Change the return type of the 3rd showMessageDialog() method(the one right above) to JPanel
		//	   Make sure to return your panel at the end of that method
		//	
		//	3. Call the showMessageDialog() method you just modified in this method
		//	   Set the method equal to a JPanel
		//	
		//	4. Set the background of your panel to the backgroundColor parameter
		//
		//	5. Call this method in the Runner class
		//
		// WHY DID WE DO THIS? - because we were able to overload this method by calling one of the other methods inside of it
	
	
	public static ImageIcon loadImage(String fileName) {
		try {
			return new ImageIcon(ImageIO.read(new LeagueOptionPane().getClass().getResourceAsStream(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}


	
}
