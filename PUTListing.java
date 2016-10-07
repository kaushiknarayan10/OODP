package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/listing/{param}")
public class PUTListing {
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putlisting(@PathParam("param") int lid, Listings l){
		if(lid == 0){
			return Response.status(404).entity("Entered ID not present").build();
		}
		else if(l.getDescription().isEmpty() || l.getLink().isEmpty() || 
				l.getListingType().isEmpty() || l.getCategory().isEmpty() ||
				l.getStartDate().isEmpty() || l.getEndDate().isEmpty()){
			return Response.status(204).entity("Required Content not present").build();
		}
		else{
			ModifyListing ml = new ModifyListing(lid,l);
			ml.modify();
			return  Response.status(200).entity(String.valueOf(lid)+" Successfully Updated").build();
		}
	}
}