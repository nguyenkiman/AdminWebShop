package AdminWebShop.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Category;

@Transactional
@Repository
public interface CategoryRepository {

	public List<Category> findAll();
	
	public List<Category> findAllActive();
	
	public List<Category> findByNameLike(String name);
	
	public Category findById(int id);
	
	public void save(Category category);
	
	public void disableById(int id);
	
	public void enableById(int id);
	
	public void update(Category category);
	
}
