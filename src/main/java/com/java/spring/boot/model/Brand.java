package com.java.spring.boot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(generator = "brand_seq")
    @SequenceGenerator(name = "brand_seq", initialValue = 1,sequenceName = "brand_seq")
    private Integer id;

    @Column(name = "brand_name")
    private String name;



}
