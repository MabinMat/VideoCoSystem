import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
	
	private String orderID;
	private double price;
	private List<Movie> movies;
	private double lateFee;
	private String status;
	
	public Order(){
		orderID = Order.generateOrderID();
		price=0;
		movies = new ArrayList<Movie>();
		lateFee=0;
		status="Ordered";
	}
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
 
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public void addMovie(Movie movie) {
		this.movies.add(movie);
		this.price=this.price+5;
	}
	
	public void removeMovie(Movie movie) {
		this.movies.remove(movie);
		this.price=this.price-5;
	}
	

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public void addLateFee(int days) {
		int size = this.movies.size();
		int fee = size;
		fee += days;
		this.lateFee=fee;
		}
	
	public boolean clearOrder() {
		if(status.equals("ordered")) {
			this.setPrice(00);
			this.setLateFee(00);
			List<Movie> o = new ArrayList<Movie>();
			this.setMovies(o);
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		String out = "";
		
		if(this.getMovies().contains(null))
			out="No Movies added";
		else {
		for(int i =0;i< this.getMovies().size();i++) {
			if(i==0) {
				out+= this.getMovies().get(i).getTitle();
			}
			else
				out+= "," + this.getMovies().get(i).getTitle();
		}
		
		}
		return out;
			
	}
	

	
	public static String generateOrderID() {
		char first,second,third;
		int first1,second1,third1;
		Random r = new Random();
		first = (char)(r.nextInt('Z' - 'A') + 'A');
		second = (char)(r.nextInt('Z' - 'A') + 'A');
		third = (char)(r.nextInt('Z' - 'A') + 'A');
		
		first1 = (int) Math.floor(Math.random()*(9-0+1)+0);
		second1= (int) Math.floor(Math.random()*(9-0+1)+0);
		third1 = (int) Math.floor(Math.random()*(9-0+1)+0);
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		sb.append(second);
		sb.append(first1);
		sb.append(second1);
		sb.append(third);
		sb.append(third1);
		
		String out = sb.toString();
		return out;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
