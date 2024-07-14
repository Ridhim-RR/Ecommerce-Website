package com.example.ecommerce.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity(name = "JT_User")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @jakarta.persistence.Id
    private long Id;
    private String Name;
    private String Email;
    private String Password;
}
