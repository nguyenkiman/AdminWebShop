package AdminWebShop.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Customer;
import AdminWebShop.Models.Order;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	
}
