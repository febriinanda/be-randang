package com.beehive.randang.utils;

import java.util.List;

public interface ServiceFactory<T,U> {
    List<T> findAll();

    T findById(U id);

    void save(T t);

    void save(List<T> list);

    void update(U id, T t);

    T shouldExist(U id);
}
