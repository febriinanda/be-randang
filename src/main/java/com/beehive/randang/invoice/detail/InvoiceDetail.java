package com.beehive.randang.invoice.detail;

import com.beehive.randang.invoice.Invoice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "d_invoice")
@Data
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int quantity;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    @JsonIgnore
    private Invoice invoice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceDetail)) return false;
        InvoiceDetail that = (InvoiceDetail) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getInvoice(), that.getInvoice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getQuantity(), getPrice(), getInvoice());
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
