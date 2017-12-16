package project.model;

public class ChiKhac {
	
	private String maChi;
	private String lyDo;
	private String soTien;
	private String tinhTrang;
	public ChiKhac() {
		
	}
	public ChiKhac(String maChi, String lyDo, String soTien, String tinhTrang) {
		this.maChi = maChi;
		this.lyDo = lyDo;
		this.soTien = soTien;
		this.tinhTrang = tinhTrang;
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
	
	
}