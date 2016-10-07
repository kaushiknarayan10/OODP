package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/listing/{param}")
public class DELETEListingByID {
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletelist(@PathParam("param") int lid){
		if(lid == 0){
			return Response.status(404).entity("Entered ID not present").build();
		}
		else{
			DeleteListing dl = new DeleteListing(lid);
			dl.delete();
			return  Response.status(200).entity
					(String.valueOf(lid)+" Successfully Deleted").build();
		}
	}
}