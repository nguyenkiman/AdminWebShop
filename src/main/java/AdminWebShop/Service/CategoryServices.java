package AdminWebShop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import AdminWebShop.Models.Category;

@Service
public interface CategoryServices {

	public List<Category> findAll();
	
	public List<Category> findAllActive();
	
	public List<Category> findByNameLike(String name);
	
	public Category findById(int id);
	
	public void insert(Category category);
	
	public void update(Category category);
	
	public void disableById(int id);
	
	public void enableById(int id);
}
