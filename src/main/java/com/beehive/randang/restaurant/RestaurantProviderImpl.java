package com.beehive.randang.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantProviderImpl implements RestaurantProvider {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void save(List<Restaurant> list) {
        restaurantRepository.saveAll(list);
    }

    @Override
    public void update(Long id, Restaurant restaurant) {
        Restaurant exist = this.shouldExist(id);

        restaurant.setId(exist.getId());
        this.save(restaurant);
    }

    @Override
    public Restaurant shouldExist(Long id) {
        Restaurant restaurant = this.findById(id);

        if(restaurant == null)
            throw new RuntimeException("This restaurant is not exist");

        return restaurant;
    }
}
