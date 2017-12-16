//NTS.
package project.view.phongql;

import javax.swing.JPanel;

import project.control.DeTaiControl;
import project.model.TaiKhoan;
import project.view.DangNhapPanel;
import project.view.admin.DoiMatKhauPanel;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class TuyChonPhongQLPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private LoginPanel loginPanel;
	//private ThongKeDeTaiPanel thongKeDeTai;
	private DangNhapPanel dangNhapPanel;
	
	private DoiMatKhauPanel doiMatKhauPanel;
	
	public TaiKhoan taiKhoan;
	private JLabel lbID_tk;

	public TuyChonPhongQLPanel() {

		setBounds(0, 0, 800, 500);
		setLayout(null);
		
		
		//Tai.
		JLabel lblPhongQuanLy = new JLabel("Phòng quản lý");
        lblPhongQuanLy.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblPhongQuanLy.setBounds(438, 43, 152, 21);
        add(lblPhongQuanLy);
        
        
        
		
		JButton btnThongKeDeTai = new JButton("Danh sách tất cả đề tài");
		
		btnThongKeDeTai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TimKiemDeTaiResultFrame xxx = new TimKiemDeTaiResultFrame(DeTaiControl.thongKeDeTai()); // Tìm kiếm với all => Thống kê !
				xxx.lblFrameTitle.setText("Danh sách tất cả đề tài");
			}
		});
		btnThongKeDeTai.setBounds(438, 236, 282, 32);
		add(btnThongKeDeTai);
		
		//ThongKeDeTaiResultFrame_theoChuyenDe
		JButton btnDeTaiDangLam = new JButton("Danh sách đề tài theo Chuyên đề hoặc Cấp");
		btnDeTaiDangLam.setBounds(438, 279, 282, 32);
		btnDeTaiDangLam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				//new ThongKeDeTaiResultFrame_theoChuyenDe();
				new ThongKeDeTaiChiTiet_Frame();
			}
		});
		add(btnDeTaiDangLam);
		
		JButton btnDuyetChiKhac = new JButton("Duyệt chi khác");
		btnDuyetChiKhac.setBounds(438, 153, 282, 32);
		btnDuyetChiKhac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				new TuyChonPhongQL_DuyetChiKhac_Frame();
			}
		});
		add(btnDuyetChiKhac);
		
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show(false);
                dangNhapPanel.reset();
                dangNhapPanel.show();
			}
		});
		btnDangXuat.setBounds(658, 11, 126, 23);
		add(btnDangXuat);
		
		JButton btnDuyetDeTai = new JButton("Duyệt đăng ký đề tài");
		btnDuyetDeTai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DanhSachDeTaiDangChoFrame();
			}
		});
		btnDuyetDeTai.setBounds(438, 110, 282, 32);
		add(btnDuyetDeTai);
		
		JButton btnThngK = new JButton("Thống kê đề tài theo số lượng");
		btnThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThongKeDeTaiSoLuong_Frame();
			}
		});
		btnThngK.setBounds(438, 322, 282, 32);
		add(btnThngK);
		
		JButton btnDanhSchTt = new JButton("Danh sách tất cả giảng viên");
		btnDanhSchTt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DanhSachTatCaGiangVienFrame();
			}
		});
		btnDanhSchTt.setBounds(438, 408, 282, 32);
		add(btnDanhSchTt);
		
		JButton btniMtKhu = new JButton("Đổi mật khẩu");
		btniMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doiMatKhauPanel.reset();
				doiMatKhauPanel.setTaiKhoan(taiKhoan);

				doiMatKhauPanel.show();
			}
		});
		btniMtKhu.setBounds(658, 45, 126, 23);
		add(btniMtKhu);
		
		
		
		
		doiMatKhauPanel = new DoiMatKhauPanel();
		doiMatKhauPanel.show(false);
		add(doiMatKhauPanel);
		
		lbID_tk = new JLabel("ID :");
		lbID_tk.setBounds(438, 75, 46, 14);
		add(lbID_tk);
		
	}

	public void setDangNhapPanel(DangNhapPanel Panel) {
		this.dangNhapPanel = Panel;
	}
	
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
		this.lbID_tk.setText("ID : "+taiKhoan.getTaiKhoan());
		// Phòng quản lý sẽ KHÔNG có MaGV !
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(project.model.Image.BACKGROUND, 0, 0, 794, 471, null);
	}
}