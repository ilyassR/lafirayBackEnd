package com.lafiray.springboot.enteties;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Category extends EntityWithUUID {

    private String name;

    @OneToMany(mappedBy="category",cascade= CascadeType.ALL)
    @JsonManagedReference
    private List<SubCategory> subcategories;

}
