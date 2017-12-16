package project.view.giangvien;

import javax.swing.*;

import project.control.GiangVienControl;
import project.model.GiangVien;
import project.model.TaiKhoan;

import java.awt.event.*;

@SuppressWarnings("serial")
public class ChinhSuaThongTinGVPanel extends JPanel {
	private JTextField txtMaGV;
	private JTextField txtTenGV;
	private JTextField txtGioiTinh;
	//private JTextField txtNgaySinh;
	private JTextField txtChucDanh;
	//private JTextField txtNgayVeTruong;
	private JTextField txtEmail;
	private JTextField txtDienThoai;
	//private JTextField txtNgayVaoDang;
	private JTextField txtDiaChi;
	private JTextField txtSoTK;
	private TuyChonGVPanel tuyChonGVPanel;
	private JTextField txtBoMon;
	
	
	private JTextField txtNgay_sinh;
	private JTextField txtThang_sinh;
	private JTextField txtNam_sinh;
	
	private JTextField txtNgay_vetruong;
	private JTextField txtThang_vetruong;
	private JTextField txtNam_vetruong;
	
	private JTextField txtNgay_vaodang;
	private JTextField txtThang_vaodang;
	private JTextField txtNam_vaodang;

	
	private GiangVien giangVien;
	@SuppressWarnings("unused")
	private TaiKhoan taiKhoan;

	public ChinhSuaThongTinGVPanel() {
		setLayout(null);

		JLabel lblMaGV = new JLabel("Mã giảng viên");
		lblMaGV.setBounds(132, 43, 94, 20);
		add(lblMaGV);

		JLabel lblTenGV = new JLabel("Tên giảng viên");
		lblTenGV.setBounds(132, 96, 94, 14);
		add(lblTenGV);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(132, 148, 94, 14);
		add(lblGioiTinh);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(132, 198, 70, 14);
		add(lblNgaySinh);

		JLabel lblChucDanh = new JLabel("Chức danh");
		lblChucDanh.setBounds(132, 260, 70, 14);
		add(lblChucDanh);

		txtMaGV = new JTextField();
		txtMaGV.setBounds(236, 43, 86, 20);
		txtMaGV.setEditable(false);
		txtMaGV.setColumns(10);
		add(txtMaGV);

		txtTenGV = new JTextField();
		txtTenGV.setBounds(236, 93, 169, 20);
		txtTenGV.setColumns(10);
		add(txtTenGV);

		txtGioiTinh = new JTextField();
		txtGioiTinh.setBounds(236, 145, 169, 20);
		txtGioiTinh.setColumns(10);
		add(txtGioiTinh);

//		txtNgaySinh = new JTextField();
//		txtNgaySinh.setBounds(236, 199, 169, 20);
//		txtNgaySinh.setColumns(10);
//		add(txtNgaySinh);

		txtChucDanh = new JTextField();
		txtChucDanh.setBounds(236, 257, 169, 20);
		txtChucDanh.setColumns(10);
		add(txtChucDanh);

		JLabel lblNgayVeTruong = new JLabel("Ngày về trường");
		lblNgayVeTruong.setBounds(132, 304, 94, 20);
		add(lblNgayVeTruong);

//		txtNgayVeTruong = new JTextField();
//		txtNgayVeTruong.setBounds(236, 304, 169, 20);
//		txtNgayVeTruong.setColumns(10);
//		add(txtNgayVeTruong);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(480, 146, 94, 14);
		add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(574, 146, 189, 20);
		txtEmail.setColumns(10);
		add(txtEmail);

		JLabel lblSoTK = new JLabel("Số tài khoản");
		lblSoTK.setBounds(480, 198, 94, 14);
		add(lblSoTK);

		JLabel lblDienThoai = new JLabel("Điện thoại");
		lblDienThoai.setBounds(480, 252, 94, 14);
		add(lblDienThoai);

		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(574, 252, 189, 20);
		txtDienThoai.setColumns(10);
		add(txtDienThoai);

		JLabel lblNgayVaoDang = new JLabel("Ngày vào Đảng");
		lblNgayVaoDang.setBounds(480, 307, 94, 14);
		add(lblNgayVaoDang);

//		txtNgayVaoDang = new JTextField();
//		txtNgayVaoDang.setBounds(574, 307, 189, 20);
//		txtNgayVaoDang.setColumns(10);
//		add(txtNgayVaoDang);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(132, 358, 94, 20);
		add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(236, 358, 352, 20);
		txtDiaChi.setColumns(10);
		add(txtDiaChi);

		txtSoTK = new JTextField();
		txtSoTK.setBounds(574, 198, 189, 20);
		txtSoTK.setColumns(10);
		add(txtSoTK);
		setBounds(0, 0, 800, 500);

		JButton btnTroVe = new JButton("Trở về");
		btnTroVe.setBounds(701, 11, 89, 23);
		btnTroVe.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				tuyChonGVPanel.show();
				show(false);
			}
		});
		add(btnTroVe);

		JLabel lblTnBMn = new JLabel("Tên bộ môn");
		lblTnBMn.setBounds(477, 96, 87, 14);
		add(lblTnBMn);

		txtBoMon = new JTextField();
		txtBoMon.setBounds(574, 96, 189, 20);
		add(txtBoMon);
		txtBoMon.setColumns(10);
		
		
		
		
		//--------------------------------NGAY-SINH----------------
		//String dateSinh[] = dateOf(giangVien.getNgaySinh());
		txtNgay_sinh = new JTextField();
		txtNgay_sinh.setBounds(236, 196, 35, 20);
		add(txtNgay_sinh);
		txtNgay_sinh.setColumns(10);
		//txtNgay_sinh.setText(dateSinh[0]);
		
		txtThang_sinh = new JTextField();
		txtThang_sinh.setBounds(287, 196, 35, 20);
		add(txtThang_sinh);
		txtThang_sinh.setColumns(10);
		//txtThang_sinh.setText(dateSinh[1]);
		
		txtNam_sinh = new JTextField();
		txtNam_sinh.setBounds(351, 196, 54, 20);
		add(txtNam_sinh);
		txtNam_sinh.setColumns(10);
		//txtNam_sinh.setText(dateSinh[2]);
		//------------------------------------------------
		
		
		//--------------------------------NGAY-VE-TRUONG----------------	
		//String dateVeTruong[] = dateOf(giangVien.getNgayVeTruong());
		//System.out.println("NTS at : ChinhSua... at setGiangVien : dateVeTruong**="+dateVeTruong[0]+"<><>"+dateVeTruong[1]+"<><>"+dateVeTruong[2]);
		txtNgay_vetruong = new JTextField();
		txtNgay_vetruong.setBounds(236, 304, 35, 20);
		add(txtNgay_vetruong);
		txtNgay_vetruong.setColumns(10);
		//txtNgay_vetruong.setText(dateVeTruong[0]);
		
		txtThang_vetruong = new JTextField();
		txtThang_vetruong.setBounds(287, 304, 35, 20);
		add(txtThang_vetruong);
		txtThang_vetruong.setColumns(10);
		//txtThang_vetruong.setText(dateVeTruong[1]);
		
		txtNam_vetruong = new JTextField();
		txtNam_vetruong.setBounds(351, 304, 54, 20);
		add(txtNam_vetruong);
		txtNam_vetruong.setColumns(10);
		//txtNam_vetruong.setText(dateVeTruong[2]);
		//------------------------------------------------
		
		
		//--------------------------------NGAY-VAO-DANG----------------
		//String dateVaoDang[] = dateOf(giangVien.getNgayVaoDang());
		txtNgay_vaodang = new JTextField();
		txtNgay_vaodang.setBounds(574, 304, 35, 20);
		add(txtNgay_vaodang);
		txtNgay_vaodang.setColumns(10);
		//txtNgay_vaodang.setText(dateVaoDang[0]);
		
		txtThang_vaodang = new JTextField();
		txtThang_vaodang.setBounds(622, 304, 35, 20);
		add(txtThang_vaodang);
		txtThang_vaodang.setColumns(10);
		//txtThang_vaodang.setText(dateVaoDang[1]);
		
		txtNam_vaodang = new JTextField();
		txtNam_vaodang.setBounds(677, 304, 54, 20);
		add(txtNam_vaodang);
		txtNam_vaodang.setColumns(10);
		//txtNam_vaodang.setText(dateVaoDang[2]);
		//------------------------------------------------
		
		
		
		
		

		JButton btnLuu = new JButton("Cập nhật thông tin");
		btnLuu.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (!ngayvaodangValid()) {
					JOptionPane.showMessageDialog(null, "Ngày vào Đảng cần nhập đúng, hoặc bỏ trống hoàn toàn");
				} else if (emptyFieldExist()) {
					JOptionPane.showMessageDialog(null, "Không được bỏ trống các trường có dấu * !");
				} else if (!dateValidNumChar()) {
					JOptionPane.showMessageDialog(null, "Nhập ngày-tháng-năm không đúng định dạng !");
				} else if (!dateValidRange()) {
					JOptionPane.showMessageDialog(null, "Nhập ngày-tháng-năm vượt quá giá trị cho phép !");
				} else {
					updateGiangVien();
					GiangVienControl.updateThongTinGV(giangVien);
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin giảng viên thành công !");
					tuyChonGVPanel.show();
					show(false);
				} 
			}
		});
		btnLuu.setBounds(574, 432, 189, 23);
		add(btnLuu);
		
		JLabel label = new JLabel("-");
		label.setBounds(45, 181, 17, 14);
		add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(276, 198, 17, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setBounds(332, 198, 17, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("-");
		label_3.setBounds(276, 307, 17, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("-");
		label_4.setBounds(332, 307, 17, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("-");
		label_5.setBounds(614, 307, 17, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("-");
		label_6.setBounds(667, 307, 17, 14);
		add(label_6);

	}
	
	
	
	
	
	
	
	
	
	private String[] dateOf(String dateArg) {
		String[] strReturn = {"","",""};
		if (dateArg!=null && dateArg.length()==10) {
			strReturn[2] = new String(dateArg.substring(0, 4)); // Nam.
			strReturn[1] = new String(dateArg.substring(5, 7)); // Thang.
			strReturn[0] = new String(dateArg.substring(8, 10)); // Ngay. //10 is out of bound but OK.
		} 
		return strReturn;
	}
	

	public TuyChonGVPanel getTuyChonGVPanel() {
		return tuyChonGVPanel;
	}

	public void setTuyChonGVPanel(TuyChonGVPanel tuyChonGVPanel) {
		this.tuyChonGVPanel = tuyChonGVPanel;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	public void setGiangVien(GiangVien giangVien) { // set to JTextFields !
		this.giangVien = giangVien;
		this.txtMaGV.setText(giangVien.getMaGV());
		this.txtTenGV.setText(giangVien.getTenGV());
		//this.txtNgaySinh.setText(giangVien.getNgaySinh());
		this.txtGioiTinh.setText(giangVien.getGioiTinh());
		this.txtChucDanh.setText(giangVien.getChucDanh());
		//this.txtNgayVeTruong.setText(giangVien.getNgayVeTruong());
		this.txtEmail.setText(giangVien.geteMail());
		this.txtSoTK.setText(giangVien.getSoTK());
		this.txtDienThoai.setText(giangVien.getDienThoai());
		//this.txtNgayVaoDang.setText(giangVien.getNgayVaoDang());
		this.txtBoMon.setText(giangVien.getTenBoMon());
		this.txtDiaChi.setText(giangVien.getDiaChi());
		
		
		
		//--------------------------------NGAY-SINH----------------
		String dateSinh[] = dateOf(giangVien.getNgaySinh());
		
		this.txtNgay_sinh.setText(dateSinh[0]);
		this.txtThang_sinh.setText(dateSinh[1]);
		this.txtNam_sinh.setText(dateSinh[2]);
		//------------------------------------------------
		
		
		//--------------------------------NGAY-VE-TRUONG----------------	
		String dateVeTruong[] = dateOf(giangVien.getNgayVeTruong());
		//System.out.println("NTS at : ChinhSua... at setGiangVien : dateVeTruong**="+dateVeTruong[0]+"<><>"+dateVeTruong[1]+"<><>"+dateVeTruong[2]);
		
		this.txtNgay_vetruong.setText(dateVeTruong[0]);		
		this.txtThang_vetruong.setText(dateVeTruong[1]);
		this.txtNam_vetruong.setText(dateVeTruong[2]);
		//------------------------------------------------
		
		
		//--------------------------------NGAY-VAO-DANG----------------
		if (giangVien.getNgayVaoDang().equals("")) {			
			this.txtNgay_vaodang.setText("");
			this.txtThang_vaodang.setText("");
			this.txtNam_vaodang.setText("");
		} else {
			String dateVaoDang[] = dateOf(giangVien.getNgayVaoDang());
			this.txtNgay_vaodang.setText(dateVaoDang[0]);
			this.txtThang_vaodang.setText(dateVaoDang[1]);
			this.txtNam_vaodang.setText(dateVaoDang[2]);
		}
		//------------------------------------------------
	}

	public JTextField getTxtTenGV() {
		return this.txtTenGV;
	}

	public JTextField getTxtMaGV() {
		return txtMaGV;
	}

	public JTextField getTxtGioiTinh() {
		return txtGioiTinh;
	}

//	public JTextField getTxtNgaySinh() {
//		return txtNgaySinh;
//	}

	public JTextField getTxtChucDanh() {
		return txtChucDanh;
	}

//	public JTextField getTxtNgayVeTruong() {
//		return txtNgayVeTruong;
//	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtDienThoai() {
		return txtDienThoai;
	}

//	public JTextField getTxtNgayVaoDang() {
//		return txtNgayVaoDang;
//	}

	public JTextField getTxtDiaChi() {
		return txtDiaChi;
	}

	public JTextField getTxtSoTK() {
		return txtSoTK;
	}

	public JTextField getTxtBoMon() {
		return txtBoMon;
	}

	public void setTxtTenGV(JTextField txtTenGV) {
		this.txtTenGV = txtTenGV;
	}
	
	public void updateGiangVien() { // from JTextFields !
		this.giangVien.setTenGV(this.txtTenGV.getText());
		this.giangVien.setNgaySinh(getNgaySinh_fromTXT());
		this.giangVien.setGioiTinh(this.txtGioiTinh.getText());
		this.giangVien.setChucDanh(this.txtChucDanh.getText());
		this.giangVien.setNgayVeTruong(getNgayVeTruong_fromTXT());
		this.giangVien.seteMail(this.txtEmail.getText());
		this.giangVien.setSoTK(this.txtSoTK.getText());
		this.giangVien.setDienThoai(this.txtDienThoai.getText());
		if(ngayvaodangValid()) {
			this.giangVien.setNgayVaoDang(getNgayVaoDang_fromTXT());
		} else this.giangVien.setNgayVaoDang("");
		this.giangVien.setTenBoMon(this.txtBoMon.getText());
		this.giangVien.setDiaChi(this.txtDiaChi.getText());
	}
	
	private String getNgaySinh_fromTXT() {
		String ngay = (txtNgay_sinh.getText().length()==2) ? txtNgay_sinh.getText() : "0"+txtNgay_sinh.getText();
		String thang = (txtThang_sinh.getText().length()==2) ? txtThang_sinh.getText() : "0"+txtThang_sinh.getText();
		String nam = txtNam_sinh.getText();
		System.out.println(new String(nam+"-"+thang+"-"+ngay));
		return new String(nam+"-"+thang+"-"+ngay);
	}
	private String getNgayVeTruong_fromTXT() {
		String ngay = (txtNgay_vetruong.getText().length()==2) ? txtNgay_vetruong.getText() : "0"+txtNgay_vetruong.getText();
		String thang = (txtThang_vetruong.getText().length()==2) ? txtThang_vetruong.getText() : "0"+txtThang_vetruong.getText();
		String nam = txtNam_vetruong.getText();
		System.out.println(new String(nam+"-"+thang+"-"+ngay));
		return new String(nam+"-"+thang+"-"+ngay);
	}
	private String getNgayVaoDang_fromTXT() {
		if (txtNgay_vaodang.getText().equals("") || txtThang_vaodang.getText().equals("") || txtNam_vaodang.getText().equals("")) return new String("");
		String ngay = (txtNgay_vaodang.getText().length()==2) ? txtNgay_vaodang.getText() : "0"+txtNgay_vaodang.getText();
		String thang = (txtThang_vaodang.getText().length()==2) ? txtThang_vaodang.getText() : "0"+txtThang_vaodang.getText();
		String nam = txtNam_vaodang.getText();
		System.out.println(new String(nam+"-"+thang+"-"+ngay));
		return new String(nam+"-"+thang+"-"+ngay);
	}
	
	
	private boolean emptyFieldExist() {
		JTextField[] allTextField = {
		txtMaGV,
		txtTenGV,
		txtGioiTinh,
		txtChucDanh,
		txtEmail,
		txtDienThoai,
		txtDiaChi,
		txtSoTK,
		txtBoMon,		
		txtNgay_sinh,
		txtThang_sinh,
		txtNam_sinh,		
		txtNgay_vetruong,
		txtThang_vetruong,
		txtNam_vetruong,		
		//txtNgay_vaodang,
		//txtThang_vaodang,
		//txtNam_vaodang 
		};
		for (JTextField field : allTextField) {
			if (field.getText().equals("")) return true;
		}
		return false;
	}
	
	private boolean dateValidNumChar() {
		//(!isValidNumber(txtNam.getText()) || !isValidNumber(txtThang.getText()) || !isValidNumber(txtNgay.getText()) || Integer.parseInt(txtNam.getText())>9999 || Integer.parseInt(txtNam.getText())<0 || Integer.parseInt(txtThang.getText())>12 || Integer.parseInt(txtThang.getText())<0 || Integer.parseInt(txtNgay.getText())>31 || Integer.parseInt(txtNgay.getText())<0) return false;
		if (!isValidNumber(txtNam_sinh.getText()) || !isValidNumber(txtThang_sinh.getText()) || !isValidNumber(txtNgay_sinh.getText()) ) 
			return false;		
		if (!isValidNumber(txtNam_vetruong.getText()) || !isValidNumber(txtThang_vetruong.getText()) || !isValidNumber(txtNgay_vetruong.getText()) ) 
			return false;				
		return true;
	}
	private boolean dateValidRange() {
		if ( Integer.parseInt(txtNam_sinh.getText())>9999 || Integer.parseInt(txtNam_sinh.getText())<1000 || Integer.parseInt(txtThang_sinh.getText())>12 || Integer.parseInt(txtThang_sinh.getText())<0 || Integer.parseInt(txtNgay_sinh.getText())>31 || Integer.parseInt(txtNgay_sinh.getText())<0) 
			return false;
		if ( Integer.parseInt(txtNam_vetruong.getText())>9999 || Integer.parseInt(txtNam_vetruong.getText())<1000 || Integer.parseInt(txtThang_vetruong.getText())>12 || Integer.parseInt(txtThang_vetruong.getText())<0 || Integer.parseInt(txtNgay_vetruong.getText())>31 || Integer.parseInt(txtNgay_vetruong.getText())<0) 
			return false;
		return true;
	}
	private boolean isValidNumber(String str) {
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)>'9' || str.charAt(i)<'0') return false;
		}
		return true;
	}
	private boolean dateVaoDang_empty_all() {
		if (txtNgay_vaodang.getText().equals("") && txtThang_vaodang.getText().equals("") && txtNam_vaodang.getText().equals("")) return true;
		else return false;
	}
	private boolean ngayvaodangValid() {
		if (dateVaoDang_empty_all()) 
			return true;
		//else :
		if (txtNam_vaodang.getText().equals("") || txtThang_vaodang.getText().equals("") || txtNgay_vaodang.getText().equals("")) 
			return false;
		if (!isValidNumber(txtNam_vaodang.getText()) || !isValidNumber(txtThang_vaodang.getText()) || !isValidNumber(txtNgay_vaodang.getText()) ) 
			return false;
		if (Integer.parseInt(txtNam_vaodang.getText())>9999 || Integer.parseInt(txtNam_vaodang.getText())<1000 || Integer.parseInt(txtThang_vaodang.getText())>12 || Integer.parseInt(txtThang_vaodang.getText())<0 || Integer.parseInt(txtNgay_vaodang.getText())>31 || Integer.parseInt(txtNgay_vaodang.getText())<0) 
			return false;
		return true;
	}
}
