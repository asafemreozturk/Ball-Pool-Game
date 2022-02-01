package Panel;
import java.awt.*;
import java.awt.event.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;
import javax.swing.Timer;
public class BallPanel extends JPanel implements ActionListener,MouseListener,MouseMotionListener,KeyListener {
	
	int a = 0;
	
	
	static public int score;
	private int point = 0;
	public void setpoint() {	
		point = point+1;
		System.out.println(point);
		
	}
	public int getpoint() {
		return point;
	}
	
	double sz=40;
	double Vx=2,Vy=2;
	double Vx2=0,Vy2=0,Vx3=0,Vy3=0,Vx4=0,Vy4=0;
	double V=10;
	Ellipse2D.Double ball = new Ellipse2D.Double(200,200,sz,sz);
	Ellipse2D.Double ball2 = new Ellipse2D.Double(150,100,sz,sz);
	Ellipse2D.Double ball3 = new Ellipse2D.Double(400,100,sz,sz);
	Ellipse2D.Double ball4 = new Ellipse2D.Double(240,100,sz,sz);
	Rectangle rect = new Rectangle(0,0,3,200);
	
     
	Timer t = new Timer(15,this);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateBallPosition();
		
		
	}
	

	public void updateBallPosition() {
		
		
		ball.x+=Vx;
		ball.y+=Vy;
		
		ball2.x+=Vx2;
		ball2.y+=Vy2;
		
		ball3.x+=Vx3;
		ball3.y+=Vy3;
		
		
		ball4.x+=Vx4;
		ball4.y+=Vy4;
		
		
		Vx = Vx*0.99;
		Vy = Vy*0.99;
		
		Vx2 = Vx2*0.99;
		Vy2 = Vy2*0.99;
		
		Vx3 = Vx3*0.99;
		Vy3 = Vy3*0.99;
		
		Vx4 = Vx4*0.99;
		Vy4 = Vy4*0.99;
		
		
		

		if(ball.x<0 || ball.x>getWidth()-sz) 
			Vx=-Vx;
			
		if(ball.y<0 || ball.y>getHeight()-sz) Vy=-Vy;
		
		if(ball2.x<0 || ball2.x>getWidth()-sz) Vx2=-Vx2;
		if(ball2.y<0 || ball2.y>getHeight()-sz) Vy2=-Vy2 ;
		
		if(ball3.x<0 || ball3.x>getWidth()-sz) Vx3=-Vx3;
		if(ball3.y<0 || ball3.y>getHeight()-sz) Vy3=-Vy3;
		
		if(ball4.x<0 || ball4.x>getWidth()-sz) Vx4=-Vx4;
		if(ball4.y<0 || ball4.y>getHeight()-sz) Vy4=-Vy4;
		
		
		double dx = ball2.x - ball.x;
		double dy = ball2.y - ball.y;
		
		double dx1 = ball3.x - ball.x;
		double dy1 = ball3.y - ball.y;
		
		double dx2 = ball4.x - ball.x;
		double dy2 = ball4.y - ball.y;
		
		double dx4 = ball3.x - ball4.x;
		double dy4 = ball3.y - ball4.y;
		
		double dx5 = ball4.x - ball2.x;
		double dy5 = ball4.y - ball2.y;
		
		double dx6 = ball3.x - ball2.x;
		double dy6 = ball3.y - ball2.y;
		
		
		
		double Umag = Math.hypot(dx, dy);
		double Umag2 = Math.hypot(dx1, dy1);
		double Umag3 = Math.hypot(dx2, dy2);
		
		double Umag4 = Math.hypot(dx4, dy4);
		double Umag5 = Math.hypot(dx5, dy5);
		double Umag6 = Math.hypot(dx6, dy6);
		
		
		if(Umag <= ball.width)
		{
			
			
			double VrMag = (Vx*dx + Vy*dy )/ Umag;
			double Vrx = VrMag * dx / Umag;
			double Vry = VrMag * dy / Umag;
			
			double Vtx = Vx - Vrx;
			double Vty = Vy - Vry;
			
			
			Vx = Vtx;
			Vy = Vty;
			Vx2 = Vrx;
			Vy2 = Vry;
			
		
		}
		else if(Umag2 <= ball.width)
		{
			
			
			double VrMag1 = (Vx*dx1 + Vy*dy1 )/ Umag2;
			double Vrx1 = VrMag1 * dx1 / Umag2;
			double Vry1 = VrMag1 * dy1 / Umag2;
			
			double Vtx1 = Vx - Vrx1;
			double Vty1 = Vy - Vry1;
			
			
			Vx = Vtx1;
			Vy = Vty1;
			Vx3 = Vrx1;
			Vy3 = Vry1;
			
		
		}
		else if(Umag3 <= ball.width)
		{
			
			
			double VrMag2 = (Vx*dx2 + Vy*dy2 )/ Umag3;
			double Vrx2 = VrMag2 * dx2 / Umag3;
			double Vry2 = VrMag2 * dy2 / Umag3;
			
			double Vtx2 = Vx - Vrx2;
			double Vty2 = Vy- Vry2;
			
		
			Vx = Vtx2;
			Vy = Vty2;
			Vx4 = Vrx2;
			Vy4 = Vry2;
			
			
		}
		
		else if(Umag4 <= ball4.width)
		{
			
			
			double VrMag4 = (Vx4*dx4 + Vy4*dy4 )/ Umag4;
			double Vrx4 = VrMag4 * dx4 / Umag4;
			double Vry4 = VrMag4 * dy4/ Umag4;
			
			double Vtx4 = Vx4 - Vrx4;
			double Vty4 = Vy4 - Vry4;
			
			
			Vx4 = Vtx4;
			Vy4 = Vty4;
			Vx3 = Vrx4;
			Vy3 = Vry4;
			setpoint();
			score++;
		
		}
		else if(Umag5 <= ball2.width)
		{
			
			
			double VrMag5 = (Vx2*dx5 + Vy2*dy5 )/ Umag5;
			double Vrx5 = VrMag5 * dx5 / Umag5;
			double Vry5 = VrMag5 * dy5 / Umag5;
			
			double Vtx5 = Vx2 - Vrx5;
			double Vty5 = Vy2 - Vry5;
			
			
			Vx2 = Vtx5;
			Vy2 = Vty5;
			Vx4 = Vrx5;
			Vy4 = Vry5;
			setpoint();
			score++;
		}
		else if (Umag6 <= ball2.width)
		{
			
			
			double VrMag6 = (Vx2*dx6 + Vy2*dy6 )/ Umag6;
			double Vrx6 = VrMag6 * dx6 / Umag6;
			double Vry6 = VrMag6 * dy6 / Umag6;
			
			double Vtx6 = Vx2 - Vrx6;
			double Vty6 = Vy2 - Vry6;
			
			
			Vx2 = Vtx6;
			Vy2 = Vty6;
			Vx3 = Vrx6;
			Vy3 = Vry6;
			setpoint();
			score++;
		}
//		
//		
//		if(Vx2*Vx2 + Vy2*Vy2 < 1 )
//			
//			t.stop();
//		if(Vx*Vx + Vy*Vy < 1 )
//			
//			t.stop();
//		if(Vx*Vx + Vy*Vy < 1 )
//			t.stop();
	
	
      

		repaint();
	}

	

	   
	public BallPanel() {
		
	    addMouseListener(this);
	    addMouseMotionListener(this);
	    addKeyListener(this);
	    
	    
	} 
	
	


	@Override	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	int mouseX=0,mouseY=0;
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


public void mouseClicked(MouseEvent e) {
	
	
}
	
	@Override
	public void mouseMoved(MouseEvent e) {

		
		mouseX=e.getX();
	    mouseY=e.getY();
	    rect.setLocation(mouseX, mouseY);
	    repaint();
	    
	}

	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		

		
	
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.green);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.white);
		g2d.fill(ball);
		g2d.setColor(Color.blue);
		g2d.fill(ball2);
		g2d.setColor(Color.red);
		g2d.fill(ball3);
		g2d.setColor(Color.gray);
		g2d.fill(ball4);
		g2d.fill((Shape) rect);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	
	
	


	@Override
	public void keyTyped(KeyEvent e) {
		char ch = e.getKeyChar();  
	    if(ch == 'a' || ch == 'A')              
	    {
	      Vx=(Vx*1.5);
	      Vy=(Vy*1.5);
	      
	    }
	    else if(ch == 'w'|| ch == 'W')    
	    {
	      t.stop();

		  
	    }
	    else if(ch == 's'|| ch == 'S')    
	    {
	      t.restart();
	    }
	    else if(ch == 'd'|| ch == 'D')    
	    {
	      Vx=Vx*0.9;
	      Vy=Vy*0.9;

		 
	    }
		
		
	
	}
}



