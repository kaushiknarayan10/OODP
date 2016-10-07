package restapi;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
public class ModifyCategory extends Category implements Serializable{
	private static final long serialVersionUID = 1807008940751821228L;
	int categoryid;
	Category category;
	Collection<Category> cat = new HashSet<Category>();
	Collection<Listings> list = new HashSet<Listings>();
	saveRestoreState srs = new saveRestoreState();
	public ModifyCategory(int cid, Category c){
		super(cid,c);
	}
	public void modify(){
		SAD sad = new SAD();
		cat = sad.getCategory();
		list = sad.getListings();
		for(Category c : cat){
			if(c.getCategoryID() == this.categoryid){
				c.categoryName = this.category.getCategoryName();
				c.parentCategory = this.category.getParentCategory();
				for(Listings l : list){
					if(l.category.equalsIgnoreCase(c.getCategoryName())){
						l.category = this.category.getCategoryName();
					}
				}
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