package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/advertiser/{param}")
public class PUTAdvertiser {
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putadvertiser(@PathParam("param") int aid, Advertiser a){
		if(aid == 0){
			return Response.status(404).entity("Entered ID not present").build();
		}
		else if(a.getName().isEmpty() || a.getAddress().getCity().isEmpty() || 
				a.getAddress().getStreet().isEmpty() || a.getEmail().isEmpty()){
			return Response.status(204).entity("Required Content not present").build();
		}
		else{
			ModifyAdvertiser ma = new ModifyAdvertiser(aid,a);
			ma.modify();
			return Response.status(200).entity
					(String.valueOf(aid)+" Successfully Updated").build();
		}
	}
}