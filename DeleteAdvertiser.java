package restapi;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
public class DeleteAdvertiser extends Advertiser implements Serializable{	
	private static final long serialVersionUID = 4696956250742700663L;
	int id;
	saveRestoreState srs = new saveRestoreState();
	public DeleteAdvertiser(int aid){
		this.id = aid;
	}
	public void delete(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = new HashSet<Advertiser>();
		adlist = sad.getAdvertiser();
		Iterator<Advertiser> lite = adlist.iterator();
		while(lite.hasNext()){
			Advertiser a = lite.next();
			int adid = a.getAdvertiserId();
			if(adid==this.id){
				lite.remove();
			}
		}
		try {
			srs.saveadvertiser(sad);
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
}