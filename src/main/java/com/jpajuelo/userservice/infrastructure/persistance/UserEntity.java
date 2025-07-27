package com.jpajuelo.userservice.infrastructure.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity {
    //tst
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserId;
}
