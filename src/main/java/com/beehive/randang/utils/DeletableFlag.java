package com.beehive.randang.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class DeletableFlag extends AuditorBase {
    @Getter(AccessLevel.NONE) private Boolean deleted = false;

    public Boolean isDeleted() {
        return deleted;
    }
}
