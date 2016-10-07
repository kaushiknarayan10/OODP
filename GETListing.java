package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/sad/admin/listing")
public class GETListing {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> getadvertisers(){
		SAD sad = new SAD();
		Collection<Listings> list = sad.getListings();
		ArrayList<String> listings = new ArrayList<String>();
		Map<String,ArrayList<String>> result = 
				new HashMap<String,ArrayList<String>>();
		for(Listings l : list){
			listings.add("Description : "+l.getDescription());
			listings.add("Link : "+l.getLink());
			listings.add("Image : "+l.getImage());
			listings.add("Price : "+String.valueOf(l.getPrice()));
			listings.add("Start Date : "+l.startDate);
			listings.add("End Date : "+l.getEndDate());
			listings.add("Listing Type : "+l.getListingType());
			listings.add("Category : "+l.getCategory());
			listings.add("ID : "+l.getListingID());
		}
		result.put("Listings", listings);
		return result;
	}
}