package project.view.giangvien;

import javax.swing.*;

import project.control.ChiKhacControl;
import project.model.DeTai;
import project.model.GiangVien;
import project.view.Main;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DeTaiCaNhanPanel extends JPanel {

	private JTextField txtMaDeTai;
	private JTextField txtTenDeTai;
	private JTextField txtTinhTrang;
	private JTextField txtThoiGianBatDau;
	private JTextField txtThoiGianKetThuc;
	private JButton btnDanhSachChi;
	private JButton btnXinChiKhac;
	private JButton btnHuyDeTai;
	private JButton btnTroVe;
	private JLabel lblTenDeTai;
	private JLabel lblMaDeTai;
	private JLabel lblTinhTrang;
	private JLabel lblThoiGianBatDau;
	private JLabel lblThoiGianKetThuc;
	
	JComboBox<String> cbbChonMaDeTai;
	
	
	private DanhSachChiPanel danhSachChiPanel;
	private XinChiKhacPanel xinChiKhacPanel;
	private HuyDeTaiPanel huyDeTaiPanel;
	
	
	private DeTai deTai;

	//@SuppressWarnings("unused")
	private GiangVien giangVien;
	private JTextField txtChuyenDe;
	private JLabel lblChuyn;
	private JTextField txtKinhPhi;
	private JTextArea txtrNoiDung;

	@SuppressWarnings("deprecation")
	public DeTaiCaNhanPanel() {
		//this.giangVien = giangVienArg;
		
		setBounds(70, 15, 379, 430);
		setLayout(null);

		btnTroVe = new JButton("Đóng");
		btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show(false);
			}
		});
		btnTroVe.setBounds(123, 394, 148, 25);
		add(btnTroVe);

		lblMaDeTai = new JLabel("M\u00E3 \u0111\u1EC1 t\u00E0i");
		lblMaDeTai.setBounds(16, 42, 66, 14);
		add(lblMaDeTai);

		txtMaDeTai = new JTextField();
		txtMaDeTai.setBounds(132, 39, 237, 20);
		txtMaDeTai.setEditable(false);
		add(txtMaDeTai);
		txtMaDeTai.setColumns(10);

		lblTenDeTai = new JLabel("T\u00EAn \u0111\u1EC1 t\u00E0i");
		lblTenDeTai.setBounds(16, 73, 66, 14);
		add(lblTenDeTai);

		txtTenDeTai = new JTextField();
		txtTenDeTai.setBounds(132, 70, 237, 20);
		txtTenDeTai.setEditable(false);
		add(txtTenDeTai);
		txtTenDeTai.setColumns(10);

		lblTinhTrang = new JLabel("T\u00ECnh tr\u1EA1ng");
		lblTinhTrang.setBounds(16, 104, 66, 14);
		add(lblTinhTrang);

		txtTinhTrang = new JTextField();
		txtTinhTrang.setBounds(132, 101, 237, 20);
		txtTinhTrang.setEditable(false);
		add(txtTinhTrang);
		txtTinhTrang.setColumns(10);

		lblThoiGianBatDau = new JLabel("Th\u1EDDi gian b\u1EAFt \u0111\u1EA7u");
		lblThoiGianBatDau.setBounds(16, 135, 106, 14);
		add(lblThoiGianBatDau);

		lblThoiGianKetThuc = new JLabel("Th\u1EDDi gian k\u1EBFt th\u00FAc");
		lblThoiGianKetThuc.setBounds(16, 167, 106, 14);
		add(lblThoiGianKetThuc);

		txtThoiGianBatDau = new JTextField();
		txtThoiGianBatDau.setBounds(132, 132, 237, 20);
		txtThoiGianBatDau.setEditable(false);
		add(txtThoiGianBatDau);
		txtThoiGianBatDau.setColumns(10);

		txtThoiGianKetThuc = new JTextField();
		txtThoiGianKetThuc.setBounds(132, 164, 237, 20);
		txtThoiGianKetThuc.setEditable(false);
		add(txtThoiGianKetThuc);
		txtThoiGianKetThuc.setColumns(10);

		btnDanhSachChi = new JButton("Danh sách chi khác");
		btnDanhSachChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deTai!=null) {
					danhSachChiPanel.show();
					danhSachChiPanel.setDeTai(deTai);
					show(false);
				} else {
					JOptionPane.showMessageDialog(null, "Hãy chọn một mã đề tài !");
				}
			}
		});
		btnDanhSachChi.setBounds(16, 318, 158, 25);
		add(btnDanhSachChi);

		btnXinChiKhac = new JButton("Xin chi kh\u00E1c");
		btnXinChiKhac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deTai!=null) {
					xinChiKhacPanel.setDeTai(deTai);
					xinChiKhacPanel.show();
					show(false);
				} else {
					JOptionPane.showMessageDialog(null, "Hãy chọn một mã đề tài !");
				}
			}
		});
		btnXinChiKhac.setBounds(16, 357, 158, 25);
		add(btnXinChiKhac);

		btnHuyDeTai = new JButton("Hủy đề tài");
		btnHuyDeTai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//huyDeTaiPanel.show();
				//show(false);
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn hủy đề tài này ?", "Hủy đề tài", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) {
		        	if (project.control.DeTaiControl.huyDeTai(txtMaDeTai.getText())==true) {
						JOptionPane.showMessageDialog(null, "Hủy đề tài thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi hủy đề tài");
					}
		        }
		        else {		        	
		        }	        
		        updateComboBoxModel();
			}
		});
		btnHuyDeTai.setBounds(221, 318, 148, 25);
		add(btnHuyDeTai);
		
//		JComboBox cbbChonDeTai = new JComboBox();
//		cbbChonDeTai.setBounds(16, 11, 274, 20);
//		add(cbbChonDeTai);
		
		
		
		//NTS.
		cbbChonMaDeTai = new JComboBox<String>();
		cbbChonMaDeTai.setBounds(16, 11, 353, 20);
		// Don't call this here :
		//cbbChonMaDeTai.setModel(new DefaultComboBoxModel<String>(returnAll_MaDeTaiDangLam(giangVien))); 
		cbbChonMaDeTai.addActionListener (new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {
//		    	table.setModel(getModelfromResultset(project.control.DeTaiControl.thongKeDeTai_theoChuyenDe(String.valueOf(comboBox.getSelectedItem()))));  //table = new JTable(getModelfromResultset(project.control.DeTaiControl.thongKeDeTai_theoChuyenDe(String.valueOf(comboBox.getSelectedItem()))));
//		    	((DefaultTableModel) table.getModel()).fireTableDataChanged(); // DEBUG HERE !
				project.model.DeTai obj = return_1DeTaiDangLam(String.valueOf(cbbChonMaDeTai.getSelectedItem()));
				if (obj!=null) {
					deTai = obj; // HERE !  REMEMBER !				
					
					txtMaDeTai.setText(deTai.getMaDeTai());
					txtTenDeTai.setText(deTai.getTenDeTai());
					txtTinhTrang.setText(deTai.getTinhTrang());
					txtThoiGianBatDau.setText(deTai.getThoiGianBatDau());
					txtThoiGianKetThuc.setText(deTai.getThoiGianKetThuc());
					txtChuyenDe.setText(deTai.getChuyenDe());
					txtKinhPhi.setText(deTai.getKinhPhi());
					txtrNoiDung.setText(deTai.getNoiDung());
					
				} else {
					deTai = null; // DEBUG HERE _NEW				
					
					txtMaDeTai.setText("");
					txtTenDeTai.setText("");
					txtTinhTrang.setText("");
					txtThoiGianBatDau.setText("");
					txtThoiGianKetThuc.setText("");
					txtChuyenDe.setText("");
					txtKinhPhi.setText("");
					txtrNoiDung.setText("");
				}
				
		    }
		});
		add(cbbChonMaDeTai);
		
		txtChuyenDe = new JTextField();
		txtChuyenDe.setEditable(false);
		txtChuyenDe.setBounds(132, 195, 237, 20);
		add(txtChuyenDe);
		txtChuyenDe.setColumns(10);
		
		lblChuyn = new JLabel("Chuyên đề");
		lblChuyn.setBounds(16, 198, 106, 14);
		add(lblChuyn);
		
		txtKinhPhi = new JTextField();
		txtKinhPhi.setEditable(false);
		txtKinhPhi.setBounds(132, 226, 237, 20);
		add(txtKinhPhi);
		txtKinhPhi.setColumns(10);
		
		txtrNoiDung = new JTextArea();
		txtrNoiDung.setEditable(false);
		txtrNoiDung.setBounds(132, 257, 237, 51);
		add(txtrNoiDung);
		
		JLabel lblKinhPhBan = new JLabel("Kinh phí ban đầu");
		lblKinhPhBan.setBounds(16, 229, 114, 14);
		add(lblKinhPhBan);
		
		JLabel lblNiDungTm = new JLabel("Nội dung tóm tắt");
		lblNiDungTm.setBounds(16, 262, 106, 14);
		add(lblNiDungTm);
		
		JButton btnKetThucDeTai = new JButton("Kết thúc đề tài");
		btnKetThucDeTai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn kết thúc đề tài này ?", "Kết thúc đề tài", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) {
		        	if (project.control.DeTaiControl.ketThucDeTai(txtMaDeTai.getText())==true) {
						JOptionPane.showMessageDialog(null, "Kết thúc đề tài thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi kết thúc đề tài");
					}
		        }
		        else {		        	
		        }	        
		        updateComboBoxModel();
			}
		});
		btnKetThucDeTai.setBounds(221, 357, 148, 25);
		add(btnKetThucDeTai);
		
		
		
	}
	
	//NTS.
	public void updateComboBoxModel() { // update the combobox !
		cbbChonMaDeTai.setModel(new DefaultComboBoxModel<String>(returnAll_MaDeTaiDangLam(giangVien)));
	}
	
	
	

	public void reset() {
		this.txtMaDeTai.setText("");
		this.txtTenDeTai.setText("");
		this.txtTinhTrang.setText("");
		this.txtThoiGianBatDau.setText("");
		this.txtThoiGianKetThuc.setText("");
		this.txtChuyenDe.setText("");
		this.txtKinhPhi.setText("");
		this.txtrNoiDung.setText("");
	}

	public void setDanhSachChiPanel(DanhSachChiPanel danhSachChiPanel) {
		this.danhSachChiPanel = danhSachChiPanel;
	}

	public void setXinChiKhacPanel(XinChiKhacPanel xinChiKhacPanel) {
		this.xinChiKhacPanel = xinChiKhacPanel;
	}

	public void setHuyDeTaiPanel(HuyDeTaiPanel huyDeTaiPanel) {
		this.huyDeTaiPanel = huyDeTaiPanel;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
		//this.txtMaDeTai.setText(giangVien.getMaGV());
	}

	public void setDeTai(DeTai deTai) {
		this.deTai = deTai;
		this.txtMaDeTai.setText(deTai.getMaDeTai());
		this.txtTenDeTai.setText(deTai.getTenDeTai());
		this.txtTinhTrang.setText(deTai.getTinhTrang());
		this.txtThoiGianBatDau.setText(deTai.getThoiGianBatDau());
		this.txtThoiGianKetThuc.setText(deTai.getThoiGianKetThuc());
		this.txtChuyenDe.setText(deTai.getChuyenDe());
		this.txtKinhPhi.setText(deTai.getKinhPhi());
		this.txtrNoiDung.setText(deTai.getNoiDung());
	}
	
	
	
	
	//NTS.
	private static String[] returnAll_MaDeTaiDangLam(GiangVien giangVien) { // Return danh sách tất cả các mã de tai.
		if (giangVien==null) return null; // để đề phòng null pointer !
		if (giangVien.getMaGV().equals("")) return null; // để đề phòng SQL Error !
		
		try {
			String sql = "select MaDeTai from QuanLyDeTai1.dbo.DangKyDeTai where MaGV = ? and MaDeTai in (select MaDeTai from QuanLyDeTai1.dbo.DeTai where TinhTrang like N'Đang làm' or TinhTrang like 'Đang làm') order by MaDeTai;";  //"select DT.MaDeTai,DT.ChuyenDe, from QuanLyDeTai1.dbo.DeTai as DT, QuanLyDeTai1.dbo.GV_DT as GVDT, QuanLyDeTai1.dbo.GiangVien as GV     where   DT.MaDeTai=GVDT.MaDeTai and GVDT.MaGV=GV.MaGV ";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, giangVien.getMaGV());
			ResultSet rs = pst.executeQuery();
			
			
			ArrayList<String> stringArrL = new ArrayList<String>();		
			while (rs.next()) {
				stringArrL.add(new String(rs.getString(1)));
			}
			stringArrL.add(0,new String("")); // Default cho combobox. Rỗng là để khi chưa chọn gì thì không hiện gì ở combobox.
			return stringArrL.toArray(new String[stringArrL.size()]);
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	JOptionPane.showMessageDialog(null, ex.toString());
	    }
		
		return null;
	}
	
	
	//NTS.
	public static project.model.DeTai return_1DeTaiDangLam(String maDeTai) {
		if (maDeTai==null) return null;
		if (maDeTai=="") return null;
		
		try {
			String sql = "select * from DeTai where MaDeTai = ?";			
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, maDeTai);
			ResultSet rs = pst.executeQuery();			
			
			if (rs.next()) {
				project.model.DeTai obj = new project.model.DeTai(rs.getString("MaDeTai") , rs.getString("TenDeTai"), rs.getString("TinhTrang"), rs.getString("ThoiGianBatDau"), rs.getString("ThoiGianKetThuc"),
					rs.getString("KinhPhi"), rs.getString("NoiDung"), rs.getString("ChuyenDe")   );
				return obj;
			} else return null;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	JOptionPane.showMessageDialog(null, ex.toString());
        }
		return null;
	}
}




