package project.view;

import javax.swing.*;

import project.control.Manager;
import project.model.TaiKhoan;
import project.view.admin.*;
import project.view.giangvien.*;
import project.view.phongql.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DangNhapPanel extends JPanel implements View {
	private JPasswordField pwfMatKhau;
	private JTextField txtTaiKhoan;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhau;
	private JLabel lblDangNhap;
	private JComboBox<String> cbbQuyenTruyCap;
	private JButton btnDangNhap;
	
	private TaiKhoan taiKhoan;

	private TuyChonAdminPanel tuyChonAdminPanel;
	private TuyChonGVPanel tuyChonGVPanel;
	private TuyChonPhongQLPanel tuyChonPhongQLPanel;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DangNhapPanel() {
		setLayout(null);
		setBounds(0, 0, 794, 471);

		lblTaiKhoan = new JLabel("ID :");
		lblTaiKhoan.setBounds(400, 101, 51, 14);
		add(lblTaiKhoan);

		lblMatKhau = new JLabel("Mật khẩu :");
		lblMatKhau.setBounds(360, 141, 73, 14);
		add(lblMatKhau);

		lblDangNhap = new JLabel("Đăng nhập");
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDangNhap.setBounds(439, 33, 140, 50);
		add(lblDangNhap);

		pwfMatKhau = new JPasswordField();
		pwfMatKhau.setBounds(435, 138, 160, 20);
		add(pwfMatKhau);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(435, 98, 160, 20);
		add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		cbbQuyenTruyCap = new JComboBox<String>();
		cbbQuyenTruyCap.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Phòng quản lý", "Giảng viên" }));
		cbbQuyenTruyCap.setBounds(435, 198, 160, 20);
		add(cbbQuyenTruyCap);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String strTaiKhoan = txtTaiKhoan.getText();
				String strMatKhau = String.valueOf(pwfMatKhau.getPassword());
				String strQuyenTruyCap = String.valueOf(cbbQuyenTruyCap.getSelectedItem());
				if (Manager.logIn(strTaiKhoan, strMatKhau, strQuyenTruyCap)) {
					show(false);
					setTaiKhoan(new TaiKhoan(strTaiKhoan, strMatKhau, strQuyenTruyCap, null));
					Manager.getMaGV(taiKhoan);
					switch (strQuyenTruyCap) {
					case "Admin":
						tuyChonAdminPanel.show();
						tuyChonAdminPanel.setTaiKhoan(taiKhoan);
						break;
					case "Giảng viên":
						tuyChonGVPanel.show();
						tuyChonGVPanel.setTaiKhoan(taiKhoan);						
						break;
					case "Phòng quản lý":
						tuyChonPhongQLPanel.show();
						tuyChonPhongQLPanel.setTaiKhoan(taiKhoan);
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Sai ID hoặc mật khẩu !");
				}
			}
		});
		btnDangNhap.setBounds(620, 138, 100, 30);
		add(btnDangNhap);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(project.model.Image.BACKGROUND, 0, 0, 794, 471, null);
	}

	public void reset() {
		txtTaiKhoan.setText("");
		pwfMatKhau.setText("");
		cbbQuyenTruyCap.setSelectedItem("Admin");
	}

	public void setTuyChonAdminPanel(TuyChonAdminPanel panel) {
		this.tuyChonAdminPanel = panel;
	}

	public void setTuyChonGVPanel(TuyChonGVPanel panel) {
		this.tuyChonGVPanel = panel;
	}

	public void setTuyChonPhongQLPanel(TuyChonPhongQLPanel panel) {
		this.tuyChonPhongQLPanel = panel;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

}
