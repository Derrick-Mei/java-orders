package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class AgentController
{
    @Autowired
    AgentRepository agentrepos;

    @GetMapping("/agents")
    public List<Agent> findAllAgents()
    {
        return agentrepos.findAll();
    }

    @GetMapping("/agents/orders")
    public List<Object[]> findAgentsAndOrders()
    {
        return agentrepos.findAgentsAndOrders();
    }

}


//agents - Returns all agents with their customers
//agents/orders - Return a list with the agents name and associated order number and order description
//agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)