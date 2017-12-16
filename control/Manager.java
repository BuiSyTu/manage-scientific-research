package project.control;

import project.model.TaiKhoan;
import project.view.Main;

import java.sql.*;

import javax.swing.JOptionPane;

public class Manager {

	public static boolean logIn(String strTaiKhoan, String strMatKhau, String strQuyenTruyCap) {
		String sql = "select * from TaiKhoan where id = ? and pass = ? and quyentruycap = ?";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, strTaiKhoan);
			pst.setString(2, strMatKhau);
			pst.setString(3, strQuyenTruyCap);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {				
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void getMaGV(TaiKhoan taiKhoan) {
		String sql = "select * from TaiKhoan where ID = ?";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, taiKhoan.getTaiKhoan());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				taiKhoan.setMaGiangVien(rs.getString("MaGV"));
				System.out.println("get mã gv thành công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
