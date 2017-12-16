//package project.view.phongql;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.DefaultTableModel;
//
//import project.control.DeTaiControl;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JLabel;
//
//public class ThongKeDeTaiResultFrame_theoChuyenDe extends JFrame {
//	private JTable table;
//	private JScrollPane scrollPane;
//	private JTable tableOverrall;
//
//	
//	public ThongKeDeTaiResultFrame_theoChuyenDe() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 799, 514);
//		this.setVisible(true); // DEBUG HERE PLEASE!
//		getContentPane().setLayout(null);
//		
////		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
////		setBounds(100, 100, 450, 300);
////		this.setVisible(true); // DEBUG HERE PLEASE!
////		setLayout(null);
//		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 245, 763, 65);
//		getContentPane().add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		
//		JComboBox<String> comboBox = new JComboBox<String>();
//		comboBox.setBounds(10, 224, 763, 20);
//		comboBox.setModel(new DefaultComboBoxModel<String>(DeTaiControl.getTenCacChuyenDe())); // Tìm tên all Chuyên đề và nhét vào jcombobox.
//		comboBox.addActionListener (new ActionListener () {
//			@Override
//		    public void actionPerformed(ActionEvent e) {
//		    	table.setModel(getModelfromResultset(project.control.DeTaiControl.thongKeDeTai_theoChuyenDe(String.valueOf(comboBox.getSelectedItem()))));  //table = new JTable(getModelfromResultset(project.control.DeTaiControl.thongKeDeTai_theoChuyenDe(String.valueOf(comboBox.getSelectedItem()))));
//		    	((DefaultTableModel) table.getModel()).fireTableDataChanged(); // DEBUG HERE !
//				//
//		    }
//		});
//		getContentPane().add(comboBox);
//		
//		JLabel lblThongkedetaitheochuyende = new JLabel("Thống kê đề tài theo chuyên đề");
//		lblThongkedetaitheochuyende.setBounds(256, 15, 292, 33);
//		lblThongkedetaitheochuyende.setFont(new Font("Serif", Font.BOLD, 20));
//		getContentPane().add(lblThongkedetaitheochuyende);
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(10, 63, 763, 83);
//		getContentPane().add(scrollPane_1);
//		
//		tableOverrall = new JTable();
//		tableOverrall.setModel(getModelOverrall(project.control.DeTaiControl.thongKe_SoLuongDeTai_TheoChuyenDe())); 
//		scrollPane_1.setViewportView(tableOverrall);
//		
//	}
//	
//	 
//	public DefaultTableModel getModelfromResultset(ResultSet rs) {		
//		
//		DefaultTableModel newModel = new DefaultTableModel(0,6);
//		newModel.setColumnIdentifiers(new String[] {"MaDeTai", "TenDeTai", "TinhTrang", "ThoiGianBatDau", "ThoiGianKetThuc", "KinhPhi"});
//		 
//		if (rs==null) {
//			System.out.println("DEBUG <code026329> : rs is null !");
//			return newModel; // NOTE HERE !
//		}
//				
//		try {
//			Object[] objectArr = new Object[6];
//			System.out.println("DEBUG : print rs : ");
//			while (rs.next()) {
////				for (int col=0; col <= 5; col++) {
////					objectArr[col] = new String(rs.getString(col+1));
////				}
//				objectArr[0] = new String(rs.getString("MaDeTai")!=null ? rs.getString("MaDeTai") : "");
//				objectArr[1] = new String(rs.getString("TenDeTai")!=null ? rs.getString("TenDeTai") : "");
//				objectArr[2] = new String(rs.getString("TinhTrang")!=null ? rs.getString("TinhTrang") : "");
//				objectArr[3] = new String(rs.getString("ThoiGianBatDau")!=null ? rs.getString("ThoiGianBatDau") : "");
//				objectArr[4] = new String(rs.getString("ThoiGianKetThuc")!=null ? rs.getString("ThoiGianKetThuc") : "");
//				objectArr[5] = new String(rs.getString("KinhPhi")!=null ? rs.getString("KinhPhi") : "");
//				newModel.addRow(objectArr);
//            } 
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//newModel.fireTableDataChanged(); // DEBUG HERE !
//		return newModel;
//	}
//	
//	public DefaultTableModel getModelOverrall(ResultSet rs) {
//		DefaultTableModel newModel = new DefaultTableModel(0,2);
//		newModel.setColumnIdentifiers(new String[] {"ChuyenDe", "SoLuong"}); //, "TinhTrang", "ThoiGianBatDau", "ThoiGianKetThuc", "KinhPhi"});
//		 
//		if (rs==null) {
//			System.out.println("DEBUG <code0234264> : rs is null !");
//			return newModel; // NOTE HERE !
//		}
//				
//		try {
//			Object[] objectArr = new Object[2];
//			System.out.println("DEBUG : print rs : ");
//			while (rs.next()) {
//				objectArr[0] = new String(rs.getString("ChuyenDe")!=null ? rs.getString("ChuyenDe") : "");
//				objectArr[1] = new String(rs.getString("SoLuong")!=null ? rs.getString("SoLuong") : "");
//				
//				newModel.addRow(objectArr);
//            } 
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//newModel.fireTableDataChanged(); // DEBUG HERE !
//		return newModel;
//	}
//}
