package restapi;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
public class ModifyAdvertiser extends Advertiser implements Serializable {
	private static final long serialVersionUID = 8139117323393373242L;
	int advertiserid;
	Advertiser newad;
	saveRestoreState srs = new saveRestoreState();
	public ModifyAdvertiser(int aid, Advertiser n){
		this.advertiserid = aid;
		this.newad = n;
	}
	public void modify(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		for(Advertiser a : adlist){
			if(a.getAdvertiserid() == this.advertiserid){
				a.name = this.newad.getName();
				a.address = this.newad.getAddress();
				a.email = this.newad.getEmail();
				a.phone = this.newad.getPhone();
				a.facebook = this.newad.getPhone();
				a.twitter = this.newad.getTwitter();
				a.creationDate = a.getCreationDate();
				a.advertiserId = a.getAdvertiserid();
			}
		}
		try {
			srs.saveadvertiser(sad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}