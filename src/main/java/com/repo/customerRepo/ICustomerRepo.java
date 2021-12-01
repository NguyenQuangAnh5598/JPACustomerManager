package com.repo.customerRepo;

import com.model.Customer;
import com.model.Provinces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvinces(Provinces provinces);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
