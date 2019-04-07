package com.beehive.randang.person;

import com.beehive.randang.restaurant.Restaurant;
import com.beehive.randang.utils.ServiceFactory;

import java.util.List;

interface PersonService extends ServiceFactory<Person, Long> {
    List<Restaurant> collectRestaurant(long id);
}
