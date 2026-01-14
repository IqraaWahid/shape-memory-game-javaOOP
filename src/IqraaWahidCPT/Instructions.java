/*
 * Name: Iqraa Wahid
 * Date: 12/05/2023
 * Class Code; ICS4U
 * Purpose: Instructions screen.
 */

package IqraaWahidCPT;

/*
 * Name: Iqraa Wahid
 * Date: 12/05/2023
 * Class Code; ICS4U
 * Purpose: Instructions screen.
 */

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions extends JFrame implements ActionListener {
	//Importing Image And Resizing
	//Back Button
	ImageIcon Back = new ImageIcon("back.png");
	Image img1 = Back.getImage() ;
	Image newimg1 = img1.getScaledInstance(130, 80, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon back = new ImageIcon( newimg1 );
	
	//instructions picture:
	ImageIcon nameP = new ImageIcon ("instructions..png");
	Image img3 =nameP.getImage() ;   
	//scaled image to fit 100x70
	Image newimg3 = img3.getScaledInstance(280, 240, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon namepic3 = new ImageIcon( newimg3 );
	JLabel namelbl = new JLabel(namepic3);
	
	//Instruction Screen Background picture
	ImageIcon inst = new ImageIcon("InstructionScreen.jpg");
	Image img2 = inst.getImage() ;    
	Image newimg2 = img2.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH ) ; 
	ImageIcon inst2 = new ImageIcon( newimg2 );
	
	//Components Initializing
	JFrame frame = new JFrame("Shape Memory"); //Frame Setup
	JLabel label = new JLabel(); //Label For Backgroubd
	JButton bck = new JButton(back); //Button for back action
	
	public Instructions(){
		//Setups Frame For Instruction Screen
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//allows the window to be closed when cross button clicked
		frame.setLayout(null);
		label.setBounds(0,0,500,500);//sets position of label
		label.setIcon(inst2);
		//adding the photos on the background:
		namelbl.setBounds(5,220,500,90);//name of game destination
		namelbl.setVisible(true);//allow visibility of name of game
		frame.add(namelbl); //add name of game to frame
		bck.addActionListener(this);
		bck.setBounds(365,415,115,90);//set position for bck
		bck.setBorder(BorderFactory.createEmptyBorder());
		bck.setContentAreaFilled(false);
		frame.add(bck);//add bck to the frame
		frame.add(label);//adds label to the frame
		frame.setSize(500,540);//sets the size of the frame
		frame.setVisible(true);//allows visibility of frame
	}
	public static void main(String[] args) {
		Instructions n = new Instructions(); //Creates Instruction Screen
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == bck){ //Checks if user pushes Back button
			frame.dispose();
			Menu gui = new Menu(); //Goes Back To Menu Screen
		}
	}
}