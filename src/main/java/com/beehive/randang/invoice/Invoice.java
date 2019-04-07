package com.beehive.randang.invoice;

import com.beehive.randang.invoice.detail.InvoiceDetail;
import com.beehive.randang.restaurant.Restaurant;
import com.beehive.randang.utils.AuditorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Invoice extends AuditorBase {
    @Id
    @GenericGenerator(name = "invoice_id", strategy = "com.beehive.randang.utils.InvoiceIdGenerator")
    @GeneratedValue(generator = "invoice_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> details = new ArrayList<>();
}
