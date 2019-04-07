package com.beehive.randang.restaurant;

import com.beehive.randang.invoice.Invoice;
import com.beehive.randang.utils.ControllerFactoryAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends ControllerFactoryAdapter<Restaurant, Long, RestaurantServiceImpl> {
    @Override
    @GetMapping
    public List<Restaurant> index() {
        return this.service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody Restaurant restaurant) {
        this.service.save(restaurant);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        this.service.update(id, restaurant);
    }

    @GetMapping("/{id}/invoices")
    public List<Invoice> collectInvoices(@PathVariable long id, @RequestParam Date from, @RequestParam Date to){
        return this.service.collectInvoice(id, from, to);
    }
}
