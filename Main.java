package Panel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;



public class Main implements ActionListener {

	public static void main(String[] args) {
		
	
		
	
		
		
		BallPanel op = new BallPanel();
		
		Scanner sc = new Scanner(System.in);
		
		
		
		JLabel ds = new JLabel("Game is starting! ");
		JLabel asd = new JLabel(" ");
		JLabel plyr = new JLabel(" ");
		JLabel message = new JLabel("\t    Welcome to the 3 Ball Game      ");
		
		JTextField text=new JTextField();
		
		String pname = text.getText();
		
		
		
		
		
		Timer s = new Timer(1000,new ActionListener() {
		
			int time = 0;	
			
			 
		@Override
        public void actionPerformed(ActionEvent e) {
			time++;
			
			ds.setText(format(time));
			asd.setText(format(BallPanel.score));
			plyr.setText(pname);
		}
		
		});
		s.start();
		
	
		
		JFrame f = new JFrame("Points");
		
		
	
		
		
		JFrame frame = new JFrame("Menu");
		frame.setLayout(new BorderLayout());
		JPanel statusbar = new JPanel();
		frame.add(statusbar, BorderLayout.SOUTH);
		JLabel as = new JLabel("Time: ");
		JLabel das = new JLabel("seconds");
		statusbar.add(as);
		statusbar.add(ds);
		statusbar.add(das);
		statusbar.add(plyr);
		statusbar.add(asd);
		
	
		BallPanel bp = new BallPanel();
	
	
		


				
		bp.addKeyListener(bp);
		bp.addMouseListener(bp);
		frame.add(bp);
		frame.setSize(500,500);
		frame.addKeyListener(bp);
		
		if(BallPanel.score > 50)
			frame.dispose();
		
		
		
	

		JButton Play,Exit;
		Play = new JButton("Play");
		Play.setFont(new Font("Times New Roman",Font.PLAIN,40));
		Play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(true);
				f.dispose();
			}
		});
		
		Exit = new JButton("Exit");
		Exit.setFont(new Font("Times New Roman", Font.PLAIN,40));
		Exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		f.add(Play, BorderLayout.WEST);
		f.add(Exit, BorderLayout.EAST);
		f.add(message, BorderLayout.CENTER);
		
//		f.add(pn);
		
		f.setSize(500,500);
		f.setVisible(true);
	
	
	
	}
		
	
	
	
	
	public static String gett(int s) {
		String o = String.valueOf(s);
		return o ;
	}
	 public static String format(int i) {
	        String result = String.valueOf(i);
	        if (result.length() == 1) {
	            result = "0" + result;
	        }
	        return result;
	    }





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	
}
