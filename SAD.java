package restapi;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
public class SAD implements Serializable {	
	private static final long serialVersionUID = 2960151922390925981L;
	public Collection<Advertiser> adlist = new HashSet<Advertiser>();
	public Collection<Listings> listings = new HashSet<Listings>();
	public Collection<Category> categories = new HashSet<Category>();
	public SAD(){}
	@SuppressWarnings("unchecked")
	public SAD(Collection<?> ad){
		if(ad.toString().contains("Advertiser")){
			this.adlist = (Collection<Advertiser>) ad;
		}
		else if(ad.toString().contains("Listings")){
			this.listings = (Collection<Listings>) ad;
		}
		else if(ad.toString().contains("Category")){
			this.categories = (Collection<Category>) ad;
		}
	}
	public void AddAdvertiser(Advertiser a){
		saveRestoreState srs = new saveRestoreState();
		try {
			SAD sad = srs.restoreadvertiser();
			adlist = sad.adlist;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("First time...");
		}
		adlist.add(a);
	}
	public void AddListing(Listings l){
		saveRestoreState srs = new saveRestoreState();
		try {
			SAD sad = srs.restorelisting();
			listings = sad.listings;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("First time...");
		}	
		listings.add(l);
	}
	public void AddCategory(Category c){
		saveRestoreState srs = new saveRestoreState();
		try {
			SAD sad = srs.restorecategory();
			categories = sad.categories;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("First time...cat");
		}
		categories.add(c);
	}
	public Collection<Listings> getListings() {
		saveRestoreState srs = new saveRestoreState();
		try {
			SAD sad = srs.restorelisting();
			listings = sad.listings;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("First time...");
		}
		return listings;
	}
	public Collection<Advertiser> getAdvertiser() {
		saveRestoreState srs = new saveRestoreState();
		try {
			SAD sad = srs.restoreadvertiser();
			adlist = sad.adlist;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("First time...");
		}
		return adlist;
	}
	public Collection<Category> getCategory() {
		saveRestoreState srs = new saveRestoreState();
		try {
			SAD sad = srs.restorecategory();
			categories = sad.categories;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("First time...cat");
		}
		return categories;
	}
}