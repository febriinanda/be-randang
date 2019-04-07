package com.beehive.randang.invoice;

import com.beehive.randang.restaurant.Restaurant;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

class InvoiceSpecification {
    static Specification<Invoice> fromLastEntry(){
        return (Specification<Invoice>) (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("createdDate")));
            return criteriaBuilder.and();
        };
    }

    static Specification<Invoice> before(Date date){
        return (Specification<Invoice>) (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"), date);
    }

    static Specification<Invoice> byRestaurant(Restaurant r){
        return (Specification<Invoice>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("restaurant"), r);
    }

    static Specification<Invoice> between(Date from, Date to) {
        return (Specification<Invoice>) (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("createdDate"), from, to);
    }
}
