package com.openschool.api.model.entity;

import com.openschool.api.model.Address;
import com.openschool.api.model.dtos.request.StudentRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="Student")
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthdate;

    private String email;

    @Embedded
    private Address address;

    public Student(@Valid StudentRequestDTO studentData) {
        this.name = studentData.name();
        this.birthdate = studentData.birthdate();
        this.email = studentData.email();
        this.address = new Address(studentData.address());
    }
}
