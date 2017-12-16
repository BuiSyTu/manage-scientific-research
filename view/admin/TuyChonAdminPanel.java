package project.view.admin;

import javax.swing.*;

import project.model.TaiKhoan;
import project.view.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings({ "serial" })
public class TuyChonAdminPanel extends JPanel implements View{
	private JLabel lblAdmin;
	private JLabel lblAdmin1;
	private JLabel lbID;
	private JButton btnTaoTaiKhoan;
	private JButton btnDoiMatKhau;
	private JButton btnXoaTaiKhoan;
	private JButton btnDangXuat;

	private TaiKhoan taiKhoan;

	private DoiMatKhauPanel doiMatKhauPanel;
	private XoaTaiKhoanPanel xoaTaiKhoanPanel;
	private DangNhapPanel dangNhapPanel;
	private TaoTaiKhoanPanel taoTaiKhoanPanel;
	private DanhSachTatCaTaiKhoanPanel danhSachTatCaTaiKhoanPanel;
	
	
	private JButton btnDanhSchTi;

	@SuppressWarnings("deprecation")
	public TuyChonAdminPanel() {
		setBounds(0, 0, WIDTH_PANEL, HEIGHT_PANEL);
		setLayout(null);

		doiMatKhauPanel = new DoiMatKhauPanel();
		doiMatKhauPanel.show(false);
		add(doiMatKhauPanel);

		taoTaiKhoanPanel = new TaoTaiKhoanPanel();
		taoTaiKhoanPanel.show(false);
		add(taoTaiKhoanPanel);

		xoaTaiKhoanPanel = new XoaTaiKhoanPanel();
		xoaTaiKhoanPanel.show(false);
		add(xoaTaiKhoanPanel);
		
		danhSachTatCaTaiKhoanPanel = new DanhSachTatCaTaiKhoanPanel();
		danhSachTatCaTaiKhoanPanel.show(false);
		add(danhSachTatCaTaiKhoanPanel);

		lblAdmin1 = new JLabel("Admin");
		lblAdmin1.setBounds(459, 30, 127, 51);
		lblAdmin1.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblAdmin1);

		lbID = new JLabel("ID :");
		lbID.setBounds(459, 92, 73, 14);
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lbID);

		lblAdmin = new JLabel("");
		lblAdmin.setBounds(493, 92, 114, 14);
		add(lblAdmin);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setBounds(659, 45, 125, 23);
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiMatKhauPanel.reset();
				doiMatKhauPanel.setTaiKhoan(taiKhoan);

				doiMatKhauPanel.show();
				xoaTaiKhoanPanel.show(false);
				taoTaiKhoanPanel.show(false);
				danhSachTatCaTaiKhoanPanel.show(false);
			}
		});
		add(btnDoiMatKhau);

		btnTaoTaiKhoan = new JButton("Tạo tài khoản");
		btnTaoTaiKhoan.setBounds(459, 161, 197, 23);
		btnTaoTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				taoTaiKhoanPanel.reset();
//				taoTaiKhoanPanel.show();
//				xoaTaiKhoanPanel.show(false);
//				doiMatKhauPanel.show(false);
				
				doiMatKhauPanel.show(false);
				xoaTaiKhoanPanel.show(false);
				taoTaiKhoanPanel.show();
				danhSachTatCaTaiKhoanPanel.show(false);
			}
		});
		add(btnTaoTaiKhoan);

		btnXoaTaiKhoan = new JButton("Xóa tài khoản");
		btnXoaTaiKhoan.setBounds(459, 210, 197, 23);
		btnXoaTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//xoaTaiKhoanPanel.show();
				xoaTaiKhoanPanel.setTaiKhoan(taiKhoan);
				
				doiMatKhauPanel.show(false);
				xoaTaiKhoanPanel.show();
				taoTaiKhoanPanel.show(false);
				danhSachTatCaTaiKhoanPanel.show(false);
			}
		});
		add(btnXoaTaiKhoan);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBounds(659, 11, 125, 23);
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiMatKhauPanel.show(false);
				xoaTaiKhoanPanel.show(false);
				taoTaiKhoanPanel.show(false);
				danhSachTatCaTaiKhoanPanel.show(false);
				
				dangNhapPanel.reset();
				dangNhapPanel.show();
				show(false);
			}
		});
		add(btnDangXuat);
		
		btnDanhSchTi = new JButton("Danh sách tài khoản");
		btnDanhSchTi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doiMatKhauPanel.show(false);
				xoaTaiKhoanPanel.show(false);
				taoTaiKhoanPanel.show(false);
				danhSachTatCaTaiKhoanPanel.updateTable();
				danhSachTatCaTaiKhoanPanel.show();
			}
		});
		btnDanhSchTi.setBounds(459, 257, 197, 23);
		add(btnDanhSchTi);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(project.model.Image.BACKGROUND, 0, 0, 794, 471, null);
	}

	public void setDangNhapPanel(DangNhapPanel Panel) {
		this.dangNhapPanel = Panel;
	}

	public void setTaiKhoan(final TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
		this.lblAdmin.setText(taiKhoan.getTaiKhoan());
	}
}
