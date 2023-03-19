package com.lafiray.springboot.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends EntityWithUUID {

    private String nom;

    @OneToMany(mappedBy="category",cascade= CascadeType.ALL)
    private Collection<SubCategory> subcategories;

}
