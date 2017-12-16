package project.view.admin;

import javax.swing.*;

import project.control.TaiKhoanControl;
import project.model.TaiKhoan;

import java.awt.event.*;

@SuppressWarnings("serial")
public class TaoTaiKhoanPanel extends JPanel {
	private JTextField txtTaiKhoan;
	private JPasswordField pwfMatKhau;
	private JPasswordField pwfMatKhau1;
	private JLabel lbID;
	private JLabel lbPass;
	private JLabel lblRePass;
	private JLabel lblAcess;
	private JComboBox<String> cbbQuyenTruyCap;
	private JButton btnDongY;
	private JButton btnThoat;

	/**
	 * Create the panel.
	 */
	public TaoTaiKhoanPanel() {

		setBounds(70, 40, 300, 400);
		setLayout(null);

		lbID = new JLabel("Tài khoản:");
		lbID.setBounds(74, 33, 113, 23);
		add(lbID);

		lbPass = new JLabel("Mật khẩu:");
		lbPass.setBounds(74, 108, 113, 14);
		add(lbPass);

		lblRePass = new JLabel("Nhập lại mật khẩu:");
		lblRePass.setBounds(74, 176, 142, 14);
		add(lblRePass);

		lblAcess = new JLabel("Quyền truy cập:");
		lblAcess.setBounds(74, 240, 142, 14);
		add(lblAcess);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(84, 67, 142, 20);
		add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		pwfMatKhau = new JPasswordField();
		pwfMatKhau.setBounds(84, 133, 142, 20);
		add(pwfMatKhau);

		pwfMatKhau1 = new JPasswordField();
		pwfMatKhau1.setBounds(84, 201, 142, 20);
		add(pwfMatKhau1);

		cbbQuyenTruyCap = new JComboBox<String>();
		cbbQuyenTruyCap
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Admin", "Phòng quản lý", "Giảng viên" }));
		cbbQuyenTruyCap.setBounds(84, 265, 142, 20);
		add(cbbQuyenTruyCap);

		btnDongY = new JButton("Đồng ý");
		btnDongY.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String strTaiKhoan = txtTaiKhoan.getText();
				String strMatKhau = String.valueOf(pwfMatKhau.getPassword());
				String strMatKhau1 = String.valueOf(pwfMatKhau1.getPassword());
				String strQuyenTruyCap = String.valueOf(cbbQuyenTruyCap.getSelectedItem());
				if (strMatKhau1.equals(strMatKhau)) {		
					if (!project.control.TaiKhoanControl.kiemTraTaiKhoanTonTai(strTaiKhoan)) {
						if (!cbbQuyenTruyCap.getSelectedItem().toString().equals("Giảng viên")) { // if cbb != Giang vien
							if (TaiKhoanControl.taoTaiKhoan(new TaiKhoan(strTaiKhoan, strMatKhau, strQuyenTruyCap, null) , null)) {
								JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công !");
							} else {
								JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra");
							}
						} else { // if cbb == Giang vien.
							new TaoTaiKhoanThongTinGVFrame(new TaiKhoan(strTaiKhoan, strMatKhau, strQuyenTruyCap, null)); // Tham số của MaGV vẫn là null dù đang tạo tài khoản giảng viên, vì đang trong quá trình tạo !
						}
					} else {
						JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại !");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Mật khẩu nhập lần 2 không khớp với lần 1");
				}
			}
		});
		btnDongY.setBounds(41, 333, 89, 23);
		add(btnDongY);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				show(false);
			}
		});
		btnThoat.setBounds(166, 333, 89, 23);
		add(btnThoat);
	}

	public JTextField getTxtTaiKhoan() {
		return txtTaiKhoan;
	}

	public JPasswordField getPwfMatKhau() {
		return pwfMatKhau;
	}

	public JPasswordField getPwfMatKhau1() {
		return pwfMatKhau1;
	}

	public JButton getBtnDongY() {
		return btnDongY;
	}

	public JButton getBtnThoat() {
		return btnThoat;
	}

	public void setTxtTaiKhoan(JTextField txtTaiKhoan) {
		this.txtTaiKhoan = txtTaiKhoan;
	}

	public void setPwfMatKhau(JPasswordField pwfMatKhau) {
		this.pwfMatKhau = pwfMatKhau;
	}

	public void setPwfMatKhau1(JPasswordField pwfMatKhau1) {
		this.pwfMatKhau1 = pwfMatKhau1;
	}

	public void setBtnDongY(JButton btnDongY) {
		this.btnDongY = btnDongY;
	}

	public void setBtnThoat(JButton btnThoat) {
		this.btnThoat = btnThoat;
	}

	public void reset() {
		txtTaiKhoan.setText("");
		pwfMatKhau.setText("");
		pwfMatKhau1.setText("");
		cbbQuyenTruyCap.setSelectedItem("Admin");
	}

	public JComboBox<String> getCbbQuyenTruyCap() {
		return cbbQuyenTruyCap;
	}

	public void setCbbQuyenTruyCap(JComboBox<String> cbbQuyenTruyCap) {
		this.cbbQuyenTruyCap = cbbQuyenTruyCap;
	}

}
