package com.beehive.randang.utils;

import java.util.List;

public interface ControllerFactory<T, ID> {
    List<T> index();
    T findById(ID id);
    void save(T t);
    void save(List<T> list);
    void update(ID id, T t);
}
