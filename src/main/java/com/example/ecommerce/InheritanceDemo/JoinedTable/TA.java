package com.example.ecommerce.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "JT_TA")
@Data
public class TA extends User{
    private int sessions;
    private int rating;

}
