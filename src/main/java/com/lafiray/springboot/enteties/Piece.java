package com.lafiray.springboot.enteties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name="piece")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Piece extends EntityWithUUID {

    private String nom;

    private float prix;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @JsonBackReference
    private SubCategory subCategory;
}
