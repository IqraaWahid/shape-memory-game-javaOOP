/*
 * Name: Iqraa Wahid
 * Class Code: ICS4U
 * Date: 11/05/2023
 * Purpose: To create the menu of the game.
 */

package IqraaWahidCPT;

import java.awt. *; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;


public class Menu extends JFrame implements ActionListener {
	//Import Images And Resizing
	//Start Button Image
	ImageIcon Start = new ImageIcon("Start1.png");
	Image img1 = Start.getImage() ;    
	Image newimg1 = img1.getScaledInstance(180, 60, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Start1 = new ImageIcon( newimg1 );
	
	//Instruction Button Image
	ImageIcon Instructions = new ImageIcon("Instructions3.png");
	Image img3 = Instructions.getImage() ;    
	Image newimg3 = img3.getScaledInstance(100, 30, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Instructions1 = new ImageIcon( newimg3 );
	
	//Menu Background Screen
	ImageIcon Back = new ImageIcon("backPic.jpg");
	Image img4 = Back.getImage() ;    
	Image newimg4 = img4.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon Back1 = new ImageIcon( newimg4 );
	
	//import, resize and add pictures to label for PIZZA
	ImageIcon pizzaP = new ImageIcon ("name.png");
	Image img5 =pizzaP.getImage() ;   
	//scaled image to fit 100x70
	Image newimg5 = img5.getScaledInstance(600, 500, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon pizzapic1 = new ImageIcon( newimg5 );
	JLabel pizzalbl = new JLabel(pizzapic1);
	
	//import, resize and add pictures to label for PIZZA
	ImageIcon compP = new ImageIcon ("company.png");
	Image img6 =compP.getImage() ;   
	//scaled image to fit 100x70
	Image newimg6 = img6.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon comppic1 = new ImageIcon( newimg6 );
	JLabel complbl = new JLabel(comppic1);
	
	//Component Initializing
	JFrame frame = new JFrame("Shape Memory");
	JLabel back = new JLabel();
	JButton start = new JButton(Start1);
	JButton inst = new JButton(Instructions1);
	
	public Menu(){
		//Frame Screen Setup
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension a = new Dimension(700,490);//what is this for
		back.setBounds(0,0,800,500);//background
		back.setIcon(Back1);//background
		frame.setLayout(null);
		start.addActionListener(this);
		inst.addActionListener(this);
		start.setBounds(300,310, 180, 60);
		start.setBorder(BorderFactory.createEmptyBorder());
		start.setContentAreaFilled(false);
		inst.setBounds(340, 380, 100, 30);
		inst.setBorder(BorderFactory.createEmptyBorder());
		inst.setContentAreaFilled(false);
		
		//adding the photos on the background:
		pizzalbl.setBounds(215,45,500,400);//pizza destination
		pizzalbl.setVisible(true);//allow visibility of pizza
		frame.add(pizzalbl); //add pizza to frame
		
		//adding the photos on the background:
		complbl.setBounds(10,10,150,100);//pizza destination
		complbl.setVisible(true);//allow visibility of pizza
		frame.add(complbl); //add pizza to frame
				
		frame.add(start);//adds start to frame
		frame.add(inst);//adds inst to frame
		frame.add(back);//adds back to frame
		frame.setSize(800,540);//set size of frame
		frame.setVisible(true);//allows visibility of frame
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == start){ //Checks If Start is clicked
			frame.dispose();//what does this do
			Game.main(null); // Moves To Game Screen
			SwingUtilities.invokeLater(() -> new ImageDisplay().setVisible(true));//moves to the shapes imageDisplay class as well
		}
		if(event.getSource() == inst){ //Check If Instruction Button is Clicked
			frame.dispose();
			Instructions n = new Instructions(); //Move to Instruction Screen
		}
	}
	
	public static void main(String[] args) {
		Menu gui = new Menu(); //Creates Screen
	}
}