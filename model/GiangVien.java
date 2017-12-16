package project.model;

public class GiangVien {
	private String maGV, tenGV, gioiTinh, chucDanh, eMail, dienThoai ;
	private String  soTK, tenBoMon, diaChi;
	private String ngaySinh, ngayVeTruong, ngayVaoDang;
	public GiangVien() { // Không nên xóa constructor này !
		
	}

	
	public GiangVien (String maGV, String tenGV, String gioiTinh, String ngaySinh, String chucDanh,
			String ngayVeTruong, String eMail, String soTK, String dienThoai, String ngayVaoDang, String tenBoMon,
			String diaChi) {
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.chucDanh = chucDanh;
		this.ngayVeTruong = ngayVeTruong;
		this.eMail = eMail;
		this.soTK = soTK;
		this.dienThoai = dienThoai;
		this.ngayVaoDang = ngayVaoDang; if (ngayVaoDang==null) this.ngayVaoDang = "";
		this.tenBoMon = tenBoMon;
		this.diaChi = diaChi;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	public void setTenBoMon(String tenBoMon) {
		this.tenBoMon = tenBoMon;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public void setNgayVeTruong(String ngayVeTruong) {
		this.ngayVeTruong = ngayVeTruong;
	}
	public void setNgayVaoDang(String ngayVaoDang) {
		this.ngayVaoDang = ngayVaoDang;
	}
	public String getMaGV() {
		return maGV;
	}
	public String getTenGV() {
		return tenGV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public String getChucDanh() {
		return chucDanh;
	}
	public String geteMail() {
		return eMail;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public String getSoTK() {
		return soTK;
	}
	public String getTenBoMon() {
		return tenBoMon;
	}
	public  String getDiaChi() {
		return diaChi;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public  String getNgayVeTruong() {
		return ngayVeTruong;
	}
	public  String getNgayVaoDang() {
		return ngayVaoDang;
	}

	
}
