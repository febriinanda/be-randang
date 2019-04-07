package com.beehive.randang.invoice;

import com.beehive.randang.restaurant.Restaurant;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
}
