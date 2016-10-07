package restapi;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
public class HomePage implements Serializable {
	private static final long serialVersionUID = -591939370810851971L;
	Collection<Category> cat = new HashSet<Category>();
	Collection<Listings> list = new HashSet<Listings>();
	public HomePage(){}
	public HomePage(Collection<Category> c,Collection<Listings> l){
		this.cat = c;
		this.list = l;
	}
	public Collection<HomePage> getHomePage(){
		SAD sad = new SAD();
		Collection<HomePage> hp = new HashSet<HomePage>();
		Collection<Category> c1 = sad.getCategory();
		Collection<Listings> l1 = sad.getListings();
		for(Listings l : l1){
			if(l.getListingType().equalsIgnoreCase("HomePage")){
				this.list.add(l);
			}
		}
		for(Category c : c1){
			if(c.getParentCategory().equalsIgnoreCase("None")){
				this.cat.add(c);
			}
		}
		HomePage h = new HomePage(this.cat,this.list);
		hp.add(h);
		return hp;
	}
}
