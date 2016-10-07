package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
@Path("/sad/admin/listing")
public class POSTListing {
	@Context UriInfo uri;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addlisting(Listings l){
		Listings list1 = new Listings(l.getDescription(),l.getImage(),l.getLink(),
				l.getPrice(),l.getStartDate(), l.getEndDate(),l.getListingType(),
				l.category);
		AddListingRequest req = new AddListing(list1);
		req.addListing();
		String url = uri.getAbsolutePath().toString()+"/"+l.getListingID();
		return Response.status(200).entity(url).build();
	}
}