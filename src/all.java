

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class all {
	
	static ArrayList<relatives> relatives = new ArrayList<relatives>();
	static ArrayList<pfrnd> pro = new ArrayList<pfrnd>();
	static ArrayList<perfrnd> per = new ArrayList<perfrnd>();
	static ArrayList<casual> casual = new ArrayList<casual>();
	private JTable table_5;
	private JTextField textField_16;
	private JTable table_4;
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
		frame.setTitle("DISPLAY ALL CONTACTS");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel_4 = new JPanel();
		
		frame.setContentPane(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(10, 11, 593, 313);
		panel_4.add(scrollPane_11);
		
		table_5 = new JTable(){
			public boolean isCellEditable(int x,int y){
				return false;
			}
		};
		scrollPane_11.setViewportView(table_5);
		DefaultTableModel model5=(new DefaultTableModel(
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
		});
		table_5.setModel(model5);
	   
		    	  
		    	  for (int i =table_5.getRowCount()- 1; i >= 0; i--) {
					    model5.removeRow(i);
					}
					
					for(int i=0;i<relatives.size();i++)
				       {
						     String na=relatives.get(i).getName();
							 String Mobile=relatives.get(i).getMob();
							 String email=relatives.get(i).getE_mail();
							 String cat="relatives";
							 Object[] president = {na,Mobile,email,cat};
							 model5.addRow(president);
				       }  
					for(int i=0;i<pro.size();i++)
				       {
						     String na=pro.get(i).getName();
							 String Mobile=pro.get(i).getMob();
							 String email=pro.get(i).getE_mail();
							 String cat="professional friends";
							 Object[] president = {na,Mobile,email,cat};
							 model5.addRow(president);
				       } 
					for(int i=0;i<per.size();i++)
				       {
						     String na=per.get(i).getName();
							 String Mobile=per.get(i).getMob();
							 String email=per.get(i).getE_mail();
							 String cat="personal friends";
							 Object[] president = {na,Mobile,email,cat};
							 model5.addRow(president);
				       }
					for(int i=0;i<casual.size();i++)
				       {
						     String na=casual.get(i).getName();
							 String Mobile=casual.get(i).getMob();
							 String email=casual.get(i).getE_mail();
							 String cat="casual friends";
							 Object[] president = {na,Mobile,email,cat};
							 model5.addRow(president);
				       }
		    

	
	}
}
