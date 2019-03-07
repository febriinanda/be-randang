package com.beehive.randang.invoice;

import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class InvoiceSpecification {
    static Specification<Invoice> fromLastEntry(){
        return (Specification<Invoice>) (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("createdDate")));
            return criteriaBuilder.and();
        };
    }

    static Specification<Invoice> before(Date date){
        return (Specification<Invoice>) (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"), date);
    }
}
