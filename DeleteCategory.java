package restapi;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
public class DeleteCategory extends Category implements Serializable {
	private static final long serialVersionUID = 3181685099552736192L;
	int catid;
	Collection<Category> cat = new HashSet<Category>();
	Collection<Listings> list = new HashSet<Listings>();
	saveRestoreState srs = new saveRestoreState();
	public DeleteCategory(int cid){
		this.catid = cid;
	}
	public void delete(){
		SAD sad = new SAD();
		cat = sad.getCategory();
		list = sad.getListings();
		Iterator<Category> ite = cat.iterator();
		Iterator<Listings> lite = list.iterator();
		while(ite.hasNext()){
			Category c1 = ite.next();
			int categoryid = c1.getCategoryID();
			if(categoryid == this.catid){
				String catname = c1.getCategoryName();
				while(lite.hasNext()){
					Listings l1 = lite.next();
					String category = l1.getCategory();
					if(category.equalsIgnoreCase(catname)){
						lite.remove();
					}
				}
				ite.remove();
			}
		}
		try {
			srs.savecategory(sad);
			srs.savelisting(sad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
