package com.beehive.randang.invoice;

import org.springframework.data.jpa.domain.Specification;

public class InvoiceSpecification {
    static Specification<Invoice> fromLastEntry(){
        return (Specification<Invoice>) (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("createdDate")));
            return criteriaBuilder.and();
        };
    }
}
