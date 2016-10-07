package restapi;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class ListingTest {

	@Test
	public void AddListingTest(){
		Listings l1 = new Listings();
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		assertNotEquals(0,list.size());
	}
	
	@Test
	public void GetDescriptionTest(){
		Listings l1 = new Listings("Boston Sports Corp", "www.bsc.com","img_path",
				150, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"HomePage","Sports");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getLink().equalsIgnoreCase("www.bsc.com")){
				assertEquals("Boston Sports Corp",l.getDescription());
			}
		}
	}
	
	@Test
	public void GetLinkTest(){
		Listings l1 = new Listings("Illinois Inst of Tech", "www.iit.edu","img_path",
				150, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"HomePage","Education");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getDescription().equalsIgnoreCase("Illinois Inst of Tech")){
				assertEquals("www.iit.edu",l.getLink());
			}
		}
	}
	
	@Test
	public void GetImageTest(){
		Listings l1 = new Listings("Aston Martin used cars", "www.aston.com","img_path",
				150, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"HomePage","Automotive");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getDescription().equalsIgnoreCase("Aston Martin used cars")){
				assertEquals("img_path",l.getImage());
			}
		}
	}
	@Test
	public void GetPriceTest(){
		Listings l1 = new Listings("Books and CDs", "www.bcd.com","img_path",
				100, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"Category","General");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getDescription().equalsIgnoreCase("Books and CDs")){
				assertNotEquals(99999,l.getPrice());
			}
		}
	}
	
	@Test
	public void GetDatesTest(){
		Listings l1 = new Listings("Books and CDs", "www.bcd.com","img_path",
				100, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"Category","General");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getDescription().equalsIgnoreCase("Books and CDs")){
				assertEquals(LocalDate.now().toString(),l.getStartDate());
			}
			if(l.getDescription().equalsIgnoreCase("Books and CDs")){
				assertNotEquals(LocalDate.now().toString(),l.getEndDate());
			}
		}
	}
	
	@Test
	public void GetCategoryTest(){
		Listings l1 = new Listings("Clothing for men", "www.levis.com","img_path",
				100, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"Regular","Apparel");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getDescription().equalsIgnoreCase("Clothing for men")){
				assertEquals("Apparel",l.getCategory());
			}
		}
	}
	
	@Test
	public void GetListingTypeTest(){
		Listings l1 = new Listings("Laptops and iPhones", "www.apple.com","img_path",
				600, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"HomePage","Electronics");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getDescription().equalsIgnoreCase("Laptops and iPhones")){
				assertNotEquals("Regular",l.getListingType());
			}
		}
	}
	
	@Test
	public void ModifyListingTest(){
		Listings l1 = new Listings("Rental movies", "www.movies.com","img_path",
				400, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"HomePage","Sports");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		Listings l2 = new Listings("Rental movies", "www.movies.com","img_path",
				400, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"HomePage","Movies");
		ModifyListing ml = new ModifyListing(l1.getListingID(),l2);
		ml.modify();
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		for(Listings l : list){
			if(l.getDescription().equalsIgnoreCase("Rental movies")){
				assertNotSame("Sports",l.getCategory());
			}
		}
	}
	
	@Test
	public void DeleteListingTest(){
		SAD sad = new SAD();
		Collection<Listings> list = new HashSet<Listings>();
		list = sad.getListings();
		Listings l1 = new Listings("Data to be deleted", "www.delete.com","img_path",
				400, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"Category","Sports");
		AddListingRequest req = new AddListing(l1);
		req.addListing();
		DeleteListing dl = new DeleteListing(l1.getListingID());
		dl.delete();
		for(Listings l : list){
			if(!l.getDescription().equalsIgnoreCase("Data to be deleted")){
				assertTrue("Deleted",true);
			}
		}
	}

}
