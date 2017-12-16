//package project.view.phongql;
//
////import javax.swing.JPanel;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JTextArea;
//
//
//public class ChiTietMotDeTaiDangXetPanel extends JFrame {
//	private JTextField txtMaDeTai;
//	private JTextField txtTenDeTai;
//	private JTextField txtThoiGianBatDau;
//	private JTextField txtTinhTrang;
//	private JTextField txtChuyenDe;
//	private JTextField txtKinhPhi;
//	private JTextField txtCap;
//	
//	
//	private String strMaDeTai;
//	private String strTenDeTai;
//	private String strThoiGianBatDau;
//	private String strTinhTrang;
//	private String strChuyenDe;
//	private String strKinhPhi;
//	private String strNoiDung;
//	private String strCap;
//
//	/**
//	 * Create the frame.
//	 */
//	public ChiTietMotDeTaiDangXetPanel(String strMaDeTaiArg, String strTenDeTaiArg, String strThoiGianBatDauArg, String strTinhTrangArg, String strChuyenDeArg, String strKinhPhiArg, String strNoiDungArg, String strCapArg) {
//		
//
//	}
//}








//public class ChiTietMotDeTaiDangXetPanel extends JPanel {
//	private JTextField txtMaDeTai;
//	private JTextField txtTenDeTai;
//	private JTextField txtThoiGianBatDau;
//	private JTextField txtTinhTrang;
//	private JTextField txtChuyenDe;
//	private JTextField txtKinhPhi;
//	private JTextField txtCap;
//	
//	
//	private String strMaDeTai;
//	private String strTenDeTai;
//	private String strThoiGianBatDau;
//	private String strTinhTrang;
//	private String strChuyenDe;
//	private String strKinhPhi;
//	private String strNoiDung;
//	private String strCap;
//
//	/**
//	 * Create the panel.
//	 */
//	public ChiTietMotDeTaiDangXetPanel(String strMaDeTaiArg, String strTenDeTaiArg, String strThoiGianBatDauArg, String strTinhTrangArg, String strChuyenDeArg, String strKinhPhiArg, String strNoiDungArg, String strCapArg) {
//		this.strMaDeTai = strMaDeTaiArg;
//		this.strTenDeTai = strTenDeTaiArg;
//		this.strThoiGianBatDau = strThoiGianBatDauArg;
//		this.strTinhTrang = strTinhTrangArg;
//		this.strChuyenDe = strChuyenDeArg;
//		this.strKinhPhi = strKinhPhiArg;
//		this.strNoiDung = strNoiDungArg;
//		this.strCap = strCapArg;
//		
//		
//		if (strMaDeTai==null) strMaDeTai = new String("");
//		if (strTenDeTai==null) strTenDeTai = new String("");
//		if (strThoiGianBatDau==null) strThoiGianBatDau = new String("");
//		if (strTinhTrang==null) strTinhTrang = new String("");
//		if (strChuyenDe==null) strChuyenDe = new String("");
//		if (strKinhPhi==null) strKinhPhi = new String("");
//		if (strNoiDung==null) strNoiDung = new String("");
//		if (strCap==null) strCap = new String("");
//		
//		
//		setLayout(null);
//		
//		JLabel lblMaDeTai = new JLabel("Mã đề tài");
//		lblMaDeTai.setBounds(10, 81, 46, 14);
//		add(lblMaDeTai);
//		
//		txtMaDeTai = new JTextField();
//		txtMaDeTai.setText(strMaDeTai);
//		txtMaDeTai.setBounds(86, 78, 86, 20);
//		add(txtMaDeTai);
//		txtMaDeTai.setColumns(10);
//		
//		JLabel lblTenDeTai = new JLabel("Tên đề tài");
//		lblTenDeTai.setBounds(10, 119, 46, 14);
//		add(lblTenDeTai);
//		
//		txtTenDeTai = new JTextField();
//		txtTenDeTai.setText(strTenDeTai);
//		txtTenDeTai.setBounds(86, 116, 86, 20);
//		add(txtTenDeTai);
//		txtTenDeTai.setColumns(10);
//		
//		JLabel lblThoiGianBatDau = new JLabel("Thời gian bắt đầu");
//		lblThoiGianBatDau.setBounds(10, 241, 46, 14);
//		add(lblThoiGianBatDau);
//		
//		txtThoiGianBatDau = new JTextField();
//		txtThoiGianBatDau.setText(strThoiGianBatDau);
//		txtThoiGianBatDau.setBounds(86, 238, 86, 20);
//		add(txtThoiGianBatDau);
//		txtThoiGianBatDau.setColumns(10);
//		
//		JLabel lblTinhTrang = new JLabel("Tình trạng");
//		lblTinhTrang.setBounds(10, 156, 46, 14);
//		add(lblTinhTrang);
//		
//		txtTinhTrang = new JTextField();
//		txtTinhTrang.setText(strTinhTrang);
//		txtTinhTrang.setBounds(86, 153, 86, 20);
//		add(txtTinhTrang);
//		txtTinhTrang.setColumns(10);
//		
//		JLabel lblChuyenDe = new JLabel("Chuyên đề");
//		lblChuyenDe.setBounds(10, 283, 46, 14);
//		add(lblChuyenDe);
//		
//		txtChuyenDe = new JTextField();
//		txtChuyenDe.setText(strChuyenDe);
//		txtChuyenDe.setBounds(86, 280, 86, 20);
//		add(txtChuyenDe);
//		txtChuyenDe.setColumns(10);
//		
//		JLabel lblKinhPhi = new JLabel("Kinh phí");
//		lblKinhPhi.setBounds(10, 319, 46, 14);
//		add(lblKinhPhi);
//		
//		txtKinhPhi = new JTextField();
//		txtKinhPhi.setText(strKinhPhi);
//		txtKinhPhi.setBounds(86, 316, 86, 20);
//		add(txtKinhPhi);
//		txtKinhPhi.setColumns(10);
//		
//		JLabel lblNoiDung = new JLabel("Nội dung");
//		lblNoiDung.setBounds(10, 359, 46, 14);
//		add(lblNoiDung);
//		
//		JTextArea txtrNoiDung = new JTextArea();
//		txtrNoiDung.setText(strNoiDung);
//		txtrNoiDung.setBounds(86, 354, 86, 20);
//		add(txtrNoiDung);
//		
//		JLabel lblCap = new JLabel("Cấp");
//		lblCap.setBounds(10, 392, 46, 14);
//		add(lblCap);
//		
//		txtCap = new JTextField();
//		txtCap.setText(strCap);
//		txtCap.setBounds(86, 389, 86, 20);
//		add(txtCap);
//		txtCap.setColumns(10);
//
//	}
//}
