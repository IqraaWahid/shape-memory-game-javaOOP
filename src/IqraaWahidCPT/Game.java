package IqraaWahidCPT;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Dimension;

public class Game extends JFrame implements ActionListener{
	String user="";//to store user's sequence
	int counter2=0;
	//Menu Background Screen
	ImageIcon Back = new ImageIcon("gameBack.jpg");
	Image img1 = Back.getImage() ;    
	Image newimg1 = img1.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Back1 = new ImageIcon( newimg1 );
		
	//import, resize and add pictures to label for GAME NAME
	ImageIcon nameP = new ImageIcon ("name.png");
	Image img2 =nameP.getImage() ;   
	//scaled image to fit 100x70
	Image newimg2 = img2.getScaledInstance(100, 83, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon namepic1 = new ImageIcon( newimg2 );
	JLabel namelbl = new JLabel(namepic1);
		
	//import, resize and add pictures to label for company name of game
	ImageIcon compP = new ImageIcon ("company.png");
	Image img3 =compP.getImage() ;   
	//scaled image to fit 100x70
	Image newimg3 = img3.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon comppic1 = new ImageIcon( newimg3 );
	JLabel complbl = new JLabel(comppic1);
	
	//intsruction:
	ImageIcon Instruct = new ImageIcon("instructions1.png");
	Image img9 = Instruct.getImage() ;    
	Image newimg9 = img9.getScaledInstance(220, 30, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Instruct1 = new ImageIcon( newimg9 );
	JLabel instructlbl = new JLabel(Instruct1);
	
	//SHAPES:
	//circle Button Image
	ImageIcon Circle = new ImageIcon("circle.jpg");
	Image img4 = Circle.getImage() ;    
	Image newimg4 = img4.getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Circle1 = new ImageIcon( newimg4 );
	
	//heart Button Image
	ImageIcon Heart = new ImageIcon("heart.jpg");
	Image img5 = Heart.getImage() ;    
	Image newimg5 = img5.getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Heart1 = new ImageIcon( newimg5 );
	
	// triangle Button Image
	ImageIcon Triangle = new ImageIcon("triangle123.png");
	Image img6 = Triangle.getImage() ;    
	Image newimg6 = img6.getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Triangle1 = new ImageIcon( newimg6 );
	
	//octagon Button Image
	ImageIcon Octagon = new ImageIcon("octagon.jpg");
	Image img7 = Octagon.getImage() ;    
	Image newimg7 = img7.getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Octagon1 = new ImageIcon( newimg7 );
	
	//semicircle Button Image
	ImageIcon Semicircle = new ImageIcon("semicircle.jpg");
	Image img8 = Semicircle.getImage() ;    
	Image newimg8 = img8.getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Semicircle1 = new ImageIcon( newimg8 );
	
	//clear Button Image
	ImageIcon Clear = new ImageIcon("clear.png");
	Image img10 = Clear.getImage() ;    
	Image newimg10 = img10.getScaledInstance(70, 50, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Clear1 = new ImageIcon( newimg10 );
	
	 JTextArea textArea = new JTextArea( 10, 20 ) ;//to store shape selected by user	
	 
	//Component Initializing
	JFrame frame = new JFrame("Shape Memory");//name of window
	JLabel back = new JLabel();	
	JButton circle = new JButton(Circle1);
	JButton heart = new JButton(Heart1);
	JButton triangle = new JButton(Triangle1);
	JButton octagon = new JButton(Octagon1);
	JButton semicircle = new JButton(Semicircle1);
	JButton clear = new JButton(Clear1);
	
	//constructor
	public Game(){
		//Frame Screen Setup
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension a = new Dimension(700,490);
		back.setBounds(0,0,800,500);//background destination type
		back.setIcon(Back1);//background
		frame.setLayout(null);
		
		//adding the photos on the background:
		namelbl.setBounds(10,10,80,40);//name of game destination
		namelbl.setVisible(true);//allow visibility of name of game
		frame.add(namelbl); //add name of game to frame
		
		//adding the photos on the background:
		complbl.setBounds(330,3,140,50);//company name destination
		complbl.setVisible(true);//allow visibility of company name
		frame.add(complbl); //add company name to frame
		
		//adding the photos on the background:
		instructlbl.setBounds(110,210,220,30);//instructions destination
		instructlbl.setVisible(true);//allow visibility of instructions
		frame.add(instructlbl); //add instructions to frame
		
		//SHAPES:
		//circle
		circle.addActionListener(this);
		circle.setBounds(1,175, 95, 250);
		circle.setBorder(BorderFactory.createEmptyBorder());
		circle.setContentAreaFilled(false);
		
		//heart
		heart.addActionListener(this);
		heart.setBounds(85,175, 95, 250);
		heart.setBorder(BorderFactory.createEmptyBorder());
		heart.setContentAreaFilled(false);
				
		//heptagon
		triangle.addActionListener(this);
		triangle.setBounds(170,175, 95, 250);
		triangle.setBorder(BorderFactory.createEmptyBorder());
		triangle.setContentAreaFilled(false);
		
		//octagon
		octagon.addActionListener(this);
		octagon.setBounds(255,175, 95, 250);
		octagon.setBorder(BorderFactory.createEmptyBorder());
		octagon.setContentAreaFilled(false);
		
		//semicircle
		semicircle.addActionListener(this);
		semicircle.setBounds(340,175, 95, 250);
		semicircle.setBorder(BorderFactory.createEmptyBorder());
		semicircle.setContentAreaFilled(false);
		//end of shapes
		
		//CLEAR BUTTON:
		clear.addActionListener(this);
		clear.setBounds(1,345, 95, 250);
		clear.setBorder(BorderFactory.createEmptyBorder());
		clear.setContentAreaFilled(false);
		
		//textArea boxes:
		textArea.setBounds(180,360,100,83);//label destination
		textArea.setVisible(true);
		
		//adding the components onto the frame
		frame.add(clear);
		frame.add(circle);
		frame.add(heart);
		frame.add(triangle);
		frame.add(octagon);
		frame.add(semicircle);
		frame.add(textArea) ; //adding the textArea onto frame
		frame.add(back);//add the background
		frame.setSize(450,540);//size of the frame
		frame.setVisible(true);//allow visibility of frame
	}
	
	//Action Performed method:
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == circle){
			textArea.append( "circle\n" ) ;//outputs the user option
			user=user+"C";//add to the textArea, "circle"
			counter2=counter2+1;
		}
		if(event.getSource() == heart){
			textArea.append( "heart\n" ) ;//outputs the user option
			user=user+"H";//adds the letter H to to user answer
			counter2=counter2+1;
		}
		if(event.getSource() == triangle){
			textArea.append( "triangle\n" ) ;//outputs the user option
			user=user+"T";//adds the letter T to to user answer
			counter2=counter2+1;
		}
		if(event.getSource() == octagon){
			textArea.append( "octagon\n" ) ;//outputs the user option
			user=user+"O";//adds the letter O to to user answer
			counter2=counter2+1;
		}
		if(event.getSource() == semicircle){
			textArea.append( "semicircle\n" ) ;//adds the letter S to to user answer
			user=user+"S";
			counter2=counter2+1;
		}
		if(event.getSource() == clear){
			textArea.setText("");//erase the entire text
			user="";//clear the user's answer
			counter2=0;//clear the number of answer user has given
		}
		if(counter2==5){ //Checks if the shapes are all chosen first
			if(user.equals(ImageDisplay.seq)){//instead of COTHS, it should be the variable seq, who's initialization needs to be merged
				frame.dispose();
				win n = new win(); //if user's sequence matches the actual sequence then move to win screen
				System.out.println(ImageDisplay.seq);
			}
			else {//if user's sequence does not match the actual sequence then move to the lock screen
				frame.dispose();
				lost n = new lost(); //Move to lost Screen if user answer does not equal to the actual sequence
				//System.out.println(seq);
			}
		}
	}
	
	 public static void main( String[] args ){
		 Game gui = new Game();
		 
		//this thread is for the music:
		 new Thread(){
				@Override
				public void run(){
					try {
						   File file = new File("Audio.wav");//file name
						   Clip clip = AudioSystem.getClip();
						   clip.open(AudioSystem.getAudioInputStream(file));
						   clip.loop(100);//audio will loop 100 times
						   Thread.sleep(clip.getMicrosecondLength());
						  } catch (Exception e) {
						  }
				}
			}.start();		
	 }
}