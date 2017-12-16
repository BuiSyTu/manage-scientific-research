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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import project.control.DeTaiControl;
import project.model.GiangVien;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

public class ThongKeDeTaiChiTiet_Frame extends JFrame {
	private JTable tableDeTai;
	private JScrollPane scrollPaneDeTai;

	private String TIEUCHI = "1";
	private JTable tableGiangVien;
	
	public int lastSelectedRowID = -1;
	private JLabel lblRoHon;
	
	public ThongKeDeTaiChiTiet_Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 514);
		this.setVisible(true); // DEBUG HERE PLEASE!
		getContentPane().setLayout(null);
		
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		this.setVisible(true); // DEBUG HERE PLEASE!
//		setLayout(null);
		
		scrollPaneDeTai = new JScrollPane();
		scrollPaneDeTai.setBounds(10, 136, 763, 158);
		getContentPane().add(scrollPaneDeTai);
		
		tableDeTai = new JTable();
		tableDeTai.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDeTai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	int currentSelectedRowID = tableDeTai.getSelectedRow();
		    	if (currentSelectedRowID >= 0) { // :  != -1
		    		lastSelectedRowID = currentSelectedRowID;
		    		System.out.println(lastSelectedRowID);
		    		tableGiangVien.setModel(getModelfromResultset_GiangVien(project.control.GiangVienControl.lietKeGiangVienLamDeTai(tableDeTai.getValueAt(lastSelectedRowID, 0).toString() )   ));
		    	}
		    }
		});
		scrollPaneDeTai.setViewportView(tableDeTai);
		
		JComboBox<String> cbbRoHon = new JComboBox<String>();
		cbbRoHon.setBounds(10, 105, 763, 20);
		cbbRoHon.setModel(new DefaultComboBoxModel<String>(DeTaiControl.getTenCacChuyenDe())); // DEFAULT !!!
		cbbRoHon.addActionListener (new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {
				//New!
				tableGiangVien.setModel(getBlankModel_GiangVien());
				lastSelectedRowID = -1;
				tableDeTai.setModel(getBlankModel_DeTai());
				//
		    	if (TIEUCHI.equals("1")) {
		    		tableDeTai.setModel(getModelfromResultset_DeTai(project.control.DeTaiControl.thongKeDeTai_theoChuyenDe(String.valueOf(cbbRoHon.getSelectedItem()))));  
		    	} else if (TIEUCHI.equals("2")) {
		    		tableDeTai.setModel(getModelfromResultset_DeTai(project.control.DeTaiControl.thongKeDeTai_theoCap(String.valueOf(cbbRoHon.getSelectedItem())))); 
		    	}
		    	((DefaultTableModel) tableDeTai.getModel()).fireTableDataChanged(); // DEBUG HERE !
				//
		    }
		});
		getContentPane().add(cbbRoHon);
		
		JLabel lblThongkedetaitheochuyende = new JLabel("Thống kê đề tài");
		lblThongkedetaitheochuyende.setBounds(296, 11, 165, 33);
		lblThongkedetaitheochuyende.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(lblThongkedetaitheochuyende);
		
		JComboBox<String> cbbTieuChi = new JComboBox<String>();
		cbbTieuChi.setBounds(94, 55, 148, 20);
		String[] optionForTieuChi = {"1. Chuyên đề","2. Cấp"};
		cbbTieuChi.setModel(new DefaultComboBoxModel<String>(optionForTieuChi));
		cbbTieuChi.addActionListener (new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {
				//New!
				tableGiangVien.setModel(getBlankModel_GiangVien());
				lastSelectedRowID = -1;
				tableDeTai.setModel(getBlankModel_DeTai());
				//
				TIEUCHI = String.valueOf(cbbTieuChi.getSelectedItem()).substring(0, 1); // encrypt ...
				if (TIEUCHI.equals("1")) {
					lblRoHon.setText("Chọn tên chuyên đề");
					cbbRoHon.setModel(new DefaultComboBoxModel<String>(DeTaiControl.getTenCacChuyenDe())); 
				} else if (TIEUCHI.equals("2")) {
					lblRoHon.setText("Chọn Cấp");
					cbbRoHon.setModel(new DefaultComboBoxModel<String>(DeTaiControl.getTenCacCap())); 
				}
		    }
		});
		getContentPane().add(cbbTieuChi);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 337, 763, 127);
		getContentPane().add(scrollPane_1);
		
		tableGiangVien = new JTable();
		scrollPane_1.setViewportView(tableGiangVien);
		
		JLabel lblThngKTheo = new JLabel("Thống kê theo ");
		lblThngKTheo.setBounds(10, 58, 90, 14);
		getContentPane().add(lblThngKTheo);
		
		lblRoHon = new JLabel("Chọn tên chuyên đề");
		lblRoHon.setBounds(10, 83, 165, 14);
		getContentPane().add(lblRoHon);
		
		JLabel lblDanhSchGing = new JLabel("Danh sách giảng viên thực hiện");
		lblDanhSchGing.setBounds(10, 312, 216, 14);
		getContentPane().add(lblDanhSchGing);
		
	}
	
	 
	private DefaultTableModel getModelfromResultset_DeTai(ResultSet rs) {		
		
		DefaultTableModel newModel = new DefaultTableModel(0,6);
		newModel.setColumnIdentifiers(new String[] {"Mã đề tài", "Tên đề tài", "Tình trạng", "Thời gian bắt đầu", "Thời gian kết thúc", "Kinh phí"});
		 
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
	
	
	private DefaultTableModel getModelfromResultset_GiangVien(ResultSet rs) {		
		
		DefaultTableModel newModel = new DefaultTableModel(0,5);
		newModel.setColumnIdentifiers(new String[] {"Mã giảng viên", "Tên giảng viên", "Chức danh", "Email", "Tên bộ môn"});
		 
		if (rs==null) {
			System.out.println("DEBUG <code042094> : rs is null !");
			return newModel; // NOTE HERE !
		}
				
		try {
			Object[] objectArr = new Object[5];
			while (rs.next()) {
				objectArr[0] = new String(rs.getString("MaGV")!=null ? rs.getString("MaGV") : "");
				objectArr[1] = new String(rs.getString("TenGV")!=null ? rs.getString("TenGV") : "");
				objectArr[2] = new String(rs.getString("ChucDanh")!=null ? rs.getString("ChucDanh") : "");
				objectArr[3] = new String(rs.getString("Email")!=null ? rs.getString("Email") : "");
				objectArr[4] = new String(rs.getString("TenBoMon")!=null ? rs.getString("TenBoMon") : "");
				//objectArr[5] = new String(rs.getString("KinhPhi")!=null ? rs.getString("KinhPhi") : "");
				newModel.addRow(objectArr);
            } 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//newModel.fireTableDataChanged(); // DEBUG HERE !
		return newModel;
	}
	
	private DefaultTableModel getBlankModel_GiangVien() {
		DefaultTableModel newModel = new DefaultTableModel(0,5);
		newModel.setColumnIdentifiers(new String[] {"Mã giảng viên", "Tên giảng viên", "Chức danh", "Email", "Tên bộ môn"});
		return newModel;
	}
	
	private DefaultTableModel getBlankModel_DeTai() {
		DefaultTableModel newModel = new DefaultTableModel(0,6);
		newModel.setColumnIdentifiers(new String[] {"Mã đề tài", "Tên đề tài", "Tình trạng", "Thời gian bắt đầu", "Thời gian kết thúc", "Kinh phí"});
		return newModel;
	}
}