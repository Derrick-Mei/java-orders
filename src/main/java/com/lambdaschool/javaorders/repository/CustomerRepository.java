package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    @Query(value = "" +
            "SELECT c.custname, o.ordnum " +
            "FROM customers c " +
            "LEFT JOIN orders o ORDER BY c.custname",
            nativeQuery = true)
    public List<Object[]> findCustomersAndOrders();

//    @Query(value = "SELECT c.custname FROM customers AS c INNER JOIN orders as o WHERE UPPER(c.custname) = UPPER(:name)", nativeQuery = true)
//    public List<Order> findByCustomerOrdersByName(@Param("name") String name);

//    @Query(value = "SELECT *" +
//            "       FROM orders o " +
//            "       WHERE o.custcode = :custcode " +
//            "       ORDER BY o.ordnum",
//            nativeQuery = true)
//    @Query(value = "SELECT c.custname FROM customer AS c INNER JOIN orders as o WHERE c.custname = :name", nativeQuery = true)
//    public List<Object[]> findByCustName(@Param("name") String name);

    // doesn't work I need to troubleshoot this one
    @Query(value = "SELECT * from orders WHERE orders.custcode IN (SELECT customers.custcode FROM customers LEFT JOIN orders ON customers.custcode = orders.custcode WHERE customers.custname LIKE %:name%)", nativeQuery = true)
    public List<Object[]> findByCustName(@Param("name") String name);

    @Query(value = "Select * from orders WHERE orders.custcode IN (SELECT customers.custcode from customers LEFT JOIN orders ON customers.custcode = orders.custcode where orders.custcode = :custcode)", nativeQuery = true)
    List<Object[]> findCustOrdersByCustCode(@Param("custcode") long custcode);

}

