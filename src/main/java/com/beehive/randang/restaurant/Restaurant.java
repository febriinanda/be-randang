package com.beehive.randang.restaurant;

import com.beehive.randang.person.Person;
import com.beehive.randang.utils.DeletableFlag;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Restaurant extends DeletableFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Date establishedDate = new Date();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;
}
