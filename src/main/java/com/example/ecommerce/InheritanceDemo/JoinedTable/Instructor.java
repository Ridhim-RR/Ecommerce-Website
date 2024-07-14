package com.example.ecommerce.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name="JT_INS")
@Data
public class Instructor extends User{
    private String specialization;
}
