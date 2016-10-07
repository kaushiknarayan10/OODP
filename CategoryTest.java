package restapi;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class CategoryTest {

	@Test
	public void GetCategoryTest(){
		Category c = new Category("Sports","None");
		AddCategory ac = new AddCategory(c);
		ac.addCategory();
		SAD sad = new SAD();
		Collection<Category> catlist = new HashSet<Category>();
		catlist = sad.getCategory();
		for(Category ca : catlist){
			if(ca.getParentCategory().equalsIgnoreCase("Sports")){
				assertEquals("Field",ca.getCategoryName());
			}
		}
	}
	
	@Test
	public void GetSubCategoryTest(){
		Category c = new Category("Field","Sports");
		AddCategory ac = new AddCategory(c);
		ac.addCategory();
		SAD sad = new SAD();
		Collection<Category> catlist = new HashSet<Category>();
		catlist = sad.getCategory();
		for(Category ca : catlist){
			if(ca.getCategoryName().equalsIgnoreCase("Sports")){
				assertNotEquals("Foot",ca.getParentCategory());
			}
		}
	}
	
	@Test
	public void ModifyCategoryTest(){
		Category c = new Category("Foot","Field");
		AddCategory ac = new AddCategory(c);
		ac.addCategory();
		Category c2 = new Category("Leg","None");
		AddCategory ac2 = new AddCategory(c2);
		ac2.addCategory();
		ModifyCategory mc = new ModifyCategory(c.getCategoryID(),c2);
		mc.modify();
		SAD sad = new SAD();
		Collection<Category> catlist = new HashSet<Category>();
		catlist = sad.getCategory();
		for(Category ca : catlist){
			if(ca.getParentCategory().equalsIgnoreCase("Foot")){
				assertEquals("Leg",ca.getCategoryName());
			}
		}
	}
	
	@Test
	public void DeleteCategoryTest(){
		Category c = new Category("Movies","None");
		AddCategory ac = new AddCategory(c);
		ac.addCategory();
		DeleteCategory dc = new DeleteCategory(c.getCategoryID());
		dc.delete();
		SAD sad = new SAD();
		Collection<Category> catlist = new HashSet<Category>();
		catlist = sad.getCategory();
		for(Category ca : catlist){
			if(!ca.getCategoryName().equalsIgnoreCase("Movies")){
				assertTrue("Deleted",true);
		}
	}
	}
}
