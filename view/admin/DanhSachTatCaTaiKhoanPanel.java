package project.view.admin;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DanhSachTatCaTaiKhoanPanel extends JPanel {
	public JTable table1;
	private JScrollPane scrollPane1;
	//public JLabel lblFrameTitle;
	//private static final int TABLEWIDTH = 280;
	
	@SuppressWarnings("serial")
	public DanhSachTatCaTaiKhoanPanel () { // constructor.
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(70, 40, 300, 400);
		//this.setVisible(true); // DEBUG HERE PLEASE!
		setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 82, 280, 307);
		add(scrollPane1);
		
		table1 = new JTable();
		scrollPane1.setViewportView(table1);
		table1.setModel(getModelfromResultset(project.control.TaiKhoanControl.timTatCaTaiKhoan_ID_QuyenTruyCap()));
		
			
		
		
		JLabel lblDanhSchTt = new JLabel("Danh sách tất cả các tài khoản");
		lblDanhSchTt.setBounds(10, 38, 309, 14);
		add(lblDanhSchTt);
		lblDanhSchTt.setFont(new Font("Tahoma", Font.BOLD, 17));
		

	}
	
	@SuppressWarnings("serial")
	public DefaultTableModel getModelfromResultset(ResultSet rs) { // rs là kết quả của truy vấn select * from GiangVien
				
		DefaultTableModel newModel = new DefaultTableModel(0,2);
		newModel.setColumnIdentifiers(new String[] {"ID", "Quyền truy cập"});
		
		if (rs==null) return newModel; // NOTE HERE !  to prevent null pointer !
		
		try {
			Object[] objectArr = new Object[2];
			while (rs.next()) {
				objectArr[0] = new String(rs.getString("ID")!=null ? rs.getString("ID") : "");
				objectArr[1] = new String(rs.getString("QuyenTruyCap")!=null ? rs.getString("QuyenTruyCap") : "");
				
				newModel.addRow(objectArr);
            } 
		} catch (Exception e) {
			e.printStackTrace();
		}
		newModel.fireTableDataChanged();
		return newModel;
	}	
	
	public void updateTable() {
		table1.setModel(getModelfromResultset(project.control.TaiKhoanControl.timTatCaTaiKhoan_ID_QuyenTruyCap()));
	}
}
