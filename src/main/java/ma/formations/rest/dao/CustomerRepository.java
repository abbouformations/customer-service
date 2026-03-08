package ma.formations.rest.dao;

import ma.formations.rest.service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Object> findByIdentityRef(String identityRef);

    Optional<Object> findByUsername(String username);
}
