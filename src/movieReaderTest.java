import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class movieReaderTest {
  static String moviePath = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\movies.csv";
  static String moviePathWriter = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\moviesWriter.csv";
  static String orderPath = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\orders.csv";
  static String orderPathWriter = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\ordersWriter.csv";
  static String customerPath = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\customers.csv";
  static String customerPathWriter = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\customersWriter.csv";
  static String adminPath ="C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\admins.csv";
  static String adminPathWriter ="C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\adminsWriter.csv";
  static String employeePath = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\employee.csv";
  static String employeePathWriter = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\employeeWriter.csv";
  static String warehousePath = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\warehouse.csv";
  static String warehousePathWriter = "C:\\Users\\mabin\\eclipse-workspace\\EECS3311_DesignProject\\warehouseWriter.csv";
  
  static List<Movie> movies = new ArrayList<Movie>();
  static List<Order> orders = new ArrayList<Order>();
  static List<Customer> customers = new ArrayList<Customer>();
  static List<Admin> admins = new ArrayList<Admin>();
  static List<String> employees= new ArrayList<String>();
  static List<Warehouse> warehouses= new ArrayList<Warehouse>();
  
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
		
		CsvReader warehouseReader = new CsvReader(warehousePathWriter);
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
		
			
		
		System.out.println(" ");
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
		customerOutput.endRecord();
		
		for(Customer u: customers){
			customerOutput.write(u.getName());
			customerOutput.write(u.getUserName());
			customerOutput.write(u.getEmail());
			customerOutput.write(u.getPassword());
			customerOutput.write(String.valueOf(u.getLoyaltyPoints()));
			customerOutput.write(u.getShipping_billingInfo());
			customerOutput.write(u.getOrder().getOrderID());
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
	   //movieReaderTest.update();
	   movieReaderTest.load();
	   movieReaderTest.update();
	  
	   
	   //System.out.println(movies.toString());
	   //movies.toString();
   }

}



