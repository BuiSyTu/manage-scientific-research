//NTS.
package project.view.phongql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import project.control.ChiKhacControl;
import project.control.DeTaiControl;
import project.control.Manager;
import project.model.TaiKhoan;
import project.view.Main;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TuyChonPhongQL_DuyetChiKhac_Frame extends JFrame {
	private JTextField txtMaChi;
	//private JTextField txtMaGV;
	//private JTextField txtTenGV;	
	private JTextField txtSoTien;	
	private JTextField txtTinhTrang;	
	private JTextArea txtrLyDo;	
	private JTextField txtMaDeTai;
	private JTextField txtTenDeTai;
	
	private String maChi; // lưu mã chi của 1 chi khác đang lựa chọn.

	JComboBox<String> comboBox;
	
	public TuyChonPhongQL_DuyetChiKhac_Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		this.setVisible(true);		
		
		
		txtMaChi = new JTextField();
		txtMaChi.setBounds(95, 128, 86, 20);
		getContentPane().add(txtMaChi);
		txtMaChi.setColumns(10);		
		
		
		txtMaDeTai = new JTextField();
		txtMaDeTai.setBounds(95, 159, 86, 20);
		getContentPane().add(txtMaDeTai);
		txtMaDeTai.setColumns(10);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setBounds(95, 194, 182, 20);
		getContentPane().add(txtTenDeTai);
		txtTenDeTai.setColumns(10);
		
		txtSoTien = new JTextField();
		txtSoTien.setBounds(95, 227, 86, 20);
		getContentPane().add(txtSoTien);
		txtSoTien.setColumns(10);
		
		
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setBounds(95, 263, 86, 20);
		getContentPane().add(txtTinhTrang);
		txtTinhTrang.setColumns(10);
		
		
		
		txtrLyDo = new JTextArea();
		txtrLyDo.setText("Lý do");
		txtrLyDo.setBounds(377, 156, 397, 295);
		getContentPane().add(txtrLyDo);
		
		
		
		
		JLabel lblDanhSchChi = new JLabel("Danh sách chi khác đợi duyệt");
		lblDanhSchChi.setBounds(247, 15, 338, 20);
		lblDanhSchChi.setFont(new Font("Serif", Font.BOLD, 20));
		getContentPane().add(lblDanhSchChi);
		
		JLabel lblLDo = new JLabel("Lý do");
		lblLDo.setBounds(377, 131, 46, 14);
		getContentPane().add(lblLDo);
		
		
		
		JLabel lblMChi = new JLabel("Mã chi");
		lblMChi.setBounds(10, 131, 75, 14);
		getContentPane().add(lblMChi);		
		
		
		
		JLabel lblMTi = new JLabel("Mã đề tài");
		lblMTi.setBounds(10, 161, 75, 14);
		getContentPane().add(lblMTi);
		
		JLabel lblTnTi = new JLabel("Tên đề tài");
		lblTnTi.setBounds(10, 197, 75, 14);
		getContentPane().add(lblTnTi);
				
		JLabel lblSotien = new JLabel("Số tiền");
		lblSotien.setBounds(10, 230, 75, 14);
		getContentPane().add(lblSotien);
		
		JLabel lblTnhTrng = new JLabel("Tình trạng");
		lblTnhTrng.setBounds(10, 266, 75, 14);
		getContentPane().add(lblTnhTrng);
		
		
		
		JButton btnChpThun = new JButton("Chấp thuận");
		btnChpThun.setBounds(39, 428, 142, 23);
		btnChpThun.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				project.control.ChiKhacControl.chapThuan(maChi);
				reset();
			}
		});
		getContentPane().add(btnChpThun);
		
		JButton btnTuChoi = new JButton("Từ chối");
		btnTuChoi.setBounds(209, 428, 142, 23);
		btnTuChoi.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				project.control.ChiKhacControl.tuChoi(maChi);
				reset();
			}
		});
		getContentPane().add(btnTuChoi);
		
		JLabel lblChnMtM = new JLabel("Chọn một mã chi khác");
		lblChnMtM.setBounds(10, 46, 267, 14);
		getContentPane().add(lblChnMtM);
		
		
		
		
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 71, 764, 20);
		comboBox.setModel(new DefaultComboBoxModel<String>(ChiKhacControl.returnAllMaChiKhacChuaDuyet())); // Tìm tên all Chuyên đề và nhét vào jcombobox.
		comboBox.addActionListener (new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {
//		    	table.setModel(getModelfromResultset(project.control.DeTaiControl.thongKeDeTai_theoChuyenDe(String.valueOf(comboBox.getSelectedItem()))));  //table = new JTable(getModelfromResultset(project.control.DeTaiControl.thongKeDeTai_theoChuyenDe(String.valueOf(comboBox.getSelectedItem()))));
//		    	((DefaultTableModel) table.getModel()).fireTableDataChanged(); // DEBUG HERE !
				project.model.ChiKhac_with_MaDeTai obj = project.control.ChiKhacControl.return1ChiKhac_with_DeTai(String.valueOf(comboBox.getSelectedItem()));
				if (obj!=null) {
					txtMaChi.setText(obj.getMaChi());
					txtrLyDo.setText(obj.getLyDo());
					txtSoTien.setText(obj.getSoTien());
					txtTinhTrang.setText(obj.getTinhTrang());
					//txtMaGV.setText(obj.maGV);
					//txtTenGV.setText(obj.tenGV);
					txtMaDeTai.setText(obj.getMaDeTai());
					txtTenDeTai.setText(obj.getTenDeTai());
					
					maChi = obj.getMaChi();
					
				}
				
		    }
		});
		getContentPane().add(comboBox);
		
		
		
	}
	
	
	
	//New!
	public void reset() {
		txtMaChi.setText("");
		txtSoTien.setText("");	
		txtTinhTrang.setText("");	
		txtrLyDo.setText("");	
		txtMaDeTai.setText("");
		txtTenDeTai.setText("");
		comboBox.setModel(new DefaultComboBoxModel<String>(ChiKhacControl.returnAllMaChiKhacChuaDuyet())); // update JComboBox model.
	}
}

