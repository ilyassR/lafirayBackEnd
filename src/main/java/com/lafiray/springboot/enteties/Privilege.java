package com.lafiray.springboot.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Privilege extends EntityWithUUID {
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
