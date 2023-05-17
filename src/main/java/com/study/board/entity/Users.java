package com.study.board.entity;

import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@SequenceGenerator(name = "id_seq_generator", sequenceName = "id_seq_security", initialValue = 1, allocationSize = 1)
public class Users {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_generator")
    private int id;

    private  String username;
    private  String password;
    private  String email;
    private  String role; //ROLE_USER, ROLE_ADMIN
//    @CreationTimestamp
//    private  Timestamp createDate;

}

