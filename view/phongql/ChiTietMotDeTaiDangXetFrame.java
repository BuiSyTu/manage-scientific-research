package project.view.phongql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project.view.Main;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTietMotDeTaiDangXetFrame extends JFrame {

	private JTextField txtMaDeTai;
	private JTextField txtTenDeTai;
	private JTextField txtThoiGianBatDau;
	private JTextField txtTinhTrang;
	private JTextField txtChuyenDe;
	private JTextField txtKinhPhi;
	private JTextField txtCap;
	
	private JTextArea txtrNoiDung;
	
	
	private String strMaDeTai;
	private String strTenDeTai;
	private String strThoiGianBatDau;
	private String strTinhTrang;
	private String strChuyenDe;
	private String strKinhPhi;
	private String strNoiDung;
	private String strCap;

	private boolean resetted = false;

	/**
	 * Create the frame.
	 */
	public ChiTietMotDeTaiDangXetFrame(DanhSachDeTaiDangChoFrame dsdtdcFrame, String strMaDeTaiArg, String strTenDeTaiArg, String strThoiGianBatDauArg, String strTinhTrangArg, String strChuyenDeArg, String strKinhPhiArg, String strNoiDungArg, String strCapArg) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		this.setVisible(true);
		
		
		
		this.strMaDeTai = strMaDeTaiArg;
		this.strTenDeTai = strTenDeTaiArg;
		this.strThoiGianBatDau = strThoiGianBatDauArg;
		this.strTinhTrang = strTinhTrangArg;
		this.strChuyenDe = strChuyenDeArg;
		this.strKinhPhi = strKinhPhiArg;
		this.strNoiDung = strNoiDungArg;
		this.strCap = strCapArg;
		
		
		if (strMaDeTai==null) strMaDeTai = new String("");
		if (strTenDeTai==null) strTenDeTai = new String("");
		if (strThoiGianBatDau==null) strThoiGianBatDau = new String("");
		if (strTinhTrang==null) strTinhTrang = new String("");
		if (strChuyenDe==null) strChuyenDe = new String("");
		if (strKinhPhi==null) strKinhPhi = new String("");
		if (strNoiDung==null) strNoiDung = new String("");
		if (strCap==null) strCap = new String("");
		
		
		
		
		JLabel lblMaDeTai = new JLabel("Mã đề tài");
		lblMaDeTai.setBounds(81, 81, 102, 14);
		getContentPane().add(lblMaDeTai);
		
		txtMaDeTai = new JTextField();
		txtMaDeTai.setText(strMaDeTai);
		txtMaDeTai.setBounds(182, 75, 120, 20);
		getContentPane().add(txtMaDeTai);
		txtMaDeTai.setColumns(10);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài");
		lblTenDeTai.setBounds(81, 119, 102, 14);
		getContentPane().add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setText(strTenDeTai);
		txtTenDeTai.setBounds(182, 113, 295, 20);
		getContentPane().add(txtTenDeTai);
		txtTenDeTai.setColumns(10);
		
		JLabel lblThoiGianBatDau = new JLabel("Thời gian bắt đầu");
		lblThoiGianBatDau.setBounds(81, 194, 102, 14);
		getContentPane().add(lblThoiGianBatDau);
		
		txtThoiGianBatDau = new JTextField();
		txtThoiGianBatDau.setText(strThoiGianBatDau);
		txtThoiGianBatDau.setBounds(182, 191, 120, 20);
		getContentPane().add(txtThoiGianBatDau);
		txtThoiGianBatDau.setColumns(10);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng");
		lblTinhTrang.setBounds(81, 156, 102, 14);
		getContentPane().add(lblTinhTrang);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setText(strTinhTrang);
		txtTinhTrang.setBounds(182, 150, 120, 20);
		getContentPane().add(txtTinhTrang);
		txtTinhTrang.setColumns(10);
		
		JLabel lblChuyenDe = new JLabel("Chuyên đề");
		lblChuyenDe.setBounds(81, 233, 102, 14);
		getContentPane().add(lblChuyenDe);
		
		txtChuyenDe = new JTextField();
		txtChuyenDe.setText(strChuyenDe);
		txtChuyenDe.setBounds(182, 230, 120, 20);
		getContentPane().add(txtChuyenDe);
		txtChuyenDe.setColumns(10);
		
		JLabel lblKinhPhi = new JLabel("Kinh phí");
		lblKinhPhi.setBounds(81, 277, 102, 14);
		getContentPane().add(lblKinhPhi);
		
		txtKinhPhi = new JTextField();
		txtKinhPhi.setText(strKinhPhi);
		txtKinhPhi.setBounds(182, 274, 120, 20);
		getContentPane().add(txtKinhPhi);
		txtKinhPhi.setColumns(10);
		
		JLabel lblNoiDung = new JLabel("Nội dung tóm tắt");
		lblNoiDung.setBounds(81, 349, 102, 14);
		getContentPane().add(lblNoiDung);
		
		txtrNoiDung = new JTextArea();
		txtrNoiDung.setText(strNoiDung);
		txtrNoiDung.setBounds(182, 344, 295, 72);
		getContentPane().add(txtrNoiDung);
		
		JLabel lblCap = new JLabel("Cấp");
		lblCap.setBounds(81, 319, 102, 14);
		getContentPane().add(lblCap);
		
		txtCap = new JTextField();
		txtCap.setText(strCap);
		txtCap.setBounds(182, 313, 120, 20);
		getContentPane().add(txtCap);
		txtCap.setColumns(10);
		
		JButton btnChapnhan = new JButton("Chấp nhận");
		btnChapnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!resetted) {
					project.control.DeTaiControl.chapThuan(strMaDeTai);
					dsdtdcFrame.updateTable();
					reset();
				}
			}
		});
		btnChapnhan.setBounds(230, 427, 113, 23);
		getContentPane().add(btnChapnhan);
		
		JButton btnTuchoi = new JButton("Từ chối");
		btnTuchoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!resetted) {
					project.control.DeTaiControl.tuChoi(strMaDeTai);
					dsdtdcFrame.updateTable();
					reset();
				}				
			}
		});
		btnTuchoi.setBounds(364, 427, 113, 23);
		getContentPane().add(btnTuchoi);
		
		JLabel lblThngTin = new JLabel("Thông tin đề tài");
		lblThngTin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThngTin.setBounds(81, 23, 262, 30);
		getContentPane().add(lblThngTin);
		
	}
	
	
	
	
	
	private void reset() {
		resetted = true;
		this.txtMaDeTai.setText("");
		this.txtTenDeTai.setText("");
		this.txtThoiGianBatDau.setText("");
		this.txtTinhTrang.setText("");
		this.txtChuyenDe.setText("");
		this.txtKinhPhi.setText("");
		this.txtrNoiDung.setText("");
		this.txtCap.setText("");
	}
}
