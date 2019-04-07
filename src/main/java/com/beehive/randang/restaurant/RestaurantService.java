package com.beehive.randang.restaurant;

import com.beehive.randang.invoice.Invoice;
import com.beehive.randang.utils.ServiceFactory;

import java.util.List;

interface RestaurantService extends ServiceFactory<Restaurant, Long> {
    List<Invoice> collectInvoice(long id);
}
