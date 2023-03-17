package com.sefaa.todoapplast.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Todo {

    @Id
    @SequenceGenerator(name = "se_id", allocationSize = 1)
    @GeneratedValue(generator = "se_id", strategy = GenerationType.SEQUENCE)
    private int id;

    private Date createDate = new Date();
    @Column(name = "list_name")
    private String listName;

    @Column(name = "content")
    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;
}
