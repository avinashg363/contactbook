

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class cas {
	private static JTable table_3;
	private static JTextField textField_12;
	private static JTextField textField_13;
	private static JTextField textField_14;
	private static JTextField txtDdmmyyyy_3;
	static ArrayList<casual> casual = new ArrayList<casual>();
	
	public static void loadFromFile3() throws IOException, ClassNotFoundException {
		ObjectInputStream is;
		int coursecount;
		try{
			is = new ObjectInputStream(new FileInputStream("casual"));
		}catch(FileNotFoundException e){
			coursecount = 0; return;
		}
		coursecount = is.readInt();
		for(int i=0; i<coursecount; i++){
			{casual c=(casual) is.readObject();
			casual.add(c);
			}
			
		}
		
		is.close();
	}
	
	public static void saveToFile3() throws FileNotFoundException, IOException {
		int coursecount=casual.size();
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("casual"));
		os.writeInt(coursecount);
		for(int i=0; i<coursecount; i++){
			os.writeObject(casual.get(i));
		}
		os.close();
	}
	
	public void  newwindow() {
		JFrame frame=new JFrame();
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		       
		            frame.dispose();
		        }
		    }
		});
		
		frame.setTitle("Casual Friends");
		frame.setBounds(100, 100, 628, 375);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(0, 0, 613, 221);
		panel.add(scrollPane_6);
		
		table_3 = new JTable(){
			public boolean isCellEditable(int x,int y){
				return false;
			}
		};
		scrollPane_6.setViewportView(table_3);
		DefaultTableModel model3=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Mobile Number", "E-Mail", "When met", "Where Met", "Circumstances", "Any information"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		
		table_3.setModel(model3);
		if(table_3.getRowCount()==0)
		for(int i=0;i<casual.size();i++)
		{
			model3.addRow(new Object[]{casual.get(i).getName(),casual.get(i).getMob(),casual.get(i).getE_mail(),casual.get(i).getWhen(),casual.get(i).getWhere(),casual.get(i).getCircum(),casual.get(i).getAny()});
		}
		
		JLabel lblName_3 = new JLabel("Name");
		lblName_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName_3.setBounds(10, 224, 46, 14);
		panel.add(lblName_3);
		
		textField_12 = new JTextField();
		textField_12.setBounds(51, 221, 86, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblMobileNo_3 = new JLabel("Mobile No");
		lblMobileNo_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMobileNo_3.setBounds(141, 224, 54, 14);
		panel.add(lblMobileNo_3);
		
		textField_13 = new JTextField();
		textField_13.setBounds(198, 221, 86, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblEmail_3 = new JLabel("E-Mail");
		lblEmail_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail_3.setBounds(293, 224, 46, 14);
		panel.add(lblEmail_3);
		
		textField_14 = new JTextField();
		textField_14.setBounds(333, 221, 86, 20);
		panel.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblWhenMet = new JLabel("When Met");
		lblWhenMet.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWhenMet.setBounds(429, 224, 58, 14);
		panel.add(lblWhenMet);
		
		txtDdmmyyyy_3 = new JTextField();
		txtDdmmyyyy_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDdmmyyyy_3.setText(null);
			}
		});
		txtDdmmyyyy_3.setText("dd-mm-yyyy");
		txtDdmmyyyy_3.setBounds(497, 221, 86, 20);
		panel.add(txtDdmmyyyy_3);
		txtDdmmyyyy_3.setColumns(10);
		
		JLabel lblWhereMet = new JLabel("Where Met");
		lblWhereMet.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWhereMet.setBounds(61, 249, 63, 14);
		panel.add(lblWhereMet);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(5, 263, 169, 72);
		panel.add(scrollPane_7);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_7.setViewportView(textArea_3);
		textArea_3.setLineWrap(true);
		textArea_3.setWrapStyleWord(true);
		
		
		
		JLabel lblCircumstances = new JLabel("Circumstances");
		lblCircumstances.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCircumstances.setBounds(225, 246, 69, 14);
		panel.add(lblCircumstances);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(178, 263, 176, 72);
		panel.add(scrollPane_8);
		
		JTextArea textArea_4 = new JTextArea();
		scrollPane_8.setViewportView(textArea_4);
		textArea_4.setLineWrap(true);
		textArea_4.setWrapStyleWord(true);
		
		JLabel lblAnyInformation = new JLabel("Any Information");
		lblAnyInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnyInformation.setBounds(389, 249, 102, 14);
		panel.add(lblAnyInformation);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(360, 263, 169, 72);
		panel.add(scrollPane_9);
		
		JTextArea textArea_5 = new JTextArea();
		scrollPane_9.setViewportView(textArea_5);
		textArea_5.setLineWrap(true);
		textArea_5.setWrapStyleWord(true);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            String Name = "", Mobile = "", Email = "";
	    		
	    		Name = textField_12.getText();
	    		Mobile =textField_13.getText();
	    		Email = textField_14.getText();
	    		String ate=txtDdmmyyyy_3.getText();
	    		String context=textArea_3.getText();
	    		String cpi=textArea_4.getText();
	    		String any=textArea_5.getText();
	    		if(context.length()>100)
	    		{
	    			JOptionPane.showMessageDialog(table_3,
					        "Place of Meeting exceeds 100 chars.Casual friend not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else if(any.length()>100)
	    		{
	    			JOptionPane.showMessageDialog(table_3,
					        "Any other information exceeds 100 chars.Casual friend not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else if(cpi.length()>100)
	    		{
	    			JOptionPane.showMessageDialog(null,
					        "Circumstances of meeting exceeds 100 chars.Casual friend not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		};
	    		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-mm-yyyy");
	    		Date BDate=new Date();
	    		try {
					BDate = dateFormatter.parse(ate);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null,
					        "The date entered is not in dd/mm/yyyy.Casual Friend not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

	    		casual rel=new casual();
	    		rel.setName(Name);
	    		rel.setMob(Mobile);
	    		rel.setE_mail(Email);
	    		rel.setWhen(BDate);
	    		rel.setWhere(context);
	    		rel.setCircum(cpi);
	    		rel.setAny(any);
	    		casual.add(rel);
	    		Object[] president = {Name,Mobile, Email,BDate,context,cpi,any};
	    		 model3.addRow(president);
	    		 textField_12.setText(null);
		    	textField_13.setText(null);
		    	textField_14.setText(null);
		    	txtDdmmyyyy_3.setText("dd-mm-yyyy");
		    	textArea_3.setText(null);
		        textArea_4.setText(null);
		    	textArea_5.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(530, 245, 84, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					table_3.getSelectedRow();
					casual.remove(table_3.getSelectedRow());
					model3.removeRow(table_3.getSelectedRow());
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please select a casual friend by clicking a row of table to delete");
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(530, 281, 84, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Name=casual.get(table_3.getSelectedRow()).getName();
				 String Mobile=casual.get(table_3.getSelectedRow()).getMob();
				 String email=casual.get(table_3.getSelectedRow()).getE_mail();
				 Date bdate =casual.get(table_3.getSelectedRow()).getWhen();
				 String where=casual.get(table_3.getSelectedRow()).getWhere();
				 String circum=casual.get(table_3.getSelectedRow()).getCircum();
				 String any=casual.get(table_3.getSelectedRow()).getAny();
				 JOptionPane.showMessageDialog(table_3, "Name :"+Name+"\nMobile No :"+Mobile+"\nE-mail :"+email+"\nWhen met :"+bdate+"\nWhere met :"+where+"\nCircumstances in which met :"+circum+"\nAny other information :"+any, "Contact Infromation", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(530, 310, 84, 25);
	    panel.add(btnNewButton_3);
	}

	public static ArrayList<casual> get() {
		
		return casual;
	}

}
