package com.ing.cruddocker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//JPA
@Entity(name = "cd_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String ci;
    private String name;
    @Column(name = "last_name")
    private String lastName;

}
