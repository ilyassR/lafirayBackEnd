package com.lafiray.springboot.enteties;

import com.lafiray.springboot.enums.MarqueEnum;
import com.lafiray.springboot.enums.MotorisationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends EntityWithUUID {

    //Mercedes;BMW..
    @Enumerated(EnumType.STRING)
    private MarqueEnum marque;

    // AMG, Serie1..
    private String model;

    //Disel; Essence
    @Enumerated(EnumType.STRING)
    private MotorisationEnum motorisation;
}
