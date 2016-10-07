package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/sad/admin/advertiser")
public class GETAdvertiser {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> getadvertisers(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		ArrayList<String> advertisers = new ArrayList<String>();
		ArrayList<String> add = new ArrayList<String>();
		Map<String,ArrayList<String>> result = new HashMap<String,ArrayList<String>>();
		for(Advertiser a : adlist){
			advertisers.add("Name : "+a.getName());
			advertisers.add("Email : "+a.getEmail());
			advertisers.add("Phone : "+a.getPhone());
			advertisers.add("Address : ");
			Address address = a.getAddress();
			add.add("Street : "+address.getStreet());
			add.add("City : "+address.getCity());
			add.add("State : "+address.getState());
			add.add("Zip : "+address.getZip());
			advertisers.add(add.toString());
			advertisers.add("Twitter : "+a.getTwitter());
			advertisers.add("Facebook : "+a.getFacebook());
			advertisers.add("Advertiser ID : "+String.valueOf(a.getAdvertiserid()));
		}
		result.put("Advertisers ", advertisers);
		return result;
	}
}