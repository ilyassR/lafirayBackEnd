package com.lafiray.springboot.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends EntityWithUUID {
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Person> persons;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="privilege_id", referencedColumnName = "id")
    )
    private Collection<Privilege> privileges;
}
