
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Daryna. Class for drawing animations.
 *
 */
public class ActionAfterAnswer extends JPanel implements ActionListener {

	private double answer;
	private double rightAnswer;

	private int height = 400;
	private int width = 700;
	private Timer timer;
	private double finalWidth;
	private double widthPath;
	private int x;
	private int y;

	private double indent;
	private double biggerH;
	private double biggerA;
	private double smallerH;
	private double smallerA;
	private double biggerC;
	private double smallerC;
	private double ballSize;
	private double c;
	private double beginBiggerArrX;
	private double beginBiggerArrY;
	private double beginSmallerArrX;
	private double beginSmallerArrY;
	private double endSmallerArrX;
	private double endSmallerArrY;
	private double ballX;
	private double ballY;
	private double currentC;
	private double sinB;
	private double sinA;
	private double bigC = 0;
	private double finalX;

	private double widthSpace;
	private double yDist;
	private boolean first = true;
	private boolean second = false;
	private boolean third = false;
	private double distX;

	public ActionAfterAnswer(double answer, double rightAnswer) {
		this.answer = answer;
		this.rightAnswer = rightAnswer;

		if (Game.currentTopic == 0) {
			int curLevel = MechanicMovementTopic.getLevel();
			switch (curLevel) {
			case 0:
				x = 100;
				timer = new Timer(5, this);
				widthPath = width - x - 110 - (width / 6);
				finalWidth = (int) (answer * (widthPath) / rightAnswer);
				break;
			case 1:
				timer = new Timer(50, this);
				ballSize = height / 12;
				biggerH = 2 * height / 3;
				biggerA = 2 * biggerH / 3;
				smallerA = biggerH / 3;
				biggerC = Math.sqrt(biggerH * biggerH + (biggerA * biggerA));
				smallerC = 2 * biggerC / 3;
				c = biggerC + smallerC;
				smallerH = Math.sqrt(smallerC * smallerC - (smallerA * smallerA));
				widthPath = c;
				finalWidth = answer * c / rightAnswer;

				double a = smallerA + biggerA;

				beginBiggerArrX = (width - a) / 2 + a;
				beginBiggerArrY = height / 6;
				beginSmallerArrX = beginBiggerArrX - biggerA;
				beginSmallerArrY = beginBiggerArrY + biggerH;
				endSmallerArrX = beginBiggerArrX - a;
				endSmallerArrY = beginSmallerArrY - smallerH;

				ballX = beginBiggerArrX - (ballSize / 2);
				ballY = beginBiggerArrY - ballSize / 2;

				currentC = 0;
				sinB = biggerH / biggerC;
				sinA = smallerH / smallerC;

				if (finalWidth > biggerC) {
					double h = finalWidth - biggerC;
					double y = sinA * h;
					finalX = beginBiggerArrX - Math.sqrt(h * h - y * y) - ballSize / 2 - biggerA;
				} else {
					double y = sinB * finalWidth;
					finalX = beginBiggerArrX - Math.sqrt(finalWidth * finalWidth - y * y) - ballSize / 2;
				}

				break;
			}
		} else if (Game.currentTopic == 1) {
			int curLevel = PathTopic.getLevel();
			switch (curLevel) {
			case 0:
				x = 50;
				timer = new Timer(5, this);
				widthPath = width - 100;
				double ans = 2 * answer;
				finalWidth = (int) (ans * (widthPath) / 1200);
				break;
			case 1:
				x = width - 50 - width / 6;
				timer = new Timer(5, this);
				widthPath = width - 100;
				finalWidth = (int) (answer * (widthPath) / rightAnswer);
				break;
			case 2:
				timer = new Timer(5, this);
				y = 100;
				yDist = height - 200;
				widthPath = 60 * yDist / 25;
				widthSpace = (width - widthPath) / 2;

				finalWidth = (int) (answer * (widthPath) / rightAnswer);

				break;
			default:
				break;
			}
		}

		setPreferredSize(new Dimension(width, height));
		setVisible(true);
		timer.start();
	}

	/**
	 * Draw level animation
	 */
	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		if (Game.currentTopic == 0) {
			int level = MechanicMovementTopic.getLevel();
			if (level == 0)
				drawCarAnimation(g2d);
			else
				drawBallAnimation(g2d);
		}
		if (Game.currentTopic == 1) {
			int level = PathTopic.getLevel();
			if (level == 0)
				drawPlainAnimation(g2d);

			else if (level == 1)
				drawTrainAnimation(g2d);
			else
				drawPlain1Animation(g2d);
		}
		setVisible(true);
		Game.getInstance().visible();
	}

	private void drawBallAnimation(Graphics2D g2d) {

		// painting arrows
		g2d.setColor(Color.white);
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
		g2d.setStroke(dashed);
		g2d.drawLine((int) beginBiggerArrX, (int) beginBiggerArrY, (int) beginSmallerArrX, (int) beginSmallerArrY);
		g2d.drawLine((int) beginSmallerArrX, (int) beginSmallerArrY, (int) endSmallerArrX, (int) endSmallerArrY);

		// painting field arrow
		dashed = new BasicStroke(4);
		g2d.setStroke(dashed);

		if (ballX <= finalX) {
			timer.stop();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (finalWidth == widthPath)
				Game.getInstance().changePanel(new WinPanel(height, width));
			else
				Game.getInstance().changePanel(new LoosePanel());
			return;
		}

		if (ballX < endSmallerArrX - 50) {
			timer.stop();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Game.getInstance().changePanel(new LoosePanel());
			return;
		}

		// painting ball
		g2d.setColor(Color.red);
		g2d.drawOval((int) ballX, (int) ballY, (int) ballSize, (int) ballSize);
		g2d.fillOval((int) ballX, (int) ballY, (int) ballSize, (int) ballSize);

		currentC++;

		if (ballX >= beginSmallerArrX - ballSize / 2) {
			bigC++;
			double y = currentC * sinB;
			double x = Math.sqrt(currentC * currentC - y * y);
			ballX -= x;
			ballY += y;
		} else {
			double c = currentC - bigC;
			double y = c * sinA;
			double x = Math.sqrt(c * c - y * y);
			ballX -= x;
			ballY -= y;
		}

	}

	private void drawCarAnimation(Graphics2D g2d) {

		g2d.setColor(Color.white);
		g2d.setFont(new Font("Monospaced", Font.BOLD, 20));
		g2d.drawString("Магазин", 10, (height / 2));
		g2d.drawString("Театр", width - 90, (height / 2));
		g2d.drawLine(100, height / 2, width - 110, height / 2);

		x += 7;
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("static/car.png"));
			Image dimg = myPicture.getScaledInstance(width / 7, height / 7, Image.SCALE_SMOOTH);
			g2d.drawImage(dimg, x, height / 2 - height / 7, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (x >= finalWidth + 100) {
			// g2d.drawString("Стоп", width/2-5, (height/4));

			try {
				timer.stop();
				Thread.sleep(500);
				if (finalWidth == widthPath)
					Game.getInstance().changePanel(new WinPanel(height, width));
				else
					Game.getInstance().changePanel(new LoosePanel());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		} else if (x >= width) {
			Game.getInstance().changePanel(new LoosePanel());
			return;
		}
	}

	private void drawPlainAnimation(Graphics2D g2d) {

		g2d.setColor(Color.white);
		g2d.setFont(new Font("Monospaced", Font.BOLD, 20));
		g2d.drawLine(50, height / 2, width - 50, height / 2);
		g2d.drawString("v = " + answer + " км/год", 50, 50);
		g2d.drawString("t = 2 год", 50, 65);

		x += 7;
		double curS = (1200 * (x + 50)) / widthPath;
		if (curS > 2 * answer)
			g2d.drawString("s = " + 2 * answer + " км", 50, 80);
		else
			g2d.drawString("s = " + (int) curS + " км", 50, 80);

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("static/plain.png"));
			Image dimg = myPicture.getScaledInstance(width / 7, height / 7, Image.SCALE_SMOOTH);

			g2d.drawImage(dimg, x, height / 2 - height / 7, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (x >= finalWidth + 56 - width / 7) {
			try {
				timer.stop();
				Thread.sleep(1000);
				if (finalWidth == widthPath) {
					Game.getInstance().changePanel(new WinPanel(height, width));
				} else {
					Game.getInstance().changePanel(new LoosePanel());
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		} else if (x >= width) {
			Game.getInstance().changePanel(new LoosePanel());
			return;
		}
	}

	private void drawTrainAnimation(Graphics2D g2d) {

		g2d.setColor(Color.white);
		g2d.setFont(new Font("Monospaced", Font.BOLD, 20));
		g2d.drawLine(50, height / 2, width - 50, height / 2);
		g2d.drawString("v = 180 км/год", width - 200, 50);
		g2d.drawString("t = 1 хв", width - 200, 65);
		g2d.drawString("s = " + answer + " м", width - 200, 80);

		x -= 7;

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("static/train.png"));
			Image dimg = myPicture.getScaledInstance(width / 6, height / 7, Image.SCALE_SMOOTH);
			g2d.drawImage(dimg, x, height / 2 - height / 7, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (x + 10 <= width - finalWidth - 50) {
			try {
				timer.stop();
				Thread.sleep(1000);
				if (finalWidth == widthPath) {
					Game.getInstance().changePanel(new WinPanel(height, width));
				} else {
					Game.getInstance().changePanel(new LoosePanel());
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		} else if (x <= 0) {
			Game.getInstance().changePanel(new LoosePanel());
			return;
		}
	}

	private void drawPlain1Animation(Graphics2D g2d) {

		g2d.setColor(Color.white);
		g2d.drawLine((int) widthSpace, 100, (int) widthSpace, height - 100);
		g2d.drawLine((int) (width - widthSpace), 100, (int) (width - widthSpace), height - 100);
		g2d.drawLine((int) widthSpace, height - 100, (int) (width - widthSpace), height - 100);

		if (first) {
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("static/plain.png"));
				Image dimg = myPicture.getScaledInstance(width / 7, height / 7, Image.SCALE_SMOOTH);

				g2d.drawImage(dimg, (int) (widthSpace - width / 14), y, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (second) {
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("static/plain.png"));
				Image dimg = myPicture.getScaledInstance(width / 7, height / 7, Image.SCALE_SMOOTH);

				g2d.drawImage(dimg, (int) (widthSpace + x), height - 100 - height / 14, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (third) {
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("static/plain.png"));
				Image dimg = myPicture.getScaledInstance(width / 7, height / 7, Image.SCALE_SMOOTH);

				g2d.drawImage(dimg, (int) (width - widthSpace - width / 14), y, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("static/plain.png"));
				Image dimg = myPicture.getScaledInstance(width / 7, height / 7, Image.SCALE_SMOOTH);

				g2d.drawImage(dimg, x, y, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			g2d.setColor(Color.red);
			g2d.drawLine((int) widthSpace, 100, (int) distX, 100);

		}

		if (distX >= finalWidth + widthSpace) {
			try {
				timer.stop();
				Thread.sleep(1000);
				if (finalWidth == widthPath) {
					Game.getInstance().changePanel(new WinPanel(height, width));
				} else {
					Game.getInstance().changePanel(new LoosePanel());
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		} else if (distX >= width) {
			Game.getInstance().changePanel(new LoosePanel());
			return;
		}

		if (first) {
			if (y >= height - 100 - height / 7) {
				first = false;
				second = true;
				x = (int) widthSpace;
				y = height - 100 - height / 7;
			} else
				y += 7;
		} else if (second) {
			if (x >= width - widthSpace - width / 7) {
				second = false;
				third = true;
				x = (int) (width - widthSpace - width / 14);
			} else
				x += 7;
		} else if (third) {
			if (y <= 100) {
				third = false;
				y = 100;
				distX = widthSpace;
			} else
				y -= 7;
		} else {
			distX += 7;
		}
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
