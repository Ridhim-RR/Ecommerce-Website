package com.example.ecommerce.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "Single_Ins")
@Data
@DiscriminatorValue("3")
public class Instructor extends User{
    private String specialization;

}
