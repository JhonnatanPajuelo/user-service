package com.jpajuelo.userservice.domain.model;

import lombok.Getter;
import java.util.HashSet;
import java.util.Set;
@Getter
public class Role {
    private Long id;
    private String name;
    private Boolean isActivo = true;

    public Role() {
    }

    public Role(Long id, String name, Boolean isActivo) {
        this.id = id;
        this.name = name;
        this.isActivo = isActivo;
    }
}
