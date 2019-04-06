package com.beehive.randang.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommonRepository<T, U> extends JpaRepository<T, U>, JpaSpecificationExecutor<T> {
}
