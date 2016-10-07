package restapi;
import java.io.IOException;
import java.io.Serializable;
public class AddListing extends AddListingRequest implements Serializable{
	private static final long serialVersionUID = -6315078973356033858L;
	private Listings listing;
	saveRestoreState srs = new saveRestoreState();
	public AddListing(String description, String link, String image, int price,
			String startDate, String endDate, String listingType, String category) {
		super(description, link, image, price, startDate, endDate, listingType, category);
	}
	public AddListing(Listings l){
		super(l);
	}
	@Override
	public void addListing() {
		listing = new Listings(this.description, this.link, this.image, this.price,
				this.startDate, this.endDate, this.listingType, this.category);
		SAD sad = new SAD();
		sad.AddListing(listing);
		try {
			srs.savelisting(sad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}