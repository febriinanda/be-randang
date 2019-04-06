package com.beehive.randang.utils;

import java.util.List;

public interface ProviderFactory<T,U> {
    List<T> findAll();
    T findById(U id);
    void save(T t);
    void save(List<T> list);
}
