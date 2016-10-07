package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/category/{param}")
public class DELETECategoryByID {
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putlisting(@PathParam("param") int cid){
		if(cid == 0){
			return Response.status(404).entity("Entered ID not present").build();
		}
		else{
			DeleteCategory dc = new DeleteCategory(cid);
			dc.delete();
			return Response.status(200).entity
					(String.valueOf(cid)+" Successfully Deleted").build();
		}
	}
}
