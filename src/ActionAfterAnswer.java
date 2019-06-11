
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
import javax.swing.JPanel;
import javax.swing.Timer;

public class ActionAfterAnswer extends JPanel implements ActionListener{
	
	private int height = 600;
	private int width =750;
	private Timer timer;
	private int finalWidth;
	private int widthPath;
	private int x;
	
	
	public ActionAfterAnswer( double answer, double rightAnswer) {
		x=100;    
	    timer = new Timer(5, this);
	    widthPath = width-x-110-(width/6);
	    finalWidth = (int) (answer*(widthPath)/rightAnswer);
	    
		setPreferredSize(new Dimension(width, height));
		setVisible(true);
		timer.start();
	}
	
	 @Override
	public void paintComponent(Graphics g) {
		    Graphics2D g2d = (Graphics2D) g;
		    g2d.setColor(Color.black);
		    g.fillRect(0, 0, width, height);
		    
		    g2d.setColor(Color.white);
		    g2d.setFont(new Font("Monospaced", Font.BOLD, 20));
		    g2d.drawString("Магазин", 10, (height/2));
		    g2d.drawString("Театр", width-90, (height/2));
		    g2d.drawLine(100, height/2, width-110, height/2);
		    
		    x+=3;
		    BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("static/car.png"));
				Image dimg = myPicture.getScaledInstance(width/7, height/7,
				        Image.SCALE_SMOOTH);
				g2d.drawImage(dimg, x , height/2-height/7, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(x>=finalWidth+100) {
				timer.stop();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(finalWidth == widthPath) Game.getInstance().changePanel(new WinPanel(height, width));
				else Game.getInstance().changePanel(new LoosePanel());
				
			} else if(x>=width) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Game.getInstance().changePanel(new LoosePanel());
			}
			setVisible(true);
			Game.getInstance().visible();
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
