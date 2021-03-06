package AdminWebShop.RepositoryImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Category;
import AdminWebShop.Models.Product;
import AdminWebShop.Repository.CategoryRepository;
import AdminWebShop.Repository.ProductRepository;

@Transactional
@Repository
public class CategoryRepositoryImp implements CategoryRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory; 
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Category order by status desc";
		
		Query query = session.createQuery(hql);
		List<Category> listCategories = query.getResultList();
		
		return listCategories;
	}
	
	@Override
	public List<Category> findAllActive() {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Category where status=true order by status desc";
		
		Query query = session.createQuery(hql);
		List<Category> listCategories = query.getResultList();
		
		return listCategories;
	}
	
	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		try {
			Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
			String hql = "from Category where id=:id";
			
			Query query = session.createQuery(hql); 
			query.setParameter("id", id);
			
			Category category =  (Category) query.getSingleResult();
			
			return category;
		}catch(Exception e){
			
		}
		return null;
	}

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.save(category);
		
	}

	@Override
	public void disableById(int id) {
		// TODO Auto-generated method stub
		
		
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Transaction txn = session.beginTransaction();
		String hql = "update Category set status=false where id=:id";
		
		Query query = session.createQuery(hql); 
		query.setParameter("id", id);
		
		query.executeUpdate();  
		txn.commit();
	}
	
	@Override
	public void enableById(int id) {
		// TODO Auto-generated method stub
		
		
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Transaction txn = session.beginTransaction();
		String hql = "update Category set status=true where id=:id";
		
		Query query = session.createQuery(hql); 
		query.setParameter("id", id);
		
		query.executeUpdate();  
		txn.commit();
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		Transaction txn = session.beginTransaction();
		String hql = "update Category c set c.catename=:n where c.id=:i";
		
		Query query = session.createQuery(hql); 
		query.setParameter("n", category.getName());
		query.setParameter("i", category.getId());
		
		
		
		query.executeUpdate();
		txn.commit();
	}

	@Override
	public List<Category> findByNameLike(String name) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Category where name like '%:name%' order by status desc";
		
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Category> listCategories = query.getResultList();
		
		return listCategories;
	}
	
	

}
