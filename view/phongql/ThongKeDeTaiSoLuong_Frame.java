package project.view.phongql;

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

public class ThongKeDeTaiSoLuong_Frame extends JFrame {
	private JTable tableOverrall;

	private String TIEUCHI = "1";
	
	public ThongKeDeTaiSoLuong_Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 514);
		this.setVisible(true); // DEBUG HERE PLEASE!
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Thống kê đề tài");
		lblTitle.setBounds(256, 15, 292, 33);
		lblTitle.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(lblTitle);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 99, 763, 365);
		getContentPane().add(scrollPane_1);
		
		tableOverrall = new JTable();
		tableOverrall.setModel(getModel_theoChuyenDe(project.control.DeTaiControl.thongKe_SoLuongDeTai_TheoChuyenDe())); // DEFAULT !
		scrollPane_1.setViewportView(tableOverrall);
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(10, 56, 115, 20);
//		getContentPane().add(comboBox);
		
		JComboBox<String> cbbTieuChi = new JComboBox<String>();
		cbbTieuChi.setBounds(97, 57, 115, 20);
		String[] optionForTieuChi = {"1. Chuyên đề","2. Cấp"};
		cbbTieuChi.setModel(new DefaultComboBoxModel<String>(optionForTieuChi));
		cbbTieuChi.addActionListener (new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {
				TIEUCHI = String.valueOf(cbbTieuChi.getSelectedItem()).substring(0, 1); // encrypt ...
				if (TIEUCHI.equals("1")) {
					tableOverrall.setModel(getModel_theoChuyenDe(project.control.DeTaiControl.thongKe_SoLuongDeTai_TheoChuyenDe()));
				} else if (TIEUCHI.equals("2")) {
					tableOverrall.setModel(getModel_theoCap(project.control.DeTaiControl.thongKe_SoLuongDeTai_TheoCap()));
				}
		    }
		});
		getContentPane().add(cbbTieuChi);
		
		JLabel lblThngKTheo = new JLabel("Thống kê theo :");
		lblThngKTheo.setBounds(10, 60, 107, 14);
		getContentPane().add(lblThngKTheo);
		
	}
	
	 
	public DefaultTableModel getModelfromResultset(ResultSet rs) {		
		
		DefaultTableModel newModel = new DefaultTableModel(0,6);
		newModel.setColumnIdentifiers(new String[] {"MaDeTai", "TenDeTai", "TinhTrang", "ThoiGianBatDau", "ThoiGianKetThuc", "KinhPhi"});
		 
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
	
	public DefaultTableModel getModel_theoChuyenDe(ResultSet rs) {
		DefaultTableModel newModel = new DefaultTableModel(0,3);
		newModel.setColumnIdentifiers(new String[] {"Chuyên đề", "Số lượng đề tài" , "Tổng kinh phí"}); //, "TinhTrang", "ThoiGianBatDau", "ThoiGianKetThuc", "KinhPhi"});
		 
		if (rs==null) {
			System.out.println("DEBUG <code0234264> : rs is null !");
			return newModel; // NOTE HERE !
		}
				
		try {
			Object[] objectArr = new Object[3];
			System.out.println("DEBUG : print rs : ");
			while (rs.next()) {
				objectArr[0] = new String(rs.getString("ChuyenDe")!=null ? rs.getString("ChuyenDe") : "");
				objectArr[1] = new String(rs.getString("SoLuong")!=null ? rs.getString("SoLuong") : "");
				objectArr[2] = new String(rs.getString("TongKinhPhi")!=null ? rs.getString("TongKinhPhi") : "");
				
				newModel.addRow(objectArr);
            } 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//newModel.fireTableDataChanged(); // DEBUG HERE !
		return newModel;
	}
	
	public DefaultTableModel getModel_theoCap(ResultSet rs) {
		DefaultTableModel newModel = new DefaultTableModel(0,3);
		newModel.setColumnIdentifiers(new String[] {"Cấp", "Số lượng đề tài" , "Tổng kinh phí"}); //, "TinhTrang", "ThoiGianBatDau", "ThoiGianKetThuc", "KinhPhi"});
		 
		if (rs==null) {
			System.out.println("DEBUG <code0234264> : rs is null !");
			return newModel; // NOTE HERE !
		}
				
		try {
			Object[] objectArr = new Object[3];
			System.out.println("DEBUG : print rs : ");
			while (rs.next()) {
				objectArr[0] = new String(rs.getString("Cap")!=null ? rs.getString("Cap") : "");
				objectArr[1] = new String(rs.getString("SoLuong")!=null ? rs.getString("SoLuong") : "");
				objectArr[2] = new String(rs.getString("TongKinhPhi")!=null ? rs.getString("TongKinhPhi") : "");
				
				newModel.addRow(objectArr);
            } 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//newModel.fireTableDataChanged(); // DEBUG HERE !
		return newModel;
	}
}
