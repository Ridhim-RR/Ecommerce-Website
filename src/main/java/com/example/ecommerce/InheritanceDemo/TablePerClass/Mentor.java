package com.example.ecommerce.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "T_Mentor")
@Data
public class Mentor extends User {
    private double mentorRating;
}
