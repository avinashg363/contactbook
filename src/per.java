
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class per {

	
	private static JTable table_2;
	private static JTextField textField_8;
	private static JTextField textField_9;
	private static JTextField textField_10;
	private static JTextField txtDdmmyyyy_2;
	static ArrayList<perfrnd> per = new ArrayList<perfrnd>();
	
	public static void loadFromFile2() throws IOException, ClassNotFoundException {
		ObjectInputStream is;
		int coursecount;
		try{
			is = new ObjectInputStream(new FileInputStream("perfrnd"));
		}catch(FileNotFoundException e){
			coursecount = 0; return;
		}
		coursecount = is.readInt();
		for(int i=0; i<coursecount; i++){
			{perfrnd c=(perfrnd) is.readObject();
			per.add(c);
			}
			
		}
		
		is.close();
	}
	
	public static void saveToFile2() throws FileNotFoundException, IOException {
		int coursecount=per.size();
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("perfrnd"));
		os.writeInt(coursecount);
		for(int i=0; i<coursecount; i++){
			os.writeObject(per.get(i));
		}
		os.close();
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void  newwindow()   {
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
		
		frame.setTitle("Personal Friends");
		frame.setBounds(100, 100, 628, 370);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel_2 = new JPanel();
		frame.setContentPane(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 613, 218);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable(){
			public boolean isCellEditable(int x,int y){
				return false;
			}
		};
		scrollPane_2.setViewportView(table_2);
		DefaultTableModel model2=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Mobile Number", "E-Mail", "Context", "Special Events", "Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		table_2.setModel(model2);
		if(table_2.getRowCount()==0)
		for(int i=0;i<per.size();i++)
		{
			model2.addRow(new Object[]{per.get(i).getName(),per.get(i).getMob(),per.get(i).getE_mail(),per.get(i).getContext(),per.get(i).getSpec_events(),per.get(i).getDate()});
		}
		
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName_2.setBounds(10, 229, 46, 14);
		panel_2.add(lblName_2);
		
		textField_8 = new JTextField();
		textField_8.setBounds(50, 226, 86, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblMobileNo_2 = new JLabel("Mobile No");
		lblMobileNo_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMobileNo_2.setBounds(146, 229, 54, 14);
		panel_2.add(lblMobileNo_2);
		
		textField_9 = new JTextField();
		textField_9.setBounds(208, 226, 86, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblEmail_2 = new JLabel("E-Mail");
		lblEmail_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail_2.setBounds(304, 229, 46, 14);
		panel_2.add(lblEmail_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(346, 226, 133, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate_1.setBounds(495, 229, 46, 14);
		panel_2.add(lblDate_1);
		
		txtDdmmyyyy_2 = new JTextField();
		txtDdmmyyyy_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDdmmyyyy_2.setText(null);	
			}
		});
		txtDdmmyyyy_2.setText("dd-mm-yyyy");
		txtDdmmyyyy_2.setBounds(525, 227, 85, 20);
		panel_2.add(txtDdmmyyyy_2);
		txtDdmmyyyy_2.setColumns(10);
		
		JLabel lblContext = new JLabel("Context");
		lblContext.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContext.setBounds(10, 254, 46, 14);
		panel_2.add(lblContext);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(66, 249, 168, 75);
		panel_2.add(scrollPane_3);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_3.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		
		JLabel lblSpecialEvents = new JLabel("Special Events");
		lblSpecialEvents.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpecialEvents.setBounds(244, 257, 86, 14);
		panel_2.add(lblSpecialEvents);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(329, 249, 175, 75);
		panel_2.add(scrollPane_5);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_5.setViewportView(textArea_2);
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name = "", Mobile = "", Email = "";
	    		
	    		Name = textField_8.getText();
	    		Mobile =textField_9.getText();
	    		Email = textField_10.getText();
	    		String ate=txtDdmmyyyy_2.getText();
	    		String context=textArea_1.getText();
	    		String cpi=textArea_2.getText();
	    		if(context.length()>100)
	    		{
	    			JOptionPane.showMessageDialog(table_2,
					        "Context of Meeting exceed 100 chars.Personal friend not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		else if(cpi.length()>100)
	    		{
	    			JOptionPane.showMessageDialog(null,
					        "Special Events exceed 100 chars.Persoonal friend not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		};
	    		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-mm-yyyy");
	    		Date BDate=new Date();
	    		try {
					BDate = dateFormatter.parse(ate);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null,
					        "The date entered is not in dd/mm/yyyy.Personal Friend not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

	    		perfrnd rel=new perfrnd();
	    		rel.setName(Name);
	    		rel.setMob(Mobile);
	    		rel.setE_mail(Email);
	    		rel.setDate(BDate);
	    		rel.setContext(context);
	    		rel.setSpec_events(cpi);
	    		per.add(rel);
	    		Object[] president = {Name,Mobile, Email,context,cpi,BDate};
	    		 model2.addRow(president);
	    		 textField_8.setText(null);
		         textField_9.setText(null);
		    	 textField_10.setText(null);
		    	 txtDdmmyyyy_2.setText("dd-mm-yyyy");
		         textArea_1.setText(null);
		    	 textArea_2.setText(null);
		}
	});
		btnAdd_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd_1.setBounds(524, 254, 89, 23);
		panel_2.add(btnAdd_1);
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					table_2.getSelectedRow();
					per.remove(table_2.getSelectedRow());
					model2.removeRow(table_2.getSelectedRow());
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please select a personal friendby clicking a row of table to delete");
				}
				
			}
		});
		btnRemove_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove_1.setBounds(525, 282, 89, 23);
		panel_2.add(btnRemove_1);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Name=per.get(table_2.getSelectedRow()).getName();
				 String Mobile=per.get(table_2.getSelectedRow()).getMob();
				 String email=per.get(table_2.getSelectedRow()).getE_mail();
				 Date date=per.get(table_2.getSelectedRow()).getDate();
				 String bdate =per.get(table_2.getSelectedRow()).getContext();
				 String ev=per.get(table_2.getSelectedRow()).getSpec_events();
				
				 JOptionPane.showMessageDialog(null, "Name :"+Name+"\nMobile No :"+Mobile+"\nE-mail :"+email+"\nContext in which acquainted :"+bdate+"\nDate on which acquainted"+date+"\nSpecial Events:"+ev, "Contact Infromation", JOptionPane.PLAIN_MESSAGE);
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(524, 307, 89, 23);
		panel_2.add(btnNewButton);
		
	}
	public ArrayList<perfrnd> get() {
		
		// TODO Auto-generated method stub
		return per;
	}

}
