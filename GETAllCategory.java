package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/sad/admin/category")
public class GETAllCategory {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> getcategorybyid(){
		SAD sad = new SAD();
		Collection<Category> catlist = sad.getCategory();
		ArrayList<String> categories = new ArrayList<String>();
		Map<String,ArrayList<String>> result = 
				new HashMap<String,ArrayList<String>>();
		for(Category c : catlist){
				categories.add("Category :"+c.getCategoryName());
				categories.add("Parent Category : "+c.getParentCategory());
				categories.add("Category ID : "+String.valueOf(c.getCategoryID()));
		}
		result.put("Categories", categories);
		return result;
	}
}
