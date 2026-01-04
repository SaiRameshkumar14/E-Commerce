package com.flex.ps.dto;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "product_sequence",
//            allocationSize = 1, // increment
//            initialValue = 101  //start
//    )
//    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private int id;

//    @Column
    private String name;

    private String description;

    private double price;

//    @Column
    private int quantity;
}
