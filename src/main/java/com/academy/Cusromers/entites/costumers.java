package com.academy.Cusromers.entites;

import jakarta.persistence.*;
import lombok.*;



//or Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString @Entity @Table(name="customers")
public class costumers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firsname;
    private String lastname;
    private String email;
    private  String adress;








}
