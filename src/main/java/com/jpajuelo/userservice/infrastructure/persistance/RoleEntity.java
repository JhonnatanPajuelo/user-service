package com.jpajuelo.userservice.infrastructure.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RoleId;
}
