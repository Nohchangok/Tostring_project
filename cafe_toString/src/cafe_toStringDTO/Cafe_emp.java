package cafe_toStringDTO;

public class Cafe_emp {
	int emp_id;
	String name;
	int age;
	String position;
	int pay;
	int star;

	public Cafe_emp() {
		super();
	}

	public Cafe_emp(int emp_id, String name, int age, String position, int pay) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.age = age;
		this.position = position;
		this.pay = pay;

	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "cafe_emp [emp_id=" + emp_id + ", name=" + name + ", age=" + age + ", position=" + position + ", pay="
				+ pay + ", star=" + star + "]";
	}

}
