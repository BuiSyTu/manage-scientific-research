package project.model;

public class ChiKhac_with_MaDeTai { // extends ChiKhac
	private String maChi;
	private String lyDo;
	private String soTien;
	private String tinhTrang;
	private String maDeTai;
	private String tenDeTai;
	
	public ChiKhac_with_MaDeTai(String maChi, String lyDo, String soTien, String tinhTrang, String maDeTai, String tenDeTai) {
		this.maChi = maChi;
		this.lyDo = lyDo;
		this.soTien = soTien;
		this.tinhTrang = tinhTrang;
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
	}
	public String getMaChi() {
		return maChi;
	}
	public String getLyDo() {
		return lyDo;
	}
	public String getSoTien() {
		return soTien;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public String getMaDeTai() {
		return maDeTai;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	
	
	public void setMaChi(String maChi) {
		this.maChi = maChi;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public void setSoTien(String soTien) {
		this.soTien = soTien;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
}
