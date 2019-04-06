package com.beehive.randang.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.MappedSuperclass;
import java.util.List;
@MappedSuperclass
public abstract class ControllerFactoryAdapter<T,U, V> implements ControllerFactory<T, U> {
    @Autowired
    protected V adapter;

    @Override
    public List<T> index() {
        return null;
    }

    @Override
    public T findById(U id) {
        return null;
    }

    @Override
    public void save(T t) {

    }

    @Override
    @PostMapping("/bulk")
    public void save(@RequestBody List<T> list) {

    }
}
