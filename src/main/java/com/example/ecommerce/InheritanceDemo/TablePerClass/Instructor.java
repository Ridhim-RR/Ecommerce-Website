package com.example.ecommerce.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "T_Ins")
@Data
public class Instructor extends User{
    private String specialization;
}
