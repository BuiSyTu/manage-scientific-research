package project.view.giangvien;

import javax.swing.*;

import project.view.giangvien.DeTaiCaNhanPanel;

import java.awt.*;
import java.awt.event.*;

public class HuyDeTaiPanel extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaGV;
	private JTextField txtTenGV;
	private JTextField txtTenDeTai;
	private JTextField txtKinhPhiBanDau;
	private JTextField txtThoiGianBatDau;
	private JTextField txtThoiGianKetThuc;
	private DeTaiCaNhanPanel deTaiCaNhanPanel;

	public HuyDeTaiPanel() {
		setBounds(70, 40, 300, 400);
		setLayout(null);
		
		JButton txtTroVe = new JButton("Tr\u1EDF v\u1EC1");
		txtTroVe.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				deTaiCaNhanPanel.show();
				show(false);
			}
		});
		txtTroVe.setBounds(150, 366, 76, 23);
		add(txtTroVe);
		
		JLabel label_1 = new JLabel("T\u00EAn \u0111\u1EC1 t\u00E0i");
		label_1.setBounds(10, 137, 65, 14);
		add(label_1);
		
		txtMaGV = new JTextField();
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(102, 48, 188, 20);
		add(txtMaGV);
		
		JLabel lblMaGV = new JLabel("M\u00E3 GV");
		lblMaGV.setBounds(10, 51, 46, 14);
		add(lblMaGV);
		
		txtTenGV = new JTextField();
		txtTenGV.setColumns(10);
		txtTenGV.setBounds(102, 89, 188, 20);
		add(txtTenGV);
		
		JLabel lblTenGV = new JLabel("T\u00EAn GV");
		lblTenGV.setBounds(10, 92, 46, 14);
		add(lblTenGV);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setColumns(10);
		txtTenDeTai.setBounds(102, 134, 188, 20);
		add(txtTenDeTai);
		
		JLabel lblLDo = new JLabel("L\u00FD do");
		lblLDo.setBounds(10, 307, 46, 14);
		add(lblLDo);
		
		JLabel lblKinhPhiBanDau = new JLabel("Kinh ph\u00ED ban \u0111\u1EA7u");
		lblKinhPhiBanDau.setBounds(10, 178, 89, 14);
		add(lblKinhPhiBanDau);
		
		txtKinhPhiBanDau = new JTextField();
		txtKinhPhiBanDau.setColumns(10);
		txtKinhPhiBanDau.setBounds(102, 175, 188, 20);
		add(txtKinhPhiBanDau);
		
		JButton btnGi = new JButton("G\u1EEDi");
		btnGi.setBounds(29, 366, 89, 23);
		add(btnGi);
		
		JTextArea txtrLyDo = new JTextArea();
		txtrLyDo.setBackground(Color.WHITE);
		txtrLyDo.setBounds(102, 302, 188, 46);
		add(txtrLyDo);
		
		JLabel lblThoiGianBatDau = new JLabel("Th\u1EDDi gian b\u1EAFt \u0111\u1EA7u");
		lblThoiGianBatDau.setBounds(10, 218, 89, 14);
		add(lblThoiGianBatDau);
		
		txtThoiGianBatDau = new JTextField();
		txtThoiGianBatDau.setColumns(10);
		txtThoiGianBatDau.setBounds(102, 215, 188, 20);
		add(txtThoiGianBatDau);
		
		JLabel lblThoiGianKetThuc = new JLabel("Th\u1EDDi gian k\u1EBFt th\u00FAc");
		lblThoiGianKetThuc.setBounds(10, 257, 89, 14);
		add(lblThoiGianKetThuc);
		
		txtThoiGianKetThuc = new JTextField();
		txtThoiGianKetThuc.setColumns(10);
		txtThoiGianKetThuc.setBounds(102, 254, 188, 20);
		add(txtThoiGianKetThuc);
	}

	public void setDeTaiCaNhanPanel(DeTaiCaNhanPanel deTaiCaNhanPanel) {
		// TODO Auto-generated method stub
		this.deTaiCaNhanPanel = deTaiCaNhanPanel;
	}

}
