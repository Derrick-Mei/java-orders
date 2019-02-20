package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long>
{
}
