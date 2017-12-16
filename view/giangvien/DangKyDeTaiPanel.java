package project.view.giangvien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import project.control.GiangVienControl;
import project.model.GiangVien;
import project.view.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;

public class DangKyDeTaiPanel extends JPanel implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtKinhPhi;
	//private JTextField txtThoiGianBatDau;
	private JTextField txtTenDeTai;
	private JTextField txtChuyenDe;
	private JTextField txtCap;
	private JTextField txtNoiDung;
	
	private GiangVien giangVien;
	private JTextField txtNgay;
	private JTextField txtThang;
	private JTextField txtNam;

	/**
	 * Launch the application.
	 */

	public DangKyDeTaiPanel() {
		LocalDateTime timeNow = LocalDateTime.now();
		//maGV = giangVienArg.getMaGV();
		
		setBounds(70, 40, 350, 400);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnTrV = new JButton("Tr\u1EDF v\u1EC1");
		btnTrV.setBounds(180, 366, 83, 23);
		btnTrV.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				show(false);
			}
		});
		setLayout(null);
		add(btnTrV);
		
		JLabel lblNoiDung = new JLabel("Nội dung tóm tắt");
		lblNoiDung.setBounds(10, 252, 154, 14);
		add(lblNoiDung);
		
		JLabel lblKinhPhi = new JLabel("Kinh phí ban đầu");
		lblKinhPhi.setBounds(10, 177, 95, 14);
		add(lblKinhPhi);
		
		txtKinhPhi = new JTextField();
		txtKinhPhi.setBounds(150, 174, 86, 20);
		add(txtKinhPhi);
		txtKinhPhi.setColumns(10);
		
		JButton btnDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnDangKy.setBounds(81, 366, 83, 23);
		btnDangKy.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String ngaythangnamTemp = new String(txtNam.getText()+"-"+txtThang.getText()+"-"+txtNgay.getText());
				System.out.println("ngaythangnamTemp"+ngaythangnamTemp);
				//String maGV= txtMaGV.getText();
				//String maDeTai=txtMaDeTai.getText();
				if(txtTenDeTai.getText().equals("") || txtNam.getText().equals("") || txtThang.getText().equals("") || txtNgay.getText().equals("") || txtChuyenDe.getText().equals("") || txtKinhPhi.getText().equals("") || txtNoiDung.getText().equals("") || txtCap.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Không được bỏ trống các trường !");
				} else if (!isValidNumber(txtNam.getText()) || !isValidNumber(txtThang.getText()) || !isValidNumber(txtNgay.getText()) || Integer.parseInt(txtNam.getText())>9999 || Integer.parseInt(txtNam.getText())<0 || Integer.parseInt(txtThang.getText())>12 || Integer.parseInt(txtThang.getText())<0 || Integer.parseInt(txtNgay.getText())>31 || Integer.parseInt(txtNgay.getText())<0  || txtNgay.getText().length()<2 || txtThang.getText().length()<2 )  {
					JOptionPane.showMessageDialog(null, "Nhập  ngày-tháng-năm  sai định dạng !");
				} else if (!isValidNumber(txtKinhPhi.getText())) { 
					JOptionPane.showMessageDialog(null, "Nhập kinh phí sai định dạng !");				
				} else if(project.control.DeTaiControl.dangKyDeTai(giangVien.getMaGV(),txtTenDeTai.getText(),ngaythangnamTemp,txtChuyenDe.getText(),txtKinhPhi.getText(), txtNoiDung.getText(),txtCap.getText())) {
					show(false);
					JOptionPane.showMessageDialog(null, "Đăng ký đề tài thành công !");
				} else {
					JOptionPane.showMessageDialog(null, "Đăng ký đề tài thất bại !");
				}
			}
		});
		add(btnDangKy);
		
		JLabel lblThoiGianBatDau = new JLabel("Thời gian bắt đầu");
		lblThoiGianBatDau.setBounds(10, 89, 103, 14);
		add(lblThoiGianBatDau);
		
//		txtThoiGianBatDau = new JTextField();
//		txtThoiGianBatDau.setBounds(150, 86, 185, 20);
//		add(txtThoiGianBatDau);
//		txtThoiGianBatDau.setColumns(10);
		
		JLabel lblngK = new JLabel("Đăng ký đề tài");
		lblngK.setBounds(107, 11, 143, 14);
		lblngK.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblngK);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài");
		lblTenDeTai.setBounds(10, 49, 95, 14);
		add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setBounds(150, 46, 185, 20);
		add(txtTenDeTai);
		txtTenDeTai.setColumns(10);
		
		JLabel lblChuyenDe = new JLabel("Chuyên đề");
		lblChuyenDe.setBounds(10, 146, 95, 14);
		add(lblChuyenDe);
		
		txtChuyenDe = new JTextField();
		txtChuyenDe.setBounds(150, 143, 185, 20);
		add(txtChuyenDe);
		txtChuyenDe.setColumns(10);
		
		JLabel lblCap = new JLabel("Cấp");
		lblCap.setBounds(10, 213, 46, 14);
		add(lblCap);
		
		txtCap = new JTextField();
		txtCap.setBounds(150, 210, 86, 20);
		add(txtCap);
		txtCap.setColumns(10);
		
		txtNoiDung = new JTextField();
		txtNoiDung.setBounds(10, 277, 325, 20);
		add(txtNoiDung);
		txtNoiDung.setColumns(10);
		
		
		//--------------------------------DATE----------------
		txtNgay = new JTextField();
		txtNgay.setBounds(150, 86, 35, 20);
		add(txtNgay);
		txtNgay.setColumns(10);
		String strNgay = String.valueOf(timeNow.getDayOfMonth());
		if (strNgay.length()<2) {
			strNgay = "0" + strNgay;
		}
		txtNgay.setText(strNgay);
		
		txtThang = new JTextField();
		txtThang.setBounds(201, 86, 35, 20);
		add(txtThang);
		txtThang.setColumns(10);
		String strThang = String.valueOf(timeNow.getMonthValue());
		if (strThang.length()<2) {
			strThang = "0" + strThang;
		}
		txtThang.setText(strThang);
		
		txtNam = new JTextField();
		txtNam.setBounds(256, 86, 54, 20);
		add(txtNam);
		txtNam.setColumns(10);
		txtNam.setText(String.valueOf(timeNow.getYear()));
		//------------------------------------------------
		
		
		JLabel lblUsd = new JLabel("USD");
		lblUsd.setBounds(246, 177, 46, 14);
		add(lblUsd);
		
		JLabel label = new JLabel("-");
		label.setBounds(192, 89, 18, 14);
		add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(240, 89, 23, 14);
		add(label_1);
		
		JLabel lblDd = new JLabel("DD");
		lblDd.setBounds(160, 117, 35, 14);
		add(lblDd);
		
		JLabel lblMm = new JLabel("MM");
		lblMm.setBounds(211, 117, 32, 14);
		add(lblMm);
		
		JLabel lblYyyy = new JLabel("YYYY");
		lblYyyy.setBounds(266, 118, 46, 14);
		add(lblYyyy);
	}
	
	private boolean isValidNumber(String str) {
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)>'9' || str.charAt(i)<'0') return false;
		}
		return true;
	}
	
	public void setGiangVien(GiangVien giangVienArg) {
		this.giangVien = giangVienArg;
	}

	public void reset() {
		txtKinhPhi.setText(""); 
		//txtNgay.setText("");
		//txtThang.setText("");
		//txtNam.setText("");
		
		txtTenDeTai.setText("");
		txtChuyenDe.setText("");
		txtCap.setText("");
		txtNoiDung.setText("");
	}
}
