
public class Customer extends User{

	private int loyaltyPoints;
	private Order order;
	private String shipping_billingInfo;
	private String paymentService;
	
	
	
	public Customer() {
		super();
		loyaltyPoints = 0;
		shipping_billingInfo ="N/A";
		paymentService = "N/A";
		order = new Order();
				
	}
	

	
	
	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}



	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}



	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	public String getShipping_billingInfo() {
		return shipping_billingInfo;
	}



	public void setShipping_billingInfo(String shipping_billingInfo) {
		this.shipping_billingInfo = shipping_billingInfo;
	}



	public String getPaymentService() {
		return paymentService;
	}



	public void setPaymentService(String paymentService) {
		this.paymentService = paymentService;
	}

	
	public void addLoyaltyPoints() {
		this.loyaltyPoints++;
	}
	
	public boolean addToOrderList(Movie movie) {
		
		if(this.getOrder().getMovies().contains(movie)) {
			return false;
		}
		if(!movie.inStock()) {
			return false;
		}
			
		else {
			this.order.addMovie(movie);
			movie.removeStock();
			this.addLoyaltyPoints();
			return true;
		}
		
	}
	
	public boolean removeFromOrderList(Movie movie) {
		
		if(!this.getOrder().getMovies().contains(movie)) {
			return false;
		}
		else {
			this.order.removeMovie(movie);
			movie.addStock();
			return true;
		}
		
	}
	
	
	public boolean payUsingService() {
		
		if(this.paymentService!=null) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean payUsingLoyalty() {
		int size = this.getOrder().getMovies().size();
		int numOfFreeMovies = this.getLoyaltyPoints()/10;
		
		if(numOfFreeMovies<size)
			return false;
		else {
			int loyaltSubstractor = size*10;
			this.setLoyaltyPoints(this.getLoyaltyPoints()-loyaltSubstractor);
			return true;
			
			
		}
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
