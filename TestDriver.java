package restapi;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
public class TestDriver {
//	public void testproperty(){
//		Properties prop = new Properties();
//		try {
//			String propfile = "config.properties";
//			prop.load(getClass().getClassLoader().getResourceAsStream(propfile));
//		}  catch (IOException e) {
//	        e.printStackTrace();
//		}
//		String advertisers = prop.getProperty("advertisers");
//		System.out.println(advertisers);
//	}
	public static void main(String args[]){
//		Category c1 = new Category("Sports","None");
//		AddCategory ac1 = new AddCategory(c1);
//		ac1.addCategory();
//		Category c2 = new Category("Automotive","None");
//		AddCategory ac2 = new AddCategory(c2);
//		ac2.addCategory();
//		Category c3 = new Category("Groceries","None");
//		AddCategory ac3 = new AddCategory(c3);
//		ac3.addCategory();
//		Category c4 = new Category("Field","Sports");
//		AddCategory ac4 = new AddCategory(c4);
//		ac4.addCategory();
//		Category c5 = new Category("Air","Sports");
//		AddCategory ac5 = new AddCategory(c5);
//		ac5.addCategory();
//		Category c6 = new Category("Cars","Automotive");
//		AddCategory ac6 = new AddCategory(c6);
//		ac6.addCategory();
//		Listings l1 = new Listings("Boston Sports Corp", "www.bsc.com","img_path",
//		150, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"HomePage","Sports");
//		AddListingRequest lr1 = new AddListing(l1);
//		lr1.addListing();
//		
//		Listings l2 = new Listings("Dicks Sporting Goods", "www.dicks.com","img_path",
//		150, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"Category","Sports");
//		AddListingRequest lr2 = new AddListing(l2);
//		lr2.addListing();
//		
//		Listings l3 = new Listings("Field Goods", "www.field.com","img_path",
//		150, LocalDate.now().toString(), LocalDate.now().plusDays(30).toString(),"Category","Field");
//		AddListingRequest lr3 = new AddListing(l3);
//		lr3.addListing();
//		
//		Category c10 = new Category("Field","None");
//		ModifyCategory mc = new ModifyCategory(c1.getCategoryID(),c10);
//		mc.modify();
//		Advertiser ad = new Advertiser("Wayne Rooney", "www.wayne@manutd.com", "1011018899", 
//				new Address(), "www.facebook.com/wazza" ,"@rooney");
//		AddAdvertiserRequest req2 = new AddAdvertiser(ad);
//		req2.addAccount();
//		Advertiser ad1 = new Advertiser("Lionel Messi", "www.wayne@manutd.com", "778990765", 
//				new Address("224 W Street","Buenos Aires", "LA","77661"),
//				"www.facebook.com/messi" ,"@messi");
//		AddAdvertiserRequest req3 = new AddAdvertiser(ad1);
//		req3.addAccount();
//		ModifyAdvertiser ma = new ModifyAdvertiser(ad1.getAdvertiserid(),ad1);
//		ma.modify();
		SAD sad = new SAD();
		Collection<Advertiser> testlist = new HashSet<Advertiser>();
//		testlist = sad.getAdvertiser();
//		testlist.forEach(tl->System.out.println(tl.getName()));
//		testlist.forEach(t->System.out.println(t.getAddress().getCity()));
//		for(Advertiser a : testlist){
//			Address ad111 = a.getAddress();
//			System.out.println(ad111.getState());
//		}
		Collection<Category> cat = sad.getCategory();
		cat.forEach(c->System.out.println(c.getCategoryName()));
//		Collection<Listings> list = sad.getListings();
//		list.forEach(l->System.out.println(l.listingType));
//		list.forEach(l->System.out.println(l.getCategory()));
//		HomePage h = new HomePage();
//		Collection<HomePage> hp = h.getHomePage();
//		for(HomePage h1 : hp){
//			for(Category c : h1.cat){
//				System.out.println(c.getCategoryName());
//			}
//		}
//		TestDriver td = new TestDriver();
//		td.testproperty();
	}
}
