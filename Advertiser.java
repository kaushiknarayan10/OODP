package restapi;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
public class Advertiser implements Serializable {	
	private static final long serialVersionUID = 3783914981222262580L;
	public String name, email, phone, twitter, facebook;
    public Address address;
    public int advertiserId;
    public LocalDate creationDate;
    public Advertiser() {
    	this.name = "Jane Doe";
    	this.email = "jane.doe@example.com";
    	this.phone = "1234567890";
    	this.address = new Address();
    	this.advertiserId = new Random().nextInt(1000);
    	this.creationDate = LocalDate.now();
    }
	public Advertiser (String name, String email, String phone, Address add, String fb, String tw) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", "");
    	this.address = add;
    	this.twitter = tw;
    	this.facebook = fb;
    	this.advertiserId = new Random().nextInt(1000);
    	this.creationDate = LocalDate.now();
    }
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getTwitter() {
		return twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public Address getAddress() {
		return address;
	}
	public int getAdvertiserid() {
		return this.advertiserId;
	}
	public LocalDate getCreationDate() {
		return this.creationDate;
	}
	public int getAdvertiserId() {
		return advertiserId;
	}
}
