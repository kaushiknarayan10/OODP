package restapi;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sad/admin/advertiser")
public class POSTAdvertiser {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addadvertiser(Advertiser ad){
		String name = ad.getName();
		String email = ad.getEmail();
		String phone = ad.getPhone();
		Address add = ad.getAddress();
		String twitter = ad.getTwitter();
		String fb = ad.getFacebook();
		if(twitter.isEmpty()){
			twitter = "None";
		}
		if(fb.isEmpty()){
			fb = "None";
		}
		Advertiser a = new Advertiser(name, email, phone,add, fb, twitter);
		AddAdvertiserRequest req = new AddAdvertiser(a);
		req.addAccount();
		return Response.status(200).entity(a.getAdvertiserId()).build();	
	}
}