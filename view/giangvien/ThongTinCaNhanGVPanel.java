//package project.view.giangvien;
//
//import javax.swing.*;
//
//import project.model.GiangVien;
//import java.awt.event.*;
//
//@SuppressWarnings("serial")
//public class ThongTinCaNhanGVPanel extends JPanel {
//
//	/**
//	 * 
//	 */
//
//
//
//	private JTextField txtMaGV;
//	private JTextField txtTenGV;
//	private JTextField txtGioiTinh;
//	private JTextField txtNgaySinh;
//	private JTextField txtChucDanh;
//	private JTextField txtNgayVeTruong;
//	private JTextField txtEmail;
//	private JTextField txtDienThoai;
//	private JTextField txtNgayVaoDang;
//	private JTextField txtDiaChi;
//	private JTextField txtSoTK;
//	private TuyChonGVPanel tuyChonGVPanel;
//	private JTextField txtBoMon;
//	
//	@SuppressWarnings("unused")
//	private GiangVien giangVien;
//
//	public ThongTinCaNhanGVPanel() {
//		setLayout(null);
//
//		JLabel lblMaGV = new JLabel("M\u00E3 GV");
//		lblMaGV.setBounds(231, 27, 94, 20);
//		add(lblMaGV);
//
//		JLabel lblTenGV = new JLabel("T\u00EAn GV");
//		lblTenGV.setBounds(231, 96, 94, 14);
//		add(lblTenGV);
//
//		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh");
//		lblGioiTinh.setBounds(231, 148, 94, 14);
//		add(lblGioiTinh);
//
//		JLabel lblNgaySinh = new JLabel("Ng\u00E0y sinh");
//		lblNgaySinh.setBounds(231, 202, 70, 14);
//		add(lblNgaySinh);
//
//		JLabel lblChucDanh = new JLabel("Ch\u1EE9c danh");
//		lblChucDanh.setBounds(231, 260, 70, 14);
//		add(lblChucDanh);
//		
//		JLabel lblNgayVeTruong = new JLabel("Ng\u00E0y v\u1EC1 tr\u01B0\u1EDDng");
//		lblNgayVeTruong.setBounds(231, 304, 94, 20);
//		add(lblNgayVeTruong);
//		
//		JLabel lblSoTK = new JLabel("S\u1ED1 TK");
//		lblSoTK.setBounds(497, 198, 94, 14);
//		add(lblSoTK);
//
//		JLabel lblDienThoai = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
//		lblDienThoai.setBounds(497, 252, 94, 14);
//		add(lblDienThoai);
//
//		txtMaGV = new JTextField();
//		txtMaGV.setBounds(335, 27, 86, 20);
//		txtMaGV.setColumns(10);
//		txtMaGV.setEditable(false);
//		add(txtMaGV);
//
//		txtTenGV = new JTextField();
//		txtTenGV.setEditable(false);
//		txtTenGV.setBounds(335, 93, 86, 20);
//		txtTenGV.setColumns(10);
//		add(txtTenGV);
//
//		txtGioiTinh = new JTextField();
//		txtGioiTinh.setEditable(false);
//		txtGioiTinh.setBounds(335, 145, 86, 20);
//		txtGioiTinh.setColumns(10);
//		add(txtGioiTinh);
//
//		txtNgaySinh = new JTextField();
//		txtNgaySinh.setEditable(false);
//		txtNgaySinh.setBounds(335, 199, 86, 20);
//		txtNgaySinh.setColumns(10);
//		add(txtNgaySinh);
//
//		txtChucDanh = new JTextField();
//		txtChucDanh.setEditable(false);
//		txtChucDanh.setBounds(335, 257, 86, 20);
//		txtChucDanh.setColumns(10);
//		add(txtChucDanh);
//
//		txtNgayVeTruong = new JTextField();
//		txtNgayVeTruong.setEditable(false);
//		txtNgayVeTruong.setBounds(335, 304, 86, 20);
//		txtNgayVeTruong.setColumns(10);
//		add(txtNgayVeTruong);
//
//		JLabel lblEmail = new JLabel("Email");
//		lblEmail.setBounds(497, 146, 94, 14);
//		add(lblEmail);
//
//		txtEmail = new JTextField();
//		txtEmail.setEditable(false);
//		txtEmail.setBounds(601, 143, 86, 20);
//		txtEmail.setColumns(10);
//		add(txtEmail);
//
//		txtDienThoai = new JTextField();
//		txtDienThoai.setEditable(false);
//		txtDienThoai.setBounds(601, 249, 86, 20);
//		txtDienThoai.setColumns(10);
//		add(txtDienThoai);
//
//		JLabel lblNgayVaoDang = new JLabel("Ng\u00E0y v\u00E0o \u0110\u1EA3ng");
//		lblNgayVaoDang.setBounds(497, 310, 94, 14);
//		add(lblNgayVaoDang);
//
//		txtNgayVaoDang = new JTextField();
//		txtNgayVaoDang.setEditable(false);
//		txtNgayVaoDang.setBounds(601, 307, 86, 20);
//		txtNgayVaoDang.setColumns(10);
//		add(txtNgayVaoDang);
//
//		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9");
//		lblDiaChi.setBounds(231, 388, 94, 20);
//		add(lblDiaChi);
//
//		txtDiaChi = new JTextField();
//		txtDiaChi.setEditable(false);
//		txtDiaChi.setBounds(335, 388, 352, 20);
//		txtDiaChi.setColumns(10);
//		add(txtDiaChi);
//
//		txtSoTK = new JTextField();
//		txtSoTK.setEditable(false);
//		txtSoTK.setBounds(601, 195, 86, 20);
//		txtSoTK.setColumns(10);
//		add(txtSoTK);
//		setBounds(0, 0, 800, 500);
//
//		JButton btnTroVe = new JButton("Tr\u1EDF v\u1EC1");
//		btnTroVe.setBounds(10, 11, 89, 23);
//		btnTroVe.addActionListener(new ActionListener() {
//			@SuppressWarnings("deprecation")
//			public void actionPerformed(ActionEvent e) {
//				tuyChonGVPanel.show();
//				show(false);
//			}
//		});
//		add(btnTroVe);
//		
//		JLabel lblTnBMn = new JLabel("Tên bộ môn");
//		lblTnBMn.setBounds(494, 96, 70, 14);
//		add(lblTnBMn);
//		
//		txtBoMon = new JTextField();
//		txtBoMon.setEditable(false);
//		txtBoMon.setBounds(601, 93, 86, 20);
//		add(txtBoMon);
//		txtBoMon.setColumns(10);
//		
//
//	}
//	
//	public void setGiangVien(GiangVien giangVien) {
//		this.giangVien = giangVien;
//		this.txtMaGV.setText(giangVien.getMaGV());
//		this.txtTenGV.setText(giangVien.getTenGV());
//		this.txtNgaySinh.setText(giangVien.getNgaySinh());
//		this.txtGioiTinh.setText(giangVien.getGioiTinh());
//		this.txtChucDanh.setText(giangVien.getChucDanh());
//		this.txtNgayVeTruong.setText(giangVien.getNgayVeTruong());
//		this.txtEmail.setText(giangVien.geteMail());
//		this.txtSoTK.setText(giangVien.getSoTK());
//		this.txtDienThoai.setText(giangVien.getDienThoai());
//		this.txtNgayVaoDang.setText(giangVien.getNgayVaoDang());
//		this.txtBoMon.setText(giangVien.getTenBoMon());
//		this.txtDiaChi.setText(giangVien.getDiaChi());
//	}
//
//	public void setTuyChonGVPanel(TuyChonGVPanel tuyChonGVPanel) {
//		this.tuyChonGVPanel = tuyChonGVPanel;
//		
//	}
//}
