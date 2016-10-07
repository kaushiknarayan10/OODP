package restapi;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
public class Listings implements Serializable {
	private static final long serialVersionUID = 7281025817923737048L;
	String description, link, image,listingType,category,advertiserId,startDate,endDate;
	int price,listingid;
	public Listings(){
		this.description = "Finest Car dealers";
		this.link = "www.janedoe.com/Automotive";
		this.image = "image_path";
		this.price = 100;
		this.startDate = LocalDate.now().toString();
		this.endDate = LocalDate.now().plusDays(30).toString();
		this.listingType = "Regular";
		this.category = "Automotive";
		this.advertiserId = "None";
		this.listingid = new Random().nextInt(1000);
	}
	public Listings(String desc, String link, String image,
		int price, String sdate, String edate, String type, String category){
		this.description = desc;
		this.link = link;
		this.image = image;
		this.price = price;
		this.startDate = sdate;
		this.endDate = edate;
		this.listingType = type;
		this.category = category;
		this.advertiserId = "None";
		this.listingid = new Random().nextInt(1000);
	}
	public String getDescription() {
		return this.description;
	}
	public String getLink() {
		return this.link;
	}
	public String getImage() {
		return this.image;
	}
	public int getPrice() {
		return this.price;
	}
	public String getStartDate() {
		return this.startDate;
	}
	public String getEndDate() {
		return this.endDate;
	}
	public String getListingType() {
		return this.listingType;
	}
	public String getCategory() {
		return this.category;
	}
	public String getAdvertiserID() {
		return this.advertiserId;
	}
	public int getListingID() {
		return this.listingid;
	}
}
