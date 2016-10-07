package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
@Path("/sad/{param : .*}")
public class GETCategory {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> getcategory(@PathParam("param") List<PathSegment> path){
		SAD sad = new SAD();
		Collection<Category> catlist = new HashSet<Category>();
		Collection<Listings> list = new HashSet<Listings>();
		catlist = sad.getCategory();
		list = sad.getListings();
		ArrayList<String> newcat = new ArrayList<String>();
		ArrayList<String> newlist = new ArrayList<String>();
		ArrayList<String> regularlist = new ArrayList<String>();
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		ArrayList<String> cat = new ArrayList<String>();
		ArrayList<String> listcat = new ArrayList<String>();
		String cat1;
		String cat2;
		for(PathSegment s : path){
			cat.add(s.getPath());
		}
		if(cat.size()==1){
			for(Category c : catlist){
				if(c.getParentCategory().equalsIgnoreCase(cat.get(cat.size()-1))){
					newcat.add(c.getCategoryName());
				}
			}
			for(Listings l : list){
				if(l.getCategory().equalsIgnoreCase(cat.get(cat.size()-1))){
					if(l.getListingType().equalsIgnoreCase("Category")){
						newlist.add("Description : "+l.getDescription());
						newlist.add("Image : "+l.getImage());
						newlist.add("Link : "+l.getLink());
						newlist.add("Price : "+String.valueOf(l.getPrice()));
						newlist.add("Start Date : "+l.getStartDate());
						newlist.add("End Date : "+l.getEndDate());
						newlist.add("Category : "+l.getCategory());
					}
				}
			}
			result.put("Categories", newcat);
			result.put("Listings", newlist);
		}
		else{
			cat1 = cat.get(cat.size()-1);
			cat2 = cat.get(cat.size()-2);
			for(Category c : catlist){
				if(c.getParentCategory().equalsIgnoreCase(cat1)){
					newcat.add(c.getCategoryName());
				}
			}
			for(Listings l : list){
				if(l.getCategory().equalsIgnoreCase(cat2)){
					if(l.getListingType().equalsIgnoreCase("Category")){
						newlist.add("Description : "+l.getDescription());
						newlist.add("Image : "+l.getImage());
						newlist.add("Link : "+l.getLink());
						newlist.add("Price : "+String.valueOf(l.getPrice()));
						newlist.add("Start Date : "+l.getStartDate());
						newlist.add("End Date : "+l.getEndDate());
						newlist.add("Category : "+l.getCategory());
					}
					if(l.getListingType().equalsIgnoreCase("Regular")){
						regularlist.add("Description : "+l.getDescription());
						regularlist.add("Image : "+l.getImage());
						regularlist.add("Link : "+l.getLink());
						regularlist.add("Price : "+String.valueOf(l.getPrice()));
						regularlist.add("Start Date : "+l.getStartDate());
						regularlist.add("End Date : "+l.getEndDate());
						regularlist.add("Category : "+l.getCategory());
					}
				}
				else if(l.getCategory().equalsIgnoreCase(cat1)){
					listcat.add("Description : "+l.getDescription());
					listcat.add("Image : "+l.getImage());
					listcat.add("Link : "+l.getLink());
					listcat.add("Price : "+String.valueOf(l.getPrice()));
					listcat.add("Start Date : "+l.getStartDate());
					listcat.add("End Date : "+l.getEndDate());
					listcat.add("Category : "+l.getCategory());
				}
			}
		result.put("Categories", newcat);
		result.put("Category-Featured of "+cat.get(cat.size()-2), newlist);
		result.put("Category-Featured of "+cat.get(cat.size()-1), listcat);
		result.put("Regular Listings of "+cat.get(cat.size()-2), regularlist);
		}
		return result;
	}
}
