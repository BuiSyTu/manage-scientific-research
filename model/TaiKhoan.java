package project.model;

public class TaiKhoan {

	private String taiKhoan;
	private String matKhau;
	private String quyenTruyCap;
	private String maGiangVien;
	
	public TaiKhoan() {
		
	}

	public TaiKhoan(final String taiKhoan, final String matKhau, final String quyenTruyCap, final String MaGiangVien) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.quyenTruyCap = quyenTruyCap;
		this.maGiangVien = MaGiangVien;
	}
	
//	public TaiKhoan(final String taiKhoan, final String matKhau, final String quyenTruyCap) {
//		this.taiKhoan = taiKhoan;
//		this.matKhau = matKhau;
//		this.quyenTruyCap = quyenTruyCap;
//	}
	
	@Override
	public String toString() {
		return this.taiKhoan+this.maGiangVien;
	}
	
	public TaiKhoan(final String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public String getQuyenTruyCap() {
		return quyenTruyCap;
	}

	public String getMaGiangVien() {
		return maGiangVien;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	
	@Override
	public boolean equals(Object other) {
		 if (this == other) {
	            return true;
	        }
		if (!(other instanceof TaiKhoan)) {
			return false;
		}
		final TaiKhoan otherTaiKhoan = (TaiKhoan) other;
		return this.taiKhoan.equals(otherTaiKhoan.getTaiKhoan()) && this.matKhau.equals(otherTaiKhoan.getMatKhau())
				&& this.quyenTruyCap.equals(otherTaiKhoan.getQuyenTruyCap());
	}
}