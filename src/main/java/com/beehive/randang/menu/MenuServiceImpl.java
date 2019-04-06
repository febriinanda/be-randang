package com.beehive.randang.menu;

import com.beehive.randang.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public void save(List<Menu> list) {
        menuRepository.saveAll(list);
    }

    @Override
    public void update(Long id, Menu menu) {
        Menu exist = this.shouldExist(id);

        menu.setId(exist.getId());
        this.save(menu);
    }

    @Override
    public Menu shouldExist(Long id) {
        Menu menu = this.findById(id);

        if(menu == null)
            throw new ResourceNotFound("menu");

        return menu;
    }
}
