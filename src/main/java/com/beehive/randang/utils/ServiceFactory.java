package com.beehive.randang.utils;

import java.util.List;

public interface ServiceFactory<T, ID> {
    List<T> findAll();

    T findById(ID id);

    void save(T t);

    void save(List<T> list);

    void update(ID id, T t);

    T shouldExist(ID id);
}
