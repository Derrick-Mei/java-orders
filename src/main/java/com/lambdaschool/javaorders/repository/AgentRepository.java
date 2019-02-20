package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long>
{
    @Query(value = "SELECT Concat('Agent Name: ', a.agentname), Concat('Customer Name: ', c.custname) FROM agents a, customers c WHERE a.agentcode = c.agentcode ORDER BY a.agentname", nativeQuery = true)
    List<Object[]> findAgentsAndCustomers();

    @Query(value = "SELECT CONCAT('Agent Name: ', a.agentname), CONCAT('OrderNum:   ', o.ordnum), CONCAT('OrdDesc:    ', o.orddescription) FROM agents a LEFT JOIN orders o ORDER BY a.agentname", nativeQuery = true)
    List<Object[]> findAgentsAndOrders();

}