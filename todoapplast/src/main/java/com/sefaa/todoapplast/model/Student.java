package com.sefaa.todoapplast.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @SequenceGenerator(name = "seqq_id", allocationSize = 1)
    @GeneratedValue(generator = "seqq_id", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "student_name")
    private String name;

    @Column(name="student_id")
    private int studentId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Todo> todo;
}
