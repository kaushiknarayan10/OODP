package restapi;

public abstract class AddAdvertiserRequest {
	public String name, email, phone, twitter, facebook;
	public Address add;
	public AddAdvertiserRequest(Advertiser a){
		this.name = a.getName();
		this.email = a.getEmail();
		this.phone = a.getPhone();
		this.twitter = a.getTwitter();
		this.facebook = a.getFacebook();
		this.add = a.getAddress();
	}
	public abstract void addAccount();
}