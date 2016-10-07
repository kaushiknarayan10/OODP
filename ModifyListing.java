package restapi;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
public class ModifyListing extends Listings implements Serializable{
	private static final long serialVersionUID = -5470204450080325170L;
	Listings list;
	int olddata;
	saveRestoreState srs = new saveRestoreState();
	public ModifyListing(int o, Listings l){
		this.list = l;
		this.olddata = o;
	}
	public void modify(){
		SAD sad = new SAD();
		Collection<Listings> listing = sad.getListings();
		for(Listings l : listing){
			if(l.listingid == this.olddata){
				l.description = this.list.getDescription();
				l.link = this.list.getLink();
				l.image = this.list.getImage();
				l.price = this.list.getPrice();
				l.startDate = this.list.getStartDate();
				l.endDate = this.list.getEndDate();
				l.listingType = this.list.getListingType();
				l.category = this.list.getCategory();
				l.advertiserId = this.list.getAdvertiserID();
			}
		}
		try {
			srs.savelisting(sad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}