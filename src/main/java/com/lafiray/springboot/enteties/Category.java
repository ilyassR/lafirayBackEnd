package com.lafiray.springboot.enteties;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class Category extends EntityWithUUID {

    private String name;

    @OneToMany(mappedBy="category",cascade= CascadeType.ALL)
    private Collection<SubCategory> subcategories;

}
