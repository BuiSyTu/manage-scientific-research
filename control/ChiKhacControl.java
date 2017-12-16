package project.control;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import project.model.ChiKhac;
import project.model.DeTai;
import project.view.Main;

public class ChiKhacControl {
	public static Vector<Object> loadDanhSachChi(DeTai deTai) {
		String sql = "Select chikhac.* from detai,chikhac,mc_dt" + " where detai.madetai = mc_dt.madetai"
				+ " and mc_dt.machi = chikhac.machi" + " and detai.madetai = ?";
		Vector<Object> data = new Vector<Object>();
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, deTai.getMaDeTai());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Vector<String> chiKhac = new Vector<String>();
				chiKhac.addElement(rs.getString("MaChi"));
				chiKhac.addElement(rs.getString("LyDo"));
				chiKhac.addElement(rs.getString("Sotien"));
				chiKhac.addElement(rs.getString("tinhTrang"));
				data.addElement(chiKhac);
			}
			return data;

		} catch (SQLException e) {
			e.printStackTrace();
			return data;
		}

	}

	public static void xinChiKhac(ChiKhac ck, DeTai dt) {
		String sql = "Insert into ChiKhac(Machi, Lydo, Sotien, TinhTrang) values (?,?,?,N'Đang chờ')";
		String sql1 = "Insert into mc_dt(Machi, madetai) values (?,?)";
		try {
			Main.getConnection().setAutoCommit(false);
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			PreparedStatement pst1 = Main.getConnection().prepareStatement(sql1);
			pst.setString(1, String.valueOf(newMaChi_ChiKhac()));
			pst.setString(2, ck.getLyDo());
			pst.setString(3, ck.getSoTien());

			pst1.setString(1, String.valueOf(newMaChi_mcdt()));
			pst1.setString(2, dt.getMaDeTai());

			pst.execute();
			pst1.execute();
			Main.getConnection().commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int newMaChi_ChiKhac() {
		String sql = "select Max(Machi) as max from chikhac";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt("Max") + 1);
				return rs.getInt("Max") + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return -1;

	}

	private static int newMaChi_mcdt() {
		String sql = "select Max(Machi) as max from mc_dt";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt("Max") + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return -1;

	}

	public static Vector<Object> loadDanhSachChiDangCho() {
		String sql = "select * from chikhac where tinhtrang = N'Đang chờ'";
		Vector<Object> data = new Vector<Object>();
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Vector<String> chiKhac = new Vector<String>();
				chiKhac.addElement(rs.getString("MaChi"));
				chiKhac.addElement(rs.getString("LyDo"));
				chiKhac.addElement(rs.getString("Sotien"));
				chiKhac.addElement(rs.getString("tinhTrang"));
				data.addElement(chiKhac);
			}
			return data;

		} catch (SQLException e) {
			e.printStackTrace();
			return data;
		}
	}
	
	public static void duyetChiKhac(ChiKhac chiKhac) {
		String sql = "Update ChiKhac set tinhtrang = N'Đã duyệt' where machi = ?";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, chiKhac.getMaChi());
			int kq = pst.executeUpdate();
			System.out.println(kq);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void xoaChiKhac(ChiKhac chiKhac) {
		String sql = "Delete from ChiKhac where machi = ?";
		String sql1 = "Delete from mc_dt where machi = ?";
		try {
			Main.getConnection().setAutoCommit(false);
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			PreparedStatement pst1 = Main.getConnection().prepareStatement(sql1);
			pst.setString(1, chiKhac.getMaChi());

			pst1.setString(1, chiKhac.getMaChi());
			pst1.execute();
			pst.execute();
			Main.getConnection().commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String[] returnAllMaChiKhacChuaDuyet() { // Return danh sách tất cả các mã chi khác.
		
		//Connection databaseConnection = Main.connection;
		//ResultSet rs = null ;		
		
		try {			
			String sql = "select distinct MaChi from ChiKhac where TinhTrang = N'Đang chờ' or TinhTrang = 'Đang chờ' order by MaChi"; // Đừng xóa hay sửa dòng code này ! NTS.
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = null ;
			rs = pst.executeQuery();
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
	
	
	public static project.model.ChiKhac_with_MaDeTai return1ChiKhac_with_DeTai(String maChiArg) { // Tuy là String nhưng LUÔN lưu 1 giá trị số nguyên ! Vì cột MaChi là int.
		if (maChiArg==null) return null; // để đề phòng null pointer !
		if (maChiArg.equals("")) return null; // để đề phòng SQL Error !	
		
		try {
			String sql = "select CK.MaChi,DT.MaDeTai,DT.TenDeTai,CK.SoTien,CK.LyDo,CK.TinhTrang   from ChiKhac CK, DeTai DT, MC_DT MCDT where CK.MaChi=MCDT.MaChi and MCDT.MaDeTai=DT.MaDeTai and CK.MaChi="+maChiArg+" order by MaChi"; // Không cần tinhtrang='Đang chờ' ở đây vì đã xét ở chỗ khác rồi.
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				project.model.ChiKhac_with_MaDeTai obj = new project.model.ChiKhac_with_MaDeTai(rs.getString("MaChi"),rs.getString("LyDo"),rs.getString("SoTien"),rs.getString("TinhTrang"),rs.getString("MaDeTai"),rs.getString("TenDeTai"));
				return obj;
			} else return null;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
		return null;
	}
	
	
	public static boolean chapThuan(String maChi) {	
		if (maChi==null) return false; // để đề phòng null pointer !
		if (maChi.equals("")) return false; // để đề phòng SQL Error !
		try {
			String sql = "Update ChiKhac set tinhtrang = N'Đã duyệt' where machi = ?";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, maChi);
			int status = pst.executeUpdate();
			if (status > 0) return true;
			else return false;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean tuChoi(String maChi) {	
		if (maChi==null) return false; // để đề phòng null pointer !
		if (maChi.equals("")) return false; // để đề phòng SQL Error !
		try {
			String sql = "Update ChiKhac set tinhtrang = N'Từ chối' where machi = ?"; // Không xóa trong Database để Giảng viên còn xem được là đã từ chối !
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, maChi);
			int status = pst.executeUpdate();
			if (status > 0) return true;
			else return false;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
