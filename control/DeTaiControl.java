package project.control;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import project.model.DeTai;
import project.model.GiangVien;
import project.view.Main;

public class DeTaiControl {
	public static ResultSet timKiemDeTai(String cumTuTimKiem, String tuyChonTimKiem) {
		if (cumTuTimKiem == null || tuyChonTimKiem == null)
			return null; // tránh Null Pointer.
		if (cumTuTimKiem.equals("") || tuyChonTimKiem.equals(""))
			return null; // tránh SQL Error.

		try {
			String sql = ""; // DEBUG HERE !
			Connection databaseConnection = Main.getConnection();
			PreparedStatement pst = null;
			if (tuyChonTimKiem.equals("Tên đề tài")) {
				sql = "select * from DeTai where TenDeTai = ?";
				pst = databaseConnection.prepareStatement(sql);
				pst.setString(1, cumTuTimKiem);
			} else if (tuyChonTimKiem.equals("Mã đề tài")) {
				sql = "select * from DeTai where MaDeTai = ?";
				pst = databaseConnection.prepareStatement(sql);
				pst.setString(1, cumTuTimKiem);
			} else if (tuyChonTimKiem.equals("Tên giảng viên")) {
				sql = "select * from DeTai as DT, DangKyDeTai as DKDT, GiangVien as GV     where DT.MaDeTai = DKDT.MaDeTai and DKDT.MaGV = GV.MaGV and     GV.TenGV = ?";
				pst = databaseConnection.prepareStatement(sql);
				pst.setString(1, cumTuTimKiem);
			} else if (tuyChonTimKiem.equals("Mã giảng viên")) {
				sql = "select * from DeTai as DT, DangKyDeTai as DKDT, GiangVien as GV     where DT.MaDeTai = DKDT.MaDeTai and DKDT.MaGV = GV.MaGV and     GV.MaGV = ?";
				pst = databaseConnection.prepareStatement(sql);
				pst.setString(1, cumTuTimKiem);
			} else if (tuyChonTimKiem.equals("Chuyên đề")) {
				sql = "select * from DeTai where ChuyenDe = ?";
				pst = databaseConnection.prepareStatement(sql);
				pst.setString(1, cumTuTimKiem);
			}
			if (pst != null) {
				ResultSet rs = pst.executeQuery();
				return rs;
			} else
				return null;
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		return null;
	}

	// Mã đề tài, mã chuyên đề , tên chuyên đề, số tiền, TGBD, TGKT, người thực
	// hiện, nhóm thực hiện, tình trạng thực hiện
	public static ResultSet thongKeDeTai() { // hiển thị hết cả bảng Đề Tài. // thống kê này thuộc phòng quản lý !
		String sql = "select * from DeTai";// "select DT.MaDeTai,DT.ChuyenDe, from DeTai as DT, GV_DT as GVDT, GiangVien
											// as GV where DT.MaDeTai=GVDT.MaDeTai and GVDT.MaGV=GV.MaGV ";
		Connection databaseConnection = Main.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	public static String[] getTenCacChuyenDe() {
		String sql = "select distinct ChuyenDe from DeTai order by ChuyenDe";// "select DT.MaDeTai,DT.ChuyenDe, from
																				// DeTai as DT, GV_DT as GVDT, GiangVien
																				// as GV where DT.MaDeTai=GVDT.MaDeTai
																				// and GVDT.MaGV=GV.MaGV ";
		Connection databaseConnection = Main.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		ArrayList<String> stringArrL = new ArrayList<String>();
		stringArrL.add(0, new String("")); // Default cho combobox. Rỗng là để khi chưa chọn gì thì không hiện gì ở
											// combobox.
		try {
			if (rs != null) { // đề phòng Null Pointer.
				while (rs.next()) {
					String str = rs.getString(1);
					if (str != null) { // đề phòng Null Pointer.
						stringArrL.add(new String(str));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stringArrL.toArray(new String[stringArrL.size()]);
	}

	public static String[] getTenCacCap() {
		String sql = "select distinct Cap from DeTai order by Cap";// "select DT.MaDeTai,DT.ChuyenDe, from DeTai as DT,
																	// GV_DT as GVDT, GiangVien as GV where
																	// DT.MaDeTai=GVDT.MaDeTai and GVDT.MaGV=GV.MaGV ";
		Connection databaseConnection = Main.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		ArrayList<String> stringArrL = new ArrayList<String>();
		stringArrL.add(0, new String("")); // Default cho combobox. Rỗng là để khi chưa chọn gì thì không hiện gì ở
											// combobox.
		try {
			if (rs != null) { // đề phòng Null Pointer.
				while (rs.next()) {
					String str = rs.getString(1);
					if (str != null) { // đề phòng Null Pointer.
						stringArrL.add(new String(str));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stringArrL.toArray(new String[stringArrL.size()]);
	}

	public static ResultSet thongKeDeTai_theoChuyenDe(String ChuyenDe) { // hiển thị hết cả bảng Đề Tài. // thống kê này
																			// thuộc phòng quản lý !
		String sql = "select * from DeTai where ChuyenDe LIKE N'" + ChuyenDe + "'";// "select DT.MaDeTai,DT.ChuyenDe,
																					// from DeTai as DT, GV_DT as GVDT,
																					// GiangVien as GV where
																					// DT.MaDeTai=GVDT.MaDeTai and
																					// GVDT.MaGV=GV.MaGV ";
		Connection databaseConnection = Main.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		return rs;
	}

	public static ResultSet thongKeDeTai_theoCap(String Cap) { // hiển thị hết cả bảng Đề Tài. // thống kê này thuộc
																// phòng quản lý !
		String sql = "select * from DeTai where Cap = N'" + Cap + "'";// "select DT.MaDeTai,DT.ChuyenDe, from DeTai as
																		// DT, GV_DT as GVDT, GiangVien as GV where
																		// DT.MaDeTai=GVDT.MaDeTai and GVDT.MaGV=GV.MaGV
																		// ";
		Connection databaseConnection = Main.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		return rs;
	}

	public static DeTai layThongTinDeTaiDangLam(GiangVien giangVien) {
		DeTai deTai = null;
		String sql = "Select DeTai.* from DeTai, GiangVien, DangKyDeTai where DeTai.MaDeTai = DangKyDeTai.MaDeTai "
				+ " and DangKyDeTai.MaGV = GiangVien.MaGV and DeTai.TinhTrang = 'Đang làm' and GiangVien.magv = ?";
		try {
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, giangVien.getMaGV());
			ResultSet rs = pst.executeQuery();
			System.out.println(giangVien.getMaGV());
			if (rs.next()) {
				deTai = new DeTai(rs.getString("MaDeTai"), rs.getString("tenDeTai"), rs.getString("tinhTrang"),
						rs.getString("thoiGianBatDau"), rs.getString("thoiGianKetThuc"), rs.getString("kinhPhi"),
						rs.getString("Noidung"), rs.getString("ChuyenDe"));
				return deTai;
			}
			return deTai;

		} catch (SQLException e) {
			e.printStackTrace();
			return deTai;
		}

	}

	public static ResultSet thongKe_SoLuongDeTai_TheoChuyenDe() {
		String sql = "select ChuyenDe,count(MaDeTai) as SoLuong, sum(CAST(KinhPhi AS INT)) as TongKinhPhi from DeTai group by ChuyenDe order by ChuyenDe";
		Connection databaseConnection = Main.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		return rs;
	}

	public static ResultSet thongKe_SoLuongDeTai_TheoCap() {
		String sql = "select Cap,count(MaDeTai) as SoLuong, sum(CAST(KinhPhi AS INT)) as TongKinhPhi from DeTai group by Cap order by Cap";
		Connection databaseConnection = Main.getConnection();
		ResultSet rs = null;

		try {
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}

		return rs;
	}

	public static boolean huyDeTai(String maDeTaiArg) {
		if (maDeTaiArg == null)
			return false; // tránh Null Pointer.
		if (maDeTaiArg.equals(""))
			return false; // tránh SQL Error.

		try {
			Connection databaseConnection = Main.getConnection();

			String sql1 = "delete from DangKyDeTai where MaDeTai = " + maDeTaiArg;
			PreparedStatement pst = databaseConnection.prepareStatement(sql1);
			pst.execute();
			String sql2 = "delete from DeTai where MaDeTai = " + maDeTaiArg;
			pst = databaseConnection.prepareStatement(sql2);
			pst.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		return false;
	}

	public static boolean ketThucDeTai(String maDeTaiArg) {
		if (maDeTaiArg == null)
			return false; // tránh Null Pointer.
		if (maDeTaiArg.equals(""))
			return false; // tránh SQL Error.

		try {
			Connection databaseConnection = Main.getConnection();

			LocalDateTime timeNow = LocalDateTime.now();
			String homnay = new String(
					timeNow.getYear() + "-" + timeNow.getMonthValue() + "-" + timeNow.getDayOfMonth());
			String sql = "update DeTai set TinhTrang = N'Kết thúc', ThoiGianKetThuc = '" + homnay + "' where MaDeTai = "
					+ maDeTaiArg;
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			int result = pst.executeUpdate();

			if (result > 0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		return false;
	}

	public static boolean dangKyThamGiaDeTaiDaCo(String maGVArg, String maDeTaiArg) {
		if (maDeTaiArg == null)
			return false; // tránh Null Pointer.
		if (maDeTaiArg.equals(""))
			return false; // tránh SQL Error.
		if (maGVArg == null)
			return false; // tránh Null Pointer.
		if (maGVArg.equals(""))
			return false; // tránh SQL Error.

		try {
			Connection databaseConnection = Main.getConnection();

			// -------------------------------
			String sqlTestExist = "select * from DangKyDeTai where MaGV=? and MaDeTai=?";
			PreparedStatement pstTestExist = databaseConnection.prepareStatement(sqlTestExist);
			pstTestExist.setString(1, maGVArg);
			pstTestExist.setString(2, maDeTaiArg);

			ResultSet rs = pstTestExist.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Bạn đã tham gia đề tài này từ trước !");
				return false;
			}

			// -----------------------------

			// -----------------------
			String sql = "insert into DangKyDeTai(MaGV,MaDeTai) values (?,?)";

			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			pst.setString(1, maGVArg);
			pst.setString(2, maDeTaiArg);

			int result = pst.executeUpdate();

			if (result > 0)
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		return false;
	}

	// Phải có maGV để biết ai đăng ký.
	public static boolean dangKyDeTai(String maGV, String tenDeTai, String thoiGianBatDau, String chuyenDe,
			String kinhPhi, String noiDung, String cap) {
				
		DatabaseConnection databaseConnection = new DatabaseConnection();
		String sql = "Insert into  DeTai(madetai,tendetai,tinhtrang,thoigianbatdau,thoigianketthuc,chuyende,kinhphi,noidung,cap)"
				+ " values(?,?,N'Đang chờ',?,null,?,?,?,?)";
		String sql1 = "Insert into DangKyDeTai(MaGV, MaDeTai) " + " values(?,?)";
		try {
			String newMaDeTai = String.valueOf(returnNewMaDeTai());
			PreparedStatement pst = databaseConnection.getConnection().prepareStatement(sql);
			pst.setString(1, newMaDeTai);
			pst.setString(2, tenDeTai);
			pst.setString(3, thoiGianBatDau);
			pst.setString(4, chuyenDe);
			pst.setString(5, kinhPhi);
			pst.setString(6, noiDung);
			pst.setString(7, cap);
			pst.execute();
			PreparedStatement pst1 = Main.getConnection().prepareStatement(sql1);
			pst1.setString(1, maGV);
			pst1.setString(2, newMaDeTai);
			pst1.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static int returnNewMaDeTai() {
		
		try { // Kiểm tra xem trong bảng GiangVien đã có dòng nào chưa.
			String sql = "select * from DeTai";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) { // Nếu trong bảng có ít nhất 1 dòng rồi.
				// Do nothing and move to next step !
			} else { // Còn nếu trong bảng đang rỗng
				return 10000; // Thì trả về 10000 là mã đầu tiên.
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		try {
			String sql = "select Max(MaDeTai) as max from DeTai";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) { // Ban đầu rs trỏ vào dòng -1 nên phải có lệnh next này.
				return rs.getInt("max") + 1; // Không cần kiểm tra rs==null do dù bảng có rỗng thì rs cũng khác null !!!
			} else return 10000;
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return 10000; // Gần như không dùng đến dòng này ! Chỉ viết để đề phòng !
		
	}
	
	
	public static ResultSet getResultSet_fromDeTai_byMaDeTai(String maDeTaiArg) { // để gửi vào Frame mới xuất hiện sau đó.
		if (maDeTaiArg==null) return null;
		if (maDeTaiArg.equals("")) return null;		 		
		
		try {
			String sql = "select * from DeTai where MaDeTai = " + maDeTaiArg;
			
			Connection databaseConnection = Main.getConnection();
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
        } catch (SQLException ex) {
          	ex.printStackTrace();
        }
		
		return null;
	}
	
	public static ResultSet getAllDeTaiDangCho() {		
		try {
			String sql = "select * from QuanLyDeTai1.dbo.DeTai where TinhTrang = N'Đang chờ' or TinhTrang = 'Đang chờ'";//"select DT.MaDeTai,DT.ChuyenDe, from QuanLyDeTai1.dbo.DeTai as DT, QuanLyDeTai1.dbo.GV_DT as GVDT, QuanLyDeTai1.dbo.GiangVien as GV     where   DT.MaDeTai=GVDT.MaDeTai and GVDT.MaGV=GV.MaGV ";
			Connection databaseConnection = Main.getConnection();			
			PreparedStatement pst = databaseConnection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
        } catch (SQLException ex) {
          	ex.printStackTrace();
        }		
		return null;
	}
	
	
	public static boolean chapThuan(String strMaDeTai) {	
		if (strMaDeTai==null) return false; // để đề phòng null pointer !
		if (strMaDeTai.equals("")) return false; // để đề phòng SQL Error !
		try {
			String sql = "Update DeTai set TinhTrang = N'Đang làm' where MaDeTai = ?"; // Không được phép set TinhTrang=N'Đã duyệt' !
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, strMaDeTai);
			int status = pst.executeUpdate();
			if (status > 0) return true;
			else return false;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean tuChoi(String strMaDeTai) {	
		if (strMaDeTai==null) return false; // để đề phòng null pointer !
		if (strMaDeTai.equals("")) return false; // để đề phòng SQL Error !
		try {
			String sql = "Update DeTai set TinhTrang = N'Từ chối' where MaDeTai = ?";
			PreparedStatement pst = Main.getConnection().prepareStatement(sql);
			pst.setString(1, strMaDeTai);
			int status = pst.executeUpdate();
			if (status > 0) return true;
			else return false;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
