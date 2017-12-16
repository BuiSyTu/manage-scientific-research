package project.view.admin;

import javax.swing.*;

import project.control.TaiKhoanControl;
import project.model.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class XoaTaiKhoanPanel extends JPanel {
	private JTextField txtID;
	private JTextField txtLoaiTaiKhoan;
	
	private TaiKhoan taiKhoan; // Tài khoản đang sử dụng.
	
	private TaiKhoan taiKhoanTimKiem;
	private GiangVien giangVienTimKiem;
	
	private JLabel lblMaGV;
	private JLabel lblTenGV;
	private JLabel lblGioiTinh;
	private JLabel lblChucDanh;
	private JLabel lblTenBoMon;

	/**
	 * Create the panel.
	 */
	public XoaTaiKhoanPanel() {
		setLayout(null);
		setBounds(70, 40, 300, 400);
		
		JLabel lbID = new JLabel("Nhập tài khoản cần xóa:");
		lbID.setBounds(54, 66, 198, 14);
		add(lbID);
		
		txtID = new JTextField();
		txtID.setBounds(64, 91, 148, 20);
		add(txtID);
		txtID.setColumns(10);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//				String strTaiKhoan = txtID.getText();
//				if (TaiKhoanControl.xoaTaiKhoan(strTaiKhoan)) {
//					JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công !");
//					show(false);
//				} else {
//					JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra !");
//					//show(false);
//				}
				String ID = txtID.getText();
				if (ID.equals(taiKhoan.getTaiKhoan())) {
					JOptionPane.showMessageDialog(null, "Tài khoản này đang được sử dụng !");
					return;
				}
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tài khoản này ?", "Hủy đề tài", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) {
		        	if (TaiKhoanControl.xoaTaiKhoan(ID)) {
						JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công !");
						//show(false);
					} else {
						JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra !");
						//show(false);
					}
		        }
		        else {	
		        	// Do nothing !
		        }	
			}
		});
		btnXoa.setBounds(42, 340, 89, 23);
		add(btnXoa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				show(false);
			}
		});
		btnThoat.setBounds(163, 340, 89, 23);
		add(btnThoat);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
				String IDTemp = txtID.getText();
				if (IDTemp.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập ID để tìm !");
					return;
				} else {
					taiKhoanTimKiem = project.control.TaiKhoanControl.timTaiKhoanWithoutPassword(IDTemp);
					if (taiKhoanTimKiem==null) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy tài khoản !");
						return;
					} else {
						txtLoaiTaiKhoan.setText(taiKhoanTimKiem.getQuyenTruyCap());
						System.out.println("taiKhoan.getQuyenTruyCap()="+taiKhoanTimKiem.getQuyenTruyCap()+"|||");
						System.out.println("length="+taiKhoanTimKiem.getQuyenTruyCap().length());
						System.out.println("txtLoaiTaiKhoan.length="+txtLoaiTaiKhoan.getText().length());
						if (taiKhoanTimKiem.getQuyenTruyCap().equals("Admin")) {
							System.out.println("ADMIN !!!");
						} else if (taiKhoanTimKiem.getQuyenTruyCap().substring(0, 10).equals("Giảng viên")) {
							System.out.println("GV !!!");
							giangVienTimKiem = project.control.GiangVienControl.layThongTinGV(taiKhoanTimKiem);
							if (giangVienTimKiem!=null) {
								lblMaGV.setText("Mã giảng viên : "+giangVienTimKiem.getMaGV());
								lblTenGV.setText("Tên giảng viên : "+giangVienTimKiem.getTenGV());
								lblGioiTinh.setText("Giới tính : "+giangVienTimKiem.getGioiTinh());
								lblChucDanh.setText("Chức danh : "+giangVienTimKiem.getChucDanh());
								lblTenBoMon.setText("Tên bộ môn : "+giangVienTimKiem.getTenBoMon());
							} else {
								// Do nothing !
							}
						} else if (taiKhoanTimKiem.getQuyenTruyCap().substring(0, 13).equals("Phòng quản lý")) {
							System.out.println("PQL !!!");
						}
					}
				}
			}
		});
		btnTm.setBounds(222, 90, 68, 23);
		add(btnTm);
		
		JLabel lblTnTiKhon = new JLabel("Loại tài khoản");
		lblTnTiKhon.setBounds(10, 151, 121, 14);
		add(lblTnTiKhon);
		
		txtLoaiTaiKhoan = new JTextField();
		txtLoaiTaiKhoan.setEditable(false);
		txtLoaiTaiKhoan.setBounds(97, 148, 193, 20);
		add(txtLoaiTaiKhoan);
		txtLoaiTaiKhoan.setColumns(10);
		
		lblMaGV = new JLabel("Mã giảng viên : ");
		lblMaGV.setBounds(10, 185, 280, 14);
		add(lblMaGV);
		
		lblTenGV = new JLabel("Tên giảng viên :");
		lblTenGV.setBounds(10, 210, 280, 14);
		add(lblTenGV);
		
		lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(10, 235, 280, 14);
		add(lblGioiTinh);
		
		lblChucDanh = new JLabel("Chức danh");
		lblChucDanh.setBounds(10, 260, 280, 14);
		add(lblChucDanh);
		
		lblTenBoMon = new JLabel("Tên bộ môn");
		lblTenBoMon.setBounds(10, 286, 280, 14);
		add(lblTenBoMon);
	}
	
	public void setTaiKhoan(TaiKhoan taiKhoanArg) {
		this.taiKhoan = taiKhoanArg;
	}
	
	public void reset() {
		lblMaGV.setText("");
		lblTenGV.setText("");
		lblGioiTinh.setText("");
		lblChucDanh.setText("");
		lblTenBoMon.setText("");
	}
}
