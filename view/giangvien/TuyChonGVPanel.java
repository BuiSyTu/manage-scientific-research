package project.view.giangvien;

import javax.swing.*;

import project.control.DeTaiControl;
import project.control.GiangVienControl;
import project.model.DeTai;
import project.model.GiangVien;
import project.model.TaiKhoan;
import project.view.*;

import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class TuyChonGVPanel extends JPanel implements View {
	private DangNhapPanel dangNhapPanel;
	//private TimKiemDeTaiPanel timKiemDeTaiPanel;
	private DangKyDeTaiPanel dangKyDeTaiPanel;
	private DeTaiCaNhanPanel deTaiCaNhanPanel;
	private DanhSachChiPanel danhSachChiPanel;
	private XinChiKhacPanel xinChiKhacPanel;
	private HuyDeTaiPanel huyDeTaiPanel;
	//private ThongTinCaNhanGVPanel thongTinCaNhanGVPanel;
	private ChinhSuaThongTinGVPanel chinhSuaThongTinGVPanel;
	private DoiMatKhauPanel doiMatKhauPanel;
	
	private DeTai deTai;
	
	private TaiKhoan taiKhoan;
	private GiangVien giangVien;

	//private JButton btnChinhSuaThongTinCaNhan;
	private JButton btnDeTaiDangLam;
	private JButton btnTimKiemDeTai;
	private JButton btnDangXuat;
	private JButton btnDangKyDeTai;
	private JLabel lblGiangVien;
	private JLabel lblTaiKhoan;
	private JLabel lblMaGV;

	@SuppressWarnings("deprecation")
	public TuyChonGVPanel() {

		setBounds(0, 0, WIDTH_PANEL, HEIGHT_PANEL);
		setLayout(null);
		
//		timKiemDeTaiPanel = new TimKiemDeTaiPanel();
//		timKiemDeTaiPanel.show(false);

		dangKyDeTaiPanel = new DangKyDeTaiPanel();
		dangKyDeTaiPanel.show(false);

		deTaiCaNhanPanel = new DeTaiCaNhanPanel();
		deTaiCaNhanPanel.show(false);

		danhSachChiPanel = new DanhSachChiPanel();
		danhSachChiPanel.show(false);

		xinChiKhacPanel = new XinChiKhacPanel();
		xinChiKhacPanel.show(false);

		huyDeTaiPanel = new HuyDeTaiPanel();
		huyDeTaiPanel.show(false);
		
		doiMatKhauPanel = new DoiMatKhauPanel();
		doiMatKhauPanel.show(false);

		deTaiCaNhanPanel.setDanhSachChiPanel(this.danhSachChiPanel);
		danhSachChiPanel.setDeTaiCaNhanPanel(this.deTaiCaNhanPanel);
		deTaiCaNhanPanel.setXinChiKhacPanel(this.xinChiKhacPanel);
		xinChiKhacPanel.setDeTaiCaNhanPanel(this.deTaiCaNhanPanel);
		deTaiCaNhanPanel.setHuyDeTaiPanel(this.huyDeTaiPanel);
		huyDeTaiPanel.setDeTaiCaNhanPanel(this.deTaiCaNhanPanel);

		add(deTaiCaNhanPanel);
		add(danhSachChiPanel);
		//add(timKiemDeTaiPanel);
		add(dangKyDeTaiPanel);
		add(xinChiKhacPanel);
		add(huyDeTaiPanel);
		add(doiMatKhauPanel);
		

		btnDeTaiDangLam = new JButton("\u0110\u1EC1 t\u00E0i \u0111ang l\u00E0m");
		btnDeTaiDangLam.setBounds(504, 241, 168, 32);
		btnDeTaiDangLam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deTaiCaNhanPanel.reset();
				giangVien = GiangVienControl.layThongTinGV(taiKhoan);				
				deTaiCaNhanPanel.setGiangVien(giangVien);
				deTaiCaNhanPanel.updateComboBoxModel();
				deTaiCaNhanPanel.show();
				//timKiemDeTaiPanel.show(false);
				dangKyDeTaiPanel.show(false);
				doiMatKhauPanel.show(false);
			}
		});
		add(btnDeTaiDangLam);

		btnTimKiemDeTai = new JButton("Tìm kiếm đề tài");
		btnTimKiemDeTai.setBounds(504, 303, 168, 32);
		btnTimKiemDeTai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				timKiemDeTaiPanel.reset();
//				timKiemDeTaiPanel.show();
				dangKyDeTaiPanel.show(false);
				deTaiCaNhanPanel.show(false);
				doiMatKhauPanel.show(false);
				new TimKiemDeTaiFrame(giangVien);
			}
		});
		add(btnTimKiemDeTai);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBounds(675, 11, 109, 23);
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ẩn hết các panel sau khi thoát, điều này là bắt buộc ! Và phải làm ở đây.
				//timKiemDeTaiPanel.show(false);
				//thongTinCaNhanGVPanel.show(false);
				dangKyDeTaiPanel.show(false);
				deTaiCaNhanPanel.show(false);
				danhSachChiPanel.show(false);
				xinChiKhacPanel.show(false);
				huyDeTaiPanel.show(false);
				chinhSuaThongTinGVPanel.show(false);
				doiMatKhauPanel.show(false);
				
				dangNhapPanel.reset();
				dangNhapPanel.show();
				show(false);
			}
		});
		add(btnDangXuat);

		btnDangKyDeTai = new JButton("Đăng ký đề tài");
		btnDangKyDeTai.setBounds(504, 365, 168, 32);
		btnDangKyDeTai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangKyDeTaiPanel.reset();
				dangKyDeTaiPanel.setGiangVien(giangVien);
				dangKyDeTaiPanel.show();
				//timKiemDeTaiPanel.show(false);
				deTaiCaNhanPanel.show(false);
			}
		});
		add(btnDangKyDeTai);

		lblGiangVien = new JLabel("Giảng viên");
		lblGiangVien.setBounds(504, 58, 98, 23);
		lblGiangVien.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblGiangVien);

		JButton btnHienThiThongTin = new JButton("Hiển thị thông tin"); // + chỉnh sửa thông tin !
		btnHienThiThongTin.setBounds(504, 179, 168, 32);
		btnHienThiThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				giangVien = GiangVienControl.layThongTinGV(taiKhoan);
//				thongTinCaNhanGVPanel.setGiangVien(giangVien);
//				thongTinCaNhanGVPanel.show();
//				show(false);
				
				giangVien = GiangVienControl.layThongTinGV(taiKhoan);
				chinhSuaThongTinGVPanel.setGiangVien(giangVien);
				chinhSuaThongTinGVPanel.show();
				show(false);
			}
		});
		add(btnHienThiThongTin);
		
//		btnChinhSuaThongTinCaNhan = new JButton("Chỉnh sửa thông tin");
//		btnChinhSuaThongTinCaNhan.setBounds(504, 221, 168, 32);
//		btnChinhSuaThongTinCaNhan.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				giangVien = GiangVienControl.layThongTinGV(taiKhoan);
//				chinhSuaThongTinGVPanel.setGiangVien(giangVien);
//				chinhSuaThongTinGVPanel.show();
//				show(false);
//			}
//		});
//		add(btnChinhSuaThongTinCaNhan);

		JLabel lblTiKhon = new JLabel("ID tài khoản : ");
		lblTiKhon.setBounds(504, 134, 98, 14);
		add(lblTiKhon);

		lblTaiKhoan = new JLabel("mataikhoan");
		lblTaiKhoan.setBounds(599, 134, 127, 14);
		add(lblTaiKhoan);
		
		JButton btniMtKhu = new JButton("Đổi mật khẩu");
		btniMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				deTaiCaNhanPanel.show(false);
				dangKyDeTaiPanel.show(false);
				
//				doiMatKhauPanel.show();
//				doiMatKhauPanel.setTaiKhoan(taiKhoan);
				
				doiMatKhauPanel.reset();
				doiMatKhauPanel.setTaiKhoan(taiKhoan);
				doiMatKhauPanel.show();				
			}
		});
		btniMtKhu.setBounds(675, 40, 109, 23);
		add(btniMtKhu);
		
		JLabel lblMGingVin = new JLabel("Mã giảng viên :");
		lblMGingVin.setBounds(504, 109, 98, 14);
		add(lblMGingVin);
		
		lblMaGV = new JLabel("MaGV");
		lblMaGV.setBounds(599, 109, 46, 14);
		add(lblMaGV);
	}

	public void setDangNhapPanel(DangNhapPanel panel) {
		this.dangNhapPanel = panel;
	}

//	public void setThongTinCaNhanGVPanel(ThongTinCaNhanGVPanel panel) {
//		this.thongTinCaNhanGVPanel = panel;
//	}

	public void setChinhSuaThongTinGVPanel(ChinhSuaThongTinGVPanel panel) {
		this.chinhSuaThongTinGVPanel = panel;

	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
		this.lblTaiKhoan.setText(taiKhoan.getTaiKhoan());	
		setGiangVien(project.control.GiangVienControl.layThongTinGV(taiKhoan)); // Chỉ có thể gọi setGiangVien ở đây thôi ! Thực ra chưa rõ có chỗ nào khác gọi setGiangVien rồi không !  DEBUG HERE !
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
		this.lblMaGV.setText(giangVien.getMaGV());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(project.model.Image.BACKGROUND, 0, 0, 794, 471, null);
	}
}
