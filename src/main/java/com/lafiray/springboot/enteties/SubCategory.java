package com.lafiray.springboot.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="subcategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory extends EntityWithUUID {
    private String nom;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy="subCategory",cascade= CascadeType.ALL)
    private Collection<Piece> pieces;
}
