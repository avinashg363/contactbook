

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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class rel {
	private static JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField txtDdmmyyyy;
	private static JTextField txtDdmmyyyy_1;
	private  JTable table;
	 static ArrayList<relatives> relatives = new ArrayList<relatives>();
	public static void loadFromFile() throws IOException, ClassNotFoundException {
		ObjectInputStream is;
		int coursecount;
		try{
			is = new ObjectInputStream(new FileInputStream("relatives"));
		}catch(FileNotFoundException e){
			coursecount = 0; return;
		}
		coursecount = is.readInt();
		for(int i=0; i<coursecount; i++){
			{relatives c=(relatives) is.readObject();
			relatives.add(c);
			}
			
		}
		
		is.close();
	}
	
	public static void saveToFile() throws FileNotFoundException, IOException {
		int coursecount=relatives.size();
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("relatives"));
		os.writeInt(coursecount);
		for(int i=0; i<coursecount; i++){
			os.writeObject(relatives.get(i));
		}
		os.close();
	}
	
	public void  newwindow()  {
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
		
		
		frame.setBounds(100, 100, 628, 370);
		frame.setTitle("RELATIVES");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JPanel relative = new JPanel();
		frame.setContentPane(relative);
		relative.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(23, 262, 46, 14);
		relative.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(68, 259, 86, 20);
		relative.add(textField);
		textField.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMobileNo.setBounds(176, 262, 59, 14);
		relative.add(lblMobileNo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 259, 86, 20);
		relative.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(358, 262, 46, 14);
		relative.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(409, 259, 86, 20);
		relative.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDate = new JLabel(" Meeting Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(10, 287, 93, 14);
		relative.add(lblDate);
		
		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDdmmyyyy.setText(null);
			}
		});
		txtDdmmyyyy.setText("dd-mm-yyyy");
		txtDdmmyyyy.setBounds(100, 284, 86, 20);
		relative.add(txtDdmmyyyy);
		txtDdmmyyyy.setColumns(10);
		
		JLabel lblBirthdate = new JLabel("BirthDate");
		lblBirthdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBirthdate.setBounds(201, 287, 59, 14);
		relative.add(lblBirthdate);
		
		txtDdmmyyyy_1 = new JTextField();
		txtDdmmyyyy_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDdmmyyyy_1.setText(null);
			}
		});
		txtDdmmyyyy_1.setText("dd-mm-yyyy");
		txtDdmmyyyy_1.setBounds(270, 284, 86, 20);
		relative.add(txtDdmmyyyy_1);
		txtDdmmyyyy_1.setColumns(10);
		
		JButton btnAddRelative = new JButton("Add Relative");
		
		btnAddRelative.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddRelative.setBounds(505, 258, 106, 23);
		relative.add(btnAddRelative);
		
		JButton btnDeleteRelative = new JButton("Delete Relative");
		
		btnDeleteRelative.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteRelative.setBounds(368, 283, 127, 23);
		relative.add(btnDeleteRelative);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Name=relatives.get(table.getSelectedRow()).getName();
				 String Mobile=relatives.get(table.getSelectedRow()).getMob();
				 String email=relatives.get(table.getSelectedRow()).getE_mail();
				 Date bdate =relatives.get(table.getSelectedRow()).getBday();
				 Date ldate=relatives.get(table.getSelectedRow()).getLdate();
				 JOptionPane.showMessageDialog(table, "Name :"+Name+"\nMobile No :"+Mobile+"\nE-mail :"+email+"\nBirthdate :"+bdate+"\nLast Meeting Date :"+ldate, "Contact Infromation", JOptionPane.PLAIN_MESSAGE);
				 
			}
		});
		btnView.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnView.setBounds(505, 283, 105, 23);
		relative.add(btnView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 611, 252);
		relative.add(scrollPane);
		
		table = new JTable(){
			public boolean isCellEditable(int x,int y){
				return false;
			}
		};
		scrollPane.setViewportView(table);
		DefaultTableModel model=new DefaultTableModel(new String[] {
				"Name", "Mobile No", "E-Mail", "Birthdate", "Meeting Date"
			},0
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		} ;
		table.setModel(model);
		if(table.getRowCount()==0)
		for(int i=0;i<relatives.size();i++)
		{
			model.addRow(new Object[]{relatives.get(i).getName(),relatives.get(i).getMob(),relatives.get(i).getE_mail(),relatives.get(i).getBday(),relatives.get(i).getLdate()});
		}
		
		btnDeleteRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					table.getSelectedRow();
					relatives.remove(table.getSelectedRow());
					model.removeRow(table.getSelectedRow());
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please select a relativeby clicking a row of table to delete");
				}
				

			}
		});
		
		btnAddRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                String Name = "", Mobile = "", Email = "", Bdate = "",Ldate="";
	    		
	    		Name = textField.getText();
	    		Mobile =textField_1.getText();
	    		Email = textField_2.getText();
	    		Bdate=txtDdmmyyyy_1.getText();
	    		Ldate=txtDdmmyyyy.getText();
	    		
	    		// Will convert from string to date
	    		
	    		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-mm-yyyy");
	    		Date BDate=new Date();
	    		Date LDate=new Date();
	    		try {
					BDate = dateFormatter.parse(Bdate);
					LDate = dateFormatter.parse(Ldate);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(table,
					        "The date entered is not in dd/mm/yyyy.Relative not added",
					        "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
	    		relatives rel=new relatives();
	    		rel.setName(Name);
	    		rel.setMob(Mobile);
	    		rel.setE_mail(Email);
	    		rel.setBday(BDate);
	    		rel.setLdate(LDate);
	    		relatives.add(rel);
	    		Object[] president = {Name,Mobile, Email,BDate,LDate};
	    		 model.addRow(president);
	    		 txtDdmmyyyy_1.setText("dd-mm-yyyy");
	    		 txtDdmmyyyy.setText("dd-mm-yyyy");
	    		 textField.setText(null);
		         textField_1.setText(null);
		    	 textField_2.setText(null);
			}
		});
	}

	public ArrayList<relatives> get() {
		
		return relatives;
	}

}
