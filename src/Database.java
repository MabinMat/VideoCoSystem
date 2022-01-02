import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class  Database {
	
	static List<Movie> movies = new ArrayList<Movie>();
	static List<Order> orders = new ArrayList<Order>();
	static List<Customer> customers = new ArrayList<Customer>();
	static List<Admin> admins = new ArrayList<Admin>();
	static List<String> employees= new ArrayList<String>();
	static List<Warehouse> warehouses= new ArrayList<Warehouse>();
	  
	static String customerPath = "customers.csv";
	static String moviePath = "movies.csv";
	static String orderPath = "orders.csv";
	static String adminPath ="admins.csv";
	static String warehousePath = "warehouse.csv";
	static String employeePath = "employee.csv";
	
	

	public static List<Customer> getcustomer() {
		return customers;
	}

	public static void setCustomers(List<Customer> customersList) {
		Database.customers = customersList;
	}

	public static List<Admin> getAdmins() {
		return admins;
	}

	public static void setAdmins(List<Admin> admins) {
		Database.admins = admins;
	}

	public static List<String> getEmployees() {
		return employees;
	}

	public static void setEmployees(List<String> employees) {
		Database.employees = employees;
	}

	public static List<Movie> getMovies() {
		return movies;
	}

	public static void setMovies(List<Movie> movies) {
		Database.movies = movies;
	}

	public static List<Order> getOrders() {
		return orders;
	}

	public static void setOrders(List<Order> orders) {
		Database.orders = orders;
	}

	public static List<Warehouse> getWarehouses() {
		return warehouses;
	}
	

	public static void setWarehouses(List<Warehouse> warehouses) {
		Database.warehouses = warehouses;
	}
	
	
	public static void  addCustomer(Customer cust) {
		Database.customers.add(cust);
	}

	public static void  removeCustomer(Customer cust) {
		Database.customers.remove(cust);
	}
	
	public static void removeCustomer(String userName) {
		
		for(Customer c: customers) {
			if(c.getUserName().equals(userName))
				customers.remove(c);
		}
	}
	
	public static boolean checkAdmin(Admin admin) {
		
		return(Database.employees.contains(admin.getName()));
		
	}
	
	public static boolean isAdmin(String username,String password) {
		
		for(Admin a: admins) {
			
			if(a.getUserName().equals(username) && a.getPassword().equals(password))
				return true;
		}
		
		return false;
	}
	
	public static void addAdmin( Admin admin) {
		Database.admins.add(admin);
	}
	
	public static boolean removeAdmin(Admin admin) {
		if(admins.contains(admin)) {
			Database.admins.remove(admin);
			return true;
		}
			return false;
	}
	
	public static boolean removeAdmin(String username) {
		
		for(Admin a: admins) {
			if(a.getUserName().equals(username)) {
				Database.admins.remove(a);
				return true;
			}
				
		}
		
	return false;
	}
	
	public static void addMovie( Movie movie) {
		Database.movies.add(movie);
	}
	
	public static void removeMovie( Movie movie) {
		Database.movies.remove(movie);
	}
	
	public static void removeMovie( String movieName) {
		
		for(Movie m: movies) {
			
			if(m.getTitle().equals(movieName))
				movies.remove(m);
		}
	}
	

	
	public static void addOrder(Order order) {
		Database.orders.add(order);
	}
	
	public static void removeOrder(Order order) {
		Database.orders.add(order);
	}
	
	public static boolean isCustomer(String username,String password) {
		
		for(Customer c: customers) {
			
			if(c.getUserName().equals(username) && c.getPassword().equals(password))
				return true;
		}
		
		return false;
	}
	

	
	
	/*
	 * IMPLEMENTAION:
	 * 	shipping_info should have city of Customer,
	 * 		order should be shipped to warehouse in that city
	 * 		
	 */

	public String findShipping(Order Order) {
		return null;
	}
	
	public static Order findOrder(String orderID) {
		
		for(Order order: orders) {
			if(order.getOrderID().equals(orderID))
				return order;
		}
		
		return null;
	}
	
	
	public static Movie findMovie(String movie) {
		
		for(Movie mov: movies) {
			if(mov.getTitle().equals(movie))
				return mov;
		}
		
		return null;
	}
	
	public static Customer findCustomer(String userName) {
		
		for(Customer c: customers) {
			if(c.getUserName().equals(userName))
				return c;
		}
		
		return null;
		
		
	}
	
public static Admin findAdmin(String userName) {
		
		for(Admin a: admins) {
			if(a.getUserName().equals(userName))
				return a;
		}
		
		return null;
		
		
	}

public static Warehouse findwarehouse(String warehouseLocation) {
	
	for(Warehouse w: warehouses) {
		if(w.getLocation().equals(warehouseLocation))
			return w;
	}
	
	return null;
	
	
}

public static boolean sendOrder(Order o,Customer c) {
	String location = c.getShipping_billingInfo();
	
	for(Warehouse w: warehouses) {
		if(w.getLocation().equals(location)) {
			w.addOrder(o);
			return true;
		}
	}
	return false;
	
}
	
	public static List<Movie> sortMovie(String category){
		
	List<Movie> out = new ArrayList<Movie>();
		
	for(Movie mov: movies) {
		if(mov.getCategory().equals(category))
			out.add(mov);	
	}
	
	return out;
	
	}
	
	public static boolean  updateOrderStat(String orderID,String stat) {
		if(Database.orderCheck(orderID)) {
			Order order = findOrder(orderID);
			order.setStatus(stat);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean customerCheck(String username) {
		
		return(Database.findCustomer(username)!=null);
			
	}
	
public static boolean movieCheck(String movieTitle) {
		
		return(Database.findMovie(movieTitle)!=null);
			
	}

public static boolean orderCheck(String orderID) {
	
	return(Database.findOrder(orderID)!=null);
		
}


public static boolean isLate(Customer c) {
	
	if((c.getShipping_billingInfo().equals("Alberta")) || (c.getShipping_billingInfo().equals("Surrey"))|| (c.getShipping_billingInfo().equals("Montreal"))) {
		c.getOrder().setLateFee(9.99);
		return true;
	}
	
	return false;
	
}
	
	
public static boolean isUnique(String username,String email) {
	boolean first = true, second=true;
	
	for(Customer c: customers) {
		if(c.getUserName().equals(username))
			first = false;
		if(c.getEmail().equals(email))
			second = false;
	}
	
	
	return (first&&second);
}
	
	
	public static void load() throws IOException {
		CsvReader movieReader = new CsvReader(moviePath);
		movieReader.readHeaders();
		
		CsvReader orderReader = new CsvReader(orderPath);
		orderReader.readHeaders();
		
		CsvReader customerReader = new CsvReader(customerPath);
		customerReader.readHeaders();
		
		CsvReader adminReader = new CsvReader(adminPath);
		adminReader.readHeaders();
		
		CsvReader employeeReader = new CsvReader(employeePath);
		employeeReader.readHeaders();
		
		CsvReader warehouseReader = new CsvReader(warehousePath);
		warehouseReader.readHeaders();
		
		
				
	while(movieReader.readRecord()) {
			List<String> actors = new ArrayList<String>();
			List<String> directors = new ArrayList<String>();
			Movie mov = new Movie();
			mov.setTitle(movieReader.get("Title"));
				
			mov.setCategory(movieReader.get("Category"));
			
			mov.setDateOfRelease(Integer.valueOf(movieReader.get("Date of Release")));
			
			String[] arrOfActors = movieReader.get("Actors").split(",");
			for(String a: arrOfActors)
				actors.add(a);
			mov.setActors(actors);
			
			String[] arrOfDirectors = movieReader.get("Directors").split(",");
			for(String d: arrOfDirectors)
				directors.add(d);
			mov.setDirectors(directors);
			
			for(String test2:mov.getDirectors())
				

			
			mov.setDescription(movieReader.get("Description"));
			
			mov.setStock(Integer.valueOf(movieReader.get("Stock")));
				
			movies.add(mov);
			
		}
	
	Database.setMovies(movies);
	
	while(orderReader.readRecord()) {
		Order order = new Order();
		List<Movie> movs = new ArrayList<Movie>();
		order.setOrderID(orderReader.get("OrderID"));
			
		order.setPrice(Double.valueOf(orderReader.get("Price")));
			
		order.setLateFee(Double.valueOf(orderReader.get("Late Fee")));
			
		order.setStatus(orderReader.get("Status"));
			
		String[] arrOfMovies = orderReader.get("Movies").split(",");
		
		for(String e: arrOfMovies) 
			movs.add(Database.findMovie(e));
		order.setMovies(movs);
		
		orders.add(order);
	}
	
	Database.setOrders(orders);	
	
	while(customerReader.readRecord()){ 
		Customer customer = new Customer();
		

		customer.setName(customerReader.get("Name"));
			
		customer.setUserName(customerReader.get("Username"));
			
		customer.setEmail(customerReader.get("Email"));
		
		customer.setPassword(customerReader.get("Password"));
			
		customer.setLoyaltyPoints(Integer.valueOf(customerReader.get("Loyalty Points")));
		
		customer.setShipping_billingInfo(customerReader.get("Shipping Info"));
			
		customer.setOrder(Database.findOrder(customerReader.get("OrderID")));
		
		customer.setPaymentService(customerReader.get("Payment Service"));
			
		customers.add(customer);
	}
	
	Database.setCustomers(customers);
	
	
	
	while(adminReader.readRecord()) {
		Admin admin = new Admin();
		
		admin.setName(adminReader.get("Name"));
			
		admin.setUserName(adminReader.get("Username"));
		
		admin.setEmail(adminReader.get("Email"));
		
		admin.setPassword(adminReader.get("Password"));
			
		
		admins.add(admin);
	}
	
	Database.setAdmins(admins);
	
	
	while(employeeReader.readRecord()) {
		
		employees.add(employeeReader.get("Employee"));
				
	}
	
	Database.setEmployees(employees);
	
	while(warehouseReader.readRecord()) {
		Warehouse wHouse = new Warehouse();
		
		wHouse.setLocation(warehouseReader.get("Location"));
			
		String[] arrOfCurrOrder = warehouseReader.get("Current Order").split(",");
		
		List<Order> currorders = new ArrayList<Order>();
		
		for(String k: arrOfCurrOrder) {
			
			Order o = Database.findOrder(k);
		
			currorders.add(o);
				}
		wHouse.setCurrOrders(currorders);
		
		
		
		warehouses.add(wHouse);
	}
	
	Database.setWarehouses(warehouses);
	
	
   }
   
	
public static void update() throws IOException{
		
		CsvWriter moviesOutput = new CsvWriter(new FileWriter(moviePath, false), ',');
		
		
		moviesOutput.write("Title");
		moviesOutput.write("Category");
		moviesOutput.write("Date of Release");
		moviesOutput.write("Actors");
		moviesOutput.write("Directors");
		moviesOutput.write("Description");
		moviesOutput.write("Stock");
		moviesOutput.endRecord();
		
		for(Movie m: movies) {
			moviesOutput.write(m.getTitle());
			moviesOutput.write(m.getCategory());
			moviesOutput.write(String.valueOf(m.getDateOfRelease()));
			String outActor = "";
			
					for(int i =0;i< m.getActors().size(); i++) {
						if(i==0)
							outActor += m.getActors().get(i);
						else
							outActor += "," + m.getActors().get(i);
						
					}

			
			moviesOutput.write(outActor);
			
			String outDirector = "";
			
			for(int i =0;i< m.getDirectors().size(); i++) {
				if(i==0)
					outDirector += m.getDirectors().get(i);
				else
					outDirector += "," + m.getDirectors().get(i);
				
			}
			moviesOutput.write(outDirector);
			moviesOutput.write(m.getDescription());
			moviesOutput.write(String.valueOf(m.getStock()));
			moviesOutput.endRecord();
		}
		
		moviesOutput.close();
	
		
		CsvWriter orderOutput = new CsvWriter(new FileWriter(orderPath, false), ',');
		
		orderOutput.write("OrderID");
		orderOutput.write("Price");
		orderOutput.write("Late Fee");
		orderOutput.write("Status");
		orderOutput.write("Movies");
		orderOutput.endRecord();
		
		
		for(Order o: orders) {
			orderOutput.write(o.getOrderID());
			orderOutput.write(String.valueOf(o.getPrice()));
			orderOutput.write(String.valueOf(o.getLateFee()));
			orderOutput.write(o.getStatus());
			List<Movie> outMov = o.getMovies();
			String outStr = "";
			
			for(int i = 0; i<outMov.size();i++) {
				if(i == 0)
					outStr += outMov.get(i).getTitle();
				else 
					outStr += "," + outMov.get(i).getTitle();
				
				}
			
			orderOutput.write(outStr);
			orderOutput.endRecord();
			
			}
		
		orderOutput.close();
		
		
		CsvWriter customerOutput = new CsvWriter(new FileWriter(customerPath, false), ',');
		
		customerOutput.write("Name");
		customerOutput.write("Username");
		customerOutput.write("Email");
		customerOutput.write("Password");
		customerOutput.write("Loyalty Points");
		customerOutput.write("Shipping Info");
		customerOutput.write("OrderID");
		customerOutput.write("Payment Service");
		customerOutput.endRecord();
		
		for(Customer u: customers){
			customerOutput.write(u.getName());
			customerOutput.write(u.getUserName());
			customerOutput.write(u.getEmail());
			customerOutput.write(u.getPassword());
			customerOutput.write(String.valueOf(u.getLoyaltyPoints()));
			customerOutput.write(u.getShipping_billingInfo());
			customerOutput.write(u.getOrder().getOrderID());
			customerOutput.write(u.getPaymentService());
			customerOutput.endRecord();
		}
		customerOutput.close();
		
		
		
		CsvWriter adminOutput = new CsvWriter(new FileWriter(adminPath,false), ',');
		
		
		adminOutput.write("Name");
		adminOutput.write("Username");
		adminOutput.write("Email");
		adminOutput.write("Password");
		adminOutput.endRecord();
		int counter = 0;
		for(Admin a: admins) {
			adminOutput.write(a.getName());
			adminOutput.write(a.getUserName());
			adminOutput.write(a.getEmail());
			adminOutput.write(a.getPassword());
			
			adminOutput.endRecord();
			
		}
		
		adminOutput.close();
		
		CsvWriter employeeOutput = new CsvWriter(new FileWriter(employeePath,false), ',');
		
		employeeOutput.write("Employee");
		employeeOutput.endRecord();
		
		for(String e: employees) {
			employeeOutput.write(e);
			
			employeeOutput.endRecord();
		}
	
		employeeOutput.close();
		
		
		CsvWriter warehouseOutput = new CsvWriter(new FileWriter(warehousePath,false), ',');
   
		warehouseOutput.write("Location");
		warehouseOutput.write("Current Order");
		warehouseOutput.endRecord();
		
		for(Warehouse w:warehouses) {
			warehouseOutput.write(w.getLocation());
			
			List<Order> outOrr = w.getCurrOrders();
			String outStr = "";
						
			for(int i = 0; i<outOrr.size();i++) {
				if(i == 0)
					outStr += outOrr.get(i).getOrderID();
				else 
					outStr += "," + outOrr.get(i).getOrderID();
		
				}
			warehouseOutput.write(outStr);
			warehouseOutput.endRecord();
		}
		warehouseOutput.close();
		
   }
			
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		}

}
