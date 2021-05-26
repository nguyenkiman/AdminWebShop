package AdminWebShop.RepositoryImp;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Category;
import AdminWebShop.Models.OrderDetails;
import AdminWebShop.Repository.OrderDetailsRepository;

@Transactional
@Repository
public class OrderDetailsRepositoryImp implements OrderDetailsRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	

	@Override
	public void save(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		session.save(orderDetails);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "delete from OrderDetails where id=:id";
		
		Query query=session.createQuery(hql);  
		query.setParameter("id", id);
		query.executeUpdate(); 
	}

}
