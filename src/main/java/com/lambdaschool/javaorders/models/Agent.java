package com.lambdaschool.javaorders.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "agents")
@Data //@Data from lombok allows me to not have to do boilerplate for getters and setters
public class Agent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this means it's a primary key
    @Column(name = "agentcode")
    private long id;

    @Column(name = "agentname")
    private String agentName;

    @Column(name = "workingarea")
    private String workingArea;

    private double commission;

    private String phone;

    private String country;

    // default constructor for JPA
    public Agent()
    {
    }

}
