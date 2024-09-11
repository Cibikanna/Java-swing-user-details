import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Swing_Example {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		JButton b = new JButton("Save");
		JLabel name = new JLabel("Name");
		
		JLabel mail = new JLabel("Mail");
		JTextField mailtf = new JTextField("Enter mail");
		JTextField nametf = new JTextField("Enter name");
		JLabel pswd = new JLabel("Password");
		JPasswordField pswdtf = new JPasswordField("Enter password");
		JPanel jp = new JPanel();
		nametf.setForeground(Color.BLUE);
		mailtf.setForeground(Color.BLUE);
		pswdtf.setForeground(Color.BLUE);
		pswdtf.setEchoChar((char)0);
		 
		
		
		jp.setLayout(null);
		name.setBounds(100,150,50,10);
		nametf.setBounds(170,150,100,20);
		mail.setBounds(100,180,50,10);
		mailtf.setBounds(170,180,100,20);
		pswd.setBounds(100,210,80,10);
		pswdtf.setBounds(170,210,100,20);
		b.setBounds(150, 290, 70, 20);
		
		jp.add(name);
		jp.add(nametf);
		jp.add(mail);
		jp.add(mailtf);
		jp.add(pswd);
		jp.add(pswdtf);
		jp.add(b);
		jp.setBounds(50, 50, 350, 350);
		Border br = BorderFactory.createLoweredBevelBorder();
		jp.setBorder(br);
		
		frame.add(jp);	
		Color cr = new Color(51,255,255);
		frame.getContentPane().setBackground(cr);

		FocusListener fl = new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e) {
				JTextField src = (JTextField)e.getSource();
				if(src==nametf && src.getText().equals("Enter name"))
				{
					nametf.setText("");
					nametf.setForeground(Color.RED);
				}
				if(src==mailtf && src.getText().equals("Enter mail"))
				{
					mailtf.setText("");
					mailtf.setForeground(Color.RED);
				}
				if(src==pswdtf && src.getText().equals("Enter password"))
				{
					pswdtf.setText("");
					pswdtf.setEchoChar('*');
					pswdtf.setForeground(Color.RED);
					
				}
					
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField src = (JTextField)e.getSource();
				if(src.getText().isEmpty())
				{
					if(src==nametf)
					{
						nametf.setText("Enter name");
						nametf.setForeground(Color.BLUE);
					}
					if(src==mailtf)
					{
						mailtf.setText("Enter mail");
						mailtf.setForeground(Color.BLUE);
					}
					if(src==pswdtf)
					{
						pswdtf.setText("Enter password");
						pswdtf.setForeground(Color.BLUE);
					}
				}
				
			}
			
		};
		
		nametf.addFocusListener(fl);
		mailtf.addFocusListener(fl);
		pswdtf.addFocusListener(fl);
				
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(nametf.getText());
				System.out.println(mailtf.getText());
				System.out.println(pswdtf.getText());
			}
		});
		
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		jp.requestFocusInWindow(null);

	}

}
