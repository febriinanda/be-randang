package com.beehive.randang.person;

import com.beehive.randang.utils.ControllerFactoryAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController extends ControllerFactoryAdapter<Person, Long, PersonServiceImpl> {
    @Override
    @GetMapping
    public List<Person> index() {
        return this.service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody Person person) {
        this.service.save(person);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Person person) {
        this.service.update(id, person);
    }
}
