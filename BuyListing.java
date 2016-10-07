package restapi;
import java.io.Serializable;
import java.util.Collection;

public class BuyListing extends Listings implements Serializable {

	private static final long serialVersionUID = -5553032615058555838L;
	String advertiserid, description;
	public BuyListing(String aid, String desc){
		this.advertiserid = aid;
		this.description = desc;
	}
	public void buy(){
		SAD sad = new SAD();
		Collection<Listings> list = sad.getListings();
		for(Listings l : list){
			while(l.description.equalsIgnoreCase(this.description)){
				l.advertiserId = this.advertiserid;
			}
		}
	}
}

