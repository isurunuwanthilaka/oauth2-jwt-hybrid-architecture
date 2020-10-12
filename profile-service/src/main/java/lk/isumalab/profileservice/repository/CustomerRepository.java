package lk.isumalab.profileservice.repository;

import lk.isumalab.profileservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
