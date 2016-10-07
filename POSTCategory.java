package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
@Path("/sad/admin/category")
public class POSTCategory {
	@Context UriInfo uri;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addcat(Category c){
		String catname = c.getCategoryName();
		String subcat = c.getParentCategory();
		if(c.getParentCategory().isEmpty()){
			 subcat = "None";
		}
		Category category = new Category(catname,subcat);
		AddCategory ac = new AddCategory(category);
		ac.addCategory();
		String url = uri.getBaseUri().toString();
		if(subcat.equalsIgnoreCase("none")){
			url = url+"sad/"+catname.toLowerCase();
		}
		else{
			url = url+"sad/"+catname+"/"+subcat.toLowerCase();
		}
		return Response.status(200).entity(url).build();	
	}
}
