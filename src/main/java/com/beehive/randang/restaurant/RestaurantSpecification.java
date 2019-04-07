package com.beehive.randang.restaurant;

import com.beehive.randang.person.Person;
import org.springframework.data.jpa.domain.Specification;

class RestaurantSpecification {
    static Specification<Restaurant> byOwner(Person p){
        return (Specification<Restaurant>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner"), p);
    }
}
