package lk.isumalab.profileservice.controller;

import lk.isumalab.profileservice.models.Customer;
import lk.isumalab.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer fetch(@PathVariable(value = "id") int customerId) {
        return customerService.fetchById(customerId);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }

    @GetMapping("/jwt")
    public ResponseEntity getJwt() {
        return ResponseEntity.ok("This is your Jwt");
    }

}
