package restapi;
public abstract class AddListingRequest {
	String description, startDate, endDate,link,image,listingType,category;
	int price;
	public AddListingRequest(String desc, String lnk, String img, int price,
			String sdate, String edate, String type, String category){
			this.description = desc;
			this.link = lnk;
			this.image = img;
			this.price = price;
			this.startDate = sdate;
			this.endDate = edate;
			this.listingType = type;
			this.category = category;
		}
	public AddListingRequest(Listings list){
		this.description = list.getDescription();
		this.link = list.getLink();
		this.image = list.getImage();
		this.price = list.getPrice();
		this.startDate = list.getStartDate();
		this.endDate = list.getEndDate();
		this.listingType = list.getListingType();
		this.category = list.getCategory();
	}
	public abstract void addListing();
}
