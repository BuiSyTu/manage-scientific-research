package project.model;

public class DeTai {

	private String maDeTai;
	private String tenDeTai;
	private String tinhTrang;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	private String kinhPhi;
	private String noiDung;
	private String chuyenDe;
	public DeTai() {
		
	}
	public DeTai(String maDeTai, String tenDeTai, String tinhTrang, String thoiGianBatDau, String thoiGianKetThuc,
			String kinhPhi, String noiDung, String chuyenDe) {
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.tinhTrang = tinhTrang;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.kinhPhi = kinhPhi;
		this.noiDung = noiDung;
		this.chuyenDe = chuyenDe;
	}
	public String getMaDeTai() {
		return maDeTai;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public String getKinhPhi() {
		return kinhPhi;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public String getChuyenDe() {
		return chuyenDe;
	}
	
}