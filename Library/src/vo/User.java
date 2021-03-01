package vo;

public class User {
	String Uid;
	String Uname;
	String UPassword;
	String UEmail;
	String UPhone;
	String URegDate;
	
	public String getURegDate() {
		return URegDate;
	}

	public void setURegDate(String uRegDate) {
		URegDate = uRegDate;
	}

	public User(String uid, String uname, String uPassword, String uEmail, String uPhone) {
		Uid = uid;
		Uname = uname;
		UPassword = uPassword;
		UEmail = uEmail;
		UPhone = uPhone;
	}
	
	public User(String uid, String uname, String uPassword, String uEmail, String uPhone, String uRegDate) {
		Uid = uid;
		Uname = uname;
		UPassword = uPassword;
		UEmail = uEmail;
		UPhone = uPhone;
		URegDate = uRegDate;
	}
	
	public String getUPhone() {
		return UPhone;
	}
	public void setUPhone(String uPhone) {
		UPhone = uPhone;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUPassword() {
		return UPassword;
	}
	public void setUPassword(String uPassword) {
		UPassword = uPassword;
	}
	public String getUEmail() {
		return UEmail;
	}
	public void setUEmail(String uEmail) {
		UEmail = uEmail;
	}
	
	
}
