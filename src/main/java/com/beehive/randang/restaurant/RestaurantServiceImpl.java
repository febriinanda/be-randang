package com.beehive.randang.restaurant;

import com.beehive.randang.exception.ResourceNotFound;
import com.beehive.randang.invoice.Invoice;
import com.beehive.randang.invoice.InvoiceServiceImpl;
import com.beehive.randang.person.Person;
import com.beehive.randang.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private InvoiceServiceImpl invoiceService;

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
            throw new ResourceNotFound("restaurant");

        return restaurant;
    }

    @Override
    public List<Invoice> collectInvoice(long id) {
        Restaurant exist = this.shouldExist(id);
        return invoiceService.findByRestaurant(exist);
    }

    @Override
    public List<Invoice> collectInvoice(long id, Date from, Date to) {
        Restaurant exist = this.shouldExist(id);
        return invoiceService.findByRestaurant(exist, from, to);
    }

    @Override
    public List<Restaurant> findByOwner(Person person) {
        return restaurantRepository.findAll(Specification.where(RestaurantSpecification.byOwner(person)));
    }

    @Autowired
    private PersonServiceImpl personService;

    @Override
    public List<Restaurant> findByOwner(long id) {
        Person person = personService.shouldExist(id);
        return this.findByOwner(person);
    }
}
