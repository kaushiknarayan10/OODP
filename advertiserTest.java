package restapi;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import org.junit.Test;
public class AdvertiserTest {

	@Test
	public void testAddAccount() {
		Advertiser ad1 = new Advertiser("Lionel Messi", "www.wayne@manutd.com", "778990765", 
				new Address("224 W Street","Buenos Aires", "LA","77661"),
				"www.facebook.com/messi" ,"@messi");
		AddAdvertiserRequest req3 = new AddAdvertiser(ad1);
		req3.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			assertNotSame(8,testlist.size());
		}
	}
	
	@Test
	public void nameCheckTest(){
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		Advertiser ad = new Advertiser("Kaushik", "www.kbc.com", "3123341234", new Address(),
				 "www.facebook.com/kbc","@kbc" );
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getEmail().equalsIgnoreCase("www.kbc.com")){
				assertEquals("Kaushik",a.getName());
			}
		}
	}
	
	@Test
	public void EmailTest(){
		Advertiser ad = new Advertiser("testdata1", "google", "3123341234", new Address(),
				 "www.facebook.com/kbc","@kbc" );
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getName().equalsIgnoreCase("testdata1")){
				assertEquals("google",a.getEmail());
			}
		}
		
		
	}

	
	@Test
	public void AddressTest(){
		Address add = new Address("255 W 31st street", "Chicago", "IL", "60626");
		Advertiser ad = new Advertiser("Max Payne", "www.maxpayne.com", "2623098876", add,
				 "www.facebook.com/max","@mp" );
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getName().equalsIgnoreCase("Max Payne")){
				assertEquals("Chicago",a.getAddress().getCity());
				assertEquals("255 W 31st street",a.getAddress().getStreet());
				assertNotSame("MN",a.getAddress().getState());
				assertNotSame("12345",a.getAddress().getZip());
			}
		}
		
	}
	@Test
	public void PhoneTest(){
		Advertiser ad = new Advertiser("Tom Cruise", "www.tomcruise@data.com", "99988374", 
				new Address(),"www.facebook.com/tom","@tc" );
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getName().equalsIgnoreCase("Tom Cruise")){
				assertEquals("99988374",a.getPhone());
			}
		}
	}
	@Test
	public void FacebookTest(){
		Advertiser ad = new Advertiser("Arnold", "www.arnold@body.com", "10927462", 
				new Address(), "www.facebook.com/arnold","@aschwarz" );
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getName().equalsIgnoreCase("Arnold")){
				assertNotEquals("www.facebook.com",a.getFacebook());
			}
		}
	}
	
	@Test
	public void TwitterTest(){
		Advertiser ad = new Advertiser("Barrack Obama", "www.obama@whitehouse.com", "9980989898", 
				new Address(), "www.facebook.com/obama" ,"@whitehouse");
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getName().equalsIgnoreCase("Barrack Obama")){
				assertEquals("@whitehouse",a.getTwitter());
			}
		}
	}
	
	@Test
	public void ModifyAdvertiserTest(){
		Advertiser ad = new Advertiser("Wayne Rooney", "www.wayne@manutd.com", "1011018899", 
				new Address(), "www.facebook.com/wazza" ,"@rooney");
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		Advertiser ad1 = new Advertiser("Lionel Messi", "www.wayne@manutd.com", "778990765", 
				new Address("224 W Street","Buenos Aires", "LA","77661"),
				"www.facebook.com/messi" ,"@messi");
		ModifyAdvertiser ma = new ModifyAdvertiser(ad.getAdvertiserid(),ad1);
		ma.modify();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getEmail().equalsIgnoreCase("www.wayne@manutd.com")){
				assertNotSame("Lionel Messi",a.getName());
			}
		}
	}
	
	@Test
	public void DeleteAdvertiserTest(){
		Advertiser ad = new Advertiser("Castro", "www.castro@cuba.com", "77382349732", 
				new Address(), "www.facebook.com/castro" ,"@castro");
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		DeleteAdvertiser da = new DeleteAdvertiser(ad.getAdvertiserid());
		da.delete();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(!a.getName().equalsIgnoreCase("Castro")){
				assertTrue("Deleted",true);
			}
		}
	}
	
	@Test
	public void GetAdvertiserIDTest(){
		Advertiser ad = new Advertiser("Clinton", "www.clinton@whitehouse.com", "9993238097", 
				new Address(), "www.facebook.com/clint" ,"@clint");
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getName().equalsIgnoreCase("Clinton")){
				assertNotEquals("Clinton9993238097",a.getAdvertiserid());
			}
		}
	}
	
	@Test
	public void GetCreationDateTest(){
		Advertiser ad = new Advertiser("Ross", "www.ross@friends.com", "80081358876", 
				new Address(), "www.facebook.com/ross" ,"@ross");
		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
		req2.addAccount();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
		testlist = sad.getAdvertiser();
		for(Advertiser a : testlist){
			if(a.getName().equalsIgnoreCase("Ross")){
				assertEquals(LocalDate.now(),a.getCreationDate());
			}
		}
	}

}

