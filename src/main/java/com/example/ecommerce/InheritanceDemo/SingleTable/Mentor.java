package com.example.ecommerce.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "Single_Mentor")
@Data
@DiscriminatorValue("2")
public class Mentor extends User{
    private double mentorRating;

}
