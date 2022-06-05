package com.techion.techion.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data   // @ToString @EqualsAndHashCode @Getter(on all fields) @Setter(on all non-final fields) @RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long price;

    private String description;

    private String brand;

    private Long stock;

    // getters, setters, toString, ... generated using LOMBOK annotations

}
