package com.beehive.randang.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class ControllerFactoryAdapter<T, ID, V> implements ControllerFactory<T, ID> {
    @Autowired
    protected V service;

    @Override
    public List<T> index() {
        return null;
    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public void save(T t) {

    }

    @Override
    public void save(List<T> list) {

    }

    @Override
    public void update(ID id, T t) {

    }
}
