package com.lafiray.springboot.enteties;

import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@SuperBuilder
public class EntityWithUUID {
    @Id
    private UUID id;

    public EntityWithUUID() {
        this.id = UUID.randomUUID();
    }
}
