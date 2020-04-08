package cafe_toStringDTO;

import java.time.LocalDateTime;

public class Cafe_orderlist {
	int order_num;
	int menu_id;
	int emp_id;
	int price;
	int shot;
	String ice_hot;
	String size;
	int star;
	LocalDateTime order_date = LocalDateTime.now();

	public Cafe_orderlist() {
		super();
	}

	public Cafe_orderlist(int menu_id, int emp_id, int shot, String ice_hot, String size) {
		super();
		this.menu_id = menu_id;
		this.emp_id = emp_id;
		this.shot = shot;
		this.ice_hot = ice_hot;
		this.size = size;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public String getIce_hot() {
		return ice_hot;
	}

	public void setIce_hot(String ice_hot) {
		this.ice_hot = ice_hot;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Cafe_orderlist [order_num=" + order_num + ", menu_id=" + menu_id + ", emp_id=" + emp_id + ", price="
				+ price + ", shot=" + shot + ", ice_hot=" + ice_hot + ", size=" + size + ", star=" + star
				+ ", order_date=" + order_date + "]";
	}

}
