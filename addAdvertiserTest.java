//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.util.Collection;
//import java.util.HashSet;
//
//import org.junit.Test;
//
//public class addAdvertiserTest {
//
//	@Test
//	public void testAddAccount() {
//		Collection<Advertiser> testlist = new HashSet<Advertiser>();
//		Advertiser adv = new Advertiser();
//		addAdvertiserRequest req2 = new addAdvertiser(adv);
//		addAdvertiserResponse res2 = req2.addAccount();
//		
//	}
//	
//	@Test
//	public void nameCheckTest(){
//		Advertiser ad = new Advertiser("", "www.kbc.com", "3123341234", new Address(),
//				"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1000,res2.getID());
//		
//	}
//	
//	@Test
//	public void noEmailTest(){
//		Advertiser ad = new Advertiser("testdata1", "", "3123341234", new Address(),
//				"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1002,res2.getID());
//		
//	}
//	
//	@Test
//	public void invalidEmailTest(){
//		Advertiser ad = new Advertiser("testdata1", "randomdata", "3123341234", new Address(),
//				"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1003,res2.getID());
//		
//	}
//	
//	@Test
//	public void noCityTest(){
//		Address add = new Address("255 W 31st street", "", "IL", "60626");
//		Advertiser ad = new Advertiser("testdata1", "www.random@data.com", "3123341234", add,
//				"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1006,res2.getID());
//		
//	}
//	
//	@Test
//	public void noStateTest(){
//		Address add = new Address("255 W 31st street", "Chicago", "", "60626");
//		Advertiser ad = new Advertiser("testdata1", "www.random@data.com", "3123341234", add,
//				"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1008,res2.getID());
//	}
//	
//	@Test
//	public void noZipTest(){
//		Address add = new Address("255 W 31st street", "Chicago", "IL", "");
//		Advertiser ad = new Advertiser("testdata1", "www.random@data.com", "3123341234", add,
//				"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1010,res2.getID());
//	}
//	
//	@Test
//	public void badZipTest(){
//		Address add = new Address("255 W 31st street", "Chicago", "IL", "606278f6");
//		Advertiser ad = new Advertiser("testdata1", "www.random@data.com", "3123341234", add,
//				"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1011,res2.getID());
//	}
//	
//	@Test
//	public void noPhoneTest(){
//		Advertiser ad = new Advertiser("testdata1", "www.random@data.com", "", 
//				new Address(),"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		assertEquals(1012,res2.getID());
//	}
//	
//	@Test
//	public void userHasAccountTest(){
//		Advertiser ad = new Advertiser("testdata1", "www.random@data.com", "3123376756", 
//				new Address(),"@kbc", "www.facebook.com/kbc" );
//		addAdvertiserRequest req2 = new addAdvertiser(ad);
//		addAdvertiserResponse res2 = req2.addAccount();
//		addAdvertiserRequest req3 = new addAdvertiser(ad);
//		addAdvertiserResponse res3 = req3.addAccount();
//		assertEquals(1014,res3.getID());
//	}
//
//}
