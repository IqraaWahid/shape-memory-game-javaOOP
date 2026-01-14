package IqraaWahidCPT;

import java.awt. *;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class win  {		
	//Import background
	//Menu Background Screen
	ImageIcon Back = new ImageIcon("winbac.png");
	Image img4 = Back.getImage() ;    
	Image newimg4 = img4.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Back1 = new ImageIcon( newimg4 );
	
	//Component Initializing
	JFrame frame = new JFrame("Shape Memory");
	JLabel back = new JLabel();
	public win(){
		//Frame Screen Setup
		frame.setSize(800,540);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		Dimension a = new Dimension(700,490);
		back.setBounds(0,0,800,540);//background
		back.setIcon(Back1);//background
		frame.setLayout(null);
		frame.add(back);//adding background to the frame
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		win gui = new win(); //Creates Screen
		//Music:
		 new Thread(){
				@Override
				public void run(){
					try {
						   File file = new File("Winner.wav");//file name
						   Clip clip = AudioSystem.getClip();
						   clip.open(AudioSystem.getAudioInputStream(file));
						   clip.loop(1/2);//audio will loop once
						   Thread.sleep(clip.getMicrosecondLength());
						  } catch (Exception e) {
						  }
				}
			}.start();//end of music			
		
	}
}