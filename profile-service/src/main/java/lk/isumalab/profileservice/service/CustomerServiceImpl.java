package lk.isumalab.profileservice.service;

import lk.isumalab.profileservice.models.Customer;
import lk.isumalab.profileservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer fetchById(int profileId) {
        Optional<Customer> customer = customerRepository.findById(profileId);
        return customer.orElse(null);
    }

    @Override
    public List<Customer> fetchAllProfiles() {
        return customerRepository.findAll();
    }
}
