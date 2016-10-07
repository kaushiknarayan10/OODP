package restapi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/sad/admin/advertiser/{param}")
public class GETAdvertiserByID {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,ArrayList<String>> getadvertiser(@PathParam("param") int id){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		ArrayList<String> advertisers = new ArrayList<String>();
		ArrayList<String> add = new ArrayList<String>();
		Map<String,ArrayList<String>> result = 
				new HashMap<String,ArrayList<String>>();
		if(id == 0){
			advertisers.add(String.valueOf(204));
			advertisers.add("ID is 0");
			result.put("Error", advertisers);
			return result;
		}
		else{
			for(Advertiser a : adlist){
				if(a.getAdvertiserid()  == id){
					advertisers.add("Name : "+a.getName());
					advertisers.add("Email : "+a.getEmail());
					advertisers.add("Phone : "+a.getPhone());
					advertisers.add("Address:");
					add.add("Street : "+a.getAddress().getStreet());
					add.add("City : "+a.getAddress().getCity());
					add.add("State : "+a.getAddress().getState());
					add.add("Zip : "+a.getAddress().getZip());
					advertisers.add(add.toString());
					advertisers.add("Twitter : "+a.getTwitter());
					advertisers.add("Facebook : "+a.getFacebook());
					advertisers.add("Advertiser ID : "+String.valueOf(a.getAdvertiserid()));
					result.put("Advertiser ", advertisers);
				}
			}
			return result;
		}
	}
}
