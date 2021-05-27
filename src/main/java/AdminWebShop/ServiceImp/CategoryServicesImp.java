package AdminWebShop.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AdminWebShop.Constraint.CategoryConstraints;
import AdminWebShop.Models.Category;
import AdminWebShop.Repository.CategoryRepository;
import AdminWebShop.Service.CategoryServices;

@Service
public class CategoryServicesImp implements CategoryServices{

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> findAllActive() {
		// TODO Auto-generated method stub
		return categoryRepository.findAllActive();
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		category.setStatus(CategoryConstraints.ACTIVE_CATEGORY);
		categoryRepository.save(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.update(category);
	}

	@Override
	public List<Category> findByNameLike(String name) {
		return categoryRepository.findByNameLike(name);
	}
	
	
}
