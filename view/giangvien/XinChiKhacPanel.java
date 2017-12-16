package project.view.giangvien;

import javax.swing.*;
import javax.swing.border.*;

import project.control.ChiKhacControl;
import project.model.ChiKhac;
import project.model.DeTai;
import java.awt.*;
import java.awt.event.*;

public class XinChiKhacPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaDeTai;
	private JTextField txtSoTien;
	private JTextArea txtLyDo;
	private DeTaiCaNhanPanel deTaiCaNhanPanel;
	private DeTai deTai;
	private ChiKhac chiKhac;
	public XinChiKhacPanel() {
		setBounds(70, 40, 300, 400);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblXinChiKhac = new JLabel("Xin Chi Kh\u00E1c");
		lblXinChiKhac.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblXinChiKhac.setBounds(90, 11, 81, 14);
		add(lblXinChiKhac);
		
		JLabel lblMaDeTai = new JLabel("M\u00E3 \u0111\u1EC1 t\u00E0i");
		lblMaDeTai.setBounds(10, 46, 67, 14);
		add(lblMaDeTai);
		
		txtMaDeTai = new JTextField();
		txtMaDeTai.setEditable(false);
		txtMaDeTai.setBounds(111, 43, 179, 20);
		add(txtMaDeTai);
		txtMaDeTai.setColumns(10);
		
		txtSoTien = new JTextField();
		txtSoTien.setBounds(110, 108, 180, 20);
		add(txtSoTien);
		txtSoTien.setColumns(10);
		
		JLabel lblSoTien = new JLabel("S\u1ED1 ti\u1EC1n");
		lblSoTien.setBounds(10, 111, 46, 14);
		add(lblSoTien);
		
		JLabel lblLyDo = new JLabel("L\u00FD do");
		lblLyDo.setBounds(10, 201, 46, 14);
		add(lblLyDo);
		
		txtLyDo = new JTextArea();
		txtLyDo.setBounds(111, 196, 180, 54);
		add(txtLyDo);
		
		JButton btnGui = new JButton("G\u1EEDi");
		btnGui.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				ChiKhac ck = getChiKhac();
				ChiKhacControl.xinChiKhac(ck, deTai);
				show(false);
				deTaiCaNhanPanel.show();
			}
		});
		btnGui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGui.setBounds(31, 366, 89, 23);
		add(btnGui);
		
		JButton btnTrowrVee = new JButton("Trở về");
		btnTrowrVee.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				deTaiCaNhanPanel.show();
				show(false);
			}
		});
		btnTrowrVee.setBounds(153, 367, 89, 23);
		add(btnTrowrVee);
	}


	public void setDeTaiCaNhanPanel(DeTaiCaNhanPanel deTaiCaNhanPanel) {
		this.deTaiCaNhanPanel = deTaiCaNhanPanel;
	}
	
	public void setDeTai(DeTai deTai) {
		this.deTai = deTai;
		this.txtMaDeTai.setText(deTai.getMaDeTai());
	}
	
	public ChiKhac getChiKhac() {
		chiKhac = new ChiKhac();
		this.chiKhac.setSoTien(txtSoTien.getText());
		this.chiKhac.setLyDo(txtLyDo.getText());
		return this.chiKhac;
	}

}
