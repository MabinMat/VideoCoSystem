import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProjectTester {
	
	
	@Before
	public void setup() throws IOException{
		Database.load();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		@Test
		public void test_req6_paymentService() {
		Customer c = Database.findCustomer("DanTheMan");
		boolean actual = c.payUsingService();
		boolean expected = true;
		Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_req6_paymentService_LoyaltyPoints() {
			Customer c = Database.findCustomer("DanTheMan");
			boolean actual = c.payUsingLoyalty();
			boolean expected = false;
			Assert.assertEquals(expected,actual);
		}
		
		public void test_req7_addLoyaltyPoints() {
			Customer c = Database.findCustomer("DanTheMan");
			Movie m = Database.findMovie("Iron Man");
			int initial =c.getLoyaltyPoints();
			c.addToOrderList(m);
			int actual =c.getLoyaltyPoints();
			int expected = initial+1;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_req8_LateFee_outsideOntario() {
			Customer c = Database.findCustomer("MuscleMan");
			boolean actual=Database.isLate(c);
			boolean expected=true;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_req8_LateFee_insideOntario() {
			Customer c = Database.findCustomer("daBoi45");
			boolean actual=Database.isLate(c);
			boolean expected=false;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_req9_stock_palcedOrder() {
			Customer c = Database.findCustomer("daBoi45");
			Movie m = Database.findMovie("Tenet");
			int before = m.getStock();
			c.addToOrderList(m);
			int after = m.getStock();
			
			boolean actual=(after<before);
			boolean expected=true;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_req9_stock_cancelledOrder() {
			Customer c = Database.findCustomer("daBoi45");
			Movie m = Database.findMovie("Iron Man");
			int before = m.getStock();
			c.removeFromOrderList(m);
			int after = m.getStock();
			
			boolean actual=(after>before);
			boolean expected=true;
			Assert.assertEquals(expected,actual);		
		}
		
		@Test
		public void test_req20_correctAdminRegisteration() {
			
			Admin a = new Admin();
			a.setEmail("test@test.com");
			a.setName("Mabin Mathew");
			a.setPassword("test");
			a.setUserName("Mabs");
			boolean actual = Database.checkAdmin(a);
			boolean expected = true;
			Assert.assertEquals(expected,actual);	
		}
		
		@Test
		public void test_req20_incorrectAdminRegisteration() {
			Admin a = new Admin();
			a.setEmail("test@test.com");
			a.setName("Abraham Lincoln");
			a.setPassword("test");
			a.setUserName("Mabs");
			boolean actual = Database.checkAdmin(a);
			boolean expected = false;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_reg21_removeAdminFromSystem() {
			String username = "jb";
			boolean actual = Database.removeAdmin(username);
			boolean expected = true;
			Assert.assertEquals(expected,actual);
		}
		
		public void test_reg21_IncorrectRemoveAdminFromSystem() {
			String username = "AbLinc";
			boolean actual = Database.removeAdmin(username);
			boolean expected = false;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_reg22_updateOrderStatus() {
			String orderID = "VE14E3";
			String status = "Delivered";
			boolean actual = Database.updateOrderStat(orderID, status);
			boolean expected = true;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_reg22_IncorrectupdateOrderStatus() {
			String orderID = "RG69E2";
			String status = "Delivered";
			boolean actual = Database.updateOrderStat(orderID, status);
			boolean expected = false;
			Assert.assertEquals(expected,actual);
		}
		
	
		@Test
		public void test_reg24_lateFee() {
			String orderID = "VE11E1";
			int daysLate = 10;
			Order o = Database.findOrder(orderID);
			o.addLateFee(daysLate);
			int actual =(int) o.getLateFee();
			int expected = 12;
			Assert.assertEquals(expected,actual);
		}
		
		@Test
		public void test_reg25_listOfOrders() {
			Order o = new Order();
			o.setMovies(null);
			o.setPrice(5);
			o.setStatus("Shipped");
			
			Customer c = Database.findCustomer("WazuM");
			String warehouseLocation = c.getShipping_billingInfo();
			Warehouse w = Database.findwarehouse(warehouseLocation);
			int initialSize = w.getCurrOrders().size();
			Database.sendOrder(o, c);
			int actual = w.getCurrOrders().size();
			int expected = initialSize+1;
			
			Assert.assertEquals(expected,actual);
			//String warehouseLocation = c.getShipping_billingInfo();
			
			//Warehouse w = Database.findwarehouse(warehouseLocation);
			
			
			
		}
		
		
		
		
		
}
