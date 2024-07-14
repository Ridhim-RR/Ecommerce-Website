package com.example.ecommerce.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity(name = "T_User")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @jakarta.persistence.Id
    private long Id;
    private String Name;
    private String Email;
    private String Password;
}
