package AdminWebShop.RepositoryImp;

import java.util.List;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Category;
import AdminWebShop.Models.Customer;
import AdminWebShop.Repository.CustomerRepository;

@Transactional
@Repository
public class CustomerRepositoryImp implements CustomerRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory; 
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Customer";
		
		Query query = session.createQuery(hql);
		List<Customer> listCustomers = query.getResultList();
		
		return listCustomers;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Customer where id=:id";
		
		Query query = session.createQuery(hql); 
		query.setParameter("id", id);
		
		Customer customer = (Customer) query.getSingleResult();
		
		return customer;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.save(customer);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "update Customer set status=false where id=:id";
		
		Query query = session.createQuery(hql); 
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
