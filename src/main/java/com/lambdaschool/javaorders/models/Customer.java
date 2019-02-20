package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custcode")
    private long id;

    @Column(nullable = false, name = "custname")
    private String custName;

    @Column(name = "custcity")
    private String custCity;

    @Column(name = "workingarea")
    private String workingArea;

    @Column(name = "custcountry")
    private String custCountry;

    private String grade;

    @Column(name = "openingamt")
    private double openingAmt;

    @Column(name = "receiveamt")
    private double receiveAmt;

    @Column(name = "paymentamt")
    private double paymentAmt;

    @Column(name = "outstandingamt")
    private double outstandingAmt;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agent agent;

    public Customer()
    {
    }

}
