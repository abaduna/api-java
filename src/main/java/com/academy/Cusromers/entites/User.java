package com.academy.Cusromers.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString @Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firsname;
    private String lastname;
    private String email;
    private  String adress;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;
}
