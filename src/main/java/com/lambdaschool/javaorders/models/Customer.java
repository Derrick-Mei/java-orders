package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custCode;

    @Column(nullable = false)
    private String custName;

    private String custCity;

    private String workingArea;

    private String custCountry;

    private String grade;

    private double openingAmt;

    private double receiveAmt;

    private double paymentAmt;

    private double outstandingAmt;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "agtcode", nullable = false)
    @JsonIgnore
    private Agent agent;

    public Customer()
    {
    }

}
