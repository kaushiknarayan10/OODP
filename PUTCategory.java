package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/category/{param}")
public class PUTCategory {
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putlisting(@PathParam("param") int cid, Category c){
		if(cid == 0){
			return Response.status(404).entity("Entered ID not present").build();
		}
		else if(c.getCategoryName().isEmpty()){
			return  Response.status(204).entity("Required Content not present").build();
		}
		else{
			String catname = c.getCategoryName();
			String parent = c.getParentCategory();
			if(parent.isEmpty()){
				parent = "None";
			}
			Category cat = new Category(catname,parent);
			ModifyCategory mc = new ModifyCategory(cid,cat);
			mc.modify();
			return  Response.status(200).entity(String.valueOf(cid)+" Successfully Updated").build();
		}
	}
}
