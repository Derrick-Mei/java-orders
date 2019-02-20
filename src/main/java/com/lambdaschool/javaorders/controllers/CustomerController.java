package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController
{
    @Autowired
    CustomerRepository customerrepos;

    @GetMapping("/customer/order")
    public List<Object[]> findCustomersAndOrders()
    {
        return customerrepos.findCustomersAndOrders();
    }

//    @GetMapping("/customer/name/{custname}")
//    public List<Object[]> findCustomerOrdersByName(@PathVariable String custname)
//    {
//        return customerrepos.findByCustName(custname);
//    }

    @GetMapping("/customer/order/{custcode}")
    public List<Object[]> findCustOrdersByCustCode(@PathVariable long custcode)
    {
        return customerrepos.findCustOrdersByCustCode(custcode);
    }

//    @DeleteMapping("/customer/{custcode}")
//    public void deleteByCustCode(@PathVariable long custcode)
//    {
//        customerrepos.deleteCustomerById(custcode);
//    }
}

//customer/order - Returns all customers with their orders
//customer/name/{custname} - Returns all orders for a particular based on name
//customer/order/{custcode} - Returns all orders for a particular customer based on custcode
//customer/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders