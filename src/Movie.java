import java.util.List;

public class Movie {
	private String title;
	private String category;
	private int dateOfRelease;
	private List<String> actors;
	private List<String> directors;
	private String description;
	private int stock;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Movie() {
		this.title = null;
		this.category = null;
		this.dateOfRelease= 0;
		this.actors=null;
		this.directors=null;
		this.description = null;
		this.stock=0;
	}
	

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(int dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void addStock() {
		this.stock++;
	}
	
	public void removeStock() {
		this.stock--;
	}
	
	public boolean inStock() {
		return (this.stock>0);
	}
	
	public String toString() {
		String out = "";
		out = this.getTitle() + "," + this.getCategory() + "," + this.getDateOfRelease() 
							 + "," + this.getActors() + "," + this.getDescription() + "," 
							 + this.getStock();
		return out;
	}
	
	public String[] toArr() {
		
		String[] out =  new String[] {this.title,this.getCategory(),String.valueOf(this.dateOfRelease),this.actors.toString(),this.getDescription(),String.valueOf(this.getStock())};
		
		
		return out;
		
	}
	
	public String actStr() {
		String out = "";
		
		for (int i = 0; i<this.getActors().size();i++) {
			if(i==0)
				out += this.getActors().get(i);
			else
				out+= "," + this.getActors().get(i);
			}
		return out;
	}
	
	public String dirStr() {
		String out = "";
		
		for (int i = 0; i<this.getDirectors().size();i++) {
			if(i==0)
				out += this.getDirectors().get(i);
			else
				out+= "," + this.getDirectors().get(i);
			}
		return out;
	}

}
