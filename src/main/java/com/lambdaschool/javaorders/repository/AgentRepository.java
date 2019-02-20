package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long>
{
    @Query(value = "SELECT a.agentname, o.ordnum, o.orddescription FROM agents a LEFT JOIN orders o", nativeQuery = true)
    List<Object[]> findAgentsAndOrders();
}