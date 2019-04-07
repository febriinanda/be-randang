package com.beehive.randang.restaurant;

import com.beehive.randang.invoice.Invoice;
import com.beehive.randang.person.Person;
import com.beehive.randang.utils.ServiceFactory;

import java.util.Date;
import java.util.List;

interface RestaurantService extends ServiceFactory<Restaurant, Long> {
    List<Invoice> collectInvoice(long id);

    List<Invoice> collectInvoice(long id, Date from, Date to);

    List<Restaurant> findByOwner(Person person);

    List<Restaurant> findByOwner(long id);
}
