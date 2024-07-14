package com.example.ecommerce.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "JT_Mentor")
@Data
public class Mentor extends User{
    private double mentorRating;
}
