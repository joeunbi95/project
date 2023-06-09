package domain;

public class MemberVO {
	/* Create table member(
	id varchar(100) not null,
	password  varchar(100) not null,
	email varchar(100) not null,
	age int,
	reg_date datetime default now(),
	last_login datetime default null,
	Primary key(id));
	 */
	
	private String id;
	private String password;
	private String email;
	private String reg_date;
	private String last_login;
	private int age;
	

	
	
	/*login*/
	public MemberVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	
	/*join*/
	public MemberVO(String id, String password, String email, int age) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.age = age;
	}
	
	
	/*list*/
	public MemberVO(String id, String email, String reg_date, String last_login, int age) {
		this.id = id;
		this.email = email;
		this.age = age;
		this.reg_date = reg_date;
		this.last_login = last_login;
		
	}
	
	public MemberVO(String id, String password, String email, int age, String reg_date, String last_login ) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.age = age;
		this.reg_date = reg_date;
		this.last_login = last_login;
	}
	
	
	/*modify*/
	public MemberVO(String password, String email, int age) {
		this.password = password;
		this.email = email;
		this.age = age;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getReg_date() {
		return reg_date;
	}


	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}


	public String getLast_login() {
		return last_login;
	}


	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "회원정보 : [ID : " + id + ", Password : " + password + ", Email : " + email + ", 가입날짜 : " + reg_date
				+ ", 마지막 로그인 날짜 : " + last_login + ", 나이 : " + age + "]";
	}
	
	
	
	
}
