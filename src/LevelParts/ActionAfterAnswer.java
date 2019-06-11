package LevelParts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

public class ActionAfterAnswer extends JComponent implements ActionListener{
	
	private int height;
	private int width;
	private Timer timer;
	private double answer;
	private double rightAnswer;
	private int finalWidth;
	private int x;
	
	
	public ActionAfterAnswer(int height, int width, double answer, double rightAnswer) {
		x=100;
		this.height = height;
		this.width = width;
		this.answer = answer;
		this.rightAnswer = rightAnswer;      
	    timer = new Timer(10, this);
	    int widthPath = width-x-80-(width/6);
	    finalWidth = (int) (answer*(widthPath)/rightAnswer);
	    
		setPreferredSize(new Dimension(width, height));
		setVisible(true);
		timer.start();
	}
	
	 @Override
	public void paintComponent(Graphics g) {
		    Graphics2D g2d = (Graphics2D) g;
		    g2d.setColor(Color.white);
		    g.fillRect(0, 0, width, height);
		    g2d.setColor(Color.black);
		    g2d.drawRect(0, 0, width - 1, height - 1);
		    
		    int widthIm = (width-20)/6;
		    g2d.setFont(new Font("Monospaced", Font.PLAIN, 16));
		    g2d.drawString("Магазин", 10, (height/2));
		    g2d.drawString("Театр", width-60, (height/2));
		    g2d.drawLine(100, height/2, width-80, height/2);
		    
		    x+=3;
		    BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("static/car.png"));
				Image dimg = myPicture.getScaledInstance(width/6, height/4,
				        Image.SCALE_SMOOTH);
				g2d.drawImage(dimg, x , height/4, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(x>=finalWidth+100) timer.stop();
			
			TestLevel.visible();
	  }

	  public void start() {
		    timer.start();
		  }
		 
		  public void stop() {
		    timer.stop();
		  }
		 
		  @Override
		  public void actionPerformed(ActionEvent arg0) {   
		    repaint();
		  }
}
