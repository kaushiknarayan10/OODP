package restapi;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
public class DeleteListing extends Listings implements Serializable {
	private static final long serialVersionUID = -830796214486459241L;
	int listid;
	saveRestoreState srs = new saveRestoreState();
	public DeleteListing(int l){
		this.listid = l;
	}
	public void delete(){
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		Iterator<Listings> lite = list.iterator();
		while(lite.hasNext()){
			Listings l1 = lite.next();
			int lid = l1.getListingID();
			if(lid == this.listid){
				lite.remove();
			}
		}
		try {
			srs.savelisting(sad);
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
}