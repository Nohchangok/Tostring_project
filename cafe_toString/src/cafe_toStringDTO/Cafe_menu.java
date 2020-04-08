package cafe_toStringDTO;

public class Cafe_menu {
	int menu_id;
	String coffee;
	int price;
	String size;
	String ice_hot;

	public Cafe_menu() {
		super();
	}

	public Cafe_menu(int menu_id, String coffee, int price, String size, String ice_hot) {
		super();
		this.menu_id = menu_id;
		this.coffee = coffee;
		this.price = price;
		this.size = size;
		this.ice_hot = ice_hot;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getCoffee() {
		return coffee;
	}

	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIce_hot() {
		return ice_hot;
	}

	public void setIce_hot(String ice_hot) {
		this.ice_hot = ice_hot;
	}

	@Override
	public String toString() {
		return "Cafe_menu [menu_id=" + menu_id + ", coffee=" + coffee + ", price=" + price + ", size=" + size
				+ ", ice_hot=" + ice_hot + "]";
	}

}
