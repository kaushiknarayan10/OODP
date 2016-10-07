package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/sad")
public class GETHomePage {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> gethomepage(){
		HomePage h = new HomePage();
		Collection<HomePage> hp = h.getHomePage();
		ArrayList<String> categories = new ArrayList<String>();
		ArrayList<String> listings = new ArrayList<String>();
		Map<String,ArrayList<String>> cat = new HashMap<String,ArrayList<String>>();
		for(HomePage h1 : hp){
			for(Category c : h1.cat){
				categories.add(c.getCategoryName());
			}
		}
		for(HomePage h1 : hp){
			for(Listings l : h1.list){
				listings.add("Description : "+l.getDescription());
				listings.add("Image : "+l.getImage());
				listings.add("Link : "+l.getLink());
				listings.add("Price : "+String.valueOf(l.getPrice()));
				listings.add("Start Date : "+l.getStartDate());
				listings.add("End Date : "+l.getEndDate());
				listings.add("Category : "+l.getCategory());
			}
		}
		cat.put("Categories", categories);
		cat.put("Listings", listings);
		return cat;
	}
}		