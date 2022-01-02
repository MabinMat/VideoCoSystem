import java.util.List;

public class Warehouse {
	
	
	private String location;
	private List<Order> currOrders;
	
	
	public Warehouse() {
		location = null;
		currOrders = null;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Order> getCurrOrders() {
		return currOrders;
	}

	public void setCurrOrders(List<Order> currOrders) {
		this.currOrders = currOrders;
	}
	
	public void addOrder(Order order) {
		this.currOrders.add(order);
		
	}
	
	public void removeOrder(Order order) {
		this.currOrders.remove(order);
		
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
