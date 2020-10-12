package lk.isumalab.profileservice.service;


import lk.isumalab.profileservice.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer fetchById(int profileId);

    List<Customer> fetchAllProfiles();
}
