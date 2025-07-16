package com.nikul.product.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity

//yaha hamne lombock ka use kiya tha add dependancy ishliye hame getter and setter karne ki jaruru nahi
@Data

//@Table(name = "Product"); ish tarah ham table likhsakte hai nahi likhe to bydefault class name table lega
public class Product {

    @Id   //matlab ki id primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //matlab ki id autoicremet hogaya
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    //yaha pe JoiColumn se category table ki id ish table me add ho gai
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;  //yaha pe category ka refrerance hai

}
