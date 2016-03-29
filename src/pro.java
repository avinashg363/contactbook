

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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


public class pro {
	
	private static JTextField textField_8;
	private static JTextField textField_9;
	private static JTextField textField_10;
	private static JTextField txtDdmmyyyy_2;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTable table_1;
	static ArrayList<pfrnd> pro = new ArrayList<pfrnd>();
	
	public static void loadFromFile1() throws IOException, ClassNotFoundException {
		ObjectInputStream is;
		int coursecount;
		try{
			is = new ObjectInputStream(new FileInputStream("pfrnd"));
		}catch(FileNotFoundException e){
			coursecount = 0; return;
		}
		coursecount = is.readInt();
		for(int i=0; i<coursecount; i++){
			{pfrnd c=(pfrnd) is.readObject();
			pro.add(c);
			}
			
		}
		
		is.close();
	}
	
	public static void saveToFile1() throws FileNotFoundException, IOException {
		int coursecount=pro.size();
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("pfrnd"));
		os.writeInt(coursecount);
		for(int i=0; i<coursecount; i++){
			os.writeObject(pro.get(i));
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
		frame.setTitle("Professional Friends");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel_1 = new JPanel();
		frame.setContentPane(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName_1.setBounds(10, 243, 46, 14);
		panel_1.add(lblName_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(51, 240, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMobileNo_1 = new JLabel("Mobile No");
		lblMobileNo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMobileNo_1.setBounds(147, 243, 54, 14);
		panel_1.add(lblMobileNo_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(206, 240, 86, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("E-Mail");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail_1.setBounds(308, 243, 46, 14);
		panel_1.add(lblEmail_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(356, 240, 158, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblCommonProfessionalInterests = new JLabel("Common Professional interests");
		lblCommonProfessionalInterests.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommonProfessionalInterests.setBounds(10, 268, 191, 14);
		panel_1.add(lblCommonProfessionalInterests);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(190, 271, 324, 53);
		panel_1.add(scrollPane_4);
		
		JTextArea textArea = new JTextArea();
		scrollPane_4.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(514, 239, 89, 23);
		panel_1.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove.setBounds(514, 264, 89, 23);
		panel_1.add(btnRemove);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 613, 232);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable(){
			public boolean isCellEditable(int x,int y){
				return false;
			}
		};
		scrollPane_1.setViewportView(table_1);
		DefaultTableModel model1=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Mobile No", "E-Mail", "Common Professional Interest"
			}
		);
		table_1.setModel(model1);
		
		JButton btnView_1 = new JButton("View");
		btnView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Name=pro.get(table_1.getSelectedRow()).getName();
				 String Mobile=pro.get(table_1.getSelectedRow()).getMob();
				 String email=pro.get(table_1.getSelectedRow()).getE_mail();
				 String bdate =pro.get(table_1.getSelectedRow()).getcpi();
				
				 JOptionPane.showMessageDialog(table_1, "Name :"+Name+"\nMobile No :"+Mobile+"\nE-mail :"+email+"\nCommon Professional Interests :"+bdate, "Contact Infromation", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnView_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnView_1.setBounds(514, 289, 89, 23);
		panel_1.add(btnView_1);
		
		if(table_1.getRowCount()==0)
		for(int i=0;i<pro.size();i++)
		{
			model1.addRow(new Object[]{pro.get(i).getName(),pro.get(i).getMob(),pro.get(i).getE_mail(),pro.get(i).getcpi()});
		}
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Name = "", Mobile = "", Email = "";
		    		
		    		Name = textField_5.getText();
		    		Mobile =textField_6.getText();
		    		Email = textField_7.getText();
		    		String cpi=textArea.getText();
		    		if(cpi.length()>100)
		    		{
		    			JOptionPane.showMessageDialog(null,
						        "Common Professional Interests exceed 100 chars.Professional friend not added",
						        "ERROR", JOptionPane.ERROR_MESSAGE);
		    			return;
		    		};

		    		pfrnd rel=new pfrnd();
		    		rel.setName(Name);
		    		rel.setMob(Mobile);
		    		rel.setE_mail(Email);
		    		rel.setcpi(cpi);
		    		pro.add(rel);
		    		Object[] president = {Name,Mobile, Email,cpi};
		    		 model1.addRow(president);
		    		 textField_5.setText(null);
			         textField_6.setText(null);
			         textField_7.setText(null);
			    	 textArea.setText(null);
			}
		}
	);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					table_1.getSelectedRow();
					pro.remove(table_1.getSelectedRow());
					model1.removeRow(table_1.getSelectedRow());
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please select a professional friend by clicking a row of tableto delete");
				}
				
			}
		});
	}

	public ArrayList<pfrnd> get() {
		
		// TODO Auto-generated method stub
		return pro;
	}
}
