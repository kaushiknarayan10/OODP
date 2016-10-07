package restapi;
import java.io.IOException;
import java.io.Serializable;
public class AddCategory extends Category implements Serializable{
	private static final long serialVersionUID = 1186316212637814511L;
	private Category category;
	saveRestoreState srs = new saveRestoreState();
	public AddCategory(Category c){
		super(c);
	}
	public void addCategory() {	
		category = new Category(this.categoryName, this.parentCategory);
		SAD sad = new SAD();
		sad.AddCategory(category);
		try {
			srs.savecategory(sad);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}