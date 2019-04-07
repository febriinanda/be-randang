package com.beehive.randang.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class DeletableFlag extends AuditorBase {
    private Boolean deleted = false;
}
