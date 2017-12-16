package project.control;

import java.sql.*;
import project.model.*;
import project.view.*;

public class GiangVienControl {
	
	public static ResultSet timTatCaGiangVien() {
		GiangVien giangVien = null;
		String sql = "select * from GiangVien";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);			
			ResultSet rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static GiangVien layThongTinGV(TaiKhoan taiKhoan) {
		GiangVien giangVien = null;
		String sql = "select * from GiangVien where MaGV = ?";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, taiKhoan.getMaGiangVien());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				giangVien = new GiangVien(rs.getString("MaGV"), rs.getString("TenGV"), rs.getString("gioitinh"),
						rs.getString("ngaysinh"), rs.getString("ChucDanh"), rs.getString("NgayVeTruong"),
						rs.getString("EMail"), rs.getString("SoTK"), rs.getString("DienThoai"),
						rs.getString("NgayVaoDang"), rs.getString("TenBoMon"), rs.getString("DiaChi"));
				System.out.println("NTS : Lấy thông tin giảng viên từ tài khoản thành công, ngayvetruong = "+giangVien.getNgayVeTruong());
			}
			return giangVien;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return giangVien;
	}

	public static void updateThongTinGV(GiangVien giangVien) {
		String sql = "update GiangVien set TenGV = ?, Ngaysinh= ?,"
				+ " GioiTinh = ?, ChucDanh = ?, NgayVeTruong = ?, EMail= ?,"
				+ " SoTk = ?, DienThoai = ?, NgayVaoDang = ?, TenBoMon= ?, DiaChi = ?" + " Where MaGV = ?";
		try {
			System.out.println("giangVien.getNgayVaoDang().equals(\"\")="+giangVien.getNgayVaoDang().equals(""));
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(2, giangVien.getNgaySinh());
			pst.setString(5, giangVien.getNgayVeTruong());
			//pst.setString(9, (giangVien.getNgayVaoDang().equals(""))? "":giangVien.getNgayVaoDang());
			pst.setString(1, giangVien.getTenGV());
			pst.setString(3, giangVien.getGioiTinh());
			pst.setString(4, giangVien.getChucDanh());
			pst.setString(6, giangVien.geteMail());
			pst.setString(7, giangVien.getSoTK());
			pst.setString(8, giangVien.getDienThoai());
			pst.setString(10, giangVien.getTenBoMon());
			pst.setString(11, giangVien.getDiaChi());
			pst.setString(12, giangVien.getMaGV());
			if (giangVien.getNgayVaoDang().equals("")) {
				//java.sql.Types
				pst.setNull(9, java.sql.Types.DATE);
			} else {
				pst.setString(9, giangVien.getNgayVaoDang());
			}
			pst.execute();

			System.out.println("Thay đổi thông tin giảng viên thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//New!
	public static boolean createThongTinGV(GiangVien giangVien) {
//		String sql = "update GiangVien set TenGV = ?, Ngaysinh= ?,"
//				+ " GioiTinh = ?, ChucDanh = ?, NgayVeTruong = ?, EMail= ?,"
//				+ " SoTk = ?, DienThoai = ?, NgayVaoDang = ?, TenBoMon= ?, DiaChi = ?" + " Where MaGV = ?";
		
		String sql = "insert into GiangVien(TenGV,Ngaysinh,GioiTinh,ChucDanh,NgayVeTruong,EMail,SoTk,DienThoai,NgayVaoDang,TenBoMon,DiaChi,MaGV)"
				                  +"values (    ?,       ?,       ?,       ?,           ?,    ?,   ?,        ?,          ?,       ?,     ?,   ?)";                    
		
		try {
			//System.out.println("giangVien.getNgayVaoDang().equals(\"\")="+giangVien.getNgayVaoDang().equals(""));
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(2, giangVien.getNgaySinh());
			pst.setString(5, giangVien.getNgayVeTruong());
			//pst.setString(9, (giangVien.getNgayVaoDang().equals(""))? "":giangVien.getNgayVaoDang());
			pst.setString(1, giangVien.getTenGV());
			pst.setString(3, giangVien.getGioiTinh());
			pst.setString(4, giangVien.getChucDanh());
			pst.setString(6, giangVien.geteMail());
			pst.setString(7, giangVien.getSoTK());
			pst.setString(8, giangVien.getDienThoai());
			pst.setString(10, giangVien.getTenBoMon());
			pst.setString(11, giangVien.getDiaChi());
			pst.setString(12, giangVien.getMaGV());
			if (giangVien.getNgayVaoDang().equals("")) {
				//java.sql.Types
				pst.setNull(9, java.sql.Types.DATE);
			} else {
				pst.setString(9, giangVien.getNgayVaoDang());
			}
			int status = pst.executeUpdate();
			if (status > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	public static ResultSet lietKeGiangVienLamDeTai(String maDeTaiArg) {
		//GiangVien giangVien = null;
		String sql = "select * from GiangVien where MaGV in (select MaGV from DangKyDeTai where MaDeTai = ?)";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, maDeTaiArg);
			ResultSet rs = pst.executeQuery();
			
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public static String returnNewMaGV() {	
		try { // Kiểm tra xem trong bảng GiangVien đã có dòng nào chưa.
			String sql = "select * from GiangVien";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) { // Nếu trong bảng có ít nhất 1 dòng rồi.
				// Do nothing and move to next step !
				System.out.println("GiangVien table is NOT empty <OK>. System should now return a valid max+1 !");
			} else { // Còn nếu trong bảng đang rỗng
				return new String("1000"); // Thì trả về 1000 là mã đầu tiên.
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		try {
			String sql = "select max(cast(MaGV as int)) as max from GiangVien";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) { // Ban đầu rs trỏ vào dòng -1 nên phải có lệnh next này.
				String str = String.valueOf (Integer.parseInt(rs.getString("max")) + 1 );
				System.out.println("System will now return : "+str);
				return str; 
			} else return new String("1000");
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return new String("1000"); // Gần như không dùng đến dòng này ! Chỉ viết để đề phòng !
	}
}
