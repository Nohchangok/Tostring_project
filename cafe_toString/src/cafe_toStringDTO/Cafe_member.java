package cafe_toStringDTO;

import java.time.LocalDate;

public class Cafe_member {

	String member_id;
	String member_pwd;
	String member_name;
	LocalDate member_birthday;
	int member_point;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public LocalDate getMember_birthday() {
		return member_birthday;
	}

	public void setMember_birthday(LocalDate member_birthday) {
		this.member_birthday = member_birthday;
	}

	public int getMember_point() {
		return member_point;
	}

	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}

	public Cafe_member(String id, String pwd, String name, LocalDate birthday, int point) {
		super();
		this.member_id = id;
		this.member_pwd = pwd;
		this.member_name = name;
		this.member_birthday = birthday;
		this.member_point = point;
	}

	public Cafe_member() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cafe_member [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", member_birthday=" + member_birthday + ", member_point=" + member_point + "]";
	}

}
