package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/advertiser/{param}")
public class DELETEAdvertiserByID {
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletead(@PathParam("param") int aid){
		if(aid == 0){
			return Response.status(404).entity("Entered ID not present").build();
		}
		else{
			DeleteAdvertiser da = new DeleteAdvertiser(aid);
			da.delete();
			return  Response.status(200).entity
					(String.valueOf(aid)+" Successfully Deleted").build();
		}
	}
}
