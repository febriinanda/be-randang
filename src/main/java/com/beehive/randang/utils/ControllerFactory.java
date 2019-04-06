package com.beehive.randang.utils;

import java.util.List;

public interface ControllerFactory<T, U> {
    List<T> index();
    T findById(U id);
    void save(T t);
    void save(List<T> list);
}
