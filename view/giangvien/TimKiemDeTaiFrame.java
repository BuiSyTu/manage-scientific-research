package project.view.giangvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import project.control.DeTaiControl;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TimKiemDeTaiFrame extends JFrame {
	private JTable table1;
	private JScrollPane scrollPane;
	private JTextField txtCumTuTimKiem;

	
	public TimKiemDeTaiFrame(project.model.GiangVien giangVien) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 514);
		this.setVisible(true); // DEBUG HERE PLEASE!
		getContentPane().setLayout(null);
		
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		this.setVisible(true); // DEBUG HERE PLEASE!
//		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 763, 277);
		getContentPane().add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JLabel lblThongkedetaitheochuyende = new JLabel("Thống kê đề tài theo chuyên đề");
		lblThongkedetaitheochuyende.setBounds(256, 15, 292, 33);
		lblThongkedetaitheochuyende.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(lblThongkedetaitheochuyende);
		
		txtCumTuTimKiem = new JTextField();
		txtCumTuTimKiem.setBounds(10, 86, 203, 20);
		getContentPane().add(txtCumTuTimKiem);
		txtCumTuTimKiem.setColumns(10);
		
		JLabel lblNhpCmT = new JLabel("Nhập cụm từ tìm kiếm");
		lblNhpCmT.setBounds(10, 61, 203, 14);
		getContentPane().add(lblNhpCmT);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Tên đề tài", "Mã đề tài", "Tên giảng viên", "Mã giảng viên", "Chuyên đề"}));
		comboBox.setBounds(256, 86, 155, 20);
		getContentPane().add(comboBox);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rsTemp = project.control.DeTaiControl.timKiemDeTai(txtCumTuTimKiem.getText(), comboBox.getSelectedItem().toString());
				if (rsTemp!=null) {
					table1.setModel(getModelfromResultset(rsTemp));
				} else {
					table1.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								""
							}
						));
				}
			}
		});
		btnTm.setBounds(447, 85, 89, 23);
		getContentPane().add(btnTm);
		
		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo");
		lblTmKimTheo.setBounds(256, 61, 155, 14);
		getContentPane().add(lblTmKimTheo);
		
		JButton btnThamGia = new JButton("Tham gia đề tài này");
		btnThamGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowID = table1.getSelectedRow();
				if (selectedRowID >= 0) { // Nếu user đã chọn 1 dòng.
					String trangthaiTemp = table1.getValueAt(selectedRowID, 2).toString();
					if (trangthaiTemp.equals("Đang làm")) { // nếu đề tài đã chọn vẫn đang làm thì OK.
						int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn tham đề tài này ?", "Tham gia đề tài", JOptionPane.YES_NO_OPTION);
				        if (reply == JOptionPane.YES_OPTION) { // Nếu user ấn YES.
				        	String madetaiTemp = table1.getValueAt(selectedRowID, 0).toString();
							if (project.control.DeTaiControl.dangKyThamGiaDeTaiDaCo(giangVien.getMaGV(),madetaiTemp)==true) {
								JOptionPane.showMessageDialog(null, "Đăng ký tham gia thành công !");
							} else {
								//JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra !");
							}
				        }						
					} else { // Nếu đề tài không ở trạng thái "Đang làm" thì không thể tham gia.
						JOptionPane.showMessageDialog(null, "Không thể tham gia do đề tài có trạng thái : "+trangthaiTemp);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn hãy chọn một đề tài");
				}
			}
		});
		btnThamGia.setBounds(277, 430, 160, 23);
		getContentPane().add(btnThamGia);
		
		
		
	}
	
	 
	public DefaultTableModel getModelfromResultset(ResultSet rs) {		
		
		DefaultTableModel newModel = new DefaultTableModel(0,6);
		newModel.setColumnIdentifiers(new String[] {"Ma De Tai", "Ten De Tai", "TinhTrang", "ThoiGianBatDau", "ThoiGianKetThuc", "KinhPhi"});
		 
		if (rs==null) {
			System.out.println("DEBUG <code026329> : rs is null !");
			return newModel; // NOTE HERE !
		}
				
		try {
			Object[] objectArr = new Object[6];
			System.out.println("DEBUG : print rs : ");
			while (rs.next()) {
//				for (int col=0; col <= 5; col++) {
//					objectArr[col] = new String(rs.getString(col+1));
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
		//newModel.fireTableDataChanged(); // DEBUG HERE !
		return newModel;
	}
}
