package com.lafiray.springboot.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="piece")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piece extends EntityWithUUID {

    private String nom;

    private float prix;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;
}
