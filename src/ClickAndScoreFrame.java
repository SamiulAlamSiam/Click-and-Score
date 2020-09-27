import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class ClickAndScoreFrame extends JFrame{
	
	private JLabel lblScore, lblCount;
	private JButton btnExit,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btnAll,s;
	private JPanel pnlUpper,pnlLower,pnlLast;
	private int count=0;
	private ArrayList<String> p1= new ArrayList<>();
	
	private ArrayList<JButton> p2= new ArrayList<>();
	Timer timer,timer1;
	Random rand=new Random();
	
	public ClickAndScoreFrame()
	{
		this.setTitle("Click Counter");
		this.setSize(600, 800);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.AddComponent();
	}

	private void AddComponent() 
	{
		pnlUpper= new JPanel();
		pnlUpper.setBorder(new LineBorder(Color.RED,2));
		pnlUpper.setBounds(0, 0, 580, 100);
		pnlUpper.setLayout(null);
		add(pnlUpper);
		this.UComponent();
		
		pnlLower= new JPanel();
		pnlLower.setBorder(new LineBorder(Color.GREEN,2));
		pnlLower.setBounds(0, 105, 580, 500);
		pnlLower.setLayout(new GridLayout(5, 2 ,35 ,25));
		add(pnlLower);
		this.LComponent();
		
		pnlLast= new JPanel();
		pnlLast.setBorder(new LineBorder(Color.RED,2));
		pnlLast.setBounds(0, 650, 580, 100);
		pnlLast.setLayout(new FlowLayout());
		add(pnlLast);
		this.LaComponent();
	}

	private void LaComponent() 
	{
		btnExit=new JButton("EXIT");
		btnExit.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);		
			}
		});
		this.pnlLast.add(btnExit);
		
	}

	private void LComponent() {
		
		for(int i=1;i<11;i++)
		{
			JButton btnAll = new JButton("BUTTON "+ i);
			p1.add(btnAll.getText());
			p2.add(btnAll);
			btnAll.setBackground(Color.RED);
			btnAll.setFont(new Font("Serif", Font.BOLD, 20));
			
			this.pnlLower.add(btnAll);
		}
		
		timer = new Timer(1500, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				for(JButton b:p2)
				{
					b.setBackground(Color.RED);
				}
				
				int x=rand.nextInt(p2.size());
			    s=p2.get(x);	
			    s.setBackground(Color.GREEN);		
			}		    
		});
		timer.start();
		
		for(JButton t:p2)
		{
			t.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(t.getBackground()==Color.GREEN)
					{
						count+=5;
						lblCount.setText(""+count);
					}
					else
					{
						count-=5;
						lblCount.setText(""+count);
					}
					
					if(count<0)
					{
						timer.stop();
						for(JButton bt:p2)
						{
							bt.setEnabled(false);
						}
						JOptionPane.showMessageDialog(null, "Sorry You Fail");
					}		
					
				}
			});
			
		}		
	}

	private void UComponent() {
		lblScore=new JLabel("Score :");
		lblScore.setBounds(200, 40, 80, 50);
		lblScore.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		this.pnlUpper.add(lblScore);
		
		lblCount=new JLabel();
		lblCount.setBounds(285, 40, 100, 50);
		lblCount.setFont(new Font("serif", Font.BOLD+Font.ITALIC, 20));
		this.pnlUpper.add(lblCount);	
	}

}
