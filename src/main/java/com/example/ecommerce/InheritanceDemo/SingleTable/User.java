package com.example.ecommerce.InheritanceDemo.SingleTable;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Single_user")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name ="User_Type",
        discriminatorType =  DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
public class User {
    @jakarta.persistence.Id
    private long Id;
    private String Name;
    private String Email;
    private String Password;
}
