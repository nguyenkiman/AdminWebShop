package AdminWebShop.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AdminWebShop.Models.Customer;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
}
