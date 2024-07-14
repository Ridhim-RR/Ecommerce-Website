package com.example.ecommerce.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "Single_TA")
@Data
@DiscriminatorValue("1")
public class TA extends User {
    private int sessions;
    private int rating;
}
