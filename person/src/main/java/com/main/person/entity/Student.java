package com.main.person.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")

    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phonenumber")
    private String phonenumber;
}
