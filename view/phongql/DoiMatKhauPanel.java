package project.view.phongql;

import javax.swing.*;

import project.control.TaiKhoanControl;
import project.model.TaiKhoan;

import java.awt.event.*;

@SuppressWarnings("serial")
public class DoiMatKhauPanel extends JPanel {
	private JPasswordField pwfMatKhauCu;
	private JPasswordField pwfMatKhauMoi;
	private JPasswordField pwfMatKhauMoi1;
	private JLabel lblMatKhauCu;
	private JLabel lbMatKhauMoi;
	private JLabel lblMatKhauMoi1;
	private JButton btnDoi;
	private JButton btnThoat;
	
	private TaiKhoan taiKhoan;

	/**
	 * Create the panel.
	 */
	public DoiMatKhauPanel() {
		setBounds(70, 40, 300, 400);
		setLayout(null);

		lblMatKhauCu = new JLabel("Mật khẩu cũ:");
		lblMatKhauCu.setBounds(50, 60, 150, 14);
		add(lblMatKhauCu);

		lbMatKhauMoi = new JLabel("Mật khẩu mới:");
		lbMatKhauMoi.setBounds(50, 130, 150, 14);
		add(lbMatKhauMoi);

		lblMatKhauMoi1 = new JLabel("Nhập lại mật khẩu mới:");
		lblMatKhauMoi1.setBounds(50, 203, 150, 14);
		add(lblMatKhauMoi1);

		pwfMatKhauCu = new JPasswordField();
		pwfMatKhauCu.setBounds(60, 85, 185, 20);
		add(pwfMatKhauCu);

		pwfMatKhauMoi = new JPasswordField();
		pwfMatKhauMoi.setBounds(60, 155, 185, 20);
		add(pwfMatKhauMoi);

		pwfMatKhauMoi1 = new JPasswordField();
		pwfMatKhauMoi1.setBounds(60, 228, 185, 20);
		add(pwfMatKhauMoi1);

		btnDoi = new JButton("Đổi");
		btnDoi.setBounds(41, 343, 89, 23);
		btnDoi.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String strMatKhauCu = String.valueOf(pwfMatKhauCu.getPassword());
				String strMatKhauMoi = String.valueOf(pwfMatKhauMoi.getPassword());
				String strMatKhauMoi1 = String.valueOf(pwfMatKhauMoi1.getPassword());
				if (strMatKhauCu.equals(taiKhoan.getMatKhau()) && strMatKhauMoi.equals(strMatKhauMoi1)) {			
					if (TaiKhoanControl.doiMatKhau(taiKhoan, strMatKhauMoi)) {
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
						taiKhoan.setMatKhau(strMatKhauMoi);
						System.out.println(taiKhoan.getMatKhau());
						show(false);
					} else {
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Thông tin không chính xác");
				}
			}
		});
		add(btnDoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(168, 343, 89, 23);
		btnThoat.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				show(false);
			}
		});
		add(btnThoat);

	}
	
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	public void reset() {
		pwfMatKhauCu.setText(null);
		pwfMatKhauMoi.setText(null);
		pwfMatKhauMoi1.setText(null);
	}
}

