package AdminWebShop.RepositoryImp;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Category;
import AdminWebShop.Models.Product;
import AdminWebShop.Repository.ProductRepository;

@Transactional
@Repository
public class ProductRepositoryImp implements ProductRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<Product> findAll() {
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Product order by status desc";
		
		Query query = session.createQuery(hql);
		List<Product> products  = query.getResultList();
		
		return products;
	}

	@Override
	public List<Product> findAllActive() {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Product where status=true order by status desc";
		
		Query query = session.createQuery(hql);
		List<Product> products = query.getResultList();
		
		return products;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Product where id=:id";
		
		Query query = session.createQuery(hql); 
		query.setParameter("id", id);
		
		Product product = (Product) query.getSingleResult();
		
		return product;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.save(product);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "update Product set status=false where id=:id";
		
		Query query = session.createQuery(hql); 
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
