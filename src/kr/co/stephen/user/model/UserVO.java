package kr.co.stephen.user.model;

/*
CREATE TABLE user (
	user_id VARCHAR(30) PRIMARY KEY,
    user_pw VARCHAR(30) NOT NULL,
    user_name VARCHAR(30),
    user_email VARCHAR(30),
    user_address VARCHAR(80)
);
*/


public class UserVO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	
	public UserVO() {}

	public UserVO(String id, String pw, String name, String email, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	

}











