package restapi;
import java.io.IOException;
import java.io.Serializable;
public class AddAdvertiser extends AddAdvertiserRequest implements Serializable {
	private static final long serialVersionUID = 5656393748415449172L;
	public Address address;
	public Advertiser advertiser;
	public AddAdvertiser(Advertiser ad){
		super(ad);
	}
	@Override
	public void addAccount() {
		address = new Address(this.add.getStreet(), this.add.getCity(), this.add.getState(), this.add.getZip());
		advertiser = new Advertiser (this.name, this.email, this.phone, address,this.facebook, this.twitter);
		SAD sad = new SAD();
		saveRestoreState srs = new saveRestoreState();
		sad.AddAdvertiser(advertiser);
		try {
			srs.saveadvertiser(sad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}