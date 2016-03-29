

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class search {
	static ArrayList<relatives> relatives = new ArrayList<relatives>();
	static ArrayList<pfrnd> pro = new ArrayList<pfrnd>();
	static ArrayList<perfrnd> per = new ArrayList<perfrnd>();
	static ArrayList<casual> casual = new ArrayList<casual>();
	
	private static JTextField textField_16;
	private static JTable table_4;
	public void  newwindow() {
		rel r=new rel();
		relatives=r.get();
		pro p=new pro();
		pro=p.get();
		per pe=new per();
		per=pe.get();
	    cas c=new cas();
		casual=c.get();
		JFrame frame=new JFrame();
		frame.setBounds(100, 100, 628, 370);
		frame.setTitle("SEARCH");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel_3 = new JPanel();
		frame.setContentPane(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearch.setBounds(53, 11, 46, 14);
		panel_3.add(lblSearch);
		
		textField_16 = new JTextField();
		textField_16.setBounds(108, 8, 86, 20);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(10, 45, 593, 256);
		panel_3.add(scrollPane_10);
		
		table_4 = new JTable(){
			public boolean isCellEditable(int x,int y){
				return false;
			}
		};
		scrollPane_10.setViewportView(table_4);
		DefaultTableModel model4=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Mobile No", "E-Mail", "Category"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		
		table_4.setModel(model4);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i =table_4.getRowCount()- 1; i >= 0; i--) {
				    model4.removeRow(i);
				}
				String search=textField_16.getText();
				for(int i=0;i<relatives.size();i++)
			       {
					int k=search.compareTo(relatives.get(i).getName());
					if(k==0)
					 {
						 String Mobile=relatives.get(i).getMob();
						 String email=relatives.get(i).getE_mail();
						 String cat="relatives";
						 Object[] president = {search,Mobile,email,cat};
						 model4.addRow(president);
					 }
			       }  
				for(int i=0;i<pro.size();i++)
			       {
					int k=search.compareTo(pro.get(i).getName());
					if(k==0)
					 {
						String Mobile=pro.get(i).getMob();
						 String email=pro.get(i).getE_mail();
						 String cat="professional friends";
						 Object[] president = {search,Mobile,email,cat};
						 model4.addRow(president);
					 } 
			       } 
				for(int i=0;i<per.size();i++)
			       {
					int k=search.compareTo(per.get(i).getName());
					if(k==0)
					 {
						String Mobile=per.get(i).getMob();
						 String email=per.get(i).getE_mail();
						 String cat="personal friends";
						 Object[] president = {search,Mobile,email,cat};
						 model4.addRow(president);
					 } 
			       } 
				for(int i=0;i<casual.size();i++)
			       {
					int k=search.compareTo(casual.get(i).getName());
					if(k==0)
					 {
						String Mobile=per.get(i).getMob();
						 String email=per.get(i).getE_mail();
						 String cat="casual friends";
						 Object[] president = {search,Mobile,email,cat};
						 model4.addRow(president);
					 } 
			       } 
				textField_16.setText(null);
			}
		});
		btnNewButton_4.setBounds(213, 7, 89, 23);
		panel_3.add(btnNewButton_4);
		
	}

}
