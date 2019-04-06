package com.beehive.randang.person;

import com.beehive.randang.utils.ControllerFactoryAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController extends ControllerFactoryAdapter<Person, Long, PersonProviderImpl> {
    @Override
    @GetMapping
    public List<Person> index() {
        return this.adapter.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return this.adapter.findById(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody Person person) {
        this.adapter.save(person);
    }

    @Override
    public void save(List<Person> list) {
        this.adapter.save(list);
    }
}
