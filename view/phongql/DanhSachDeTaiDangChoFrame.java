//NTS.
package project.view.phongql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.view.Main;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;



@SuppressWarnings("serial")
public class DanhSachDeTaiDangChoFrame extends JFrame { // báº¯t buá»™c PHáº¢I lÃ  JFrame á»Ÿ Ä‘Ã¢y !	
	public JTable table1;
	private JScrollPane scrollPane1;
	public JLabel lblFrameTitle;
	private JButton btnXemchitiet;
	public DanhSachDeTaiDangChoFrame thisFrame = this;
	private JLabel lblChnMtTrong;
	
	@SuppressWarnings("serial")
	public DanhSachDeTaiDangChoFrame () { // constructor.
		ResultSet rs__getAllDeTaiDangCho = project.control.DeTaiControl.getAllDeTaiDangCho();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1150, 520);
		this.setVisible(true); // DEBUG HERE PLEASE!
		getContentPane().setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 82, 1114, 300);
		getContentPane().add(scrollPane1);
		
		table1 = new JTable();
		scrollPane1.setViewportView(table1);
		table1.setModel(getModelfromResultset(rs__getAllDeTaiDangCho));
		table1.getColumnModel().getColumn(0).setPreferredWidth(20);
		table1.getColumnModel().getColumn(1).setPreferredWidth(120);
		table1.getColumnModel().getColumn(2).setPreferredWidth(35);
		table1.getColumnModel().getColumn(3).setPreferredWidth(45);
		table1.getColumnModel().getColumn(4).setPreferredWidth(45);
		table1.getColumnModel().getColumn(5).setPreferredWidth(120);
		
		lblFrameTitle = new JLabel();
		lblFrameTitle.setText("Danh sách đề tài đang đợi duyệt");
		lblFrameTitle.setBounds(268, 11, 297, 34);
		lblFrameTitle.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(lblFrameTitle);
		
		btnXemchitiet = new JButton("Xem chi tiết đề tài");
		btnXemchitiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Hey : "+table1.getSelectedRow());
				int selectedRow = table1.getSelectedRow();
				if (selectedRow==-1) { // Nếu user đang không bấm vào hàng nào trong bảng. (-1 là do máy trả về !)
					JOptionPane.showMessageDialog(null, "Bạn hãy chọn một đề tài trong bảng");
					return;
				}
				String maDeTaiSelected = (String)table1.getValueAt(selectedRow, 0);
				System.out.println("at : btnXemchitiet :"+maDeTaiSelected+"|||");
				ResultSet rsXXX = project.control.DeTaiControl.getResultSet_fromDeTai_byMaDeTai(maDeTaiSelected);

				try {
//					if (rs.next()) {
//						new ChiTietMotDeTaiDangXetPanel(rs.getString("MaDeTai"), rs.getString("TenDeTai"), rs.getString("ThoiGianBatDau"), rs.getString("TinhTrang"), rs.getString("ChuyenDe"), rs.getString("KinhPhi"), rs.getString("NoiDung"), rs.getString("Cap") );
//					}
					rsXXX.next();
					new ChiTietMotDeTaiDangXetFrame(thisFrame, rsXXX.getString("MaDeTai"), rsXXX.getString("TenDeTai"), rsXXX.getString("ThoiGianBatDau"), rsXXX.getString("TinhTrang"), rsXXX.getString("ChuyenDe"), rsXXX.getString("KinhPhi"), rsXXX.getString("NoiDung"), rsXXX.getString("Cap") );
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnXemchitiet.setBounds(143, 418, 186, 23);
		getContentPane().add(btnXemchitiet);
		
		lblChnMtTrong = new JLabel("Chọn một trong các đề tài dưới đây rồi bấm \"Xem chi tiết đề tài\" để duyệt");
		lblChnMtTrong.setBounds(10, 57, 530, 14);
		getContentPane().add(lblChnMtTrong);
		
		table1.getColumnModel().getColumn(0).setResizable(false);
		table1.getColumnModel().getColumn(1).setResizable(false);
		table1.getColumnModel().getColumn(2).setResizable(false);
		table1.getColumnModel().getColumn(3).setResizable(false);
		table1.getColumnModel().getColumn(4).setResizable(false);
		table1.getColumnModel().getColumn(5).setResizable(false);	
		
		//modifyModelOfTableFromResultSet(rs);

	}
	
	
	public DefaultTableModel getModelfromResultset(ResultSet rs) {
		
		
		DefaultTableModel newModel = new DefaultTableModel(0,6);
		newModel.setColumnIdentifiers(new String[] {"Mã đề tài", "Tên đề tài", "Tình trạng", "Thời gian bắt đầu", "Thời gian kết thúc", "Kinh phí"});
		
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
	
	
	
	
	public void updateTable() {
		ResultSet rs__getAllDeTaiDangCho = project.control.DeTaiControl.getAllDeTaiDangCho();
		table1.setModel(getModelfromResultset(rs__getAllDeTaiDangCho));
	}
}