package com.beehive.randang.restaurant;

import com.beehive.randang.utils.AuditorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Restaurant extends AuditorBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Date establishedDate = new Date();
}
