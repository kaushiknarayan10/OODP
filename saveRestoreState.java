package restapi;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Properties;
public class saveRestoreState {
	public String listings,advertisers,category;
	public saveRestoreState(){};
	public void saveadvertiser(SAD s) throws IOException {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		Properties prop = new Properties();
		try {
			String propfile = "config.properties";
			prop.load(getClass().getClassLoader().getResourceAsStream(propfile));
			String advertisers = prop.getProperty("advertisers");
			fout = new FileOutputStream(advertisers);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(s.adlist);
		} catch (IOException e) {
		        e.printStackTrace();
		} finally {
			if(oos != null) {
				oos.close();
			} 
		}
	}
	@SuppressWarnings("unchecked")
	public SAD restoreadvertiser() throws IOException {
		ObjectInputStream ois = null;
		Properties prop = new Properties();
		try {
			String propfile = "config.properties";
			prop.load(getClass().getClassLoader().getResourceAsStream(propfile));
			String advertisers = prop.getProperty("advertisers");
			FileInputStream fis = new FileInputStream(advertisers);
			ois = new ObjectInputStream(fis);
			Collection<Advertiser> ad = (Collection<Advertiser>)ois.readObject();
			SAD s = new SAD(ad);
			return s;
		}  catch (EOFException eof){
			System.out.println("caught exception");
		}catch (IOException e) {
			System.err.println("Nothing to restore.\n");

			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException caught in restoreadvertiser()");
			e.printStackTrace();
		}
			finally {
			if (ois != null) {
				ois.close();
			} 
		}
		return null;
	}
	public void savelisting(SAD s) throws IOException {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		Properties prop = new Properties();
		try {
			String propfile = "config.properties";
			prop.load(getClass().getClassLoader().getResourceAsStream(propfile));
			String listings = prop.getProperty("listings");
			fout = new FileOutputStream(listings);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(s.listings);
		} catch (IOException e) {
		        e.printStackTrace();
		} finally {
			if(oos != null) {
				oos.close();
			} 
		}
	}
	@SuppressWarnings("unchecked")
	public SAD restorelisting() throws IOException {
		ObjectInputStream ois = null;
		Properties prop = new Properties();
		try {
			String propfile = "config.properties";
			prop.load(getClass().getClassLoader().getResourceAsStream(propfile));
			String listings = prop.getProperty("listings");
			FileInputStream fis = new FileInputStream(listings);
				ois = new ObjectInputStream(fis);
				Collection<Listings> ls = (Collection<Listings>)ois.readObject();
				SAD s = new SAD(ls);
				return s;
		}  catch (EOFException eof){
			System.out.println("caught exception");
		}catch (IOException e) {
			System.err.println("Nothing to restore.\n");
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException caught in restorelisting()");
			e.printStackTrace();
		}
			finally {
			if (ois != null) {
				ois.close();
			} 
		}
		return null;
	}
	public void savecategory(SAD s) throws IOException {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		Properties prop = new Properties();
		try {
			String propfile = "config.properties";
			prop.load(getClass().getClassLoader().getResourceAsStream(propfile));
			String category = prop.getProperty("category");
			fout = new FileOutputStream(category);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(s.categories);
		} catch (IOException e) {
		        e.printStackTrace();
		} finally {
			if(oos != null) {
				oos.close();
			} 
		}
	}
	@SuppressWarnings("unchecked")
	public SAD restorecategory() throws IOException {
		ObjectInputStream ois = null;
		Properties prop = new Properties();
		try {
			String propfile = "config.properties";
			prop.load(getClass().getClassLoader().getResourceAsStream(propfile));
			String category = prop.getProperty("category");
			FileInputStream fis = new FileInputStream(category);
				ois = new ObjectInputStream(fis);
				Collection<Category> cat = (Collection<Category>)ois.readObject();
				SAD s = new SAD(cat);
				return s;
		}  catch (EOFException eof){
			System.out.println("caught exception");
		}catch (IOException e) {
			System.err.println("Nothing to restore.\n");
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException caught in restorcategory()");
			e.printStackTrace();
		}
			finally {
			if (ois != null) {
				ois.close();
			} 
		}
		return null;
	}
}