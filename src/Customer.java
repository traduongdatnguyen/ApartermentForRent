public class Customer {
	int id;
	String fullname, gender, phoneNumber;
	int age;
	int MaP;
	String tang, moTa,tinhTrang;
	double gia;
	public Customer() {
		
	}
	public Customer(int id, String fullname, String gender, String phoneNumber, int age,int MaP, String tang, String moTa, String tinhTrang, double gia) {
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.MaP = MaP;
		this.tang = tang;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.gia = gia;
	}
	public Customer(String fullname, String gender, String phoneNumber, int age,int MaP) {
		this.fullname = fullname;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.MaP = MaP;
		this.tang = tang;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.gia = gia;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) { 
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getmaP() {
		return  MaP;
	}
	public void setmaP(int MaP) {
		this.MaP = MaP;
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