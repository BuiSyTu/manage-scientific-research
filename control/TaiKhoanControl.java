package project.control;

import java.sql.*;

import javax.swing.JOptionPane;

import project.model.GiangVien;
import project.model.TaiKhoan;
import project.view.Main;

import project.model.TaiKhoan;

public class TaiKhoanControl {

	public static boolean themTaiKhoanOLD(String strTaiKhoan, String strMatKhau, String strMauKhau1,
			String strQuyenTruyCap) {
		if (strMatKhau.equals(strMauKhau1)) {
			String sql = "Insert into TaiKhoan(ID, Pass, QuyenTruyCap)" + "values(?,?,?)";
			try {
				PreparedStatement pst = Main.getConnection().prepareStatement(sql);
				pst.setString(1, strTaiKhoan);
				pst.setString(2, strMatKhau);
				pst.setString(3, strQuyenTruyCap);
				pst.execute();
				JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công");
				return true;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi : " + e.toString());
				return false;
			}
		}
		return false;
	}

	public static boolean xoaTaiKhoan(String strTaiKhoan) {
		String sql = "delete from taikhoan where id = ?";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, strTaiKhoan);
			int status = pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công");
			if (status>0) return true;
			else return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi : " + e.toString());
			return false;
		}
	}

	public static boolean doiMatKhau(final TaiKhoan taiKhoan, String strMatKhauMoi) {
		String sql = "update TaiKhoan set pass = ? where ID = ?";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, strMatKhauMoi);
			pst.setString(2, taiKhoan.getTaiKhoan());
			pst.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean kiemTraTaiKhoanTonTai(String ID) {		
		try {
			String sql = "select * from TaiKhoan where ID = ?";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static TaiKhoan timTaiKhoanWithoutPassword(String ID) {
		
		try {
			String sql = "select * from TaiKhoan where ID = ?";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new TaiKhoan(rs.getString("ID"),null,rs.getString("QuyenTruyCap"),rs.getString("MaGV")); // Khong lay mat khau !
			} else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet timTatCaTaiKhoan_ID_QuyenTruyCap() {		
		try {
			String sql = "select ID,QuyenTruyCap from TaiKhoan";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);			
			ResultSet rs = pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean taoTaiKhoan(TaiKhoan taiKhoanArg, GiangVien giangVienArg) {
		if (timTaiKhoanWithoutPassword(taiKhoanArg.getTaiKhoan()) != null) {
			return false; // Nếu tài khoản đã tồn tại thì false luôn !
		}
		
		String sql = "Insert into TaiKhoan(ID, Pass, QuyenTruyCap, MaGV)" + "values(?,?,?,?)";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, taiKhoanArg.getTaiKhoan());
			pst.setString(2, taiKhoanArg.getMatKhau());
			pst.setString(3, taiKhoanArg.getQuyenTruyCap());
			if (giangVienArg==null) {
				pst.setNull(4, java.sql.Types.NVARCHAR);
			} else {
				pst.setString(4, giangVienArg.getMaGV());
			}
			int status = pst.executeUpdate();
			if (status > 0) {
				return true;
			} else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "Lỗi : " + e.toString());
		}
		return false;
	}
	
}
