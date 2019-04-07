package com.beehive.randang.invoice;

import com.beehive.randang.restaurant.Restaurant;
import com.beehive.randang.utils.ServiceFactory;

import java.util.List;

interface InvoiceService extends ServiceFactory<Invoice, String> {
    Invoice findLastInvoiceThisMonth();

    Invoice findOne(List<Invoice> invoices, int index);

    void submit(Invoice invoice);

    List<Invoice> findByRestaurant(Restaurant restaurant);
}
