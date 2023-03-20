package com.lafiray.springboot.enteties;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="subcategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class SubCategory extends EntityWithUUID {
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy="subCategory",cascade= CascadeType.ALL)
    private Collection<Piece> pieces;
}
