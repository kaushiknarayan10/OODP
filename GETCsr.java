package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("/sad/csr")
public class GETCsr {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Map<String,ArrayList<String>> getcsr(@QueryParam("q") String search){
		SAD sad = new SAD();
		Collection<Category> catlist = new HashSet<Category>();
		Collection<Listings> list = new HashSet<Listings>();
		Collection<Advertiser> adlist = new HashSet<Advertiser>();
		ArrayList<String> newcat = new ArrayList<String>();
		ArrayList<String> newlist = new ArrayList<String>();
		ArrayList<String> newad = new ArrayList<String>();
		ArrayList<String> address = new ArrayList<String>();
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		catlist = sad.getCategory();
		list = sad.getListings();
		adlist = sad.getAdvertiser();
		if(search.isEmpty()){
			for(Advertiser a : adlist){
				newad.add("Name : "+a.getName());
				newad.add("Email : "+a.getEmail());
				newad.add("Phone : "+a.getPhone());
				newad.add("Address : ");
				address.add("Street : "+a.getAddress().getStreet());
				address.add("City : "+a.getAddress().getCity());
				address.add("State : "+a.getAddress().getState());
				address.add("Zip : "+a.getAddress().getZip());
				newad.add(address.toString());
				newad.add("Twitter : "+a.getTwitter());
				newad.add("Facebook : "+a.getFacebook());
				newad.add("Advertiser ID : "+String.valueOf(a.getAdvertiserid()));
			}
			for(Listings l : list){
				newlist.add("Description : "+l.getDescription());
				newlist.add("Link : "+l.getLink());
				newlist.add("Image : "+l.getImage());
				newlist.add("Price : "+String.valueOf(l.getPrice()));
				newlist.add("Start Date : "+l.startDate);
				newlist.add("End Date : "+l.getEndDate());
				newlist.add("Listing Type : "+l.getListingType());
				newlist.add("Category : "+l.getCategory());
				newlist.add("ID : "+l.getListingID());
			}
			for(Category c : catlist){
				newcat.add(c.getCategoryName());
				newcat.add(String.valueOf(c.getCategoryID()));
			}
			result.put("Advertisers", newad);
			result.put("Listings", newlist);
			result.put("Categories", newcat);
		}
		else{
			for(Advertiser a : adlist){
				if(a.name.equalsIgnoreCase(search)||a.email.equalsIgnoreCase(search) || 
						a.phone.equalsIgnoreCase(search) || a.address.city.equalsIgnoreCase(search)
						|| a.address.street.equalsIgnoreCase(search) || a.address.state.equalsIgnoreCase(search)
						|| a.address.zip.equalsIgnoreCase(search) ||  a.twitter.equalsIgnoreCase(search) || 
						a.facebook.equalsIgnoreCase(search)){
					newad.add("Name : "+a.getName());
					newad.add("Email : "+a.getEmail());
					newad.add("Phone : "+a.getPhone());
					newad.add("Address : ");
					address.add("Street : "+a.getAddress().getStreet());
					address.add("City : "+a.getAddress().getCity());
					address.add("State : "+a.getAddress().getState());
					address.add("Zip : "+a.getAddress().getZip());
					newad.add(address.toString());
					newad.add("Twitter : "+a.getTwitter());
					newad.add("Facebook : "+a.getFacebook());
					newad.add("Advertiser ID : "+String.valueOf(a.getAdvertiserid()));
				}
	
			}
			for(Listings l : list){
				if(l.description.equalsIgnoreCase(search) || l.link.equalsIgnoreCase(search) || 
						l.image.equalsIgnoreCase(search) || l.startDate.equalsIgnoreCase(search) || 
						l.endDate.equalsIgnoreCase(search) || l.listingType.equalsIgnoreCase(search) || 
						l.category.equalsIgnoreCase(search)){
					newlist.add("Description : "+l.getDescription());
					newlist.add("Link : "+l.getLink());
					newlist.add("Image : "+l.getImage());
					newlist.add("Price : "+String.valueOf(l.getPrice()));
					newlist.add("Start Date : "+l.startDate);
					newlist.add("End Date : "+l.getEndDate());
					newlist.add("Listing Type : "+l.getListingType());
					newlist.add("Category : "+l.getCategory());
					newlist.add("ID : "+l.getListingID());
				}
			}
			for(Category c : catlist){
				if(c.categoryName.equalsIgnoreCase(search) || 
						c.parentCategory.equalsIgnoreCase(search)){
					newcat.add(c.getCategoryName());
					newcat.add(String.valueOf(c.getCategoryID()));
				}
			}
			result.put("Advertisers Matched", newad);
			result.put("Listings Matched", newlist);
			result.put("Categories Matched", newcat);
		}
		return result;
	}
}