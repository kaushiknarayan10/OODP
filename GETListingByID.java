package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/listing/{param}")
public class GETListingByID {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> getlistingbyid(@PathParam("param") int id){
		SAD sad = new SAD();
		Collection<Listings> list = sad.getListings();
		ArrayList<String> listings = new ArrayList<String>();
		Map<String,ArrayList<String>> result = 
				new HashMap<String,ArrayList<String>>();
		if(id==0){
			Response r = Response.status(404).entity("ID not found").build();
			listings.add(r.toString());
			result.put("Error", listings);
			return result;
		}
		for(Listings l : list){
			if(l.getListingID() == id){
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
		}
		result.put("Listings", listings);
		return result;
	}
}
