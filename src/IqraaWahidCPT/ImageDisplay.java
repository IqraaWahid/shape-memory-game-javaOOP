package IqraaWahidCPT;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Dimension;

public class ImageDisplay extends JFrame {
	private static final int DISAPPEAR_TIME_SECONDS = 15;//this variable will store the time I want the screen to disappear in which is 15 seconds
	String [] e= {"C", "H", "S", "T", "O"};
	String ts;
	public static String seq="";//String will store the sequence chosen from the program
    private static final int IMAGE_DISPLAY_TIME = 2000; // Time to display each image (in milliseconds), each image will be displayed for 2 seconds
    int xp=10;//this is the variable for the horizontal position of the images, and this variable will be updated each time an image is being displayed
    private List<ImageIcon> images; // ArrayList of images
    private JPanel imageContainer; // This container to hold the images
    private int currentIndex; // The Index of the displayed images

    public ImageDisplay() {
    	JLabel label = new JLabel("Remember the above Sequence");//initializing the instruction label
        add(label); // adding the label to the screen
        label.setVisible(true);
        setVisible(true);
        //will hide the screen after 16 seconds
        Thread task = new Thread(() -> {
            try {
                Thread.sleep(DISAPPEAR_TIME_SECONDS * 1000);
                setVisible(false); // set visible false for window (close window)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        task.start(); // method call to start the timer for 16 seconds
        
        //appearance of shapes
        loadImages(); // Method call to obtain the images
        imageContainer = new JPanel();
        imageContainer.setLayout(null); //null layout used (for positioning)
        setSize(690, 540);//size of the window
        setTitle("Shape Memory");//name of the window 
        add(imageContainer);//add the images onto the screen
        displayNextImage();//method call to display the image (this will display the first image)
    }//closing method ImageDisplay

    // Load the images
    private void loadImages() {
        images = new ArrayList<>();//Array list, images, is storing the 5 images
        images.add(new ImageIcon("circle1.png"));//0(C)
        images.add(new ImageIcon("heart1.png"));//1(H)
        images.add(new ImageIcon("semicircle1.png"));//2(S)
        images.add(new ImageIcon("tri1.png"));//3 (T)
        images.add(new ImageIcon("octagon1.png"));//4(O)
        ImageIcon t=new ImageIcon("circle1.png");

        // randomly shuffles the ArrayLists elements
        for(int i=0;i<10;i++) {
        	int k=(int)(Math.random()*(4-0+1)+0);
        	int n=(int)(Math.random()*(4-0+1)+0);
        	t=images.get(k);//for the images
        	images.set(k,images.get(n));//for the images
        	images.set(n,t);//for the images
        	ts=e[k];//for the string
        	e[k]=e[n];//for the string
        	e[n]=ts;//for the string
        }
        
        //adding the sequence into string variable sequence
        for(int i=0;i<5;i++) {
        	seq=seq+e[i];
        }
        
        System.out.println("the seq is: " + seq);//ALWAYS TWO come same
    }//closing method loadImages

    // Display the next image
    private void displayNextImage() {
        if (currentIndex < images.size()) {//if the index of the displayed images is smaller than the ArrayList size then only the if statement will be true
            JLabel imageLabel = new JLabel(images.get(currentIndex));//storing the images of each element into the imageLabel
            imageLabel.setBounds(xp, 10, imageLabel.getIcon().getIconWidth(), imageLabel.getIcon().getIconHeight());//position of the all the images, and their width and height
            imageContainer.add(imageLabel);//all the images are added into the container
            xp=xp+125;//updating the value of xp, so that each image has its shown horizontal position
            
            // Schedule hiding the image after a certain time
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    hideCurrentImage();//method call to hide images
                }
            }, IMAGE_DISPLAY_TIME);

            currentIndex++;//updating the index value of the ArrayList that has the images stored in it
            revalidate();
            repaint();//this will also all the images to appear
        }//closing if statement
    }//Closing method displayNextImage

    // To hide the displayed image before
    private void hideCurrentImage() {
        SwingUtilities.invokeLater(() -> {
            imageContainer.remove(0);
            revalidate();
            repaint();//to hide the last image (this will disappear the last image of the shuffled array)

            // Display the next image after a delay
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    displayNextImage();//method call to display next image
                }
            }, 1000); // Delay of 1 second before displaying the next image
        });
    }//closing method hideCurrentImage
    
    //main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageDisplay().setVisible(true));
    }//closing main method
}//closing class