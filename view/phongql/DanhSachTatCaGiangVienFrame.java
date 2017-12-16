package project.view.phongql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class DanhSachTatCaGiangVienFrame extends JFrame {
	public JTable table1;
	private JScrollPane scrollPane1;
	public JLabel lblFrameTitle;
	private static final int TABLEWIDTH = 1114;
	
	@SuppressWarnings("serial")
	public DanhSachTatCaGiangVienFrame () { // constructor.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1150, 520);
		this.setVisible(true); // DEBUG HERE PLEASE!
		getContentPane().setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 82, TABLEWIDTH, 389);
		getContentPane().add(scrollPane1);
		
		table1 = new JTable();
		scrollPane1.setViewportView(table1);
		table1.setModel(getModelfromResultset(project.control.GiangVienControl.timTatCaGiangVien()));
		table1.getColumnModel().getColumn(0).setPreferredWidth((int)(TABLEWIDTH*9/100));
		table1.getColumnModel().getColumn(1).setPreferredWidth((int)(TABLEWIDTH*18/100));
		table1.getColumnModel().getColumn(2).setPreferredWidth((int)(TABLEWIDTH*9/100));
		table1.getColumnModel().getColumn(3).setPreferredWidth((int)(TABLEWIDTH*10/100));
		table1.getColumnModel().getColumn(4).setPreferredWidth((int)(TABLEWIDTH*15/100));
		table1.getColumnModel().getColumn(5).setPreferredWidth((int)(TABLEWIDTH*10/100));
		table1.getColumnModel().getColumn(6).setPreferredWidth((int)(TABLEWIDTH*10/100));
		table1.getColumnModel().getColumn(7).setPreferredWidth((int)(TABLEWIDTH*19/100));
		
		lblFrameTitle = new JLabel("Danh sách tất cả các giảng viên");
		lblFrameTitle.setBounds(418, 37, 297, 34);
		lblFrameTitle.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(lblFrameTitle);
		

	}
	
	@SuppressWarnings("serial")
	public DefaultTableModel getModelfromResultset(ResultSet rs) { // rs là kết quả của truy vấn select * from GiangVien
				
		DefaultTableModel newModel = new DefaultTableModel(0,8);
		newModel.setColumnIdentifiers(new String[] {"Mã giảng viên", "Tên giảng viên", "Giới tính", "Ngày sinh", "Chức danh", "Số điện thoại", "Ngày vào Đảng" , "Tên bộ môn"});
		
		if (rs==null) return newModel; // NOTE HERE !  to prevent null pointer !
		
		try {
			Object[] objectArr = new Object[8];
			while (rs.next()) {
				objectArr[0] = new String(rs.getString("MaGV")!=null ? rs.getString("MaGV") : "");
				objectArr[1] = new String(rs.getString("TenGV")!=null ? rs.getString("TenGV") : "");
				objectArr[2] = new String(rs.getString("GioiTinh")!=null ? rs.getString("GioiTinh") : "");
				objectArr[3] = new String(getVNdateFromUSdate(rs.getString("NgaySinh")));
				objectArr[4] = new String(rs.getString("ChucDanh")!=null ? rs.getString("ChucDanh") : "");
				objectArr[5] = new String(rs.getString("DienThoai")!=null ? rs.getString("DienThoai") : "");
				objectArr[6] = new String(getVNdateFromUSdate(rs.getString("NgayVaoDang")));
				objectArr[7] = new String(rs.getString("TenBoMon")!=null ? rs.getString("TenBoMon") : "");
				newModel.addRow(objectArr);
            } 
		} catch (Exception e) {
			e.printStackTrace();
		}
		newModel.fireTableDataChanged();
		return newModel;
	}
	
	private String getVNdateFromUSdate(String dateUS) {
		if (dateUS==null) return new String("");
		String nam = dateUS.substring(0,4);
		String thang = dateUS.substring(5,7);
		String ngay = dateUS.substring(8,10);
		return new String(ngay+"-"+thang+"-"+nam);
	}
}
