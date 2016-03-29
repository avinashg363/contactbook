import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class driver extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		rel r=new rel();
		try {
			r.loadFromFile();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		per p=new per();
		try {
			per.loadFromFile2();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cas c=new cas();
		try {
			c.loadFromFile3();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		pro pr=new pro();
		try {
			pr.loadFromFile1();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driver frame = new driver(r,p,pr,c);
					frame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					        if (JOptionPane.showConfirmDialog(frame, 
					            "Are you sure to close this window?", "Really Closing?", 
					            JOptionPane.YES_NO_OPTION,
					            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					        	try {
									r.saveToFile();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    		try {
									pr.saveToFile1();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    		try {
									p.saveToFile2();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    		try {
									c.saveToFile3();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					            System.exit(0);
					        }
					    }
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public driver(rel r,per p,pro pr,cas c) {
		setTitle("CONTACT BOOK");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Display all contacts");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				all a= new all();
				a.newwindow();
			}
		});
		btnNewButton.setBounds(55, 87, 244, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO THE CONTACT BOOK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(34, 11, 293, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Relatives");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				r.newwindow();
			}
		});
		btnNewButton_1.setBounds(55, 121, 244, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Personal Friends");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				p.newwindow();
			}
		});
		btnNewButton_2.setBounds(55, 155, 244, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Professional Friends");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pr.newwindow();
			}
		});
		btnNewButton_3.setBounds(55, 189, 244, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Casual Friends");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c.newwindow();
				
			}
		});
		btnNewButton_4.setBounds(55, 223, 244, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Search");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search s=new search();
				s.newwindow();
			}
		});
		btnNewButton_5.setBounds(55, 257, 244, 23);
		contentPane.add(btnNewButton_5);
		
		
		
	}
}
