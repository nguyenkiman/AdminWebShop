package AdminWebShop.RepositoryImp;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Customer;
import AdminWebShop.Models.Order;
import AdminWebShop.Repository.OrderRepository;

@Transactional
@Repository
public class OrderRepositoryImp implements OrderRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Order";
		
		Query query = session.createQuery(hql);
		List<Order> listOrders = query.getResultList();
		
		return listOrders;
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "from Order";
		
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		
		Order order = (Order) query.getSingleResult();
		return order;
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.save(order);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "delete from Order where id=:id";
		
		Query query=session.createQuery(hql);  
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
