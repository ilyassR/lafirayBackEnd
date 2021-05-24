package com.lafiray.springboot.enteties;

import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class EntityWithUUID {
    @Id
    private UUID id;

    public EntityWithUUID() {
        this.id = UUID.randomUUID();
    }
}
