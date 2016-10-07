package restapi;
import java.io.Serializable;
import java.util.Random;
public class Category implements Serializable{
	private static final long serialVersionUID = 3433461085004041026L;
	String categoryName, parentCategory;
	int categoryid;
	public Category(){
		this.categoryName = "Sports";
		this.parentCategory = "None";
		this.categoryid = new Random().nextInt(1000);
	}
	public Category(Category c){
		this.categoryName = c.categoryName;
		this.parentCategory = c.parentCategory;
		this.categoryid = new Random().nextInt(1000);
	}
	public Category(String name, String subtype){
		this.categoryName = name;
		this.parentCategory = subtype;
		this.categoryid = new Random().nextInt(1000);
	}
	public Category(int id, Category c){
		this.categoryid = id;
		this.categoryName = c.getCategoryName();
		if(c.getParentCategory().isEmpty()){
			this.parentCategory = "None";
		}
		else{
			this.parentCategory = c.getParentCategory();
		}
	}
	public String getCategoryName() {
		return this.categoryName;
	}
	public String getParentCategory() {
		return this.parentCategory;
	}
	public int getCategoryID() {
		return this.categoryid;
	}
}
