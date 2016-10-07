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
@Path("/sad/admin/category/{param}")
public class GETCategoryByID {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> getcategorybyid(@PathParam("param") String catname){
		SAD sad = new SAD();
		Collection<Category> catlist = sad.getCategory();
		ArrayList<String> categories = new ArrayList<String>();
		Map<String,ArrayList<String>> result = 
				new HashMap<String,ArrayList<String>>();
		if(catname.isEmpty()){
			categories.add(String.valueOf(404));
			categories.add("CID Not entered");
			result.put("Error", categories);
			return result;
		}
		for(Category c : catlist){
			if(c.getCategoryName().equalsIgnoreCase(catname)){
				categories.add("Category Name: "+c.getCategoryName());
				categories.add("Parent Category : "+c.getParentCategory());
				categories.add("Category ID : "+String.valueOf(c.getCategoryID()));
			}
		}
		result.put("Category", categories);
		return result;
	}
}