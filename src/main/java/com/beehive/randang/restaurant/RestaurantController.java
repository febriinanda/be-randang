package com.beehive.randang.restaurant;

import com.beehive.randang.utils.ControllerFactoryAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends ControllerFactoryAdapter<Restaurant, Long, RestaurantServiceImpl> {
    @Override
    @GetMapping
    public List<Restaurant> index() {
        return this.provider.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable Long id) {
        return this.provider.findById(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody Restaurant restaurant) {
        this.provider.save(restaurant);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        this.provider.update(id, restaurant);
    }
}
