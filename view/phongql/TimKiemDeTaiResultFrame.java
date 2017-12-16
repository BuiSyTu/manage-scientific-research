//NTS.
package project.view.phongql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class TimKiemDeTaiResultFrame extends JFrame { // báº¯t buá»™c PHáº¢I lÃ  JFrame á»Ÿ Ä‘Ã¢y !	
	public JTable table1;
	private JScrollPane scrollPane1;
	public JLabel lblFrameTitle;
	
	@SuppressWarnings("serial")
	public TimKiemDeTaiResultFrame (ResultSet rs) { // constructor.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1150, 520);
		this.setVisible(true); // DEBUG HERE PLEASE!
		getContentPane().setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 82, 1114, 389);
		getContentPane().add(scrollPane1);
		
		table1 = new JTable();
		scrollPane1.setViewportView(table1);
		table1.setModel(getModelfromResultset(rs));
		table1.getColumnModel().getColumn(0).setPreferredWidth(20);
		table1.getColumnModel().getColumn(1).setPreferredWidth(120);
		table1.getColumnModel().getColumn(2).setPreferredWidth(35);
		table1.getColumnModel().getColumn(3).setPreferredWidth(45);
		table1.getColumnModel().getColumn(4).setPreferredWidth(45);
		table1.getColumnModel().getColumn(5).setPreferredWidth(120);
		
		lblFrameTitle = new JLabel();
		lblFrameTitle.setBounds(268, 37, 297, 34);
		lblFrameTitle.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(lblFrameTitle);
		
		table1.getColumnModel().getColumn(0).setResizable(false);
		table1.getColumnModel().getColumn(1).setResizable(false);
		table1.getColumnModel().getColumn(2).setResizable(false);
		table1.getColumnModel().getColumn(3).setResizable(false);
		table1.getColumnModel().getColumn(4).setResizable(false);
		table1.getColumnModel().getColumn(5).setResizable(false);	
		
		//modifyModelOfTableFromResultSet(rs);

	}
	
	@SuppressWarnings("serial")
	public DefaultTableModel getModelfromResultset(ResultSet rs) {
		
		
		DefaultTableModel newModel = new DefaultTableModel(0,6);
		newModel.setColumnIdentifiers(new String[] {"MaDeTai", "TenDeTai", "TinhTrang", "ThoiGianBatDau", "ThoiGianKetThuc", "KinhPhi"});
		
		if (rs==null) return newModel; // NOTE HERE !  to prevent null pointer !
					
		//DefaultTableModel model1 = (DefaultTableModel) table1.getModel(); 
		
		try {
			Object[] objectArr = new Object[6];
			while (rs.next()) {
//				for (int col=0; col <= 5; col++) {
//					objectArr[col] = new String(rs.getString(col+1));
//				}
//				for (int col=0; col <= 5; col++) {
//					System.out.print(objectArr[col]);// = new String(rs.getString(col+1));
//				}
				objectArr[0] = new String(rs.getString("MaDeTai")!=null ? rs.getString("MaDeTai") : "");
				objectArr[1] = new String(rs.getString("TenDeTai")!=null ? rs.getString("TenDeTai") : "");
				objectArr[2] = new String(rs.getString("TinhTrang")!=null ? rs.getString("TinhTrang") : "");
				objectArr[3] = new String(rs.getString("ThoiGianBatDau")!=null ? rs.getString("ThoiGianBatDau") : "");
				objectArr[4] = new String(rs.getString("ThoiGianKetThuc")!=null ? rs.getString("ThoiGianKetThuc") : "");
				objectArr[5] = new String(rs.getString("KinhPhi")!=null ? rs.getString("KinhPhi") : "");
				newModel.addRow(objectArr);
            } 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		newModel.fireTableDataChanged();
		return newModel;
	}
}