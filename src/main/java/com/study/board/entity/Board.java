package com.study.board.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "id_seq_generator", sequenceName = "id_seq", initialValue = 1, allocationSize = 1)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_generator")
    private Integer id;

    private String title;

    private String content;
}
