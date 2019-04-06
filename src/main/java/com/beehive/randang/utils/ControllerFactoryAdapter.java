package com.beehive.randang.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class ControllerFactoryAdapter<T,U, V> implements ControllerFactory<T, U> {
    @Autowired
    protected V service;

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
    public void save(List<T> list) {

    }

    @Override
    public void update(U id, T t) {

    }
}
