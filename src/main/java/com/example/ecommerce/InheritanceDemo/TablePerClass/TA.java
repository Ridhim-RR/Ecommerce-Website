package com.example.ecommerce.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name = "T_TA")
public class TA extends User{
    private int sessions;
    private int rating;
}
