package com.beehive.randang.menu;

import com.beehive.randang.restaurant.Restaurant;
import com.beehive.randang.utils.AuditorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Menu extends AuditorBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private boolean outOfStock = false;
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
