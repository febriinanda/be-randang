package com.beehive.randang.person;

import com.beehive.randang.exception.ResourceNotFound;
import com.beehive.randang.restaurant.Restaurant;
import com.beehive.randang.restaurant.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void save(List<Person> list) {
        personRepository.saveAll(list);
    }

    @Override
    public void update(Long id, Person person) {
        Person exist = this.shouldExist(id);

        person.setId(exist.getId());
        this.save(person);
    }

    @Override
    public Person shouldExist(Long id) {
        Person person = this.findById(id);

        if(person == null)
            throw new ResourceNotFound("person");

        return person;
    }

    @Override
    public List<Restaurant> collectRestaurant(long id) {
        Person person = this.shouldExist(id);
        return restaurantService.findByOwner(person);
    }
}
