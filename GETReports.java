package restapi;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/sad/admin/reports")
public class GETReports {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> getadvertisers(){
		Map<String,String> result = new HashMap<String,String>();
		History h = new History();
		result.put("Advertisers made last month", String.valueOf(h.getAdvertiser1()));
		result.put("Advertisers in last 3 months", String.valueOf(h.getAdvertiser3()));
		result.put("Advertisers in last 6 months", String.valueOf(h.getAdvertiser6()));
		result.put("Advertisers in last 12 months", String.valueOf(h.getAdvertiser12()));
		result.put("Total number of Advertisers", String.valueOf(h.getTotalAdvertiser()));
		return result;
	}
}