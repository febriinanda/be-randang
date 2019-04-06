package com.beehive.randang.menu;

import com.beehive.randang.utils.ControllerFactoryAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController extends ControllerFactoryAdapter<Menu, Long, MenuServiceImpl> {
    @Override
    @GetMapping
    public List<Menu> index() {
        return this.service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Menu findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody Menu menu) {
        this.service.save(menu);
    }

    @Override
    @PostMapping("/bulk")
    public void save(@RequestBody List<Menu> list) {
        this.service.save(list);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody Menu menu) {
        this.service.update(id, menu);
    }
}
