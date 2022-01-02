import java.util.List;

public class Admin extends User{
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	public void updateMovie(String currTile, String newTitle, String newCat, int newDate, List<String> newActors, List<String> newDircts, String newDescp, int newStock) {
		
		Movie edit = Database.findMovie(currTile);
		Database.removeMovie(edit);
		if(newTitle.length()>0)
			edit.setTitle(newTitle);
		if(newCat.length()>0)
			edit.setCategory(newCat);
		if(newDate>0)
			edit.setDateOfRelease(newDate);
		if(!(newActors.size()==0))
			edit.setActors(newActors);
		if(!(newDircts.size()==0))
			edit.setDirectors(newDircts);
		if(newDescp.length()>0)
			edit.setDescription(newDescp);
		
			edit.setStock(newStock);
			
		
		Database.addMovie(edit);
		
	}
	
	public void updateCustomer( String currUN, String newUN, String newNM, String newPass, String newEmail, int newLP, Order newOrder) {
		
		Customer edit = Database.findCustomer(currUN);
		Database.removeCustomer(edit);
		if(newUN.length()>0)
			edit.setUserName(newUN);
		if(newNM.length()>0)
			edit.setName(newNM);
		if(newPass.length()>0)
			edit.setPassword(newPass);
		if(newEmail.length()>0)
			edit.setEmail(newEmail);
		edit.setLoyaltyPoints(newLP);
		edit.setOrder(newOrder);
		
		
		Database.addCustomer(edit);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
