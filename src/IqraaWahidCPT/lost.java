package IqraaWahidCPT;

import java.awt. *; 
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class lost {
	//Import background
	//Menu Background Screen
	ImageIcon Back = new ImageIcon("lostbac.png");
	Image img4 = Back.getImage() ;    
	Image newimg4 = img4.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Back1 = new ImageIcon( newimg4 );
	
	//Component Initializing
	JFrame frame = new JFrame("Shape Memory");
	JLabel back = new JLabel();
		
	public lost(){
		//Frame Screen Setup
		frame.setSize(800,540);//sets the size of the frame
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);//allows the window to close when the cross button of the window is clicked 
		Dimension a = new Dimension(700,490);
		back.setBounds(0,0,800,540);//sets the background's position on the frane
		back.setIcon(Back1);
		frame.setLayout(null);
		
		frame.add(back);//adds back to the frame
		frame.setVisible(true);//allows visibility of frame on screen
	}
	
	public static void main(String[] args) {
		lost gui = new lost(); //Creates Screen
		
		//Adds sound to screen
		 new Thread(){
				@Override
				public void run(){
					try {
						   File file = new File("LOoser.wav");//file name
						   Clip clip = AudioSystem.getClip();
						   clip.open(AudioSystem.getAudioInputStream(file));
						   clip.loop(1/2);//audio will loop once
						   Thread.sleep(clip.getMicrosecondLength());
						  } catch (Exception e) {
						  }
				}
			}.start();//end of sound			
	 }
		
}