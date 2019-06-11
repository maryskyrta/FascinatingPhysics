package LevelParts;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import LevelParts.Level;

public class TestLevel extends JComponent {
	  private double scale;
	  private Color color;
	  private Timer timer;
	  public double x =10;
	  public double y =10;
	 static String task = "Дівчинка, йдучи до школи, долає 250 м, в до музичного театру в тому самому \nнапрямку --"
	    		+ "670 м. Який шлях долає дівчинка до музичного театру,\n якщо йде ло нього зі школи?";
	 
	  static JFrame  frame;
	  
	  public TestLevel(Color color, int delay) {
		  frame = new JFrame("Moving Circle");
		  
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.getContentPane().add(new Level());
		        frame.setSize(520, 420);
		        frame.setVisible(true);
	  }
	  
	  public static void visible() {
		  frame.setVisible(true);
	  }

	 
	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	    	TestLevel tl = new TestLevel(null, 0);
	      
	      }
	    });
	  }


}
