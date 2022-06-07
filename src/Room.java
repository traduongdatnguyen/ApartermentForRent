public class Room {
	int MaP;
	String tang, moTa,tinhTrang;
	double gia;
	public Room() {
		
	}
	public Room(int maP, String tang, String moTa, String tinhTrang, double gia) {
		this.MaP = maP;
		this.tang = tang;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.gia = gia;
	}
	public int getMaP() {
		return MaP;
	}
	public void setMaP(int maP) {
		MaP = maP;
	}
	public String getTang() {
		return tang;
	}
	public void setTang(String tang) {
		this.tang = tang;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
}
