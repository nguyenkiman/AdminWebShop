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
	
	public Category findById(int id);
	
	public void save(Category category);
	
	public void deleteById(int id);
	
	public void update(Category category);
	
}
