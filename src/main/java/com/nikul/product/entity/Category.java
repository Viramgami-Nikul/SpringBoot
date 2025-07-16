package com.nikul.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data


public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //CascadeType.ALL ka matlab ki hame all operation hui jai category me changge vo product me
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)   //yaha relationship use kiya hai One category thi many product hoi example  electronic=>mobile,tv
                                         //(mappedBy = "category") ye cascading kiya matlab jab ham category me changes karge like delete vo
                                         //product me ho jayega mappedBY match karega product class se refrence ko
    private List<Product> products= new ArrayList<>();
}
