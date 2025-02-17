package com.openschool.api.model.entity;

import com.openschool.api.model.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Student")
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime birthdate;

    private String email;

    @Embedded
    private Address address;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;
}
