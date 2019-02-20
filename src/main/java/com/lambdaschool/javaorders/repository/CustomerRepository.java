package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
}
